package br.com.unip.aps.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.unip.aps.domain.Cliente;
import br.com.unip.aps.service.ILoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	
	@GetMapping("/login")
	public String preSalvar(@ModelAttribute("login") Cliente cliente) {
		return "/login/login";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid @ModelAttribute("login") Cliente cliente, BindingResult result, RedirectAttributes redirect) {
		if(result.hasFieldErrors("email")) {
			return "/login/login";
		}
		
		if(loginService.fazerLogin(cliente.getEmail(), cliente.getSenha())) {
			redirect.addFlashAttribute("mensagem", "Login feito com sucesso");
			return "redirect:/home";
		} else {
			redirect.addFlashAttribute("mensagem", "Não foi feito login");
			return "/login/login";
		}
	}
	
}
