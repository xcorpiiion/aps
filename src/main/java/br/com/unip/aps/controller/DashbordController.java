package br.com.unip.aps.controller;

import br.com.unip.aps.domain.Empresa;
import br.com.unip.aps.domain.Ong;
import br.com.unip.aps.repository.IEmpresaRepository;
import br.com.unip.aps.repository.IOngRepository;
import br.com.unip.aps.service.ILoginService;
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

import javax.validation.Valid;
import java.util.Arrays;

@Controller
@RequestMapping("dashbord")
public class DashbordController {

    @Autowired
    private ILoginService loginService;

    @Autowired
    private IEmpresaRepository empresaRepository;

    @Autowired
    private IOngRepository ongRepository;

    private Empresa empresa;

    private Ong ong;

    @GetMapping("/inicial")
    public ModelAndView preSalvar(ModelMap modelMap) {
        if (loginService.retornaEmpresaLogada() != null) {
            this.empresa = loginService.retornaEmpresaLogada();
            modelMap.addAttribute("cliente", loginService.retornaEmpresaLogada());
        } else {
            this.ong = loginService.retornaOngLogada();
            modelMap.addAttribute("cliente", loginService.retornaOngLogada());
        }
        return new ModelAndView("/dashbord/inicial", modelMap);
    }

    @GetMapping("/profile")
    public ModelAndView profile(ModelMap modelMap) {
        if (loginService.retornaEmpresaLogada() != null) {
            modelMap.addAttribute("cliente", Arrays.asList(loginService.retornaEmpresaLogada()));
        } else {
            modelMap.addAttribute("cliente", Arrays.asList(loginService.retornaOngLogada()));
        }
        return new ModelAndView("/dashbord/profile", modelMap);
    }

    @GetMapping("/sair")
    public String sair() {
        if(empresa != null) {
            empresa = loginService.retornaEmpresaLogada();
            empresa.setLogado(false);
            empresaRepository.save(empresa);
            return "redirect:/login/login";
        }
        ong.setLogado(false);
        ongRepository.save(ong);
        return "redirect:/login/login";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("login") Empresa cliente, BindingResult result, RedirectAttributes redirect) {
        if (result.hasFieldErrors("email")) {
            return "/login/login";
        }

        empresa = loginService.fazerLoginEmpresa(cliente.getEmail(), cliente.getSenha());
        if (empresa != null) {
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
