package es.agenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CuentaController {

	@GetMapping("irACrearCuenta")
	public String irACrearCuenta() {
		return "crearCuenta";
	}
	
	@PostMapping("crearCuenta")
	public String crearCuenta() {
		return "admin/listadoUsuarios";
	}
}
