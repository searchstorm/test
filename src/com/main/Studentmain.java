package com.main;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.mapper.CjpmMapper;
import com.po.Cjpm;
import com.util.SqlSessionFactoryUtil;

public class Studentmain {
	public static void main(String[] args) throws IOException{
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			CjpmMapper cjpmMapper = sqlSession.getMapper(CjpmMapper.class);
		//	List<Sc> s = new ArrayList<Sc>();
			Cjpm c = new Cjpm();
			
/*		
			c.setrank(100);
			c.setsclass("1");
			c.setsname("hdsa");
			c.setsno("11");
			c.settotal(2);
			System.out.println("1111111111111");
			cjpmMapper.insertCjpm(c);
			System.out.println("222222222222");
        //    scMapper.insertSc(s);
  //          sqlSession.commit();
            System.out.println("3333333333333333");
          //  JSONObject jsonObject = JSONObject.;
          //  String jsonStr = JSONObject.toJSONString(s);
         //   JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		//	String jsonStr = JSONObject.toJSONString(cjcx);
			
			
		/*	for(int i = 0 ; i < sno.size() ; i ++){
				
				cj.put("rank", cs[i]["rank"]);
			}*/
			// System.out.println(jsonStr);
			// System.out.println(sa);*/
		
			cjpmMapper.deleteCjpm("11");
		}catch(Exception ex) {
			System.out.println("=================");
			System.out.println(ex.getMessage());
			sqlSession.rollback();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
	}
}
