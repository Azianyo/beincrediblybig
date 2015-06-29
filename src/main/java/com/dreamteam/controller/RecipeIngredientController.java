package com.dreamteam.controller;

import com.dreamteam.dao.RecipeIngedientDao;
import com.dreamteam.dao.recipeDao;
import com.dreamteam.model.przepis_skladnik;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Michał on 2015-06-27.
 * After acroyoga workout
 */
public class RecipeIngredientController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/RecipeIngredient.jsp";
    private static String LIST_RECIPE_INGREDIENTS = "/listRecipeIngredients.jsp";
    private RecipeIngedientDao dao;

    public RecipeIngredientController() {
        super();
        dao = new RecipeIngedientDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");


        if (action.equalsIgnoreCase("delete")){
            long recipeIngredientID = Long.parseLong(request.getParameter("id_przepis_skladnik"));
            dao.deleteRecipeIngredient(recipeIngredientID);
            forward = LIST_RECIPE_INGREDIENTS;
            request.setAttribute("przepis_skladnik", dao.getAllRecipeIngredients());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            long recipeIngredientID = Long.parseLong(request.getParameter("id_przepis_skladnik"));
            przepis_skladnik recipeIngredient = dao.getRecipeIngredientById(recipeIngredientID);
            request.setAttribute("przepis_skladnik", recipeIngredient );
        } else if (action.equalsIgnoreCase("listRecipesIngredients")){
            forward = LIST_RECIPE_INGREDIENTS;
            request.setAttribute("przepis_skladnik", dao.getAllRecipeIngredients());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        przepis_skladnik recipeIngredient = new przepis_skladnik();
        recipeIngredient.setId_przepis(Integer.parseInt(request.getParameter("id_przepis")));
        recipeIngredient.setId_skladnik(Integer.parseInt(request.getParameter("id_skladnik")));
        recipeIngredient.setIlosc(Integer.parseInt(request.getParameter("ilosc")));
        String recipeIngredientId = request.getParameter("id_przepis_skladnik");
        if(recipeIngredientId == null || recipeIngredientId.isEmpty())
        {
            dao.addRecipeIngredient(recipeIngredient);
        }
        else
        {
            recipeIngredient.setId_przepis_skladnik(Long.parseLong(recipeIngredientId));
            dao.updateRecipeIngredient(recipeIngredient);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_RECIPE_INGREDIENTS);
        request.setAttribute("przepis_skladnik", dao.getAllRecipeIngredients());
        view.forward(request, response);
    }

}
