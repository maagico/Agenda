package es.agenda.service;

import es.agenda.dao.UsuarioDaoI;
import es.agenda.model.Usuario;

public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, UsuarioDaoI> implements UsuarioServiceI{

	public UsuarioServiceImpl(UsuarioDaoI dao) {
		super(dao);
	}	
}
