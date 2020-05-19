package br.com.unip.aps.service;

import br.com.unip.aps.domain.Empresa;

public interface ILoginService {

	Empresa fazerLogin(String email, String senha);
	
}
