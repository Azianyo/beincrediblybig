package com.dreamteam.dao;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            PreparedStatement preparedStatement = connection.prepareStatement("delete from przepis where przepis_id=?");
            // Parameters start with 1
            preparedStatement.setLong(1, recipeId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecipe(Recipe przepis) {
        try {
            String command="update przepis set nazwa=? , " +
                    "opis=? ,ocena=? , typ=?, zdjecie=?" + "where przepis_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            // Parameters start with 1
            BufferedWriter out = null;
            try {
                FileWriter fstream = new FileWriter("out.txt", true); //true tells to append data.
                out = new BufferedWriter(fstream);
                out.write("\nsue");
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
            Recipe przepis = new Recipe();
            while (rs.next()) {
                przepis.setId_przepis(rs.getLong("przepis_id"));
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
                    prepareStatement("select * from users where userid=?");
            preparedStatement.setInt(1, przepisId);
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
