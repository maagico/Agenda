package es.agenda.service;

import java.util.List;

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
	
	public Usuario guardarUsuario(Usuario usuario) throws UsuarioYaExisteException {
	
		
		String nombreUsuario = usuario.getUsuario();
		String password = usuario.getPassword();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		password = encoder.encode(password);
		
		usuario.setPassword(password);
		
		Boolean existeUsuario = dao.comprobarSiExisteUsuario(nombreUsuario);
		
		if(existeUsuario) {
			
			throw new UsuarioYaExisteException("Ya existe el usuario en la base de datos", null);
		}
		
		dao.persist(usuario);
		
		return usuario;
	}

	@Override
	public Usuario findByNombreUsuario(String nombreUsuarioLogueado) {
		
		return dao.findByNombreUsuario(nombreUsuarioLogueado);
	}
 
	@Override
	public List<Usuario> findAllOrderByNombre() {
		
		return dao.findAllOrderByNombre();
	}
}
