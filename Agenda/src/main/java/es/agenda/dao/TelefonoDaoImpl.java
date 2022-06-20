package es.agenda.dao;

import org.springframework.stereotype.Repository;

import es.agenda.model.Telefono;

@Repository("telefonoDao")
public class TelefonoDaoImpl extends GenericDaoImpl<Telefono> implements TelefonoDaoI{

	public TelefonoDaoImpl() {
		super(Telefono.class);
	}
}
