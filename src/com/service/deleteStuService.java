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
import com.mapper.ScMapper;
import com.mapper.StuMapper;
import com.mapper.UserMapper;
import com.util.SqlSessionFactoryUtil;

@WebServlet("/deleteStuService")
public class deleteStuService extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sno = request.getParameter("sno");
        System.out.println(sno);
 
        SqlSession sqlSession = null;
       
        try {
        	sqlSession = SqlSessionFactoryUtil.openSqlSession();
        	StuMapper stuMapper = sqlSession.getMapper(StuMapper.class);
        	ScMapper scMapper = sqlSession.getMapper(ScMapper.class);
        	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        	CjpmMapper cjpmMapper = sqlSession.getMapper(CjpmMapper.class);
       // 	List<String> cnos = new ArrayList<String>();
        	List<String> snos = new ArrayList<String>();
        	String  jsonStr = "";
        	if(sno == null ) {
        		jsonStr = "error";
        	}
        	else { 
        		
        		try {
        		scMapper.deleteScs(sno);
        		stuMapper.deleteStudent(sno);
        		userMapper.deleteUser(sno);
        		sqlSession.commit();
        		cjpmMapper.deleteCjpm(sno);
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
