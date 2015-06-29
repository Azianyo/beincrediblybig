package com.dreamteam.controller;

import com.dreamteam.dao.RecipeConnectDao;
import com.dreamteam.model.FullRecipe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jan on 2015-06-29.
 */
public class FullRecipeController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String MAIN_PAGE = "/index.jsp";
    private static String SHOW_OR_ADD_BICEPS = "/showRecipe.jsp";
    private RecipeConnectDao dao;

    public FullRecipeController() {
        super();
        dao = new RecipeConnectDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long idRecipe;
        String forward = "";
        String isBicepsGiven = request.getParameter("giveBiceps");
        String isMainPageRequested = request.getParameter("mainPage");
        long id =1; //Long.parseLong(request.getParameter("id_przepis"));

        if (isBicepsGiven != null) {
            idRecipe = 1 ; //Long.parseLong(request.getParameter("id"));
            dao.addBiceps(idRecipe);
            FullRecipe fullRecipe;
            fullRecipe = dao.getFullRecipeByID(idRecipe);
            request.setAttribute("skladniki", fullRecipe.ingredients);
            request.setAttribute("przepis", fullRecipe.recipe);
            forward = SHOW_OR_ADD_BICEPS;
        } else if (isMainPageRequested != null) {
            forward = MAIN_PAGE;
        } else {
            FullRecipe fullRecipe;
            fullRecipe = dao.getFullRecipeByID(id);
            request.setAttribute("skladniki", fullRecipe.ingredients);
            request.setAttribute("przepis", fullRecipe.recipe);
            forward = SHOW_OR_ADD_BICEPS;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
