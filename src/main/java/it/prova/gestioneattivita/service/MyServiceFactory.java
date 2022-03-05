package it.prova.gestioneattivita.service;

import it.prova.gestioneattivita.dao.AttivitaDAO;
import it.prova.gestioneattivita.dao.AttivitaDAOImpl;

public class MyServiceFactory {
	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static AttivitaService ATTIVITA_SERVICE_INSTANCE = null;
	private static AttivitaDAO ATTIVITADAO_INSTANCE = null;

	public static AttivitaService getAttivitaServiceInstance() {
		if (ATTIVITA_SERVICE_INSTANCE == null)
			ATTIVITA_SERVICE_INSTANCE = new AttivitaServiceImpl();

		if (ATTIVITADAO_INSTANCE == null)
			ATTIVITADAO_INSTANCE = new AttivitaDAOImpl();

		ATTIVITA_SERVICE_INSTANCE.setAttivitaDao(ATTIVITADAO_INSTANCE);

		return ATTIVITA_SERVICE_INSTANCE;
	}
}
