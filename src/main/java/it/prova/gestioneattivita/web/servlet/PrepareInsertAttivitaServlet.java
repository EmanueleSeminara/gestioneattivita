package it.prova.gestioneattivita.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneattivita.model.Attivita;

@WebServlet("/PrepareInsertAttivitaServlet")
public class PrepareInsertAttivitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("activePage", "add");
		request.setAttribute("insert_attivita_attr", new Attivita());
		request.getRequestDispatcher("/attivita/insert.jsp").forward(request, response);
	}

}
