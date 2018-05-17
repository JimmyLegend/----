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

@WebServlet("/QuestionWenDaModifyServlet")
public class QuestionWenDaModifyServlet extends HttpServlet {
	QuestionService qs=new QuestionService();
	CourseService cs=new CourseService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String wendaid=request.getParameter("id");
		List<Course> courses=cs.findAllCourses();
		request.setAttribute("courseList", courses);
		Map<String,Object> quest=qs.findQuestionWenDaById(Integer.parseInt(wendaid));
		request.setAttribute("questionMap", quest);
		request.getRequestDispatcher("/teacher/queswendamodify.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String wendaid=request.getParameter("id");
		String courseId=request.getParameter("courseId");
		String queType=request.getParameter("queType");
		String queTitle=request.getParameter("queTitle");
		String ans=request.getParameter("ans");
		Question quest=new Question();
		//System.out.println(wendaid);
		quest.setId(Integer.parseInt(wendaid));
		quest.setAns(ans);
		quest.setCourseId(Integer.parseInt(courseId));
		quest.setQueTitle(queTitle);
		quest.setQueType(Integer.parseInt(queType));
		//System.out.println("123:"+queType+queTitle);
		qs.updateQuestionWenDaInfo(quest);
		response.sendRedirect(request.getContextPath()+"/QuestionWenDaQueryServlet");
	}

}
