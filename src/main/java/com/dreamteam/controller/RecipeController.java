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
import com.dreamteam.model.PDFGenerator;

public class RecipeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Recipe.jsp";
    private static String LIST_RECIPE = "/listRecipes.jsp";
    private static String DIET_GENERATOR = "/dietGenerator.jsp";
    private static String MAIN = "/index.jps";
    private recipeDao dao;

    public RecipeController() {
        super();
        dao = new recipeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");


        if (action.equalsIgnoreCase("delete")){
            long recipeID = Long.parseLong(request.getParameter("id_przepis"));
            dao.deleteRecipe(recipeID);
            forward = LIST_RECIPE;
            request.setAttribute("przepisy", dao.getAllRecipes());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            long recipeID = Long.parseLong(request.getParameter("id_przepis"));
            Recipe recipe = dao.getRecipeById(recipeID);
            request.setAttribute("przepis", recipe );
        } else if (action.equalsIgnoreCase("listRecipes")){
            forward = LIST_RECIPE;
            request.setAttribute("przepisy", dao.getAllRecipes());

        } else if (action.equalsIgnoreCase("CreateDiet")){
            forward = DIET_GENERATOR;
        } else if (action.equalsIgnoreCase("generate")){
            forward = MAIN;
            long recipeID = Long.parseLong(request.getParameter("id_przepis"));
            Recipe recipe = dao.getRecipeById(recipeID);
            new PDFGenerator(recipe);
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
