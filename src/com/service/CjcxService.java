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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mapper.CjpmMapper;
import com.mapper.ScMapper;
import com.mapper.StuMapper;
import com.po.Cjpm;
import com.po.Sc;
import com.po.Stu;
import com.util.SqlSessionFactoryUtil;

@WebServlet("/CjcxService")
public class CjcxService extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        SqlSession sqlSession = null;
       
        try {
        	sqlSession = SqlSessionFactoryUtil.openSqlSession();
        	ScMapper scMapper = sqlSession.getMapper(ScMapper.class);
			CjpmMapper cjpmMapper = sqlSession.getMapper(CjpmMapper.class);
			List<Sc> sc = new ArrayList<Sc>();
			List<Cjpm> cs = new ArrayList<Cjpm>();
			
			//Stu stu = new Stu();
		
		//	List<String> sno = new ArrayList<String>();
			cs = cjpmMapper.getCjpms();
			JSONArray cjcx = new JSONArray(); 
			//System.out.println(sno);
			for(Cjpm c : cs ) {
				JSONObject cj = new JSONObject();
			//	System.out.println(s);
			//	Cjcx c = new Cjcx();
				//stu=stuMapper.getStudent(s);
				cj.put("sno", c.getsno());
				cj.put("sname", c.getsname());
				cj.put("sclass",c.getsclass());
				cj.put("total", c.gettotal());
			    cj.put("rank", c.getrank());
				sc = scMapper.getSc(c.getsno());	
				for(Sc ss : sc) {
					cj.put(ss.getcno().trim(), ss.getgrade());
				}
				
				cjcx.add(cj);
				 
			}
            sqlSession.commit();
          //  JSONObject jsonObject = JSONObject.;
            String jsonStr = JSONObject.toJSONString(cjcx);
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