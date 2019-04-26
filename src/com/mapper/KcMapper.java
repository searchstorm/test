package com.mapper;

import java.util.List;

import com.po.Kc;

public interface KcMapper {
	public List<Kc> getKcs();
	public List<String> getCnos();
	public Kc getKc(String cno);
	public int deleteKc(String cno);
	public int insertKc(Kc c);
}
