package com.demo.services;

import com.demo.beans.User;

public interface LoginService {

	User authenticateUser(String username, String password);

}
