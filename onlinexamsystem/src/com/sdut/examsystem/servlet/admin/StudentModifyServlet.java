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
import com.sdut.examsystem.po.StuClass;
import com.sdut.examsystem.po.Student;
import com.sdut.examsystem.service.admin.StuClassService;
import com.sdut.examsystem.service.admin.StudentService;
import com.sdut.examsystem.util.Department;
@WebServlet("/studentModifyServlet")
public class StudentModifyServlet extends HttpServlet {
	StudentService ss=new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String id=req.getParameter("id");
		//System.out.println(id);
		int id_int = Integer.valueOf(id).intValue();
		Map<String, Object> student=(Map<String, Object>) ss.findStudentById(id_int);
		req.setAttribute("deptList",Department.values());
		req.setAttribute("student", student);
		StuClassService scs=new StuClassService();
		List<Map<String, Object>> list=scs.findAll();
		req.setAttribute("classList",list);
		req.getRequestDispatcher("/manager/studentmodify.jsp").forward(req, resp);
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
		String deptId=req.getParameter("deptId");
		String classId=req.getParameter("classId");
		//System.out.println(classId);
		Student stud=new Student();
		stud.setId(Integer.parseInt(id));
		stud.setBorn(born);
		stud.setClassId(Integer.parseInt(classId));
		stud.setDeptName(deptId);
		stud.setName(name);
		stud.setPwd(pwd);
		stud.setSchool(school);
		stud.setSex(sex);
		ss.updateStudent(stud);
		resp.sendRedirect(req.getContextPath()+"/studentQueryServlet");
	}

}
