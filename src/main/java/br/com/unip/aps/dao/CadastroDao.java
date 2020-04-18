package br.com.unip.aps.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class CadastroDao implements ICadastroDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void cadastrar(String nome, String email, String senha) {
		// TODO Auto-generated method stub
		
	}

}
