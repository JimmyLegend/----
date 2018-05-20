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
import com.sdut.examsystem.service.admin.TeacherService;
@WebServlet("/teacherQueryServlet")
public class TeacherQueryServlet extends HttpServlet {
	TeacherService ts=new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		//String claname=req.getParameter("claname");
		//System.out.println(name);
		//System.out.println(claname);
		List<Teacher> list=ts.findAll("");
		req.setAttribute("teacherList", list);
		req.getRequestDispatcher("/manager/teachermanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		List<Teacher> list = ts.findAll(name);
		req.setAttribute("teacherList", list);
		//req.setAttribute("courseSearch", courseSearch);
		req.getRequestDispatcher("/manager/teachermanage.jsp").forward(req, resp);
	}

}
