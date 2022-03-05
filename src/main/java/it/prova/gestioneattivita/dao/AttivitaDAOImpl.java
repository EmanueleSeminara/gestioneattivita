package it.prova.gestioneattivita.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneattivita.model.Attivita;

public class AttivitaDAOImpl implements AttivitaDAO {
	private EntityManager entityManager;

	@Override
	public List<Attivita> list() throws Exception {
		return entityManager.createQuery("from Attivita", Attivita.class).getResultList();
	}

	@Override
	public Attivita findOne(Long id) throws Exception {
		return entityManager.find(Attivita.class, id);
	}

	@Override
	public void update(Attivita input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Attivita input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Attivita input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public List<Attivita> findByExample(Attivita example) throws Exception {
		if (example == null)
			throw new Exception("Valore di input non ammesso.");

		String query = "from Attivita a where 1=1 ";
		if (example.getTitolo() != null && !example.getTitolo().isEmpty()) {
			query += " and a.titolo like '" + example.getTitolo() + "%' ";
		}

		if (example.getDescrizione() != null && !example.getDescrizione().isEmpty()) {
			query += " and a.descrizione like '" + example.getDescrizione() + "%' ";
		}

		if (example.getData() != null) {
			query += " and a.data >= '" + new java.sql.Date(example.getData().getTime()) + "'";
		}

		if (example.getPriorita() != null) {
			query += " and a.priorita >= '" + example.getPriorita() + "%' ";
		}

		return entityManager.createQuery(query, Attivita.class).getResultList();

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

}
