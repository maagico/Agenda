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

import es.agenda.excepcion.UsuarioYaExisteException;
import es.agenda.form.CuentaForm;
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
		
		model.addAttribute("cuentaForm", new CuentaForm());
		
		List<Rol> roles = rolService.findAll();
		model.addAttribute("roles", roles);
		
		return "crearCuenta";
	}
	
	@PostMapping("/crearCuenta")
	public String crearCuenta(@Valid CuentaForm cuentaForm,
						      BindingResult result,
						      HttpServletRequest request,
							  Model model) throws IllegalAccessException, InvocationTargetException {
		
		List<Rol> roles = rolService.findAll();
		model.addAttribute("roles", roles);
		
		if(result.hasErrors()) {
						
			model.addAttribute("cuentaForm", cuentaForm);
			
			return "crearCuenta";
			
		}else {
			
			Usuario usuario = new Usuario();
			BeanUtils.copyProperties(usuario, cuentaForm);
			
			Long roleId = cuentaForm.getRoleId();
			Rol rol = rolService.findById(roleId);
			usuario.setRol(rol);
			
			try {
				
				usuarioService.guardarUsuario(usuario);
				
			}catch(UsuarioYaExisteException e){
				
				String mensajeError = "El usuario ya existe, por favor elige otro";
				
				model.addAttribute("mensajeError", mensajeError);
				
				return "crearCuenta";
			}
			
			return "login";
		}		
	}
}
