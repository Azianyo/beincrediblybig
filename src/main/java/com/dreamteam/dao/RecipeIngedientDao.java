package com.dreamteam.dao;

/**
 * Created by Michał on 2015-06-27.
 * After acroyoga workout
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dreamteam.model.Ingredient;
import com.dreamteam.model.RecipeToIngredient;
import com.dreamteam.util.DbUtil;
public class RecipeIngedientDao {
    private Connection connection;

    public RecipeIngedientDao() {
        connection = DbUtil.getConnection();
    }

    public void addRecipeIngredient(RecipeToIngredient recipeIngredient) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into przepis_skladnik (id_przepis, id_skladnik, ilosc) values (?,?,?)");
            // Parameters start with 1
            preparedStatement.setInt(1, recipeIngredient.getId_przepis());
            preparedStatement.setInt(2, recipeIngredient.getId_skladnik());
            preparedStatement.setInt(3, recipeIngredient.getIlosc());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecipeIngredient(long recipeIngredientId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from przepis_skladnik where id_przepis_skladnik=?");
            // Parameters start with 1
            preparedStatement.setLong(1, recipeIngredientId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecipeIngredient(RecipeToIngredient recipeIngredient) {
        try {
            String command="update przepis_skladnik set id_przepis=?, id_skladnik=?, ilosc=? where id_przepis_skladnik=?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            // Parameters start with 1

            preparedStatement.setInt(1, recipeIngredient.getId_przepis());
            preparedStatement.setInt(2, recipeIngredient.getId_skladnik());
            preparedStatement.setInt(3, recipeIngredient.getIlosc());
            preparedStatement.setLong(4, recipeIngredient.getId_przepis_skladnik());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RecipeToIngredient> getAllRecipeIngredients() {
        List<RecipeToIngredient> RecipeIngredients = new ArrayList<RecipeToIngredient>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from przepis_skladnik");
            while (rs.next()) {
                RecipeToIngredient skladnik = new RecipeToIngredient();
                skladnik.setId_przepis_skladnik(rs.getLong("id_przepis_skladnik"));
                skladnik.setId_przepis(rs.getInt("id_przepis"));
                skladnik.setId_skladnik(rs.getInt("id_skladnik"));
                skladnik.setIlosc(rs.getInt("ilosc"));

                RecipeIngredients.add(skladnik);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return RecipeIngredients;
    }

    public RecipeToIngredient getRecipeIngredientById(long przepisSkladnikId) {
        RecipeToIngredient recipeIngredient = new RecipeToIngredient();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from przepis_skladnik where id_przepis_skladnik=?");
            preparedStatement.setLong(1, przepisSkladnikId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                recipeIngredient.setId_przepis_skladnik(rs.getLong("id_przepis_skladnik"));
                recipeIngredient.setId_przepis(rs.getInt("id_przepis"));
                recipeIngredient.setId_skladnik(rs.getInt("id_skladnik"));
                recipeIngredient.setIlosc(rs.getInt("ilosc"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipeIngredient;
    }
    public List<RecipeToIngredient> getRecipeIngredientsByIDRecipe(long recipeId) {
        List<RecipeToIngredient> RecipeIngredients = new ArrayList<RecipeToIngredient>();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from przepis_skladnik where id_przepis =?");
            preparedStatement.setLong(1, recipeId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                RecipeToIngredient skladnik = new RecipeToIngredient();
                skladnik.setId_przepis_skladnik(rs.getLong("id_przepis_skladnik"));
                skladnik.setId_przepis(rs.getInt("id_przepis"));
                skladnik.setId_skladnik(rs.getInt("id_skladnik"));
                skladnik.setIlosc(rs.getInt("ilosc"));

                RecipeIngredients.add(skladnik);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return RecipeIngredients;
    }
    public int getAmountByID(long skladnikId) {
        RecipeToIngredient skladnik = new RecipeToIngredient();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select ilosc from przepis_skladnik where id_skladnik=?");
            preparedStatement.setLong(1, skladnikId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                skladnik.setId_przepis_skladnik(rs.getLong("id_skladnik"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return skladnik.getIlosc();
    }
    /*public przepis_skladnik getRecipeIngredientById_Skladnik(long id_skladnik) {
        przepis_skladnik recipeIngredient = new przepis_skladnik();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from przepis_skladnik where id_skladnik=id_skladnik");
            preparedStatement.setLong(1, przepisSkladnikId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                recipeIngredient.setId_przepis_skladnik(rs.getLong("id_przepis_skladnik"));
                recipeIngredient.setId_przepis(rs.getInt("id_przepis"));
                recipeIngredient.setId_skladnik(rs.getInt("id_skladnik"));
                recipeIngredient.setIlosc(rs.getInt("ilosc"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipeIngredient;
    }*/

}
