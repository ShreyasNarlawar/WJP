package com.demo.dao;

import com.demo.beans.Person;
import com.demo.beans.User;

public interface LoginDao{

	User CheckUser(String uname, String passwd);

	boolean registersathi(User u1, Person p1);

}
