package es.agenda.dao;

import es.agenda.model.Usuario;

public interface UsuarioDaoI extends GenericDaoI<Usuario>{

	Boolean comprobarSiExisteUsuario(String usuario);
}
