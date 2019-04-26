package com.mapper;

import java.util.List;

import com.po.Stu;

public interface StuMapper {
	public Stu getStudent(String sno);
	public List<Stu> getStudents(); 
	public int deleteStudent(String sno);
	public int insertStudent(Stu stu);
	public int updateStudent(Stu stu);
	public List<String> getSnos();
}
