package br.com.unip.aps.service;

import br.com.unip.aps.domain.Empresa;
import br.com.unip.aps.domain.Ong;

public interface ICadastroService {
	
	void cadastrarEmpresa(Empresa empresa);
	void cadastrarOng(Ong ong);
}
