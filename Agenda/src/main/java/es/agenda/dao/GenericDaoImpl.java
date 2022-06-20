package es.agenda.dao;

import java.util.List;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<M> findAll(){
		
		return (List<M>) entityManager.createQuery("Select M from " + clazz.getSimpleName() + " M").getResultList();
	}
	
	@Override
	public M persist(M modelo) {
		
		entityManager.persist(modelo);
				
		return modelo;
	}
	
	@Override
	public M merge(M modelo) {
		
		entityManager.merge(modelo);
				
		return modelo;
	}
}
