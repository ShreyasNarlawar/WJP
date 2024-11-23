package com.demo.services;

import com.demo.beans.Person;
import com.demo.beans.User;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
	
	private LoginDao ldao;
	
	public LoginServiceImpl() {
		super();
		ldao = new LoginDaoImpl();
	}


	@Override
	public boolean registerUsers(Person p1, User u1) {
		// TODO Auto-generated method stub
		return ldao.saveDetails(p1,u1);
	}


	@Override
	public boolean authenticateUser(String username, String password) {
		// TODO Auto-generated method stub
		return ldao.validateUser(username,password);
	}

}
