package es.agenda.service;

import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public M save(M modelo) {
		return dao.save(modelo);
	}	
}
