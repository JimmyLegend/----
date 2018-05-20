package com.sdut.examsystem.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.StuClass;
import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.service.admin.TeacherService;
import com.sdut.examsystem.util.Department;
@WebServlet("/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet {
	TeacherService tc=new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.setAttribute("deptList",Department.values());
		req.getRequestDispatcher("/manager/teacheradd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		String username=req.getParameter("username");
		String num=req.getParameter("num");
		String password=req.getParameter("password");
		String dep=req.getParameter("dep");
		int num_int=Integer.valueOf(num).intValue();
		Teacher teacher=new Teacher();
		teacher.setId(num_int);
		teacher.setName(username);
		teacher.setDeptName(dep);
		teacher.setPassword(password);
		tc.addTeacher(teacher);
		resp.sendRedirect(req.getContextPath()+"/teacherQueryServlet");
	}

}
