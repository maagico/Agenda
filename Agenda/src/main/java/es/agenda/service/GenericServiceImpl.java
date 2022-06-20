package es.agenda.service;

import java.util.List;

import javax.transaction.Transactional;

import es.agenda.dao.GenericDaoI;

@Transactional
public class GenericServiceImpl<M,D extends GenericDaoI<M>> implements GenericServiceI<M>
{
	protected D dao;
	
	public GenericServiceImpl(D dao){
		this.dao = dao;
	}

	@Override
	public M findById(Long id) {
		return dao.findById(id);
	}

	public List<M> findAll(){
		return dao.findAll();
	}
	
	@Override
	public M persist(M modelo) {
		return dao.persist(modelo);
	}	
	
	@Override
	public M merge(M modelo) {
		return dao.merge(modelo);
	}	
}
