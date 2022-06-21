package es.agenda.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.agenda.constantes.Constantes;
import es.agenda.model.Contacto;
import es.agenda.service.ContactoServiceI;

@Controller
public class BuscadorContactoController {

	@Autowired
	private ContactoServiceI contactoService;
	
	@GetMapping("/web/buscarContactos")
	public String buscarContactos(@RequestParam String textoABuscar,
								  HttpServletRequest request,
							      Model model) {
		
		Long idUsuarioLogueado = (Long)request.getSession().getAttribute(Constantes.ID_USUARIO_LOGUEADO);
		
		List<Contacto> contactosEncontrados = contactoService.buscarContactos(idUsuarioLogueado, textoABuscar);
		
		model.addAttribute("contactos", contactosEncontrados);
		model.addAttribute("mostrarDeseleccionarBusqueda", true);
		
		return "web/listadoContactos";
	}
}
