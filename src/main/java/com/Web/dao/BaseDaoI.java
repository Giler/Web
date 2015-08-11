package com.Web.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDaoI<T> {
	public Serializable save(T o);
	public T login(String hql);
}
