package com.dreamteam.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.dreamteam.model.Diet;
import com.dreamteam.model.Ingredient;
import com.dreamteam.model.Recipe;
import com.dreamteam.util.DbUtil;

/**
 * chuj, dupa, kurwa, cipa
 */
public class recipeDao {
    private Connection connection;

    public recipeDao() {
        connection = DbUtil.getConnection();
    }

    public void addRecipe(Recipe przepis) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into przepis (nazwa, opis, ocena, typ, zdjecie) values (?, ?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, przepis.getNazwa());
            preparedStatement.setString(2, przepis.getOpis());
            preparedStatement.setInt(3, przepis.getOcena());
            preparedStatement.setInt(4, przepis.getTyp());
            preparedStatement.setString(5, przepis.getZdjecie());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecipe(long recipeId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from przepis where id_przepis=?");
            // Parameters start with 1
            preparedStatement.setLong(1, recipeId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecipe(Recipe przepis) {
        try {
            String command = "update przepis set nazwa=? ,opis=? ,ocena=? , typ=?, zdjecie=? where id_przepis=?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            // Parameters start with 1
            preparedStatement.setString(1, przepis.getNazwa());
            preparedStatement.setString(2, przepis.getOpis());
            preparedStatement.setInt(3, przepis.getOcena());
            preparedStatement.setInt(4, przepis.getTyp());
            preparedStatement.setString(5, przepis.getZdjecie());
            preparedStatement.setLong(6, przepis.getId_przepis());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<Recipe>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from przepis");
            while (rs.next()) {
                Recipe przepis = new Recipe();
                przepis.setId_przepis(rs.getLong("id_przepis"));
                przepis.setNazwa(rs.getString("nazwa"));
                przepis.setOpis(rs.getString("opis"));
                przepis.setOcena(rs.getInt("ocena"));
                przepis.setTyp(rs.getInt("typ"));
                przepis.setZdjecie(rs.getString("zdjecie"));
                recipes.add(przepis);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipes;
    }

    public Recipe getRecipeById(long przepisId) {
        Recipe przepis = new Recipe();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from przepis where id_przepis=?");
            preparedStatement.setLong(1, przepisId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                przepis.setId_przepis(rs.getLong("id_przepis"));
                przepis.setNazwa(rs.getString("nazwa"));
                przepis.setOpis(rs.getString("opis"));
                przepis.setOcena(rs.getInt("ocena"));
                przepis.setTyp(rs.getInt("typ"));
                przepis.setZdjecie(rs.getString("zdjecie"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return przepis;
    }


    public List<Recipe> getAllRecipes_byTyp(int typ, List<Ingredient> dislikes) {

        List<Recipe> recipes = new ArrayList<Recipe>();
        List<List<Recipe>> recipesWithoutIngredient = new ArrayList<List<Recipe>>();
        for(Ingredient i:dislikes) {
            recipesWithoutIngredient.add(getRecipesWithoutIngredient(i.getId_skladnik()));
        }
        boolean Information = false;
        try {
            String selectSQL = "select * from przepis where typ=?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, typ);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Recipe przepis = new Recipe();
                przepis.setId_przepis(rs.getLong("id_przepis"));
                przepis.setNazwa(rs.getString("nazwa"));
                przepis.setOpis(rs.getString("opis"));
                przepis.setOcena(rs.getInt("ocena"));
                przepis.setTyp(rs.getInt("typ"));
                przepis.setZdjecie(rs.getString("zdjecie"));
                for(List<Recipe> list :recipesWithoutIngredient) {
                    for (Recipe r : list) {
                        if (r.getId_przepis() == przepis.getId_przepis()) {
                            Information = true;
                        }
                    }
                }
                if(Information == false) {
                    recipes.add(przepis);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    public List<Recipe> generateDiet(Diet diet,  List<Ingredient> dislikes){
        int type=1;
        List<Recipe> recipes = new ArrayList<Recipe>();
        for(List<Recipe> i : diet.get_Days()) {
            List<Recipe> meal = this.getAllRecipes_byTyp(type, dislikes);
            for (int counter = 0; counter < 5; counter++) {
                int list_size = meal.size();
                Random rand = new Random();
                int meal_position_in_list = rand.nextInt(list_size);
                Recipe recipe = meal.get(meal_position_in_list);
                i.add(recipe);
            }
            recipes = i;
            type=type+1;
        }
        return recipes;
    }

    public  List<Recipe> getRecipesWithoutIngredient(long id) {

        List<Recipe> recipes = new ArrayList<Recipe>();
        try {

            String selectSQL1 = "select id_przepis from przepis_skladnik where id_skladnik=?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL1);
            preparedStatement.setLong(1, id);
            ResultSet rs1 = preparedStatement.executeQuery();
            String selectSQL2 = "select * from przepis where 1";
            while (rs1.next()){
                String q = rs1.getString("id_przepis");
                selectSQL2 = selectSQL2 +" and "+ "id_przepis!="+q;
            }
                PreparedStatement preparedStatement2 = connection.prepareStatement(selectSQL2);
                ResultSet rs2 = preparedStatement2.executeQuery();
                while (rs2.next()) {

                    Recipe przepis = new Recipe();
                    przepis.setId_przepis(rs2.getLong("id_przepis"));
                    przepis.setNazwa(rs2.getString("nazwa"));
                    przepis.setOpis(rs2.getString("opis"));
                    przepis.setOcena(rs2.getInt("ocena"));
                    przepis.setTyp(rs2.getInt("typ"));
                    przepis.setZdjecie(rs2.getString("zdjecie"));
                    recipes.add(przepis);
                }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

}
