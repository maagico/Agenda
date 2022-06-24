package es.agenda.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.agenda.form.UsuarioForm;
import es.agenda.model.Contacto;
import es.agenda.model.Usuario;
import es.agenda.service.ContactoServiceI;
import es.agenda.service.UsuarioServiceI;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioServiceI usuarioService;
	
	@Autowired
	private ContactoServiceI contactoService;
	
	@GetMapping("/admin/listadoUsuarios")
	public String listadoUsuarios(HttpServletRequest request,
								  Model model) {
		
		List<Usuario> usuarios = usuarioService.findAllUsuariosOrderByNombre();
		
		model.addAttribute("usuarios", usuarios);
		
		model.addAttribute("usuarioForm", new UsuarioForm());
		
		return "admin/listadoUsuarios";
	}
	
	@GetMapping("/admin/listadoContactos")
	public String listadoContactos(@RequestParam Long idUsuario,
								   HttpServletRequest request,
								   Model model) {
		
					
		List<Contacto> contactos = contactoService.findAllOrderByNombre(idUsuario);
		
		model.addAttribute("contactos", contactos);
		
		model.addAttribute("quitarBuscador", true);
		
		model.addAttribute("numeroContactos", contactos.size());
		
		return "admin/listadoContactos";
	}
	
	
	@PostMapping("/admin/eliminarUsuario")
	public String eliminarUsuario(UsuarioForm usuarioForm,
								  RedirectAttributes redirectAttributes,
							      Model model) {
	
		Long id = usuarioForm.getId();
		
		Usuario usuario = usuarioService.findById(id);
		
		usuarioService.remove(usuario);
		
		redirectAttributes.addFlashAttribute("mensaje", "Usuario eliminado correctamente");
				
		return "redirect:/admin/listadoUsuarios";
	}
}
