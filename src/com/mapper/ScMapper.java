package com.mapper;

import java.util.List;

import com.po.Sc;

public interface ScMapper {
	public List<Sc> getScs();
	public List<String> getSnos();
	public int getgrade(String sno ,String cno);
	public List<Sc> getSc(String sno);
	public int deleteSc(Sc s);
	public int deleteScs(String sno);
	public int insertSc(Sc s);
	public int updateSc(Sc s);
}
