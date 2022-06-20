package es.agenda.dao;

import org.springframework.stereotype.Repository;

import es.agenda.model.Correo;

@Repository("correoDao")
public class CorreoDaoImpl extends GenericDaoImpl<Correo> implements CorreoDaoI{

	public CorreoDaoImpl() {
		super(Correo.class);
	}
}
