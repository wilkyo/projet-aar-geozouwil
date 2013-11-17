package com.soccer.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.ejb.facade.SoccerTournamentFacadeLocal;
import com.soccer.valueobjects.VOJoueur;
import com.soccer.valueobjects.VORencontre;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/index")
public class Controleur extends HttpServlet {
	public static final long serialVersionUID = 1L;
	public static final String WEB_PATH = "/SoccerTournamentWeb/";
	public static final String CSS_PATH = "styles/";
	public static final String SCRIPTS_PATH = "scripts/";
	public static final String PAGES_PATH = "pages/";
	public static final String INCLUDES_PATH = "includes/";

	public static final String SERVLET_PATH = "index?action=";
	public static final String ACTION_REDIRECT = "redirect";
	public static final String ACTION_HOME = "home";
	public static final String ACTION_TOURNAMENT = "tournament";
	public static final String ACTION_MATCH = "match";
	public static final String ACTION_TEAM = "team";
	public static final String ACTION_NEW_TEAM = "newteam";
	public static final String ACTION_LOGIN = "login";
	public static final String ACTION_ADMIN_HOME = "adminhome";
	public static final String ACTION_CREATE_TOURNAMENT = "createtournament";
	public static final String ACTION_NEW_REFEREE = "newreferee";
	public static final String ACTION_ADMIN_MATCH = "adminmatch";
	public static final String ACTION_NEW_BUT = "newbut";
	public static final String ACTION_FAQ = "faq";
	public static final String ACTION_404 = "404";
	public static final String ACTION_AJAX = "ajax";

	public static final String JSP_HOME = "user/index.jsp";
	public static final String JSP_TOURNAMENT = "user/tournament.jsp";
	public static final String JSP_TEAM = "user/team.jsp";
	public static final String JSP_MATCH = "user/match.jsp";
	public static final String JSP_NEW_TEAM = "newteam.jsp";
	public static final String JSP_FAQ = "user/faq.jsp";
	public static final String JSP_LOGIN = "admin/login.jsp";
	public static final String JSP_ADMIN_HOME = "admin/adminindex.jsp";
	public static final String JSP_ADMIN_MATCH = "admin/adminmatch.jsp";
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
		String redirect = "";

		// si l'action est nulle ou l'action égale à home
		if (action.equals(ACTION_HOME)) {
			request.setAttribute("tournois", facade.getTournois());
			// direction la page d'accueil
			dispatcher = jsp(JSP_HOME);
		} else if (action.equals(ACTION_TOURNAMENT)) {
			String nomTournoi = request.getParameter("id");
			if (nomTournoi != null) {
				request.setAttribute("tournoi", facade.getTournoi(nomTournoi));
				dispatcher = jsp(JSP_TOURNAMENT);
			} else
				redirect = action(ACTION_404);
		}
		// si l'action est de voir une rencontre
		else if (action.equals(ACTION_MATCH)) {
			String idRencontre = request.getParameter("id");
			if (idRencontre != null) {
				request.setAttribute("rencontre",
						facade.getRencontre(Integer.parseInt(idRencontre)));
				dispatcher = jsp(JSP_MATCH);
			} else {
				redirect = action(ACTION_HOME);
			}
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
					redirect = action(ACTION_HOME);
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
					redirect = action(ACTION_ADMIN_HOME);
				} else {
					request.setAttribute("error", true);
					dispatcher = jsp(JSP_LOGIN);
				}
			} else if (request.getSession().getAttribute(SESSION_ADMIN) != null) {
				request.getSession().removeAttribute(SESSION_ADMIN);
				redirect = action(ACTION_HOME);
			} else
				// direction la page d'inscription
				dispatcher = jsp(JSP_LOGIN);
		} else if (action.equals(ACTION_FAQ)) {
			dispatcher = jsp(JSP_FAQ);
		} else if (action.equals(ACTION_404)) {
			dispatcher = jsp(JSP_404);
		} else if (request.getSession().getAttribute(SESSION_ADMIN) != null) {
			// Page d'accueil de l'admin
			if (action.equals(ACTION_ADMIN_HOME)) {
				request.setAttribute("tournois", facade.getTournois());
				request.setAttribute("equipes", facade.getEquipes());
				request.setAttribute("arbitres", facade.getArbitres());
				dispatcher = jsp(JSP_ADMIN_HOME);
				// Si l'admin souhaite créer un tournoi
			} else if (action.equals(ACTION_CREATE_TOURNAMENT)) {
				String nom = request.getParameter("nom");
				System.out.println(nom);
				if (nom != null) {
					facade.creerTournoi(nom);
					redirect = action(ACTION_ADMIN_HOME);
				}
			}
			// si l'admin souhaite ajouter un arbitre
			else if (action.equals(ACTION_NEW_REFEREE)) {
				String nom = request.getParameter("nomReferee");
				String prenom = request.getParameter("prenomReferee");
				if (nom != null && prenom != null) {
					facade.ajouterArbitre(nom, prenom);
				}
				redirect = action(ACTION_ADMIN_HOME);
			} else if (action.equals(ACTION_ADMIN_MATCH)) {
				// Si l'admin veut modifier une rencontre
				String id = request.getParameter("id");
				if (id != null) {
					int idRencontre = Integer.parseInt(id);
					request.setAttribute("arbitres", facade.getArbitres());
					String debutD = request.getParameter("debutD");
					String debutH = request.getParameter("debutH");
					String finH = request.getParameter("fin");
					String arbitre = request.getParameter("arbitre");
					if (debutD != null && debutH != null && arbitre != null) {
						if (!debutD.equals("") && !debutH.equals("")) {
							int[] dDebut = toIntegerArray(debutD.split("/"));
							int[] hDebut = toIntegerArray(debutH.split(":"));
							if (dDebut.length == 3 && hDebut.length == 2) {
								facade.setDebutRencontre(idRencontre,
										new GregorianCalendar(dDebut[2],
												dDebut[1], dDebut[0],
												hDebut[0], hDebut[1], 0));
							}
							if (finH != null) {
								int[] hFin = toIntegerArray(finH.split(":"));
								facade.validerRencontre(idRencontre,
										new GregorianCalendar(dDebut[2],
												dDebut[1], dDebut[0], hFin[0],
												hFin[1], 0));
							}
						}
						if (!arbitre.equals("0"))
							facade.affecterArbitre(Integer.parseInt(arbitre),
									idRencontre);
						redirect = action(ACTION_TOURNAMENT
								+ "&id="
								+ facade.getRencontre(idRencontre)
										.getNomTournoi());
					} else {
						request.setAttribute("rencontre",
								facade.getRencontre(idRencontre));
						dispatcher = jsp(JSP_ADMIN_MATCH);
					}
				} else
					redirect = action(ACTION_404);
			} else if (action.equals(ACTION_NEW_BUT)) {
				String id = request.getParameter("id");
				if (id != null) {
					int idRencontre = Integer.parseInt(id);
					VORencontre rencontre = facade.getRencontre(idRencontre);
					String buteur = request.getParameter("butJoueur");
					String butHeure = request.getParameter("butHeure");
					if (buteur != null && butHeure != null) {
						if (!buteur.equals("--") && !butHeure.equals("")) {
							int[] hBut = toIntegerArray(butHeure.split(":"));
							facade.ajouterBut(
									idRencontre,
									Integer.parseInt(buteur),
									new GregorianCalendar(rencontre.getDebut()
											.get(Calendar.DAY_OF_YEAR),
											rencontre.getDebut().get(
													Calendar.MONTH),
											rencontre.getDebut().get(
													Calendar.DAY_OF_MONTH),
											hBut[0], hBut[1], 0));
						}
						redirect = action(ACTION_TOURNAMENT + "&id="
								+ rencontre.getNomTournoi());
					} else {
						request.setAttribute("rencontre", rencontre);
						dispatcher = jsp(JSP_ADMIN_MATCH);
					}
				} else
					redirect = action(ACTION_404);
			}
		}
		if (action.equals(ACTION_AJAX)) {
			String nomEquipe = request.getParameter("butEquipe");
			StringBuffer content = new StringBuffer(
					"<option value=\"0\">--</option>");
			if (nomEquipe != null) {
				for (VOJoueur j : facade.getEquipe(nomEquipe).getJoueurs()) {
					content.append("<option value=\"" + j.getId() + "\">"
							+ j.getPrenom() + " " + j.getNom() + "</option>");
				}
			}
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(content.toString());
			// Ne pas redispatcher
			return;
		}
		// Si on veut rediriger
		if (redirect.length() > 0)
			response.sendRedirect(redirect);
		// Sinon, la page n'existe pas.
		else if (dispatcher.equals("")) {
			response.sendRedirect(action(ACTION_404));
		} else
			request.getRequestDispatcher(dispatcher).forward(request, response);
	}

	/**
	 * Builds the path for the given action.
	 * 
	 * @param action
	 *            String of the action.
	 * @return String of the path to the action.
	 */
	private String action(String action) {
		return WEB_PATH + SERVLET_PATH + action;
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

	/**
	 * Formats a number into a 2 digits number.
	 * 
	 * @param number
	 *            Integer to format.
	 * @return The formatted String.
	 */
	private static String formatNumber2Digits(int number) {
		return (number < 10 ? "0" : "") + number;
	}

	/**
	 * Formats the date.
	 * 
	 * @param date
	 *            Calendar of the date.
	 * @return Date on format dd/mm/yyyy.
	 */
	public static String formatDate(Calendar date) {
		return formatNumber2Digits(date.get(Calendar.DAY_OF_MONTH)) + "/"
				+ formatNumber2Digits(date.get(Calendar.MONTH)) + "/"
				+ date.get(Calendar.YEAR);
	}

	/**
	 * Formats the hour.
	 * 
	 * @param date
	 *            Calendar of the date.
	 * @return Date on format hh:mm.
	 */
	public static String formatHour(Calendar date) {
		return formatNumber2Digits(date.get(Calendar.HOUR_OF_DAY)) + ":"
				+ formatNumber2Digits(date.get(Calendar.MINUTE));
	}
}
