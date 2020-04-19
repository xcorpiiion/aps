package br.com.unip.aps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unip.aps.dao.ILoginDao;

@Service
@Transactional
public class LoginService implements ILoginService {

	@Autowired
	private ILoginDao loginDao;
	
	@Override
	public boolean fazerLogin(String email, String senha) {
		return loginDao.fazerLogin(email, senha);
	}
	
	
	
}
