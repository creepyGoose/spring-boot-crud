package br.com.treinaweb.twgerenciadortarefas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContaController {
    
	@GetMapping("/login")
	public String login() {
		return "conta/login";
	}
}