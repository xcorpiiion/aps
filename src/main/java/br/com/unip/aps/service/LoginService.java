package br.com.unip.aps.service;

import br.com.unip.aps.domain.Cliente;
import br.com.unip.aps.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService implements ILoginService {

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	public boolean fazerLogin(String email, String senha) {
		for (Cliente clientes: clienteRepository.findAll()) {
			if(clientes.getEmail().equals(email) && clientes.getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
