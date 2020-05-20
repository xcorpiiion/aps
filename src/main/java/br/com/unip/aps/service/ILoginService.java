package br.com.unip.aps.service;

import br.com.unip.aps.domain.Empresa;
import br.com.unip.aps.domain.Ong;

public interface ILoginService {

	Empresa fazerLoginEmpresa(String email, String senha);

	Empresa retornaEmpresaLogada();

	Ong fazerLoginOng(String email, String senha);

	Ong retornaOngLogada();

}
