package it.prova.gestioneattivita.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneattivita.model.Attivita;

@WebServlet("/PrepareSearchAttivitaServlet")
public class PrepareSearchAttivitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("search_attivita_attr", new Attivita());
		request.setAttribute("activePage", "search");
		request.getRequestDispatcher("/attivita/search.jsp").forward(request, response);

	}

}
