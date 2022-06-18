package es.agenda.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	 
	@GetMapping(value = {"/", "/login"})
	public String login() {
		return "login";
	}
	
	@GetMapping("/redirigir")
	public String redirigir(HttpServletRequest request) {
			
		boolean esAdmin = request.isUserInRole("ADMIN");
		
		if(esAdmin) {
			
			return "admin/listadoUsuarios";
			
		}else {
			
			return "redirect:/listadoContactos";
		}
		
	}
}
