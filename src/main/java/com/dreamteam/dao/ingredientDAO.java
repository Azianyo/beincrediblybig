package com.dreamteam.dao;

/**
 * Created by macie_000 on 2015-06-27.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dreamteam.model.Ingredient;

import com.dreamteam.util.DbUtil;
public class ingredientDAO {
    private Connection connection;

    public ingredientDAO() {
        connection = DbUtil.getConnection();
    }

    public void addIngredient(Ingredient skladnik) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into skladnik (nazwa) values (?)");
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
            preparedStatement.setLong(1, IngredientId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateIngredient(Ingredient skladnik) {
        try {
            String command="update skladnik set nazwa=? where id_skladnik=?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            // Parameters start with 1

            preparedStatement.setString(1, skladnik.getNazwa());
            preparedStatement.setLong(2, skladnik.getId_skladnik());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ingredient> getAllIngredients() {
        List<Ingredient> Ingredients = new ArrayList<Ingredient>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from skladnik");
            while (rs.next()) {
                Ingredient skladnik = new Ingredient();
                skladnik.setId_skladnik(rs.getLong("id_skladnik"));
                skladnik.setNazwa(rs.getString("nazwa"));

                Ingredients.add(skladnik);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Ingredients;
    }

    public Ingredient getIngredientById(long skladnikId) {
        Ingredient skladnik = new Ingredient();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from skladnik where id_skladnik=?");
            preparedStatement.setLong(1, skladnikId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                skladnik.setId_skladnik(rs.getLong("id_skladnik"));
                skladnik.setNazwa(rs.getString("nazwa"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return skladnik;
    }
}

