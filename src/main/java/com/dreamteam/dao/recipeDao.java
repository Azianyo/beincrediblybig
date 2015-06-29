package com.dreamteam.dao;


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
            String command="update przepis set nazwa=? ,opis=? ,ocena=? , typ=?, zdjecie=? where id_przepis=?";
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
    public Recipe getRecipeWithoutId(long przepisId) {
        Recipe przepis = new Recipe();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from przepis where id_przepis!=?");
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
    public long getRecipeByIdIngredient(long SkladnikId) {
        long id=666; //liczba z dupy zeby dalo sie skompilowac
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select id_przepis from przepis_skladnik where id_skladnik=?");
            preparedStatement.setLong(1, SkladnikId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                id = rs.getLong("id_przepis");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public  List<Recipe> getAllRecipes_byTyp(int typ) {

        List<Recipe> recipes = new ArrayList<Recipe>();
        try {
            String selectSQL = "select * from przepis where typ=?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, typ);
            ResultSet rs = preparedStatement.executeQuery("selectSQL");

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

}
