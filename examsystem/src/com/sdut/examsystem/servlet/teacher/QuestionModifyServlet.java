package com.sdut.examsystem.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.Question;
import com.sdut.examsystem.service.admin.CourseService;
import com.sdut.examsystem.service.teacher.QuestionService;
@WebServlet("/questionModifyServlet")
public class QuestionModifyServlet extends HttpServlet {
	QuestionService qs=new QuestionService();
	CourseService cs=new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String id=req.getParameter("id");
		List<Course> courses=cs.findAllCourses();
		req.setAttribute("courseList", courses);
		Map<String,Object> quest=qs.findQuestionById(Integer.parseInt(id));
		req.setAttribute("questionMap", quest);
		req.getRequestDispatcher("teacher/quesmodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String id=req.getParameter("id");
		String courseId=req.getParameter("courseId");
		String queType=req.getParameter("queType");
		String queTitle=req.getParameter("queTitle");
		String choiceA=req.getParameter("choiceA");
		String choiceB=req.getParameter("choiceB");
		String choiceC=req.getParameter("choiceC");
		String choiceD=req.getParameter("choiceD");
		String ans=req.getParameter("ans");
		Question question=new Question();
		question.setAns(ans);
		question.setChoiceA(choiceA);
		question.setChoiceB(choiceB);
		question.setChoiceC(choiceC);
		question.setChoiceD(choiceD);
		question.setCourseId(Integer.parseInt(courseId));
		question.setId(Integer.parseInt(id));
		question.setQueExist(1);
		question.setQueTitle(queTitle);
		question.setQueType(Integer.parseInt(queType));
		qs.updateQuestionInfo(question);
		resp.sendRedirect(req.getContextPath()+"/questionQueryServlet");
	}

}
