package com.dreamteam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dreamteam.dao.recipeDao;
import com.dreamteam.model.Recipe;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import com.dreamteam.model.Ingredient;
//import com.dreamteam.model.PDFGenerator;

public class RecipeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Recipe.jsp";
    private static String LIST_RECIPE = "/listRecipes.jsp";
    private static String DIET_GENERATOR = "/dietGenerator.jsp";
    private recipeDao dao;

    public RecipeController() {
        super();
        dao = new recipeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");


        if (action.equalsIgnoreCase("delete")) {
            long recipeID = Long.parseLong(request.getParameter("id_przepis"));
            dao.deleteRecipe(recipeID);
            forward = LIST_RECIPE;
            request.setAttribute("przepisy", dao.getAllRecipes());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            long recipeID = Long.parseLong(request.getParameter("id_przepis"));
            Recipe recipe = dao.getRecipeById(recipeID);
            request.setAttribute("przepis", recipe);
        } else if (action.equalsIgnoreCase("listRecipes")) {
            forward = LIST_RECIPE;
            request.setAttribute("przepisy", dao.getAllRecipes());
        } else if (action.equalsIgnoreCase("CreateDiet")) {
            forward = DIET_GENERATOR;

            List<Recipe> Poniedzialek = new ArrayList<Recipe>();
            for(int counter =0; counter<5; counter ++) {
                List<Recipe> meal = dao.getAllRecipes_byTyp(counter + 1);
                int list_size = meal.size();
                Random rand = new Random();
                int meal_position_in_list = rand.nextInt(list_size);
                if(meal_position_in_list == 0){
                    meal_position_in_list =1;
                }
                Recipe recipe = meal.get(meal_position_in_list);
                Poniedzialek.add(recipe);
            }
            request.setAttribute("poniedzialek", Poniedzialek);
            request.setAttribute("secondmeal", dao.getAllRecipes_byTyp(2));
            request.setAttribute("beforetraining", dao.getAllRecipes_byTyp(3));
            request.setAttribute("aftertraining", dao.getAllRecipes_byTyp(4));
            request.setAttribute("beforesleep", dao.getAllRecipes_byTyp(5));

        } else if (action.equalsIgnoreCase("SearchRecipes")) {
            forward = LIST_RECIPE;
           //int ingredient = Int.parseInt(request.getParameter("name_skladnik"));
           //request.setAttribute("przepisy", dao.getRecipesWithoutIngredient(ingredient));
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Recipe recipe = new Recipe();
        recipe.setNazwa(request.getParameter("nazwa"));
        recipe.setOpis(request.getParameter("opis"));
        recipe.setOcena(Integer.parseInt(request.getParameter("ocena")));
        recipe.setTyp(Integer.parseInt(request.getParameter("typ")));
        recipe.setZdjecie(request.getParameter("zdjecie"));
        String recipeId = request.getParameter("id_przepis");
        if(recipeId == null || recipeId.isEmpty())
        {
            dao.addRecipe(recipe);
        }
        else
        {
            recipe.setId_przepis(Long.parseLong(recipeId));
            dao.updateRecipe(recipe);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_RECIPE);
        request.setAttribute("przepisy", dao.getAllRecipes());
        view.forward(request, response);
    }
}
