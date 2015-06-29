package com.dreamteam.dao;

import com.dreamteam.model.Ingredient;
import com.dreamteam.model.Recipe;
import com.dreamteam.model.RecipeToIngredient;
import com.dreamteam.model.FullRecipe;
import com.dreamteam.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał on 2015-06-29.
 */

public class RecipeConnectDao {
    private Connection connection;

    public RecipeConnectDao() {
        connection = DbUtil.getConnection();
    }
    public FullRecipe getFullRecipeByID(long recipeID){
        recipeDao recipeDao2read= new recipeDao();
        final Recipe recipe2read;
        recipe2read= recipeDao2read.getRecipeById(recipeID);

        RecipeIngedientDao recipeIngredient2readDao = new RecipeIngedientDao();
        List<RecipeToIngredient> recipeIngredients= recipeIngredient2readDao.getRecipeIngredientsByIDRecipe(recipeID);
        List<Ingredient> ingredients2read =new ArrayList<Ingredient>();

        ingredientDAO ingredient2read= new ingredientDAO();

        for(int i=0; i< recipeIngredients.size(); i++){
            long idIngredient=recipeIngredients.get(i).getId_skladnik();
            ingredients2read.add(ingredient2read.getIngredientById(idIngredient));
        }
        FullRecipe fullRecipe = new FullRecipe();
        fullRecipe.recipe=recipe2read;
        fullRecipe.ingredients=ingredients2read;
        return fullRecipe;
    }
    public void addBiceps(long idRecipe){
    try {
        String command="update przepis set ocena=ocena+1 where id_przepis=?";
        PreparedStatement preparedStatement = connection.prepareStatement(command);
        // Parameters start with 1
        preparedStatement.setLong(1, idRecipe);
        preparedStatement.executeUpdate();
     } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
