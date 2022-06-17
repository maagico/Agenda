package es.agenda.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDaoImpl<M> implements GenericDaoI<M>
{ 
	private Class<M> clazz;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public GenericDaoImpl(Class<M> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public M findById(Long id) {
		
		return (M) entityManager.find(clazz, id);
	}

	@Override
	public M save(M modelo) {
		
		entityManager.persist(modelo);
		return modelo;
	}
}
