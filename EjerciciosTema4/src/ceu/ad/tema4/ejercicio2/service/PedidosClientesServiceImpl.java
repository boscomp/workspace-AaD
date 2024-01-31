package ceu.ad.tema4.ejercicio2.service;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;

import ceu.ad.tema4.ejercicio2.jpa.HibernateUtil;
import ceu.ad.tema4.ejercicio2.modelo.*;

import jakarta.persistence.PersistenceException;

public class PedidosClientesServiceImpl implements PedidosClientesService {

	@Override
	public void crearCliente(Cliente cliente) throws PedidosClientesServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.persist(cliente);
			session.getTransaction().commit();

		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error creando cliente: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Pedido crearPedido(Pedido pedido) throws PedidosClientesServiceException {
		Session session = null;
		try {
			List<PedidoLinea> lineas=pedido.getLineas();
			UUID ej = UUID.randomUUID();
			for (PedidoLinea pedidoLinea : lineas) {
				pedidoLinea.setUidLinea(ej);
			}
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.persist(pedido);
			session.getTransaction().commit();

			return pedido;
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error creando pedido: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Articulo crearArticulo(Articulo articulo) throws PedidosClientesServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.persist(articulo);
			session.getTransaction().commit();

			return articulo;
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error creando artículo: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void actualizarCliente(Cliente cliente) throws PedidosClientesServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();

			session.getTransaction().begin();
			session.merge(cliente);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error actualizando cliente: " + e.getMessage());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Cliente consultarCliente(String dni) throws NotFoundException, PedidosClientesServiceException {
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
// aqui hacemos la insercion !!
			Cliente c1 = session.get(Cliente.class, dni);
			session.getTransaction().commit();
			return c1;
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error consultando cliente: " + e.getMessage());
			e.printStackTrace();
			throw new NotFoundException(e);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Articulo consultarArticulo(Long idArticulo) throws NotFoundException, PedidosClientesServiceException {
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
// aqui hacemos la insercion !!
			Articulo a1 = session.get(Articulo.class, idArticulo);
			session.getTransaction().commit();
			return a1;
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error consultando artículo: " + e.getMessage());
			e.printStackTrace();
			throw new NotFoundException(e);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Pedido consultarPedido(String uuid) throws NotFoundException, PedidosClientesServiceException {
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
// aqui hacemos la insercion !!
			Pedido p1= session.get(Pedido.class, uuid);
			session.getTransaction().commit();
			return p1;
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error consultando pedido: " + e.getMessage());
			e.printStackTrace();
			throw new NotFoundException(e);
		
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
