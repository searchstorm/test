package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSONObject;
import com.mapper.StuMapper;
import com.po.Stu;
import com.util.SqlSessionFactoryUtil;

@WebServlet("/StuSelectService")
public class StuSelectService extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String sno = request.getParameter("sno");
    //    System.out.println(sno);
        SqlSession sqlSession = null;
       
        try {
        	sqlSession = SqlSessionFactoryUtil.openSqlSession();
			StuMapper stuMapper = sqlSession.getMapper(StuMapper.class);
			Stu s = new Stu();
            s = stuMapper.getStudent(sno);
            sqlSession.commit();
          //  JSONObject jsonObject = JSONObject.;
            String jsonStr = JSONObject.toJSONString(s);
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