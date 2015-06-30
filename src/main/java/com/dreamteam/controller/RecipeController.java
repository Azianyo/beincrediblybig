package com.dreamteam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dreamteam.dao.ingredientDAO;
import com.dreamteam.dao.recipeDao;
import com.dreamteam.model.Diet;
import com.dreamteam.model.Recipe;
import com.dreamteam.model.Ingredient;
import java.util.Random;
//import com.dreamteam.model.PDFGenerator;

public class RecipeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Recipe.jsp";
    private static String LIST_RECIPE = "/listRecipes.jsp";
    private static String DIET_GENERATOR = "/diet.jsp";
    private static String MAIN = "/index.jsp";
    private recipeDao dao;
    private String forward = "";

    public RecipeController() {
        super();
        dao = new recipeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        } else if (action.equalsIgnoreCase("show")) {
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
        } else if (action.equalsIgnoreCase("Stworz diete")) {
            ingredientDAO ingredient_dao = new ingredientDAO();
            forward = DIET_GENERATOR;
            String [] dislikes_ingredient_name = request.getParameterValues("ingredientname");
            List<Ingredient> dislikes = ingredient_dao.dislikes(dislikes_ingredient_name);
            Diet Diet = new Diet();
            dao.generateDiet(Diet, dislikes);
            request.setAttribute("poniedzialek", Diet.get_FirstMeal());
            request.setAttribute("wtorek", Diet.get_SecondMeal());
            request.setAttribute("sroda", Diet.get_ThirdMeal());
            request.setAttribute("czwartek", Diet.get_FourthMeal());
            request.setAttribute("piatek", Diet.get_FifthMeal());
        } else if (action.equalsIgnoreCase("Wyszukaj przepis")) {
            ingredientDAO ingredient_dao = new ingredientDAO();
            forward = LIST_RECIPE;
            String [] dislikes_ingredient_name = request.getParameterValues("ingredientname");
            List<Ingredient> dislikes = ingredient_dao.dislikes(dislikes_ingredient_name);
            request.setAttribute("przepisy", dao.getRecipesWithoutIngredient(dislikes));
        }else{
            forward = MAIN;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        /*
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
        */

        if (action.equalsIgnoreCase("Stworz diete")) {
            ingredientDAO ingredient_dao = new ingredientDAO();
            forward = DIET_GENERATOR;
            String [] dislikes_ingredient_name = request.getParameterValues("ingredientname");
            List<Ingredient> dislikes = ingredient_dao.dislikes(dislikes_ingredient_name);

            Diet Diet = new Diet();
            dao.generateDiet(Diet, dislikes);
            request.setAttribute("sniadanie", Diet.get_FirstMeal());
            request.setAttribute("drugie_sniadanie", Diet.get_SecondMeal());
            request.setAttribute("przed_treningiem", Diet.get_ThirdMeal());
            request.setAttribute("po_treningu", Diet.get_FourthMeal());
            request.setAttribute("kolacja", Diet.get_FifthMeal());
;
        } else if (action.equalsIgnoreCase("Wyszukaj przepis")) {
            ingredientDAO ingredient_dao = new ingredientDAO();
            forward = LIST_RECIPE;
            String [] dislikes_ingredient_name = request.getParameterValues("ingredientname");
            List<Ingredient> dislikes = ingredient_dao.dislikes(dislikes_ingredient_name);
            request.setAttribute("przepisy", dao.getRecipesWithoutIngredient(dislikes));
        }else{
            forward = MAIN;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
