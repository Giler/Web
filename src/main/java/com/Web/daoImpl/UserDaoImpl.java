package com.Web.daoImpl;

import org.springframework.stereotype.Repository;

import com.Web.dao.UserDaoI;
import com.Web.model.Users;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Users> implements UserDaoI {

}
