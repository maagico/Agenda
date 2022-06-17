package es.agenda.service;

import org.springframework.stereotype.Service;

import es.agenda.dao.UsuarioDaoI;
import es.agenda.model.Usuario;

@Service("usuarioService")
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, UsuarioDaoI> implements UsuarioServiceI{
	
	public UsuarioServiceImpl(UsuarioDaoI dao) {
		super(dao);
	}	
}
