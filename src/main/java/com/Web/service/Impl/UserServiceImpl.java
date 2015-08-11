package com.Web.service.Impl;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Web.dao.UserDaoI;
import com.Web.model.Users;
import com.Web.pageModel.User;
import com.Web.service.UserServiceI;
import com.Web.util.Encrypt;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(UserServiceImpl.class);
	private UserDaoI userDao;

	public UserDaoI getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}

	@Override
	public Serializable save(User user) {
//		user.setUsername(name);
//		user.setPassword(password);
		Users tuser =new Users();
		BeanUtils.copyProperties(user, tuser, new String[]{"pwd"});
		tuser.setId(UUID.randomUUID().toString());		
		tuser.setSetdate(new Date());
		tuser.setPwd(Encrypt.e(user.getPwd()));
		userDao.save(tuser);
		 
		return null;
	}

	@Override
	public User login(User user) {
		String hql = "from Users u where u.name='"+user.getName()+"' u.pwd='"+Encrypt.e(user.getPwd())+"'";
		Users U = userDao.login(hql);
		if(U!=null){
			return user;
		}
		return null;
	}

}
