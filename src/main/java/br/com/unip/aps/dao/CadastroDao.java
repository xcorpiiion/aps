package br.com.unip.aps.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.unip.aps.domain.Cliente;

@Repository
public class CadastroDao implements ICadastroDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void cadastrar(Cliente cliente) {
		entityManager.persist(cliente);
	}

	@Override
	public Cliente recuperarPorId(long id) {
		return entityManager.find(Cliente.class, id);
		
	}
	
	
	
}
