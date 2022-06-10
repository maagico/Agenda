package es.agenda.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.agenda.model.Usuario;

public class GenericDaoImpl<T> implements GenericDaoI<T>
{ 
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Long id) {
		return (T) entityManager.find(Usuario.class, id);
	}
}
