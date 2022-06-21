package es.agenda.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.agenda.constantes.Constantes;
import es.agenda.form.ContactoForm;
import es.agenda.model.Contacto;
import es.agenda.model.Correo;
import es.agenda.model.Telefono;
import es.agenda.model.Usuario;
import es.agenda.service.ContactoServiceI;
import es.agenda.service.UsuarioServiceI;

@Controller
public class ContactoController {

	@Autowired
	private ContactoServiceI contactoService;
	
	@Autowired
	private UsuarioServiceI usuarioService;
	
	@GetMapping("/web/addContacto")
	public String addContacto(Model model) {
		
		ContactoForm contactoForm = new ContactoForm();
		
		contactoForm.setTelefonos(List.of(""));
		
		contactoForm.setCorreos(List.of(""));
		
		model.addAttribute("contactoForm", contactoForm);
		
		model.addAttribute("esCreacion", true);
		
		return "web/editarContacto";
	}
	
	@GetMapping("/web/listadoContactos")
	public String listadoUsuarios(HttpServletRequest request,
								  Model model) {
		
		
		Long idUsuarioLogueado = (Long)request.getSession().getAttribute(Constantes.ID_USUARIO_LOGUEADO);
				
		List<Contacto> contactos = contactoService.findAllOrderByNombre(idUsuarioLogueado);
		
		model.addAttribute("contactos", contactos);
		
		model.addAttribute("numeroContactos", contactos.size());
		
		return "web/listadoContactos";
	}
	
	@PostMapping("/web/crearContacto")
	public String crearContacto(HttpServletRequest request,
								ContactoForm contactoForm,
							    Model model) throws IllegalAccessException, InvocationTargetException {
				
		Long idUsuarioLogueado = (Long)request.getSession().getAttribute(Constantes.ID_USUARIO_LOGUEADO);
		
		Usuario usuarioLogueado = usuarioService.findById(idUsuarioLogueado);
		
		Contacto contacto = populateContacto(usuarioLogueado, contactoForm);
		
		contactoService.persist(contacto);
		
		contactoForm = populateContactoForm(contacto);
		
		model.addAttribute("contactoForm", contactoForm);
		
		model.addAttribute("mensaje", "Contacto creado correctamente");
		
		model.addAttribute("esCreacion", false);

				
		return "web/editarContacto";
	}
	
	@PostMapping("/web/modificarContacto")
	public String modificarContacto(HttpServletRequest request,
									ContactoForm contactoForm,
							    	Model model) throws IllegalAccessException, InvocationTargetException {
				
		Long idUsuarioLogueado = (Long)request.getSession().getAttribute(Constantes.ID_USUARIO_LOGUEADO);
		
		Usuario usuarioLogueado = usuarioService.findById(idUsuarioLogueado);
				
		Contacto contacto = populateContacto(usuarioLogueado, contactoForm);
		
		contactoService.merge(contacto);
		
		contactoForm = populateContactoForm(contacto);
		
		model.addAttribute("contactoForm", contactoForm);
		
		model.addAttribute("mensaje", "Contacto modificado correctamente");
		
		model.addAttribute("esCreacion", false);

				
		return "web/editarContacto";
	}

	@GetMapping("/web/editarContacto")
	public String editarContacto(@RequestParam Long id,
							     Model model) throws IllegalAccessException, InvocationTargetException {
		
		Contacto contacto = contactoService.findById(id);
				
		ContactoForm contactoForm = populateContactoForm(contacto);
		
		model.addAttribute("contactoForm", contactoForm);
		
		model.addAttribute("esCreacion", false);
		
		return "web/editarContacto"; 
		
	}

	@PostMapping("/web/eliminarContacto")
	public String eliminarContacto(ContactoForm crearContactoForm,
								   RedirectAttributes redirectAttributes,
							       Model model) {
	
		Long id = crearContactoForm.getId();
		
		Contacto contacto = contactoService.findById(id);
		
		contactoService.remove(contacto);
		
		redirectAttributes.addFlashAttribute("mensaje", "Contacto eliminado correctamente");
				
		return "redirect:/web/listadoContactos";
	}
	
	private Contacto populateContacto(Usuario usuarioLogueado, ContactoForm crearContactoForm) {
		
		if(crearContactoForm.getTelefonos() == null || crearContactoForm.getTelefonos().isEmpty()) {
			crearContactoForm.setTelefonos(List.of(""));
		}
		
		if(crearContactoForm.getCorreos() == null || crearContactoForm.getCorreos().isEmpty()) {
			crearContactoForm.setCorreos(List.of(""));
		}
		
		Contacto contacto = new Contacto();
		
		Long id = crearContactoForm.getId();
		String nombre = crearContactoForm.getNombre();
		String apellidos = crearContactoForm.getApellidos();
				
		contacto.setId(id);
		contacto.setNombre(nombre);
		contacto.setApellidos(apellidos);
		contacto.setUsuario(usuarioLogueado);
		
		List<Telefono> telefonos = new ArrayList<>();
		
		for(String numero : crearContactoForm.getTelefonos()) {
			
			if(numero != null && !numero.equals("")){
				
				Telefono telefono = new Telefono();
				
				telefono.setNumero(numero);
				telefono.setContacto(contacto);
				telefonos.add(telefono);
			}
		}
		
		contacto.setTelefonos(telefonos);
		
		List<Correo> correos = new ArrayList<>();
		
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
	
	private ContactoForm populateContactoForm(Contacto contacto) throws IllegalAccessException, InvocationTargetException {
		
		ContactoForm contactoForm = new ContactoForm();
		
		Long id = contacto.getId();
		String nombre = contacto.getNombre();
		String apellidos = contacto.getApellidos();
		
		contactoForm.setId(id);
		contactoForm.setNombre(nombre);
		contactoForm.setApellidos(apellidos);
		
		List<Telefono> telefonos = contacto.getTelefonos();
		List<String> telefonosForm = new ArrayList<>();
		
		for(Telefono telefono : telefonos) {
			
			String numeroForm = telefono.getNumero();
			
			if(numeroForm != null && !numeroForm.equals("")) {
				
				telefonosForm.add(numeroForm);
			}
		}
		
		contactoForm.setTelefonos(telefonosForm);
		
		List<Correo> correos = contacto.getCorreos();
		List<String> correosForm = new ArrayList<>();
		
		for(Correo correo : correos) {
			
			String correoForm = correo.getCorreo();
			
			if(correoForm != null && !correoForm.equals("")) {
				
				correosForm.add(correoForm);
			}
		}
		
		contactoForm.setCorreos(correosForm);
		
		if(contacto.getTelefonos() == null || contacto.getTelefonos().isEmpty()) {
			contactoForm.setTelefonos(List.of(""));
		}
		
		if(contacto.getCorreos() == null || contacto.getCorreos().isEmpty()) {
			contactoForm.setCorreos(List.of(""));
		}
		
		return contactoForm;
	}
}
