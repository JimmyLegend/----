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
import com.sdut.examsystem.service.admin.StudentService;
@WebServlet("/studentQueryServlet")
public class StudentQueryServlet extends HttpServlet {
	StudentService ss=new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		List<Map<String, Object>> list=ss.findAll();
		req.setAttribute("studentList", list);
		req.getRequestDispatcher("/manager/studentmanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		List<Map<String, Object>> list=ss.findAllStudentByName(name);
		req.setAttribute("studentList", list);
		//req.setAttribute("courseSearch", courseSearch);
		req.getRequestDispatcher("/manager/studentmanage.jsp").forward(req, resp);
	}

}
