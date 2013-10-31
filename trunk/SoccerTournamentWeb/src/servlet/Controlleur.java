package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlleur
 */
@WebServlet("/")
public class Controlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Controlleur() {
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

		// si l'action est nulle
		if (action == null) {
			// direction la page d'accueil
			request.getRequestDispatcher("pages/index.jsp")
					.forward(request, response);
		}
		// si l'action est s'inscrire (représentant)
		else if (action.equals("register")) {
			String id = request.getParameter("login");
			String passwd = request.getParameter("password");
			// direction la page d'inscription
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		}
		// si l'action est de se connecter (admin)
		else if (action.equals("connect")) {
			String id = request.getParameter("login");
			String passwd = request.getParameter("password");
			// direction la page d'inscription
			request.getRequestDispatcher("login.jsp").forward(request,
					response);
		}
	}
}