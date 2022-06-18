package es.agenda.dao;

import java.util.List;

import es.agenda.model.Contacto;

public interface ContactoDaoI extends GenericDaoI<Contacto>{

	List<Contacto> findAllOrderByNombre();
}
