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
import com.sun.xml.internal.ws.util.xml.CDATA;
@WebServlet("/scheduleModifyServlet")
public class ScheduleModifyServlet extends HttpServlet {
	CourseService cs=new CourseService();
	TeacherService tc=new TeacherService();
	StuClassService scs=new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.setCharacterEncoding("utf-8");
		String info=req.getParameter("info");
		req.setAttribute("teaId", Integer.parseInt(info));
		Map<String, Object> list=cs.findTeacherCourseById(Integer.parseInt(info));
		req.setAttribute("tc", list);
		List<Course> course=cs.findAllCourses();
		req.setAttribute("courList", course);
		List<Teacher> teacher=tc.findAll("");
		req.setAttribute("teaList", teacher);
		List<Map<String, Object>> stuclass=scs.findAll();
		req.setAttribute("stuclList", stuclass);
		req.getRequestDispatcher("/manager/schedulemodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		String course=req.getParameter("course");
		String teacher=req.getParameter("teacher");
		String stuclass=req.getParameter("stuclass");
		String teaCourId=req.getParameter("teaCourId");
//		System.out.println(teaCourId);
//		System.out.println("123");
		TeacherCourse teacherCourse=new TeacherCourse();
		teacherCourse.setClassId(Integer.parseInt(stuclass));
		teacherCourse.setCourseId(Integer.parseInt(course));
		teacherCourse.setTeaId(Integer.parseInt(teacher));
		teacherCourse.setId(Integer.parseInt(teaCourId));
		cs.modifyTeacherCourse(teacherCourse);
		resp.sendRedirect(req.getContextPath()+"/scheduleQueryServlet");
		
	}
	
}
