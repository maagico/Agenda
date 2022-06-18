package es.agenda.service;

import org.springframework.stereotype.Service;

import es.agenda.dao.RolDaoI;
import es.agenda.model.Rol;

@Service("rolService")
public class RolServiceImpl extends GenericServiceImpl<Rol, RolDaoI> implements RolServiceI{
	
	public RolServiceImpl(RolDaoI dao) {
		super(dao);
	}	
}
