package it.prova.gestioneattivita.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneattivita.model.Attivita;
import it.prova.gestioneattivita.service.MyServiceFactory;
import it.prova.gestioneattivita.utility.UtilityAttivitaForm;

@WebServlet("/ExecuteSearchAttivitaServlet")
public class ExecuteSearchAttivitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// estraggo input
		String titoloInputParam = request.getParameter("titolo");
		String descrizioneInputParam = request.getParameter("descrizione");
		String prioritaInputStringParam = request.getParameter("priorita");
		String dataStringParam = request.getParameter("data");

		Attivita attivitaInstance = UtilityAttivitaForm.createAttivitaFromParams(titoloInputParam,
				descrizioneInputParam, prioritaInputStringParam, dataStringParam);

		try {
			request.setAttribute("listaAttivitaAttribute",
					MyServiceFactory.getAttivitaServiceInstance().findByExample(attivitaInstance));
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/attivita/results.jsp").forward(request, response);
	}

}
