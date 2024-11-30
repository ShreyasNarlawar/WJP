package com.demo.service;

import com.demo.dao.AccDao;
import com.demo.dao.AccDaoImpl;

public class AccServiceImpl implements AccService {
	private AccDao adao;
	
	public AccServiceImpl() {
		adao = new AccDaoImpl();
	}

	@Override
	public boolean createNewAcc(int aid, String name, String email, double balance) {
		// TODO Auto-generated method stub
		return adao.createNewAcc(aid,name,email,balance);
	}

	@Override
	public boolean updateAccount(int id, String name, String email, double balance) {
		// TODO Auto-generated method stub
		return adao.updateAccount(id,name,email,balance);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return adao.deleteById(id);
	}
	
}
