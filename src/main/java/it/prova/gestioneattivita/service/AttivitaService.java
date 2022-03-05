package it.prova.gestioneattivita.service;

import java.util.List;

import it.prova.gestioneattivita.dao.AttivitaDAO;
import it.prova.gestioneattivita.model.Attivita;

public interface AttivitaService {
	public void setAttivitaDao(AttivitaDAO attivitaDao);

	public List<Attivita> listAll() throws Exception;

	public Attivita caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Attivita input) throws Exception;

	public void inserisciNuovo(Attivita input) throws Exception;

	public void rimuovi(Attivita input) throws Exception;

	public List<Attivita> findByExample(Attivita input) throws Exception;
}
