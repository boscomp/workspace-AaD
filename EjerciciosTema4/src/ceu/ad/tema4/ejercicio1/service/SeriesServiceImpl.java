package ceu.ad.tema4.ejercicio1.service;

import java.util.List;

import org.hibernate.Session;

import ceu.ad.tema4.ejercicio1.jpa.HibernateUtil;
import ceu.ad.tema4.ejercicio1.modelo.Serie;

import jakarta.persistence.PersistenceException;

public class SeriesServiceImpl implements SeriesService {

	@Override
	public Serie consultarSerie(Long idSerie) throws SerieNotFoundException, SeriesServiceException {
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
// aqui hacemos la insercion !!
			Serie s1= session.get(Serie.class, idSerie);
			session.getTransaction().commit();
			return s1;
		} catch (PersistenceException ex) {
			session.getTransaction().rollback();
			throw ex;
			// aqui vemos que hacemos con la excepcion
		} finally {
			if (session != null) {
				session.close();
			}
		}
		// TODO: IMPLEMENTAR POR EL ALUMNO...
	}
	
	
	@Override
	public List<Serie> buscarSeries(String filtroDescripcion) throws SerieNotFoundException, SeriesServiceException {
		return null;
		// TODO: IMPLEMENTAR POR EL ALUMNO...
		
	}
	
	@Override
	public Serie crearSerie(Serie serie) throws SeriesServiceException {
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.persist(serie);
// aqui hacemos la insercion !!
			session.getTransaction().commit();
		} catch (PersistenceException ex) {
			session.getTransaction().rollback();
			throw ex;
			// aqui vemos que hacemos con la excepcion
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return serie;
		
	}
	
	
	@Override
	public void elimnarSerie(Long idSerie) throws SeriesServiceException {
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.remove(idSerie);
// aqui hacemos la insercion !!
			session.getTransaction().commit();
		} catch (PersistenceException ex) {
			session.getTransaction().rollback();
			throw ex;
			// aqui vemos que hacemos con la excepcion
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}
	
	
	@Override
	public void actualizarSerie(Serie serie) throws SeriesServiceException {
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.merge(serie);
// aqui hacemos la insercion !!
			session.getTransaction().commit();
		} catch (PersistenceException ex) {
			session.getTransaction().rollback();
			throw ex;
			// aqui vemos que hacemos con la excepcion
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}
	
	
}
