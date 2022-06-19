package es.agenda.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import es.agenda.model.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario> implements UsuarioDaoI{

	public UsuarioDaoImpl() {
		super(Usuario.class);
	}
	
	public Boolean comprobarSiExisteUsuario(String usuario) {
		
		String jpql = "Select U from Usuario U where U.usuario = :usuario";
		
		Query query = entityManager.createQuery(jpql);
		query.setParameter("usuario", usuario);
		
		Usuario usu = (Usuario)query.getSingleResult();
			
		return usu != null;
	}
}
