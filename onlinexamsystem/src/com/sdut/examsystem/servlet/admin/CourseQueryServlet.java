package com.sdut.examsystem.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.service.admin.CourseService;
@WebServlet("/courseQueryServlet")
public class CourseQueryServlet extends HttpServlet {
	CourseService cqs = new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String courseSearch = req.getParameter("courseSearch");
		List<Course> tcList = cqs.findAllCourses();
		req.setAttribute("tcList", tcList);
		//req.setAttribute("courseSearch", courseSearch);
		req.getRequestDispatcher("/manager/coursemanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("post");
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("courseSearch");
		List<Course> tcList = cqs.findAllCourses(name);
		req.setAttribute("tcList", tcList);
		//req.setAttribute("courseSearch", courseSearch);
		req.getRequestDispatcher("/manager/coursemanage.jsp").forward(req, resp);
	}
}
