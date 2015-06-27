package com.dreamteam.controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dreamteam.dao.UserDao;

import com.dreamteam.model.User;

import java.io.IOException;


public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/User.jsp";
	private static String LIST_USERS = "/listUsers.jsp";
	private UserDao dao;

	public UserController() {
		super();
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		String action = request.getParameter("action");


		if (action.equalsIgnoreCase("delete")){
			long userID = Long.parseLong(request.getParameter("id_uzytkownik"));
			dao.deleteUser(userID);
			forward = LIST_USERS;
			request.setAttribute("users", dao.getAllUsers());
		} else if (action.equalsIgnoreCase("edit")){
			forward = INSERT_OR_EDIT;
			int userID = Integer.parseInt(request.getParameter("id_uzytkownika"));
			User user = dao.getUserById(userID);
			request.setAttribute("user", user);
		} else if (action.equalsIgnoreCase("listUsers")){
			forward = LIST_USERS;
			request.setAttribute("users", dao.getAllUsers());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setHaslo(request.getParameter("haslo"));
		user.setIsAdmin(Integer.parseInt(request.getParameter("isAdmin")));

		String userId = request.getParameter("id_uzytkownik");
		if(userId == null || userId.isEmpty())
		{
			dao.addUser(user);
		}
		else
		{
			user.setId_uzytkownik(Long.parseLong(userId));
			dao.updateUser(user);
		}

		RequestDispatcher view = request.getRequestDispatcher(LIST_USERS);
		request.setAttribute("users", dao.getAllUsers());
		view.forward(request, response);
	}
}
