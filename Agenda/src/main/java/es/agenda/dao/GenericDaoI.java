package es.agenda.dao;

public interface GenericDaoI<T>
{
	T findById(Long id); 
}
