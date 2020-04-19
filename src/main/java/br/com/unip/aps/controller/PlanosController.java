package br.com.unip.aps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("planosNegocios")
public class PlanosController {
	
	@GetMapping("/planos")
	public String teste() {
		return "/planos/planos";
	}
	
}
