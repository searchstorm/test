package com.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mapper.ScMapper;
import com.mapper.StuMapper;
import com.po.Sc;
import com.po.Stu;

public class Main {
	public static SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
	}

	public static void main(String[] args) throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			
			ScMapper scMapper = sqlSession.getMapper(ScMapper.class);
		//	Sc sc = new Sc();
		//	sc.setcno("002");
			
		//	String grade="23";
			int g ;
		//	sc.setgrade(g);
		//	sc.setsno("222");
			scMapper.deleteScs("1");

		}catch(Exception ex) {
			
			System.out.println(ex.getMessage());
			sqlSession.rollback();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
	}
}
