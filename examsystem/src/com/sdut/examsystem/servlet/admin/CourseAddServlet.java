package com.sdut.examsystem.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.StuClass;
import com.sdut.examsystem.service.admin.CourseService;
@WebServlet("/courseAddServlet")
public class CourseAddServlet extends HttpServlet {
	CourseService cs=new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.getRequestDispatcher("/manager/courseadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		String courname=req.getParameter("courname");
		//Course course=new Course();
		//course.setName(courname);
		cs.addCourse(courname);
		resp.sendRedirect(req.getContextPath()+"/courseQueryServlet");
		
	}

}
