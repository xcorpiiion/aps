package br.com.unip.aps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("planosNegocios")
public class PlanosController {
	
	@GetMapping("/planos")
	public ModelAndView teste(ModelMap model) {
		return new ModelAndView("/planos/planos.html");
	}
	
}
