package br.com.unip.aps.controller;

import br.com.unip.aps.domain.Cliente;
import br.com.unip.aps.domain.Endereco;
import br.com.unip.aps.domain.Telefone;
import br.com.unip.aps.service.ICadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("cadastro")
public class CadastroController {

    @Autowired
    private ICadastroService cadastroService;

    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("cliente") Cliente cliente, @ModelAttribute("endereco") Endereco endereco,
                            @ModelAttribute("telefone") Telefone telefone) {
        return "/cadastro/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("cliente") Cliente cliente, @ModelAttribute("endereco") Endereco endereco, BindingResult result,
                         @Valid @ModelAttribute("telefone") Telefone telefone, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "/login/login";
        }

        redirect.addAttribute("mensagem", "Login feito com sucesso");
        return "/cadastro/cadastro";
    }
}
