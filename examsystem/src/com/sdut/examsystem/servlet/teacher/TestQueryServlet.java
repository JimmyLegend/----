package com.sdut.examsystem.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.service.teacher.TestService;
@WebServlet("/testQueryServlet")
public class TestQueryServlet extends HttpServlet {
	TestService ts=new TestService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		Teacher teacher=(Teacher) req.getSession().getAttribute("teacher");
		List<Map<String, Object>> test=ts.findTestsByTeaId(teacher.getId());
		//System.out.println(teacher.getId());
		req.setAttribute("testsList", test);
		req.getRequestDispatcher("/teacher/tmain.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
//		Teacher teacher=(Teacher) req.getSession().getAttribute("user");
//		List<Map<String, Object>> tList=ts.findTestsByTeaId(teacher.getId());
//		req.setAttribute("", tList);
		resp.sendRedirect(req.getContextPath()+"/testQueryServlet");
	}

}
