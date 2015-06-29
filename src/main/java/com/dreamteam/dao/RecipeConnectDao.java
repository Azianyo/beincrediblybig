package com.dreamteam.dao;

import com.dreamteam.model.*;
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
        List<IngredientWithAmount> ingredientsWithAmount2read =new ArrayList<IngredientWithAmount>();
        ingredientDAO ingredient2read= new ingredientDAO();



        for(int i=0; i< recipeIngredients.size(); i++){
            IngredientWithAmount IWA=  new IngredientWithAmount();
            long idIngredient=recipeIngredients.get(i).getId_skladnik();
            IWA.ingredient=ingredient2read.getIngredientById(idIngredient);
            IWA.amount=recipeIngredient2readDao.getAmountByID(idIngredient);
            ingredientsWithAmount2read.add(IWA);
        }
        FullRecipe fullRecipe = new FullRecipe();
        fullRecipe.recipe=recipe2read;
        fullRecipe.ingredients=ingredientsWithAmount2read;
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
