package es.agenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	 
	@GetMapping("/login")
	public String login() {
		System.out.println();
		
		return "login1";
	}
}
