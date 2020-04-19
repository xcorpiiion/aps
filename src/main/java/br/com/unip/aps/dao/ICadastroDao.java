package br.com.unip.aps.dao;

import br.com.unip.aps.domain.Cliente;

public interface ICadastroDao {
	
	void cadastrar(Cliente cliente);
	Cliente recuperarPorId(long id);
	
}
