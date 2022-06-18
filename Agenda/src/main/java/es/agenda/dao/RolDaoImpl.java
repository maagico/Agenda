package es.agenda.dao;

import org.springframework.stereotype.Repository;

import es.agenda.model.Rol;

@Repository("rolDao")
public class RolDaoImpl extends GenericDaoImpl<Rol> implements RolDaoI{

	public RolDaoImpl() {
		super(Rol.class);
	}
}
