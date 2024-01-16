package ejemplo.service;

import org.hibernate.Session;

import ejemplo.jpa.HibernateUtil;
import ejemplo.modelo.Equipo;
import jakarta.persistence.PersistenceException;

public class EquipoService {

	public void insertarEquipo(Equipo e) {

		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.persist(e);
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
	
	public void actualizarEquipo(Equipo e) {

		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.merge(e);
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
	public void eliminarEquipo(Equipo e) {

		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.remove(e);
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
	
	public Equipo consultarEquipo(Long id) {

		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
// aqui hacemos la insercion !!
			Equipo e1= session.get(Equipo.class, id);
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
