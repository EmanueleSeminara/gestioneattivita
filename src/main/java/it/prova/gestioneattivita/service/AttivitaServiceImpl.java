package it.prova.gestioneattivita.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneattivita.dao.AttivitaDAO;
import it.prova.gestioneattivita.model.Attivita;
import it.prova.gestioneattivita.web.listener.LocalEntityManagerFactoryListener;

public class AttivitaServiceImpl implements AttivitaService {
	private AttivitaDAO attivitaDao;

	@Override
	public void setAttivitaDao(AttivitaDAO attivitaDao) {
		this.attivitaDao = attivitaDao;

	}

	@Override
	public List<Attivita> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			attivitaDao.setEntityManager(entityManager);

			return attivitaDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Attivita caricaSingoloElemento(Long idInput) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			attivitaDao.setEntityManager(entityManager);

			return attivitaDao.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Attivita attivitaInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			attivitaDao.setEntityManager(entityManager);

			attivitaDao.update(attivitaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Attivita input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			attivitaDao.setEntityManager(entityManager);

			attivitaDao.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void rimuovi(Attivita attivitaInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			attivitaDao.setEntityManager(entityManager);

			attivitaDao.delete(attivitaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Attivita> findByExample(Attivita attivitaInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			attivitaDao.setEntityManager(entityManager);

			return attivitaDao.findByExample(attivitaInstance);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

}
