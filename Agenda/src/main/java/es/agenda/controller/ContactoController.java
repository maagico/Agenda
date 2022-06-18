package es.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.agenda.model.Contacto;
import es.agenda.service.ContactoServiceI;

@Controller
public class ContactoController {

	@Autowired
	private ContactoServiceI contactoService;
	
	@GetMapping("/addContacto")
	public String addContacto(Model model) {
		
		
		return "editarContacto";
	}
	
	@GetMapping("/listadoContactos")
	public String listadoUsuarios(Model model) {
		
		List<Contacto> contactos = contactoService.findAllOrderByNombre();
		
		model.addAttribute("contactos", contactos);
		
		return "listadoContactos";
	}
}
