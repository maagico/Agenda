package es.agenda.dao;

import org.springframework.stereotype.Repository;

import es.agenda.model.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario> implements UsuarioDaoI{

	public UsuarioDaoImpl() {
		super(Usuario.class);
	}
}
