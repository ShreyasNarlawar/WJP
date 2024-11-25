package com.demo.services;

import java.util.List;

import com.demo.beans.Person;
import com.demo.beans.Product;
import com.demo.beans.User;

public interface LoginService {

	boolean registerUsers(Person p1, User u1);

	User authenticateUser(String username, String password);

}
