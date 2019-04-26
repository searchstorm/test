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
import com.mapper.KcMapper;
import com.mapper.ScMapper;
import com.mapper.StuMapper;
import com.po.Sc;
import com.po.Stu;
import com.util.SqlSessionFactoryUtil;
@WebServlet("/insertScService")
public class insertScService extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sno = request.getParameter("sno");
        String grade = request.getParameter("grade");
        int g = Integer.valueOf(grade);
        String cno = request.getParameter("cno");
        System.out.println(sno);
        System.out.println(cno);
        System.out.println(g);
        SqlSession sqlSession = null;
       
        try {
        	sqlSession = SqlSessionFactoryUtil.openSqlSession();
        	KcMapper kcMapper = sqlSession.getMapper(KcMapper.class);
        	ScMapper scMapper = sqlSession.getMapper(ScMapper.class);
        	StuMapper stuMapper = sqlSession.getMapper(StuMapper.class);
        	CjpmMapper cjpmMapper = sqlSession.getMapper(CjpmMapper.class);
        	List<String> cnos = new ArrayList<String>();
        	List<String> snos = new ArrayList<String>();
        	String  jsonStr = "";
        	if(sno == null || cno == null || grade == null) {
        		jsonStr = "error1";
        	}
        	else {
        		snos = stuMapper.getSnos();
            	cnos = kcMapper.getCnos();
            	int flag = 0 ;
            	int flag1 = 0;
           // 	int flag2 = 0;
            	for (String s : snos) {
            		if(s.trim().equals(sno)) {flag= 1 ;}
            		System.out.printf(s.trim()+" ");
            	}
            	for (String c : cnos) {
            		if(c.trim().equals(cno)) {flag1= 1 ;}
            	}
            	System.out.println(flag);
            //	System.out.println(flag2);
            	if(flag ==0 || flag1 == 0) {
            		jsonStr = "error";
            		System.out.println("dsdssd");
            	}
            	else {
            		int sum = 0 ;
        		//	Cjpm cj = new Cjpm
        			Sc sc = new Sc();
            		sc.setsno(sno);
            		sc.setcno(cno.trim());
            		sc.setgrade(g);
            		try {
            			
            		scMapper.insertSc(sc);
            		sqlSession.commit();
            		cjpmMapper.updateCjpmtotal(sno);
       //     		scMapper.insertSc(sc);
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
