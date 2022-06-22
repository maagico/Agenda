package es.agenda.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.agenda.form.UsuarioForm;
import es.agenda.model.Rol;
import es.agenda.model.Usuario;
import es.agenda.service.RolServiceI;
import es.agenda.service.UsuarioServiceI;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioServiceI usuarioService;
	
	@Autowired
	private RolServiceI rolService;
	
	@GetMapping("/admin/addUsuario")
	public String addUsuario(Model model) {
		
		model.addAttribute("usuarioForm", new UsuarioForm());
		
		List<Rol> roles = rolService.findAll();
		model.addAttribute("roles", roles);
		
		model.addAttribute("esCreacion", true);
		
		return "admin/editarUsuario";
	}
	
	@GetMapping("/admin/listadoUsuarios")
	public String listadoUsuarios(Model model) {
		
		List<Usuario> usuarios = usuarioService.findAllOrderByNombre();
		
		model.addAttribute("usuarios", usuarios);
		
		return "admin/listadoUsuarios";
	}
	
	@GetMapping("/admin/editarUsuario")
	public String editarContacto(@RequestParam Long id,
							     Model model) throws IllegalAccessException, InvocationTargetException {
		
		Usuario usuario = usuarioService.findById(id);
				
		UsuarioForm usuarioForm = populateUsuarioForm(usuario);
		
		model.addAttribute("usuarioForm", usuarioForm);
		
		List<Rol> roles = rolService.findAll();
		model.addAttribute("roles", roles);
		
		model.addAttribute("esCreacion", false);
		
		return "admin/editarUsuario"; 
		
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
	
	private UsuarioForm populateUsuarioForm(Usuario usuario){
		
		UsuarioForm usuarioForm = new UsuarioForm();
		
		Long id = usuario.getId();
		String nombre = usuario.getUsuario();
		String password = "";
		Long roleId = usuario.getRol().getId();
		
		usuarioForm.setId(id);
		usuarioForm.setNombre(nombre);
		usuarioForm.setPassword(password);
		usuarioForm.setRoleId(roleId);
			
		return usuarioForm;
	}
}
