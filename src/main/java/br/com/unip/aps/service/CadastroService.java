package br.com.unip.aps.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unip.aps.dao.ICadastroDao;
import br.com.unip.aps.domain.Cliente;

@Service
@Transactional
public class CadastroService implements ICadastroService{
	
	@Autowired
	private ICadastroDao iCadastroDao;

	@Override
	public void cadastrar(Cliente cliente) {
		iCadastroDao.cadastrar(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente recuperarPorId(long id) {
		return iCadastroDao.recuperarPorId(id);
	}
	
}
