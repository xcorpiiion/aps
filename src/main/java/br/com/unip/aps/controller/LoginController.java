package br.com.unip.aps.controller;

import javax.validation.Valid;

import br.com.unip.aps.domain.Ong;
import br.com.unip.aps.repository.IEmpresaRepository;
import br.com.unip.aps.repository.IOngRepository;
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

	@Autowired
	private IOngRepository ongRepository;

	private Empresa empresa;

	private Ong ong;
	
	@GetMapping("/login")
	public String preSalvar(@ModelAttribute("login") Empresa empresa, RedirectAttributes redirect) {
		empresa = loginService.retornaEmpresaLogada();
		if(empresa == null) {
			return "/login/login";
		}

		if(empresa.isLogado()) {
			redirect.addFlashAttribute("mensagem", "");
			return "redirect:/home";
		}
		return "/login/login";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid @ModelAttribute("login") Empresa cliente, BindingResult result, RedirectAttributes redirect) {
		if(result.hasFieldErrors("email")) {
			return "/login/login";
		}

		empresa = loginService.fazerLoginEmpresa(cliente.getEmail(), cliente.getSenha());
		if(empresa != null) {
			redirect.addFlashAttribute("mensagem", "Login feito com sucesso");
			empresa.setLogado(true);
			empresaRepository.save(empresa);
			return "redirect:/dashbord/inicial";
		} else {
			this.ong = loginService.fazerLoginOng(cliente.getEmail(), cliente.getSenha());
			if(this.ong != null) {
				this.ong.setLogado(true);
				ongRepository.save(ong);
				return "redirect:/dashbord/inicial";
			}
			redirect.addFlashAttribute("mensagem", "Não foi feito login");
			return "/login/login";
		}
	}
	
}
