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

	@SuppressWarnings("unchecked")
	@Override
	public List<Contacto> findAllOrderByNombre() {
		
		String jpql = "select C from Contacto C order by C.nombre";
		
		Query query =  entityManager.createQuery(jpql);
		
		return (List<Contacto>)query.getResultList();
		
	}
}
