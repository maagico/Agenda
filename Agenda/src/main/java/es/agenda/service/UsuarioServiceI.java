package es.agenda.service;

import es.agenda.excepcion.UsuarioYaExisteException;
import es.agenda.model.Usuario;

public interface UsuarioServiceI extends GenericServiceI<Usuario>{
	
	Usuario guardarUsuario(Usuario usuario) throws UsuarioYaExisteException;
}
