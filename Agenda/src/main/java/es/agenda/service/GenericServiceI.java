package es.agenda.service;

public interface GenericServiceI<T>{
	
	T findById(Long id);
}
