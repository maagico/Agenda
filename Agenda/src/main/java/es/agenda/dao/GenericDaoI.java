package es.agenda.dao;

public interface GenericDaoI<M>
{
	M findById(Long id); 
	
	M save(M modelo);
}
