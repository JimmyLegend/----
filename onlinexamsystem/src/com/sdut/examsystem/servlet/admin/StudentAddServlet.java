package com.sdut.examsystem.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Student;
import com.sdut.examsystem.service.admin.StuClassService;
import com.sdut.examsystem.service.admin.StudentService;
import com.sdut.examsystem.util.Department;
@WebServlet("/studentAddServlet")
public class StudentAddServlet extends HttpServlet {
	StudentService ss=new StudentService();
	StuClassService scs=new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.setAttribute("deptList",Department.values());
		List<Map<String, Object>> list=scs.findAll();
		req.setAttribute("classList",list);
		req.getRequestDispatcher("/manager/studentadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String sex=req.getParameter("sex");
		String born=req.getParameter("born");
		String school=req.getParameter("school");
		String deptName=req.getParameter("deptName");
		String classId=req.getParameter("classId");
		Student stud=new Student();
		stud.setId(Integer.parseInt(id));
		stud.setClassId(Integer.parseInt(classId));
		stud.setBorn(born);
		stud.setDeptName(deptName);
		stud.setName(name);
		stud.setPwd(pwd);
		stud.setSchool(school);
		stud.setSex(sex);
		//System.out.println(stud.getBorn());
		ss.addStudent(stud);
		resp.sendRedirect(req.getContextPath()+"/studentQueryServlet");
	}

}
