package com.sdut.examsystem.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.Question;
import com.sdut.examsystem.service.admin.CourseService;
import com.sdut.examsystem.service.teacher.QuestionService;

@WebServlet("/QuestionAddPanDunServlet")
public class QuestionAddPanDunServlet extends HttpServlet {
	CourseService cs=new CourseService();
	QuestionService qs=new QuestionService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Course> listCurse=cs.findAllCourses();
		request.setAttribute("courseList", listCurse);
		request.getRequestDispatcher("/teacher/quesaddpanduan.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String queTitle=request.getParameter("paperTitle");
		Question quest=new Question();
		quest.setQueTitle(queTitle);
		System.out.println(quest.getQueTitle());
		//qs.addQuestion(quest);
		response.sendRedirect(request.getContextPath()+"/QuestionPanDuanQueryServlet");
	}

}
