package com.mapper;

import com.po.Manager;

public interface ManagerMapper {
	public Manager getManager(String manager);
	public int deleteManager(int manager);
	public int insertManager(Manager m);
}
