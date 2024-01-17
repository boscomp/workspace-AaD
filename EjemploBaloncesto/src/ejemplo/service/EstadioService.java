package ejemplo.service;

import org.hibernate.Session;

import ejemplo.jpa.HibernateUtil;
import ejemplo.modelo.Equipo;
import ejemplo.modelo.Estadio;
import jakarta.persistence.PersistenceException;

public class EstadioService {

	public void insertarEstadio(Estadio estadio ) {

		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.persist(estadio);
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
	public Estadio consultarEstadio(Long id) {

		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
// aqui hacemos la insercion !!
			Estadio e1= session.get(Estadio.class, id);
			session.getTransaction().commit();
			return e1;
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
