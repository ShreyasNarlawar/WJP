package com.demo.services;

import com.demo.beans.User;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServImpl implements LoginService {

	LoginDao ldao;
	
	public LoginServImpl() {
		ldao = new LoginDaoImpl();
	}

	@Override
	public User authenticateUser(String username, String password) {
		// TODO Auto-generated method stub
		return ldao.validateUser(username, password);
	}

	
	
}
