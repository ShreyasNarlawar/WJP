package com.demo.services;

import com.demo.beans.Person;
import com.demo.beans.User;

public interface LoginService {

	User validateUser(String uname, String passwd);

	boolean registerDetails(User u1, Person p1);

}
