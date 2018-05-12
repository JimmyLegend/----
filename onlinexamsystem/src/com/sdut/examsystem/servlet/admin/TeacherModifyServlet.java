package com.sdut.examsystem.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.StuClass;
import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.service.admin.TeacherService;
import com.sdut.examsystem.util.Department;
@WebServlet("/teacherModifyServlet")
public class TeacherModifyServlet extends HttpServlet {
	TeacherService ts=new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String id=req.getParameter("id");
//		System.out.println(id);
		int id_int = Integer.valueOf(id).intValue();
		Map<String, Object> teacherMap=ts.findTeacherInfo(id_int);
		req.setAttribute("deptList",Department.values());
		req.setAttribute("teacherInfo", teacherMap);
		req.getRequestDispatcher("/manager/teachermodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		String num=req.getParameter("num");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String dep=req.getParameter("dep");
		int num_int=Integer.valueOf(num).intValue();
		Teacher teacher=new Teacher();
		teacher.setId(num_int);
		teacher.setName(username);
		teacher.setPassword(password);
		teacher.setDeptName(dep);
		ts.updateTeacher(teacher,num_int);
		resp.sendRedirect(req.getContextPath()+"/teacherQueryServlet");
	}

}
