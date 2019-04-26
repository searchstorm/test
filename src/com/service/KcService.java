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
import com.mapper.KcMapper;
import com.po.Kc;
import com.util.SqlSessionFactoryUtil;

@WebServlet("/KcService")
public class KcService extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        SqlSession sqlSession = null;
       
        try {
        	sqlSession = SqlSessionFactoryUtil.openSqlSession();
			KcMapper kcMapper = sqlSession.getMapper(KcMapper.class);
			List<Kc> k = new ArrayList<Kc>();
            k = kcMapper.getKcs();
            sqlSession.commit();
          //  JSONObject jsonObject = JSONObject.;
            String jsonStr = JSONObject.toJSONString(k);
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