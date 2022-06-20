package es.agenda.service;

import java.util.List;

public interface GenericServiceI<T>{
	
	T findById(Long id);
	
	List<T> findAll();
	
	T persist(T entidad);
	
	T merge(T entidad);
	
	void remove(T entidad);
}
