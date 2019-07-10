package br.com.treinaweb.twgerenciadortarefas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.treinaweb.twgerenciadortarefas.modelos.Usuario;
import br.com.treinaweb.twgerenciadortarefas.servicos.ServicoUsuario;

@Controller
public class ContaController {
	private ServicoUsuario servicoUsuario;

	@GetMapping("/login")
	public String login() {
		return "conta/login";
	}

	@GetMapping("/registration")
	public ModelAndView registrarion() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("conta/registrar");
		mv.addObject("usuario", new Usuario());
		return mv;
	}

	@PostMapping("/registration")
	public ModelAndView registration(Usuario usuario, BindingResult res) {
		ModelAndView mv = new ModelAndView();
		Usuario usr = servicoUsuario.encontrarPorEmail(usuario.getEmail());
		if (usr != null) {
			res.rejectValue("email", "", "Usuário já cadastrado");
		}

		if (res.hasErrors()) {
			mv.setViewName("conta/registration");
			mv.addObject("usuario", usuario);

		} else {
			servicoUsuario.salvar(usuario);
			mv.setViewName("redirect:/login");

		}
		
		return mv;
	}

}
