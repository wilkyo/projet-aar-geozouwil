package com.soccer.servlet;

import java.io.IOException;
import java.util.GregorianCalendar;

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
	public static final String REDIRECT_PATH = "&redirect=";
	public static final String ACTION_REDIRECT = "redirect";
	public static final String ACTION_HOME = "home";
	public static final String ACTION_TEAM = "team";
	public static final String ACTION_NEW_TEAM = "newteam";
	public static final String ACTION_LOGIN = "login";
	public static final String ACTION_ADMIN_HOME = "adminhome";
	public static final String ACTION_CREATE_TOURNAMENT = "createtournament";
	public static final String ACTION_TOURNAMENT = "tournament";
	public static final String ACTION_MATCH = "match";
	public static final String ACTION_FAQ = "faq";
	public static final String ACTION_404 = "404";

	public static final String JSP_HOME = "index.jsp";
	public static final String JSP_TEAM = "team.jsp";
	public static final String JSP_MATCH = "match.jsp";
	public static final String JSP_NEW_TEAM = "newteam.jsp";
	public static final String JSP_FAQ = "faq.jsp";
	public static final String JSP_LOGIN = "login.jsp";
	public static final String JSP_ADMIN_HOME = "adminindex.jsp";
	public static final String JSP_TOURNAMENT = "tournament.jsp";
	public static final String JSP_404 = "404.jsp";
	public static final String JSP_REDIRECT = "redirect.jsp";

	public static final String SESSION_ADMIN = "admin";

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
		if (action == null)
			action = ACTION_HOME;
		System.out.println("Action=" + action);
		String dispatcher = "";

		// si l'action est nulle ou l'action égale à home
		if (action.equals(ACTION_HOME)) {
			request.setAttribute("tournois", facade.getTournois());
			// direction la page d'accueil
			dispatcher = jsp(JSP_HOME);
		}
		// si l'action est de voir une ou plusieurs équipes
		else if (action.equals(ACTION_TEAM)) {
			String idEquipe = request.getParameter("id");
			System.out.println(idEquipe);
			if (idEquipe != null) {
				request.setAttribute("equipe", facade.getEquipe(idEquipe));
			} else {
				request.setAttribute("equipes", facade.getEquipes());
			}
			dispatcher = jsp(JSP_TEAM);
		}
		// si l'action est de voir une rencontre
		else if (action.equals(ACTION_MATCH)) {
			String idRencontre = request.getParameter("id");
			System.out.println(idRencontre);
			if (idRencontre != null) {
				request.setAttribute("rencontre",
						facade.getRencontre(Integer.parseInt(idRencontre)));
				dispatcher = jsp(JSP_MATCH);
			} else {
				dispatcher = redirect(ACTION_HOME);
			}
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
					dispatcher = redirect(ACTION_HOME);
				else {
					request.setAttribute("exists", true);
					dispatcher = jsp(JSP_NEW_TEAM);
				}
			} else
				// direction la page d'inscription d'une équipe
				dispatcher = jsp(JSP_NEW_TEAM);
		}
		// si l'action est de se connecter (pour l'admin)
		else if (action.equals(ACTION_LOGIN)) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			if (login != null && password != null) {
				if (facade.connexion(login, password)) {
					request.getSession().setAttribute(SESSION_ADMIN, login);
					dispatcher = redirect(ACTION_ADMIN_HOME);
				} else {
					request.setAttribute("error", true);
					dispatcher = jsp(JSP_LOGIN);
				}
			} else if (request.getSession().getAttribute(SESSION_ADMIN) != null) {
				request.getSession().removeAttribute(SESSION_ADMIN);
				dispatcher = redirect(ACTION_HOME);
			} else
				// direction la page d'inscription
				dispatcher = jsp(JSP_LOGIN);
		} else if (action.equals(ACTION_FAQ)) {
			dispatcher = jsp(JSP_FAQ);
		} else if (action.equals(ACTION_404)) {
			dispatcher = jsp(JSP_404);
		}
		// S'il faut rediriger...
		else if (action.equals("redirect")) {
			request.setAttribute("redirect", request.getParameter("redirect"));
			dispatcher = jsp(JSP_REDIRECT);
		} else if (request.getSession().getAttribute(SESSION_ADMIN) != null) {
			if (action.equals(ACTION_ADMIN_HOME)) {
				request.setAttribute("tournois", facade.getTournois());
				request.setAttribute("equipes", facade.getEquipes());
				dispatcher = jsp(JSP_ADMIN_HOME);
			} else if (action.equals(ACTION_CREATE_TOURNAMENT)) {
				String nom = request.getParameter("nom");
				System.out.println(nom);
				if (nom != null) {
					facade.creerTournoi(nom);
					dispatcher = redirect(ACTION_ADMIN_HOME);
				}
			} else if (action.equals(ACTION_TOURNAMENT)) {
				String nomTournoi = request.getParameter("id");
				System.out.println(nomTournoi);
				facade.validerRencontre(GregorianCalendar.getInstance(), 10);
				facade.validerRencontre(GregorianCalendar.getInstance(), 11);
				if (nomTournoi != null) {
					request.setAttribute("rencontres",
							facade.getRencontres(nomTournoi));
					dispatcher = jsp(JSP_TOURNAMENT);
				} else
					dispatcher = redirect(ACTION_404);
			}
		}
		// Sinon, la page n'existe pas.
		if (dispatcher.equals("")) {
			dispatcher = redirect(ACTION_404);
		}
		request.getRequestDispatcher(dispatcher).forward(request, response);
	}

	/**
	 * Builds the redirection path for the given action.
	 * 
	 * @param action
	 *            String of the action.
	 * @return String of the path to the redirect action.
	 */
	private String redirect(String action) {
		return SERVLET_PATH + ACTION_REDIRECT + REDIRECT_PATH + action;
	}

	/**
	 * Builds the path for the given jsp.
	 * 
	 * @param jsp
	 *            String of the jsp.
	 * @return String of the path to the jsp.
	 */
	private String jsp(String jsp) {
		return PAGES_PATH + jsp;
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
