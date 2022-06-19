package es.agenda.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import es.agenda.dao.UsuarioDaoI;
import es.agenda.excepcion.UsuarioYaExisteException;
import es.agenda.model.Usuario;

@Service("usuarioService")
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, UsuarioDaoI> implements UsuarioServiceI{
	
	public UsuarioServiceImpl(UsuarioDaoI dao) {
		super(dao);
	}
	
	public Usuario merge(Usuario usuario) {
	
		
		String usu = usuario.getUsuario();
		String password = usuario.getPassword();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		password = encoder.encode(password);
		
		usuario.setPassword(password);
		
		Boolean existeUsuario = dao.comprobarSiExisteUsuario(usu);
		
		if(existeUsuario) {
			
			throw new UsuarioYaExisteException("Ya existe el usuario en la base de datos", null);
		}
		
		dao.merge(usuario);
		
		usuario.setPassword("");
		
		return usuario;
	}
}
