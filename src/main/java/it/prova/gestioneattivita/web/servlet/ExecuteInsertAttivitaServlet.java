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

@WebServlet("/ExecuteInsertAttivitaServlet")
public class ExecuteInsertAttivitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// estraggo input
		String titoloInputParam = request.getParameter("titolo");
		String descrizioneInputParam = request.getParameter("descrizione");
		String prioritaInputStringParam = request.getParameter("priorita");
		String dataStringParam = request.getParameter("data");

		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		Attivita attivitaInstance = UtilityAttivitaForm.createAttivitaFromParams(titoloInputParam,
				descrizioneInputParam, prioritaInputStringParam, dataStringParam);
		// se la validazione non risulta ok
		if (!UtilityAttivitaForm.validateAttivitaBean(attivitaInstance)) {
			request.setAttribute("insert_attivita_attr", attivitaInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/attivita/insert.jsp").forward(request, response);
			return;
		}

		// se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
		// occupiamoci delle operazioni di business
		try {
			MyServiceFactory.getAttivitaServiceInstance().inserisciNuovo(attivitaInstance);
			request.setAttribute("listaAttivitaAttribute", MyServiceFactory.getAttivitaServiceInstance().listAll());
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
