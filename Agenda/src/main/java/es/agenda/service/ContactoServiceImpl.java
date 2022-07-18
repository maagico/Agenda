package es.agenda.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.agenda.dao.ContactoDaoI;
import es.agenda.model.Contacto;

@Service("contactoService")
public class ContactoServiceImpl extends GenericServiceImpl<Contacto, ContactoDaoI> implements ContactoServiceI{
	
	public ContactoServiceImpl(ContactoDaoI dao) {
		super(dao);
	}

	@Override
	public Contacto findById(Long idUsuarioLogueado, Long id) {

		return dao.findById(idUsuarioLogueado, id);
	}
	
	@Override
	public List<Contacto> findAllOrderByNombre(Long idUsuarioLogueado) {
		
		return dao.findAllOrderByNombre(idUsuarioLogueado);
	}

	@Override
	public List<Contacto> buscarContactos(Long idUsuarioLogueado, String textoABuscar) {
		
		textoABuscar = " " + textoABuscar + " ";
		textoABuscar = textoABuscar.replace(" ", "%");
		
		return dao.buscarContactos(idUsuarioLogueado, textoABuscar);
	}
}
