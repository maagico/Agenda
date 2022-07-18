package es.agenda.service;

import java.util.List;

import es.agenda.model.Contacto;

public interface ContactoServiceI extends GenericServiceI<Contacto>{
	
	Contacto findById(Long idUsuarioLogueado, Long id);
	
	List<Contacto> findAllOrderByNombre(Long idUsuarioLogueado);

	List<Contacto> buscarContactos(Long idUsuarioLogueado, String textoABuscar);
}
