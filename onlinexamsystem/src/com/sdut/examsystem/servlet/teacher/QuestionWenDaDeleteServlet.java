package com.sdut.examsystem.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.service.teacher.QuestionService;

@WebServlet("/QuestionWenDaDeleteServlet")
public class QuestionWenDaDeleteServlet extends HttpServlet {
	QuestionService question=new QuestionService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		question.deleteQuestionWenDa(Integer.parseInt(id));
		response.sendRedirect(request.getContextPath()+"/QuestionWenDaQueryServlet");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
