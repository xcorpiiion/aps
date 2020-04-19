package br.com.unip.aps.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.unip.aps.domain.Cliente;
import br.com.unip.aps.service.ICadastroService;

@Controller
@RequestMapping("cadastro")
public class CadastroController {

	@Autowired
	private ICadastroService cadastroService;
	
	@GetMapping("/lista")
	public ModelAndView listar(ModelMap model) {
		model.addAttribute("playlist", cadastroService.recuperarPorId(5));
		return new ModelAndView("/playlist/lista", model);
	}

	@GetMapping("/cadastro")
	public String preSalvar(@ModelAttribute("cadastro") Cliente cliente) {
		return "/cadastro/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid @ModelAttribute("cadastro") Cliente cliente, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {
			return "/cadastro/cadastro";
		}
		
		cadastroService.cadastrar(cliente);
		redirect.addFlashAttribute("mensagem", "Cadastrado com sucesso");
		return "redirect:/home";
	}
	
}
