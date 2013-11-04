package servlet;

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

		// si l'action est nulle ou l'action égale à home
		if ((action == null) || (action.equals("home"))) {
			// direction la page d'accueil
			request.getRequestDispatcher(PATH + "index.jsp").forward(request,
					response);
		}
		// si l'action est s'inscrire (représentant)
		else if (action.equals(ACTION_NEW_TEAM)) {
			String id = request.getParameter("login");
			String passwd = request.getParameter("password");
			if (id != null && passwd != null) {
				System.err.println("Adding a team... " + id + " -> " + passwd);
			}
			// direction la page d'inscription
			request.getRequestDispatcher(PATH + "newteam.jsp").forward(
					request, response);
		}
		// si l'action est de se connecter (admin)
		else if (action.equals(ACTION_LOGIN)) {
			String id = request.getParameter("login");
			String passwd = request.getParameter("password");
			if (id != null && passwd != null) {
				System.err.println("Logging... " + id + " -> " + passwd);
			}
			// direction la page d'inscription
			request.getRequestDispatcher(PATH + "login.jsp").forward(request,
					response);
		}
	}
}
