package com.mapper;

import com.po.User;


public interface UserMapper {
	public User getUser(String sno);
	public int deleteUser(String sno);
	public int insertUser(User us);
}
