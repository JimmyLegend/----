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
@WebServlet("/QuestionAddWenDaServlet")
public class QuestionAddWenDaServlet extends HttpServlet {
	CourseService cs=new CourseService();
	QuestionService qs=new QuestionService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Course> listCurse=cs.findAllCourses();
		request.setAttribute("courseList", listCurse);
		request.getRequestDispatcher("/teacher/quesaddwenda.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String courseId=request.getParameter("courseId");
		String queType=request.getParameter("queType");
		String queTitle=request.getParameter("queTitle");
		String ans=request.getParameter("ans");
		Question quest=new Question();
		quest.setAns(ans);
		quest.setCourseId(Integer.parseInt(courseId));
		quest.setQueTitle(queTitle);
		quest.setQueType(Integer.parseInt(queType));
		//System.out.println("123:"+queType+queTitle);
		qs.addQuestion(quest);
		response.sendRedirect(request.getContextPath()+"/QuestionWenDaQueryServlet");
	}

}
