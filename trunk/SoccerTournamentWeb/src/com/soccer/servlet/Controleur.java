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
	public static final String PAGES_PATH = "pages/";
	public static final String CSS_PATH = "styles/";
	public static final String ACTION_NEW_TEAM = "newteam";
	public static final String ACTION_LOGIN = "login";
	public static final String ACTION_ADD = "ajout";

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
		String action = request.getParameter("action");
		System.out.println(action);

		// si l'action est nulle ou l'action égale à home
		if ((action == null) || (action.equals("home"))) {
			// direction la page d'accueil
			request.getRequestDispatcher(PAGES_PATH + "index.jsp").forward(
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
			// Nouvelle equipe
			if (nomEquipe != null && nomRepresentant != null
					&& prenomRepresentant != null && nomsJoueurs != null
					&& prenomsJoueurs != null) {
				facade.creerEquipe(nomEquipe, nomRepresentant,
						prenomRepresentant, nomsJoueurs, prenomsJoueurs);
			}
			// direction la page d'inscription d'une équipe
			request.getRequestDispatcher(PAGES_PATH + "newteam.jsp").forward(
					request, response);
		}
		// si l'action est de se connecter ( pour l'admin)
		else if (action.equals(ACTION_LOGIN)) {
			String login = request.getParameter("login");
			String passwd = request.getParameter("password");
			if (login != null && passwd != null) {
				System.err.println("Logging... " + login + " -> " + passwd);
			}
			// direction la page d'inscription
			request.getRequestDispatcher(PAGES_PATH + "login.jsp").forward(
					request, response);
		} else if (action.equals("404")) {
			System.err.println("404");
		}
	}
}
