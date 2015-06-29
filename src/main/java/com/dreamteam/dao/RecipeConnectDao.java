package com.dreamteam.dao;

import com.dreamteam.dao.recipeDao;
import com.dreamteam.dao.RecipeIngedientDao;
import com.dreamteam.dao.ingredientDAO;
import com.dreamteam.model.Ingredient;
import com.dreamteam.model.Recipe;
import com.dreamteam.model.przepis_skladnik;
import com.dreamteam.model.FullRecipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Michał on 2015-06-29.
 */

public class RecipeConnectDao {
    FullRecipe getFullRecipeByID(long recipeID){
        recipeDao recipeDao2read= new recipeDao();
        final Recipe recipe2read;
        recipe2read= recipeDao2read.getRecipeById(recipeID);

        RecipeIngedientDao recipeIngredient2readDao = new RecipeIngedientDao();
        List<przepis_skladnik> recipeIngredients= recipeIngredient2readDao.getRecipeIngredientsByIDRecipe(recipeID);
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
}
