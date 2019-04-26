package com.po;

public class User {
	public String sno;
	public String password;
	public void setsno(String sno) {
		this.sno=sno;
	}
	public String getsno() {
		return this.sno;
	}
	public void setpassword(String password) {
		this.password=password;
	}
	public String getpassword() {
		return this.password;
	}
}
