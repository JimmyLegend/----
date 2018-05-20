package com.sdut.examsystem.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.po.TeacherCourse;
import com.sdut.examsystem.service.admin.CourseService;
import com.sdut.examsystem.service.admin.StuClassService;
import com.sdut.examsystem.service.admin.TeacherService;
@WebServlet("/scheduleAddServlet")
public class ScheduleAddServlet extends HttpServlet {
    CourseService cs=new CourseService();
    TeacherService ts=new TeacherService();
    StuClassService scs=new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.setCharacterEncoding("utf-8");
		List<Course> cslist=cs.findAllCourses();
		req.setAttribute("courseList", cslist);
		List<Teacher> tslist=ts.findAll("");
		req.setAttribute("teaList", tslist);
		List<Map<String, Object>> scslist=scs.findAll();
		req.setAttribute("stuclList", scslist);
		req.getRequestDispatcher("/manager/scheduleadd.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		String course=req.getParameter("course");
		String teacher=req.getParameter("teacher");
		String stuclass=req.getParameter("stuclass");
		TeacherCourse tCourse=new TeacherCourse();
		tCourse.setClassId(Integer.parseInt(stuclass));
		tCourse.setCourseId(Integer.parseInt(course));
		tCourse.setTeaId(Integer.parseInt(teacher));
		CourseService cService=new CourseService();
		cService.addSchedule(tCourse);
//		String teacher=req.getParameter("teacher");
//		String stuclass=req.getParameter("stuclass");
		resp.sendRedirect(req.getContextPath()+"/scheduleQueryServlet");
	}

}
