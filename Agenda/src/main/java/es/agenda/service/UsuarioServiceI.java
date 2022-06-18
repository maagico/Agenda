package es.agenda.service;

import es.agenda.model.Usuario;

public interface UsuarioServiceI extends GenericServiceI<Usuario>{

	@Override
	Usuario persist(Usuario usuario);
}
