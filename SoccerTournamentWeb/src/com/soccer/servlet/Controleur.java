package com.soccer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/index")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PATH = "/pages/";
	private static final String ACTION_NEW_TEAM = "newteam";
	private static final String ACTION_LOGIN = "login";
	private static final String ACTION_ADD = "ajout";


	/**
	 * Default constructor.
	 */
	public Controleur() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);

		// si l'action est nulle ou l'action égale à home
		if ((action == null) || (action.equals("home"))) {
			// direction la page d'accueil
			request.getRequestDispatcher(PATH + "index.jsp").forward(request,
					response);
		}
		// si l'action est l'inscription d'une équipe
		else if (action.equals(ACTION_NEW_TEAM)) {
			// direction la page d'inscription d'une équipe
			request.getRequestDispatcher(PATH + "newteam.jsp").forward(request,
					response);
		}
		//Nouvelle equipe
		else if(action.equals(ACTION_ADD)){
			String []nom=request.getParameterValues("nom[]");
			String []prenom=request.getParameterValues("prenom[]");
			System.out.println(nom.length);
		}
		// si l'action est de se connecter ( pour l'admin)
		else if (action.equals(ACTION_LOGIN)) {
			String login = request.getParameter("login");
			String passwd = request.getParameter("password");
			if (login != null && passwd != null) {
				System.err.println("Logging... " + login + " -> " + passwd);
			}
			// direction la page d'inscription
			request.getRequestDispatcher(PATH + "login.jsp").forward(request,
					response);
		} else if (action.equals("404")) {
			System.err.println("404");
		}
	}
}
