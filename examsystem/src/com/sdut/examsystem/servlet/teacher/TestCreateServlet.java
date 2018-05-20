package com.sdut.examsystem.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.dao.teacher.TestDao;
import com.sdut.examsystem.po.Test;
import com.sdut.examsystem.service.teacher.TestService;
@WebServlet("/testCreateServlet")
public class TestCreateServlet extends HttpServlet {
	TestService td=new TestService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
//		req.getRequestDispatcher("/teacher/viewtest.jsp").forward(req, resp);
		Test test=new Test();
		test=(Test) req.getSession().getAttribute("test");
		td.createTest(test);
		req.getSession().removeAttribute("test");
		resp.sendRedirect(req.getContextPath()+"/testQueryServlet");
	}

}
