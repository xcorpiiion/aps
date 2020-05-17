package br.com.unip.aps.service;

import br.com.unip.aps.domain.Cliente;

public interface ICadastroService {
	
	void cadastrarEmpresa(String nome, String cnpj, String email, String senha);
	void cadastrarEnderecoEmpresa(String rua, String complemento, String estado, String cidade, String cep);
	void cadastrarTelefoneEmpresa(String numeroTelefone, String ramal);
}
