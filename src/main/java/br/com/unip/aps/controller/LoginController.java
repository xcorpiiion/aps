package br.com.unip.aps.controller;

import javax.validation.Valid;

import br.com.unip.aps.repository.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.unip.aps.domain.Empresa;
import br.com.unip.aps.service.ILoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private ILoginService loginService;

	@Autowired
	private IEmpresaRepository empresaRepository;

	private Empresa empresa;
	
	@GetMapping("/login")
	public String preSalvar(@ModelAttribute("login") Empresa empresa, RedirectAttributes redirect) {
		empresa = this.empresa;
		if(empresa == null) {
			return "/login/login";
		}
		if(empresa.isLogado()) {
			redirect.addFlashAttribute("mensagem", "");
			return "redirect:/home";
		}
		return "/login/login";
	}

	@GetMapping("/sair")
	public String sair(@ModelAttribute("login") Empresa empresa) {
		empresa = this.empresa;
		empresa.setLogado(false);
		empresaRepository.save(empresa);
		return "redirect:/login/login";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid @ModelAttribute("login") Empresa cliente, BindingResult result, RedirectAttributes redirect) {
		if(result.hasFieldErrors("email")) {
			return "/login/login";
		}

		empresa = loginService.fazerLogin(cliente.getEmail(), cliente.getSenha());
		if(empresa != null) {
			redirect.addFlashAttribute("mensagem", "Login feito com sucesso");
			empresa.setLogado(true);
			empresaRepository.save(empresa);
			return "redirect:/home";
		} else {
			redirect.addFlashAttribute("mensagem", "Não foi feito login");
			empresa.setLogado(false);
			empresaRepository.save(empresa);
			return "/login/login";
		}
	}
	
}
