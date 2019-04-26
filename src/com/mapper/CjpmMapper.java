package com.mapper;

import java.util.List;

import com.po.Cjpm;

public interface CjpmMapper {
	public int deleteCjpm(String sno);
	public int insertCjpm(Cjpm c);
	public List<Cjpm> getCjpms();
	public Cjpm getCjpm(String sno);
	public int updateCjpm(Cjpm c);
	public int updateCjpmtotal(String sno);
}
