package com.sdut.examsystem.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.service.teacher.QuestionService;
@WebServlet("/questionQueryServlet")
public class QuestionQueryServlet extends HttpServlet {
	QuestionService qs=new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		List<Map<String, Object>> list=qs.findAll("","");
		req.setAttribute("queList", list);
		req.getRequestDispatcher("/teacher/questionmanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String selectk=req.getParameter("selectk");
		String quesname=req.getParameter("quesname");
		//System.out.println(selectk+quesname);
		List<Map<String, Object>> list=qs.findAll(selectk,quesname);
		req.setAttribute("queList", list);
		req.getRequestDispatcher("/teacher/questionmanage.jsp").forward(req, resp);
	}

}
