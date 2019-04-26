package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.mapper.CjpmMapper;
import com.mapper.StuMapper;
import com.mapper.UserMapper;
import com.po.Cjpm;
import com.po.Stu;
import com.po.User;
import com.util.SqlSessionFactoryUtil;

@WebServlet("/insertStuService")
public class insertStuService extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sno = request.getParameter("sno");
        String sname = request.getParameter("sname");
       
        String sex = request.getParameter("sex");
        String sclass = request.getParameter("sclass");
        String sage = request.getParameter("sage");
        int age = Integer.valueOf(sage);
        System.out.println(sno);
 
        SqlSession sqlSession = null;
       
        try {
        	sqlSession = SqlSessionFactoryUtil.openSqlSession();
        	StuMapper stuMapper = sqlSession.getMapper(StuMapper.class);
        	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        	CjpmMapper cjpmMapper = sqlSession.getMapper(CjpmMapper.class);
        	String  jsonStr = "";
        	if( sno == null ||sname == null || sclass == null || sex == null || sage == null) {
        		jsonStr = "error";
        	}
        	else {
        		char[] sno1 = sno.toCharArray();
        		for(int i = 0 ;i < sno1.length ; i++) {
        			if(sno1[i] < '0' || sno1[i] > '9') {
            			jsonStr = "error1";
            		}
        			
        		}
        		if(jsonStr == "")
        		{
        			Stu s = new Stu();
        			Cjpm c = new Cjpm();
        			User u = new User();
            		s.setsno(sno);	
            		s.setsname(sname);	
            		s.setsex(sex);
            		s.setsclass(sclass);
            		s.setsage(age);
            		
            		c.setsno(sno);
            		c.setsname(sname);
            		c.setsclass(sclass);
            		c.setrank(0);
            		c.settotal(0);
            		
            		u.setsno(sno);
            		u.setpassword(sno);
            		try {
            		stuMapper.insertStudent(s);
            		userMapper.insertUser(u);
            		sqlSession.commit();
            		cjpmMapper.insertCjpm(c);
            		
            		jsonStr = "success";
            		}
            		catch (Exception e){
            			jsonStr = "error";
            		}
        		}
    		
        	}
        	
        	PrintWriter pWriter = response.getWriter();
        	pWriter.write(jsonStr);
            pWriter.flush();
			
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

