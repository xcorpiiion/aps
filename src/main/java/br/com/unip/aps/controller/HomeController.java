package br.com.unip.aps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@GetMapping("/home")
	public ModelAndView home(ModelMap modelMap) {
		return new ModelAndView("/home.html");
	}
	
}
