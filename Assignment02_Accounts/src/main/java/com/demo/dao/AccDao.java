package com.demo.dao;

import java.util.List;

import com.demo.beans.Accounts;

public interface AccDao {

	boolean createNewAcc(int aid, String name, String email, double balance);

	boolean updateAccount(int id, String name, String email, double balance);

	boolean deleteById(int id);

	List<Accounts> getAllAccounts();

}
