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


import com.dreamteam.model.Meal;
import com.dreamteam.dao.MealDao;

public class MealController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Meals.jsp";
    private static String LIST_MEAL = "/listMeals.jsp";
    private MealDao dao;

    public MealController() {
        super();
        dao = new MealDao();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");


        if (action.equalsIgnoreCase("delete")){
            long mealID = Long.parseLong(request.getParameter("id_posilek"));
            dao.deleteMeal(mealID);
            forward = LIST_MEAL;
            request.setAttribute("posilki", dao.getAllMeals());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            long mealID = Long.parseLong(request.getParameter("id_posilek"));
            Meal meal = dao.getMealById(mealID);
            request.setAttribute("posilek", meal );
        } else if (action.equalsIgnoreCase("listMeals")){
            forward = LIST_MEAL;
            request.setAttribute("posilki", dao.getAllMeals());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Meal meal = new Meal();
        meal.setNazwa(request.getParameter("nazwa"));
        String mealId = request.getParameter("id_posilek");
        if(mealId == null || mealId.isEmpty())
        {
            dao.addMeal(meal);
        }
        else
        {
            meal.setId_posilek(Long.parseLong(mealId));
            dao.updateMeal(meal);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_MEAL);
        request.setAttribute("posilki", dao.getAllMeals());
        view.forward(request, response);
    }
}

