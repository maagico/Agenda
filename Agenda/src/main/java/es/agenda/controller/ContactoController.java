package es.agenda.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import es.agenda.form.CrearContactoForm;
import es.agenda.model.Contacto;
import es.agenda.model.Correo;
import es.agenda.model.Telefono;
import es.agenda.service.ContactoServiceI;

@Controller
public class ContactoController {

	@Autowired
	private ContactoServiceI contactoService;
	
	@GetMapping("/web/addContacto")
	public String addContacto(Model model) {
		
		CrearContactoForm crearContactoForm = new CrearContactoForm();
		
		crearContactoForm.setTelefonos(List.of(""));
		crearContactoForm.setCorreos(List.of(""));
		
		model.addAttribute("crearContactoForm", crearContactoForm);
		
		return "web/editarContacto";
	}
	
	@GetMapping("/web/listadoContactos")
	public String listadoUsuarios(Model model) {
		
		List<Contacto> contactos = contactoService.findAllOrderByNombre();
		
		model.addAttribute("contactos", contactos);
		
		return "web/listadoContactos";
	}
	
	@PostMapping("/web/crearContacto")
	public String crearContacto(CrearContactoForm crearContactoForm,
							    Model model) throws IllegalAccessException, InvocationTargetException{
		
		if(crearContactoForm.getTelefonos() == null || crearContactoForm.getTelefonos().isEmpty()) {
			crearContactoForm.setTelefonos(List.of(""));
		}
		
		if(crearContactoForm.getCorreos() == null || crearContactoForm.getCorreos().isEmpty()) {
			crearContactoForm.setCorreos(List.of(""));
		}
		
		Contacto contacto = populateContacto(crearContactoForm);
		
		contactoService.merge(contacto);
		
		model.addAttribute("crearContactoForm", crearContactoForm);

		return "web/editarContacto";
	}

	private Contacto populateContacto(CrearContactoForm crearContactoForm) {
		
		Contacto contacto = new Contacto();
		
		contacto.setNombre(crearContactoForm.getNombre());
		contacto.setApellidos(crearContactoForm.getApellidos());
		
		Set<Telefono> telefonos = new HashSet<>();
		
		for(String numero : crearContactoForm.getTelefonos()) {
			
			if(numero != null && !numero.equals("")){
				
				Telefono telefono = new Telefono();
				
				telefono.setNumero(numero);
				telefono.setContacto(contacto);
				telefonos.add(telefono);
			}
		}
		
		contacto.setTelefonos(telefonos);
		
		Set<Correo> correos = new HashSet<>();
		
		for(String correo : crearContactoForm.getCorreos()) {
			
			if(correo != null && !correo.equals("")){
				Correo email = new Correo();
				
				email.setCorreo(correo);
				email.setContacto(contacto);
				correos.add(email);
			}
		}
		
		contacto.setCorreos(correos);
		
		return contacto;
	}
}
