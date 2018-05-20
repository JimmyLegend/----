package com.sdut.examsystem.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.service.admin.CourseService;
import com.sdut.examsystem.service.admin.TeacherCourseService;
import com.sdut.examsystem.vo.TeacherCourseView;
@WebServlet("/scheduleQueryServlet")
public class ScheduleQueryServlet extends HttpServlet {
	TeacherCourseService tcs=new TeacherCourseService();
	CourseService cs=new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		//List<Map<String, Object>> list=tcs.findAllTeacherCourse("");
		List<TeacherCourseView> list=cs.findAll();
		req.setAttribute("tcList", list);
		req.getRequestDispatcher("manager/schedulemanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		String courseSearch=req.getParameter("courseSearch");
		List<TeacherCourseView> list=cs.findTeacherCourseByKey(courseSearch);
		req.setAttribute("tcList", list);
		req.getRequestDispatcher("manager/schedulemanage.jsp").forward(req, resp);
	}

}
