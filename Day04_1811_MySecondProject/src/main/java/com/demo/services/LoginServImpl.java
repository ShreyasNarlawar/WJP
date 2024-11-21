package com.demo.services;

import com.demo.beans.Person;
import com.demo.beans.User;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServImpl implements LoginService {
	LoginDao ldao;
	public LoginServImpl() {
		super();
		ldao = new LoginDaoImpl();
	}

	@Override
	public User validateUser(String uname, String passwd) {
		return ldao.CheckUser(uname,passwd);
	}

	@Override
	public boolean registerDetails(User u1, Person p1) {
		return ldao.registersathi(u1,p1);
	}

}
