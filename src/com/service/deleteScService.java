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
import com.mapper.ScMapper;
import com.po.Sc;
import com.util.SqlSessionFactoryUtil;

@WebServlet("/deleteScService")
public class deleteScService extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sno = request.getParameter("sno");
       // String grade = request.getParameter("gradegrade");
        //int g = Integer.parseInt(grade);
        String cno = request.getParameter("cno");
        System.out.println(sno);
        System.out.println(cno);
     //   System.out.println(g);
        SqlSession sqlSession = null;
       
        try {
        	sqlSession = SqlSessionFactoryUtil.openSqlSession();
        	CjpmMapper cjpmMapper = sqlSession.getMapper(CjpmMapper.class);
        	ScMapper scMapper = sqlSession.getMapper(ScMapper.class);
        //	StuMapper stuMapper = sqlSession.getMapper(StuMapper.class);
        //	List<String> cnos = new ArrayList<String>();
        //	List<String> snos = new ArrayList<String>();
        	Sc s = new Sc();
        	s.setcno(cno);
        	s.setgrade(0);
        	s.setsno(sno);
        	String  jsonStr = "";
        	try {	
    			scMapper.deleteSc(s);
    			sqlSession.commit();
    			cjpmMapper.updateCjpmtotal(sno);
    			jsonStr = "success";
        		
        	}catch (Exception e) {
        		jsonStr = "error";
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
