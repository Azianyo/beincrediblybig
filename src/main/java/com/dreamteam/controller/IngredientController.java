package com.dreamteam.controller;

/**
 * Created by macie_000 on 2015-06-27.
 */
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dreamteam.model.Ingredient;
import com.dreamteam.dao.ingredientDAO;

public class IngredientController extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private static String INSERT_OR_EDIT = "/index.jsp";
        private static String LIST_INGREDIENT = "/listIngredients.jsp";
        private ingredientDAO dao;

        public IngredientController() {
            super();
            dao = new ingredientDAO();
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");


        if (action.equalsIgnoreCase("delete")){
            long ingredientID = Long.parseLong(request.getParameter("id_skladnik"));
            dao.deleteIngredient(ingredientID);
            forward = LIST_INGREDIENT;
            request.setAttribute("sladniki", dao.getAllIngredients());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int ingredientID = Integer.parseInt(request.getParameter("id_skladnik"));
            Ingredient ingredient = dao.getIngredientById(ingredientID);
            request.setAttribute("skladniki", ingredient );
        } else if (action.equalsIgnoreCase("listIngredients")){
            forward = LIST_INGREDIENT;
            request.setAttribute("skladniki", dao.getAllIngredients());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ingredient ingredient = new Ingredient();
        ingredient.setNazwa(request.getParameter("nazwa"));
        String ingredientId = request.getParameter("id_skladnik");
        if(ingredientId == null || ingredientId.isEmpty())
        {
            dao.addIngredient(ingredient);
        }
        else
        {
            ingredient.setId_skladnik(Long.parseLong(ingredientId));
            dao.updateIngredient(ingredient);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_INGREDIENT);
        request.setAttribute("przepisy", dao.getAllIngredients());
        view.forward(request, response);
    }
}
