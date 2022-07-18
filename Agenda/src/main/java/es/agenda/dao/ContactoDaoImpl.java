package es.agenda.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import es.agenda.model.Contacto;

@Repository("contactoDao")
public class ContactoDaoImpl extends GenericDaoImpl<Contacto> implements ContactoDaoI{

	public ContactoDaoImpl() {
		super(Contacto.class);
	}

	@Override
	public Contacto findById(Long idUsuarioLogueado, Long id) {
		
		String jpql = "select C from Contacto C where C.usuario.id = :idUsuarioLogueado and C.id = :id";
		
		Query query =  entityManager.createQuery(jpql);
		query.setParameter("idUsuarioLogueado", idUsuarioLogueado);
		query.setParameter("id", id);
		
		return (Contacto)query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contacto> findAllOrderByNombre(Long idUsuarioLogueado) {
		
		String jpql = "select C from Contacto C where C.usuario.id = :idUsuarioLogueado order by C.nombre";
		
		Query query =  entityManager.createQuery(jpql);
		query.setParameter("idUsuarioLogueado", idUsuarioLogueado);
		
		return (List<Contacto>)query.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contacto> buscarContactos(Long idUsuarioLogueado, String textoABuscar) {
		
		String jpql = "select C from Contacto C where C.usuario.id = :idUsuarioLogueado and (LOWER(C.nombre) like :textoABuscar or LOWER(C.apellidos) like :textoABuscar) order by C.nombre";
		
		Query query =  entityManager.createQuery(jpql);
		query.setParameter("idUsuarioLogueado", idUsuarioLogueado);
		query.setParameter("textoABuscar", textoABuscar);
		
		return (List<Contacto>)query.getResultList();
	}
}
