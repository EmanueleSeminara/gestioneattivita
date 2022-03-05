package it.prova.gestioneattivita.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestioneattivita.service.MyServiceFactory;

@WebServlet("/ExecuteDeleteAttivitaServlet")
public class ExecuteDeleteAttivitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdDellAttivitaDaEliminare = request.getParameter("idAttivita");

		if (!NumberUtils.isCreatable(parametroIdDellAttivitaDaEliminare)) {
			request.setAttribute("errorMessage", "Attenzione, non è stato trovato l'attivita corrispondente");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			MyServiceFactory.getAttivitaServiceInstance().rimuovi(MyServiceFactory.getAttivitaServiceInstance()
					.caricaSingoloElemento(Long.parseLong(parametroIdDellAttivitaDaEliminare)));
			request.setAttribute("listaAttivitaAttribute", MyServiceFactory.getAttivitaServiceInstance().listAll());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

		request.getRequestDispatcher("/attivita/results.jsp").forward(request, response);
	}

}
