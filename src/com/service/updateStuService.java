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

import com.mapper.CjpmMapper;
import com.mapper.StuMapper;
import com.po.Cjpm;
import com.po.Stu;
import com.util.SqlSessionFactoryUtil;

@WebServlet("/updateStuService")
public class updateStuService extends HttpServlet{
	
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
        	CjpmMapper cjpmMapper = sqlSession.getMapper(CjpmMapper.class);
        	List<String> snos = new ArrayList<String>();
        	String  jsonStr = "";
        	if(sno == null || sname == null || sclass == null || sex == null || sage == null) {
        		jsonStr = "error";
        	}
        	else {    	
        		Cjpm cj = new Cjpm();
    			Stu s = new Stu();
        		s.setsno(sno);
        		s.setsname(sname);
        		s.setsex(sex);
        		s.setsclass(sclass);
        		s.setsage(age);
        		
        		cj.setsno(sno);
        		cj.setsname(sname);
        		cj.setsclass(sclass);
        		cj.setrank(0);
        		cj.settotal(0);
        		
        		try {
        		stuMapper.updateStudent(s);
        		sqlSession.commit();
        		cjpmMapper.updateCjpm(cj);
        		jsonStr = "success";
        		}
        		catch (Exception e){
        			jsonStr = "error";
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

