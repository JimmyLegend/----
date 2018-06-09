package com.sdut.examsystem.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.sdut.examsystem.po.Student;
import com.sdut.examsystem.service.teacher.TestService;
import com.sdut.examsystem.util.ToolUtil;
@WebServlet("/recentTestServlet")
public class RecentTestServlet extends HttpServlet {
	TestService ts=new TestService();
	ToolUtil tool=new ToolUtil();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		Student student=(Student) req.getSession().getAttribute("student");
		String currData=tool.getCurrentTime();
     	List<Map<String, Object>> testList=ts.getTestByStudent(student.getId(), currData);
     	req.setAttribute("testList", testList);
     	//System.out.println(student.getId());
		req.getRequestDispatcher("/student/main.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		//resp.sendRedirect(arg0);
	}

}
