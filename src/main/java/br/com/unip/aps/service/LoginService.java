package br.com.unip.aps.service;

import br.com.unip.aps.domain.Empresa;
import br.com.unip.aps.repository.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService implements ILoginService {

	@Autowired
	private IEmpresaRepository empresaRepository;
	
	@Override
	public Empresa fazerLogin(String email, String senha) {
		for (Empresa empresas: empresaRepository.findAll()) {
			if(empresas.getEmail().equals(email) && empresas.getSenha().equals(senha)) {
				return empresas;
			}
		}
		return null;
	}
	
	
	
}
