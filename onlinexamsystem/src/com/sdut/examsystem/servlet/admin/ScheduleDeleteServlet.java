
package com.sdut.examsystem.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.service.admin.CourseService;
@WebServlet("/scheduleDeleteServlet")
public class ScheduleDeleteServlet extends HttpServlet {
	CourseService cs=new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String id=req.getParameter("info");
		cs.deleteTeacherCourse(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath()+"/scheduleQueryServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
