package br.com.unip.aps.controller;

import br.com.unip.aps.domain.Empresa;
import br.com.unip.aps.domain.Endereco;
import br.com.unip.aps.domain.Ong;
import br.com.unip.aps.domain.Telefone;
import br.com.unip.aps.service.ICadastroService;
import br.com.unip.aps.service.ValidadorMensagem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("cadastro")
public class CadastroController {

    @Autowired
    private ICadastroService cadastroService;

    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("cliente") Empresa empresa, @ModelAttribute("ong") Ong ong,
                            @ModelAttribute("endereco") Endereco endereco, @ModelAttribute("telefone") Telefone telefone) {
        return "/cadastro/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("cliente") Empresa empresa, @ModelAttribute("ong") Ong ong,
                         @ModelAttribute("endereco") Endereco endereco, BindingResult result, @ModelAttribute("telefone") Telefone telefone,
                         RedirectAttributes redirect) {
        String validadorCliente = ValidadorMensagem.returnAnnotationMsgError(empresa);
        String validadorEndereco = ValidadorMensagem.returnAnnotationMsgError(endereco);
        String validadorTelefone = ValidadorMensagem.returnAnnotationMsgError(telefone);
        if (!StringUtils.isEmpty(validadorCliente) || !StringUtils.isEmpty(validadorEndereco) || !StringUtils.isEmpty(validadorTelefone)) {
            redirect.addFlashAttribute("empresa", validadorCliente);
            redirect.addFlashAttribute("enderecoEmpresa", validadorEndereco);
            redirect.addFlashAttribute("telefoneEmpresa", validadorTelefone);
            return "redirect:/cadastro/cadastro";
        }
        cadastroService.cadastrarEmpresa(new Empresa(empresa.getNome(), empresa.getEmail(), empresa.getSenha(), empresa.getCnpj(),
                new Endereco(endereco.getRua(), endereco.getComplemento(), endereco.getEstado(), endereco.getCidade(),
                        endereco.getCep()), new Telefone(telefone.getTelefone(), telefone.getRamal())));
        redirect.addFlashAttribute("mensagem", "Cadastro feito com sucesso");
        return "redirect:/home";
    }
}
