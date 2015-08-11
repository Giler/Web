package com.Web.pageModel;

import java.io.Serializable;

public class Json implements Serializable{
	private boolean succsee = false;
	private String msg ="";
	private Object obj = null;

	public boolean isSuccsee() {
		return succsee;
	}

	public void setSuccsee(boolean succsee) {
		this.succsee = succsee;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
