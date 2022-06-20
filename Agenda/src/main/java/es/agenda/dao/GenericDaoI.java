package es.agenda.dao;

import java.util.List;

public interface GenericDaoI<M>
{
	M findById(Long id); 
	
	List<M> findAll();
	
	M persist(M modelo);
	
	M merge(M modelo);

	void remove(M modelo);
}
