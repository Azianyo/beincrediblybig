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
            List<Recipe> P = new ArrayList<Recipe>();
            List<Recipe> D = new ArrayList<Recipe>();
            List<Recipe> T = new ArrayList<Recipe>();
            List<Recipe> C = new ArrayList<Recipe>();
            List<Recipe> Piate = new ArrayList<Recipe>();
            List<List<Recipe>> Week = new ArrayList<List<Recipe>>();
            Week.add(P);
            Week.add(D);
            Week.add(T);
            Week.add(C);
            Week.add(Piate);
            for(List<Recipe> i : Week) {
                int j=1;
                List<Recipe> meal = dao.getAllRecipes_byTyp(j);
                for (int counter = 0; counter < 5; counter++) {
                    int list_size = meal.size();
                    Random rand = new Random();
                    int meal_position_in_list = rand.nextInt(list_size);
                    Recipe recipe = meal.get(meal_position_in_list);
                    i.add(recipe);
                }
                j++;
            }
            request.setAttribute("poniedzialek", P);
            request.setAttribute("wtorek", D);
            request.setAttribute("sroda", T);
            request.setAttribute("czwartek", C);
            request.setAttribute("piatek", Piate);

        } else if (action.equalsIgnoreCase("SearchRecipes")) {
            forward = LIST_RECIPE;
           long ingredient = Long.parseLong(request.getParameter("name_skladnik"));
          request.setAttribute("przepisy", dao.getRecipesWithoutIngredient(ingredient));
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
