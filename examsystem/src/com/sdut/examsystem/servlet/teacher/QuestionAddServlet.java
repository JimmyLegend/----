package com.sdut.examsystem.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.dao.admin.CourseDao;
import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.Question;
import com.sdut.examsystem.service.admin.CourseService;
import com.sdut.examsystem.service.teacher.QuestionService;
@WebServlet("/questionAddServlet")
public class QuestionAddServlet extends HttpServlet {
	CourseService cs=new CourseService();
	QuestionService qs=new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		List<Course> listCurse=cs.findAllCourses();
		req.setAttribute("courseList", listCurse);
		req.getRequestDispatcher("/teacher/quesadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String courseId=req.getParameter("courseId");
		String queType=req.getParameter("queType");
		String queTitle=req.getParameter("queTitle");
		String choiceA=req.getParameter("choiceA");
		String choiceB=req.getParameter("choiceB");
		String choiceC=req.getParameter("choiceC");
		String choiceD=req.getParameter("choiceD");
		String ans=req.getParameter("ans");
		Question quest=new Question();
		quest.setAns(ans);
		quest.setChoiceA(choiceA);
		quest.setChoiceB(choiceB);
		quest.setChoiceC(choiceC);
		quest.setChoiceD(choiceD);
		quest.setCourseId(Integer.parseInt(courseId));
		quest.setQueTitle(queTitle);
		quest.setQueType(Integer.parseInt(queType));
		//System.out.println(quest.getQueTitle());
		qs.addQuestion(quest);
		resp.sendRedirect(req.getContextPath()+"/questionQueryServlet");
	}

}
