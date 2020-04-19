package br.com.unip.aps.service;

import br.com.unip.aps.domain.Cliente;

public interface ICadastroService {
	
	void cadastrar(Cliente cliente);
	Cliente recuperarPorId(long id);
}
