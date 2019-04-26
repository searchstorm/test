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
import com.mapper.StuMapper;
import com.po.Stu;
import com.util.SqlSessionFactoryUtil;

@WebServlet("/StuService")
public class StuService extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

    //    String username = request.getParameter("username");
        // String password = request.getParameter("password");
        SqlSession sqlSession = null;
       
        try {
            // User user = (User) session.selectOne("selectUserByName", username);
        	sqlSession = SqlSessionFactoryUtil.openSqlSession();
			StuMapper studentMapper = sqlSession.getMapper(StuMapper.class);
			List<Stu> stu = new ArrayList<Stu>();
			//Stu stu = new Stu();
            stu = studentMapper.getStudents();
            sqlSession.commit();
    
           String jsonStr = JSONObject.toJSONString(stu);
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