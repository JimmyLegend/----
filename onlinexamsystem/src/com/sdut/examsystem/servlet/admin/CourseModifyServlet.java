package com.sdut.examsystem.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.StuClass;
import com.sdut.examsystem.service.admin.CourseService;
import com.sdut.examsystem.util.Department;
@WebServlet("/courseModifyServlet")
public class CourseModifyServlet extends HttpServlet {
CourseService cs=new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String id=req.getParameter("info");
		int id_int = Integer.valueOf(id).intValue();
		Map<String, Object> stuClassMap=cs.findCourseById(id_int);
		//System.out.println(stuClassMap);
		req.setAttribute("course", stuClassMap);
		req.getRequestDispatcher("/manager/coursemodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		String courname=req.getParameter("courname");
		String id=req.getParameter("id");
		int id_int=Integer.valueOf(id).intValue();
		Course course=new Course();
		course.setId(id_int);
		course.setName(courname);
		cs.updateCourse(course);
		resp.sendRedirect(req.getContextPath()+"/courseQueryServlet");
	}

}
