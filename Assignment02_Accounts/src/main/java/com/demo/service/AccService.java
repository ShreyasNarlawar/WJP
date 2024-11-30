package com.demo.service;

public interface AccService {

	boolean createNewAcc(int aid, String name, String email, double balance);

	boolean updateAccount(int id, String name, String email, double balance);

	boolean deleteById(int id);

}
