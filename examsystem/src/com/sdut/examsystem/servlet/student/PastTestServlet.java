package com.sdut.examsystem.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sdut.examsystem.po.Student;
import com.sdut.examsystem.service.admin.StudentService;
import com.sdut.examsystem.service.teacher.PaperService;
import com.sdut.examsystem.service.teacher.QuestionService;
import com.sun.swing.internal.plaf.metal.resources.metal_zh_TW;
@WebServlet("/pastTestServlet")
public class PastTestServlet extends HttpServlet {
	StudentService ss=new StudentService();
	PaperService ps=new PaperService();
	QuestionService qs=new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		//String method=(String) req.getAttribute("method");
		//System.out.println(method);
//		Student student=(Student) req.getSession().getAttribute("user");
//		Map<String, Object> stud=ss.findStudentById(student.getId());
//		req.setAttribute("user", stud);
		Student student=(Student) req.getSession().getAttribute("student");
		List list=ps.getPaperByStudentId(student.getId());
		req.setAttribute("paperList", list);
		req.getRequestDispatcher("/student/history.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		//String selectk=req.getParameter("selectk");
		Student student=(Student) req.getSession().getAttribute("student");
		String paperSearch=req.getParameter("paperSearch");
		System.out.println(paperSearch);
		//System.out.println(selectk+quesname);
		List<Map<String, Object>> list=ps.getPaperByKey(student.getId(), paperSearch);
		req.setAttribute("paperList", list);
		req.getRequestDispatcher("/student/history.jsp").forward(req, resp);
	}

}
