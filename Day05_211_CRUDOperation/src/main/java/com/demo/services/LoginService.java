package com.demo.services;

import com.demo.beans.Person;
import com.demo.beans.User;

public interface LoginService {

	boolean registerUsers(Person p1, User u1);

	boolean authenticateUser(String username, String password);

}
