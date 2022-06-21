package es.agenda.service;

import java.util.List;

import es.agenda.model.Contacto;

public interface ContactoServiceI extends GenericServiceI<Contacto>{

	List<Contacto> findAllOrderByNombre(Long idUsuarioLogueado);
}
