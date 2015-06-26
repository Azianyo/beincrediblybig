package com.dreamteam.controller;

/**
 * chuj, dupa, kurwa, cipa.
 */

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dreamteam.dao.recipeDao;
import com.dreamteam.model.Recipe;

public class RecipeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_RECIPE = "/listUser.jsp";
    private recipeDao dao;

    public RecipeController() {
        super();
        dao = new recipeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            long recipeID = Long.parseLong(request.getParameter("przepis_id"));
            dao.deleteRecipe(recipeID);
            forward = LIST_RECIPE;
            request.setAttribute("przepis", dao.getAllRecipes());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int recipeID = Integer.parseInt(request.getParameter("przepis_id"));
            Recipe user = dao.getRecipeById(recipeID);
            request.setAttribute("przepis", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_RECIPE;
            request.setAttribute("users", dao.getAllRecipes());
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
        recipe.setTyp(Integer.parseInt(request.getParameter("typ")));
        recipe.setZdjecie();


        String recipeId = request.getParameter("id_przepis");
        if(recipeId == null || recipeId.isEmpty())
        {
            dao.addRecipe(recipe);
        }
        else
        {
            recipe.setId_przepis(Integer.parseInt(recipeId));
            dao.updateRecipe(recipe);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_RECIPE);
        request.setAttribute("users", dao.getAllRecipes());
        view.forward(request, response);
    }
}
