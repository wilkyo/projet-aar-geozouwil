package com.soccer.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.ejb.facade.SoccerTournamentFacadeLocal;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/index")
public class Controleur extends HttpServlet {
	public static final long serialVersionUID = 1L;
	public static final String WEB_PATH = "/SoccerTournamentWeb/";
	public static final String CSS_PATH = "styles/";
	public static final String PAGES_PATH = "pages/";
	public static final String INCLUDES_PATH = "includes/";

	public static final String SERVLET_PATH = "index?action=";
	public static final String ACTION_HOME = "home";
	public static final String ACTION_NEW_TEAM = "newteam";
	public static final String ACTION_LOGIN = "login";

	public static final String JSP_HOME = "index.jsp";
	public static final String JSP_LOGIN = "login.jsp";
	public static final String JSP_NEW_TEAM = "newteam.jsp";
	public static final String JSP_404 = "404.jsp";

	@EJB
	private SoccerTournamentFacadeLocal facade;

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
		// Initializes the DB
		facade.initDB();

		String action = request.getParameter("action");
		System.out.println("Action=" + action);

		// si l'action est nulle ou l'action égale à home
		if ((action == null) || (action.equals(ACTION_HOME))) {
			// direction la page d'accueil
			request.getRequestDispatcher(PAGES_PATH + JSP_HOME).forward(
					request, response);
		}
		// si l'action est l'inscription d'une équipe
		else if (action.equals(ACTION_NEW_TEAM)) {
			String nomEquipe = request.getParameter("nomEquipe");
			String nomRepresentant = request.getParameter("nomRepresentant");
			String prenomRepresentant = request
					.getParameter("prenomRepresentant");
			String[] nomsJoueurs = request.getParameterValues("nom[]");
			String[] prenomsJoueurs = request.getParameterValues("prenom[]");
			String[] numeroJoueurs = request.getParameterValues("numero[]");
			// Nouvelle equipe
			if (nomEquipe != null && nomRepresentant != null
					&& prenomRepresentant != null && nomsJoueurs != null
					&& prenomsJoueurs != null && numeroJoueurs != null) {
				if (facade.creerEquipe(nomEquipe, nomRepresentant,
						prenomRepresentant, nomsJoueurs, prenomsJoueurs,
						toIntegerArray(numeroJoueurs)))
					request.getRequestDispatcher(SERVLET_PATH + ACTION_HOME)
							.forward(request, response);
				else {
					request.setAttribute("exists", true);
					request.getRequestDispatcher(PAGES_PATH + JSP_NEW_TEAM)
							.forward(request, response);
				}
			} else
				// direction la page d'inscription d'une équipe
				request.getRequestDispatcher(PAGES_PATH + JSP_NEW_TEAM)
						.forward(request, response);
		}
		// si l'action est de se connecter (pour l'admin)
		else if (action.equals(ACTION_LOGIN)) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			if (login != null && password != null) {
				if (facade.connexion(login, password)) {
					request.getSession().setAttribute("admin", login);
					request.getRequestDispatcher(SERVLET_PATH + ACTION_HOME)
							.forward(request, response);
				} else {
					request.setAttribute("error", true);
					request.getRequestDispatcher(PAGES_PATH + JSP_LOGIN)
							.forward(request, response);
				}
			} else
				// direction la page d'inscription
				request.getRequestDispatcher(PAGES_PATH + JSP_LOGIN).forward(
						request, response);
		} else if (action.equals("404")) {
			request.getRequestDispatcher(PAGES_PATH + JSP_404).forward(request,
					response);
		}
	}

	/**
	 * Casts the String Array into an Integer Array.
	 * 
	 * @param array
	 *            String Array.
	 * @return Integer Array.
	 */
	private int[] toIntegerArray(String[] array) {
		int[] res = new int[array.length];
		for (int i = 0; i < res.length; i++) {
			try {
				res[i] = Integer.parseInt(array[i]);
			} catch (java.lang.NumberFormatException e) {
				res[i] = 0;
			}
		}
		return res;
	}
}
