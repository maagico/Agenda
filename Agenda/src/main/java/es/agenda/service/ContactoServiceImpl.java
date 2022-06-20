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
	public List<Contacto> findAllOrderByNombre() {
		
		return dao.findAllOrderByNombre();
	}

	@Override
	public void remove(Contacto contacto) {
		
		dao.remove(contacto);
		
	}
}
