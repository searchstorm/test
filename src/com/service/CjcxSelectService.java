package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSONObject;
import com.mapper.CjpmMapper;
import com.mapper.ScMapper;
import com.po.Cjpm;
import com.po.Sc;
import com.util.SqlSessionFactoryUtil;

@WebServlet("/CjcxSelectService")
public class CjcxSelectService extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sno = request.getParameter("sno");
        SqlSession sqlSession = null;
       
        try {
        	sqlSession = SqlSessionFactoryUtil.openSqlSession();
        	ScMapper scMapper = sqlSession.getMapper(ScMapper.class);
			CjpmMapper cjpmMapper = sqlSession.getMapper(CjpmMapper.class);
			List<Sc> sc = new ArrayList<Sc>();
			Cjpm c = new Cjpm();
			
			//Stu stu = new Stu();
		
		//	List<String> sno = new ArrayList<String>();
			
				c = cjpmMapper.getCjpm(sno); //得到该学生的cjpm表信息
	
				JSONObject cj = new JSONObject();//创建json对象
				cj.put("sno", c.getsno()); // 插入相应的键值对，如'sno'对应c对象的sno值
				cj.put("sname", c.getsname());
				cj.put("sclass",c.getsclass());
				cj.put("total", c.gettotal());
			    cj.put("rank", c.getrank());
				sc = scMapper.getSc(c.getsno()); // 得到该学号的所有选课和成绩	
				for(Sc ss : sc) { // 遍历
					cj.put(ss.getcno().trim(), ss.getgrade()); // 将学号作为键，成绩作为值
				}
				
			//	cjcx.add(cj);
				 
            sqlSession.commit();
          //  JSONObject jsonObject = JSONObject.;
            String jsonStr = JSONObject.toJSONString(cj);
         //   JSONObject jsonObject = JSONObject.parseObject(jsonStr);
            PrintWriter pWriter = response.getWriter();
            pWriter.write(jsonStr);
            pWriter.flush();
            System.out.println(jsonStr);
            
     
   
   
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	sqlSession.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
