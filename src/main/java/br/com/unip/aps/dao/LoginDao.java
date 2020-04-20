package br.com.unip.aps.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.unip.aps.domain.Cliente;

@Repository
public class LoginDao implements ILoginDao {

	@Autowired
	private EntityManager entityManager;

	/**
	 *
	 */

	@Override
	public boolean fazerLogin(String email, String senha) {
		try {
			entityManager
					.createQuery("select c from Cliente c where c.email = :email and c.senha = :senha", Cliente.class)
					.setParameter("email", email).setParameter("senha", senha).getSingleResult();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
