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

import com.dreamteam.model.Meal;

import com.dreamteam.util.DbUtil;
public class MealDao {
    private Connection connection;

    public MealDao() {
        connection = DbUtil.getConnection();
    }

    public void addMeal(Meal posilek) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into posilek (nazwa) values (?)");
            // Parameters start with 1
            preparedStatement.setString(1, posilek.getNazwa());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMeal(long MealId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from posilek where id_posilek=?");
            // Parameters start with 1
            preparedStatement.setLong(1, MealId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMeal(Meal posilek) {
        try {
            String command="update posilek set nazwa=? where id_posilek=?";
            PreparedStatement preparedStatement = connection.prepareStatement(command);
            // Parameters start with 1

            preparedStatement.setString(1, posilek.getNazwa());
            preparedStatement.setLong(2, posilek.getId_posilek());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Meal> getAllMeals() {
        List<Meal> Meals = new ArrayList<Meal>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from posilek");
            while (rs.next()) {
                Meal posilek = new Meal();
                posilek.setId_posilek(rs.getLong("id_posilek"));
                posilek.setNazwa(rs.getString("nazwa"));

                Meals.add(posilek);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Meals;
    }

    public Meal getMealById(long posilekId) {
        Meal posilek = new Meal();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from posilek where id_posilek=?");
            preparedStatement.setLong(1, posilekId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                posilek.setId_posilek(rs.getLong("id_posilek"));
                posilek.setNazwa(rs.getString("nazwa"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posilek;
    }
}

