package com.Web.service;

import java.io.Serializable;

import com.Web.model.Users;
import com.Web.pageModel.User;

public interface UserServiceI {

	Serializable save(User user);
	User login(User user);
}
