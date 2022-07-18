package es.agenda.dao;

import java.util.List;

import es.agenda.model.Contacto;

public interface ContactoDaoI extends GenericDaoI<Contacto>{

	Contacto findById(Long idUsuarioLogueado, Long id);
	
	List<Contacto> findAllOrderByNombre(Long idUsuarioLogueado);

	List<Contacto> buscarContactos(Long idUsuarioLogueado, String textoABuscar);
}
