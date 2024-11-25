package com.demo.dao;

import java.util.List;

import com.demo.beans.Person;
import com.demo.beans.Product;
import com.demo.beans.User;

public interface LoginDao {

	boolean saveDetails(Person p1, User u1);

	User validateUser(String username, String password);

}
