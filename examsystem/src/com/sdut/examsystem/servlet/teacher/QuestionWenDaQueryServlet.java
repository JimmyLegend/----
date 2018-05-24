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

@WebServlet("/QuestionWenDaQueryServlet")
public class QuestionWenDaQueryServlet extends HttpServlet {
	QuestionService qs=new QuestionService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list=qs.findAllWenDa("","");
		request.setAttribute("queList", list);
		request.getRequestDispatcher("/teacher/questionwendamanage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String selectk=request.getParameter("selectk");
		String quesname=request.getParameter("quesname");
		//System.out.println(selectk+quesname);
		List<Map<String, Object>> list=qs.findAllWenDa(selectk,quesname);
		request.setAttribute("queList", list);
		request.getRequestDispatcher("/teacher/questionwendamanage.jsp").forward(request, response);
	}

}
