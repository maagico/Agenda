package es.agenda.service;

import java.util.List;

import es.agenda.excepcion.UsuarioYaExisteException;
import es.agenda.model.Usuario;

public interface UsuarioServiceI extends GenericServiceI<Usuario>{
	
	Usuario guardarUsuario(Usuario usuario) throws UsuarioYaExisteException;

	Usuario findByNombreUsuario(String nombreUsuarioLogueado);

	List<Usuario> findAllUsuariosOrderByNombre();

	List<Usuario> buscarUsuarios(String textoABuscar);
}
