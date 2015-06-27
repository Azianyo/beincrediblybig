package com.dreamteam.dao;

/**
 * Created by macie_000 on 2015-06-27.
 */
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dreamteam.model.Ingredient;
import com.dreamteam.model.Recipe;
import com.dreamteam.util.DbUtil;
public class ingredientDAO {
    private Connection connection;

    public ingredientDAO() {
        connection = DbUtil.getConnection();
    }

    public void addIngredient(Ingredient skladnik) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into skladnik (nazwa) values (?) )");
            // Parameters start with 1
            preparedStatement.setString(1, skladnik.getNazwa());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteIngredient(long IngredientId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from skladnik where id_skladnik=?");
            // Parameters start with 1
            preparedStatement.setLong(1, ingredientId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecipe(Recipe przepis) {
        try {
            String command="update przepis set nazwa=? where id_skladnik=?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            // Parameters start with 1
            BufferedWriter out = null;
            try {
                FileWriter fstream = new FileWriter("history.txt", true); //true tells to append data.
                out = new BufferedWriter(fstream);
                out.write(command);
            }
            catch (IOException e)
            {
                System.err.println("Error: " + e.getMessage());
            }
            finally
            {
                try {
                    out.close();
                }
                catch (IOException e){
                    System.err.println("Error: " + e.getMessage());
                }
            }
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

    public Recipe getRecipeById(int przepisId) {
        Recipe przepis = new Recipe();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from przepis where id_przepis=?");
            preparedStatement.setLong(1, przepis.getId_przepis());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                przepis.setId_przepis(rs.getLong("przepis_id"));
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
}
}
