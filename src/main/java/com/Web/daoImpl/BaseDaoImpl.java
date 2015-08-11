package com.Web.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Web.dao.BaseDaoI;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T> {
	private SessionFactory sessionfaction;

	public SessionFactory getSessionfaction() {
		return sessionfaction;
	}

	@Autowired
	public void setSessionfaction(SessionFactory sessionfaction) {
		this.sessionfaction = sessionfaction;
	}

	@Override
	public Serializable save(T o) {
		// TODO Auto-generated method stub
		return this.sessionfaction.getCurrentSession().save(o);
	}

	@Override
	public T login(String hql) {
		Query q = this.sessionfaction.getCurrentSession().createQuery(hql);
		List<T> list = q.list();
		if(list!=null & list.size()>0){
			return list.get(0);
		}
		return null;
	}


	

}
