package es.agenda.dao;

import java.util.List;

import es.agenda.model.Usuario;

public interface UsuarioDaoI extends GenericDaoI<Usuario>{

	Boolean comprobarSiExisteUsuario(String nombreUsuario);

	Usuario findByNombreUsuario(String nombreUsuarioLogueado);

	List<Usuario> findAllOrderByNombre();
}
