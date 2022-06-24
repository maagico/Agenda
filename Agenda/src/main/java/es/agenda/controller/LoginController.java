package es.agenda.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import es.agenda.constantes.Constantes;
import es.agenda.model.Usuario;
import es.agenda.service.UsuarioServiceI;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioServiceI usuarioService;
	
	@GetMapping(value = {"/", "/login"})
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/redirigir")
	public String redirigir(HttpServletRequest request) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        String nombreUsuarioLogueado = userDetails.getUsername();       
        
        Usuario usuarioLogueado = usuarioService.findByNombreUsuario(nombreUsuarioLogueado);
        
        Long idUsuarioLogueado = usuarioLogueado.getId();
        
        request.getSession(true).setAttribute(Constantes.ID_USUARIO_LOGUEADO, idUsuarioLogueado);
		
		boolean esAdmin = request.isUserInRole("ADMIN");
		
		if(esAdmin) {
			
			return "redirect:/admin/listadoUsuarios";
			
		}else {
			
			return "redirect:/web/listadoContactos";
		}
		
	}
}
