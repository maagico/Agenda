package es.agenda.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import es.agenda.dao.UsuarioDaoI;
import es.agenda.model.Usuario;

@Service("usuarioService")
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, UsuarioDaoI> implements UsuarioServiceI{
	
	public UsuarioServiceImpl(UsuarioDaoI dao) {
		super(dao);
	}
	
	public Usuario merge(Usuario usuario) {
	
		String password = usuario.getPassword();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		password = encoder.encode(password);
		
		usuario.setPassword(password);
		
		dao.merge(usuario);
		
		usuario.setPassword("");
		
		return usuario;
	}
}
