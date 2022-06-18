package es.agenda.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	 
	@GetMapping(value = {"/", "/login"})
	public String login() {
		return "login";
	}
	
	@GetMapping("/redirigir")
	public String listadoContactos(HttpServletRequest request) {
			
		boolean esAdmin = request.isUserInRole("ADMIN");
		
		if(esAdmin) {
			
			return "admin/listadoUsuarios";
			
		}else {
			
			return "listadoContactos";
		}
		
	}
}
