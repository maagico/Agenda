package es.agenda.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import es.agenda.form.CrearCuentaForm;
import es.agenda.model.Rol;
import es.agenda.model.Usuario;
import es.agenda.service.RolServiceI;
import es.agenda.service.UsuarioServiceI;

@Controller
public class CuentaController {

	@Autowired
	private UsuarioServiceI usuarioService;
	
	@Autowired
	private RolServiceI rolService;
	
	@GetMapping("/irACrearCuenta")
	public String irACrearCuenta(Model model) {
		
		model.addAttribute("crearCuentaForm", new CrearCuentaForm());
		
		List<Rol> roles = rolService.findAll();
		model.addAttribute("roles", roles);
		
		return "crearCuenta";
	}
	
	@PostMapping("/crearCuenta")
	public String crearCuenta(@Valid CrearCuentaForm crearCuentaForm,
						      BindingResult result,
						      HttpServletRequest request,
							  Model model) throws IllegalAccessException, InvocationTargetException {
		
		if(result.hasErrors()) {
			
			List<Rol> roles = rolService.findAll();
			model.addAttribute("roles", roles);
			
			model.addAttribute("crearCuentaForm", crearCuentaForm);
			
			return "crearCuenta";
			
		}else {
			
			Usuario usuario = new Usuario();
			BeanUtils.copyProperties(usuario, crearCuentaForm);
			
			usuarioService.merge(usuario);
			
			boolean esAdmin = request.isUserInRole("ADMIN");
			
			if(esAdmin) {
				
				return "/listadoContactos";
				
			}else {
				
				return "/listadoUsuarios";
			}
		}		
	}
}
