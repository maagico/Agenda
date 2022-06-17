package es.agenda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import es.agenda.form.CrearCuentaForm;
import es.agenda.service.UsuarioServiceI;

@Controller
public class CuentaController {

	@Autowired
	private UsuarioServiceI usuarioService;
	
	@GetMapping("irACrearCuenta")
	public String irACrearCuenta(Model model) {
		
		model.addAttribute("crearCuentaForm", new CrearCuentaForm());
		
		return "crearCuenta";
	}
	
	@PostMapping("crearCuenta")
	public String crearCuenta(@Valid CrearCuentaForm crearCuentaForm,
						      BindingResult result,
							  Model model) {
		
		if(result.hasErrors()) {
		
			return "crearCuenta";
			
		}else {
			
			return "admin/listadoUsuarios";
		}		
	}
}
