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
import com.sdut.examsystem.po.QuestionPanDuan;
import com.sdut.examsystem.service.admin.CourseService;
import com.sdut.examsystem.service.teacher.QuestionService;

@WebServlet("/QuestionPanDuanModifyServlet")
public class QuestionPanDuanModifyServlet extends HttpServlet {
	QuestionService qs=new QuestionService();
	CourseService cs=new CourseService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String panduanid=request.getParameter("id");
		List<Course> courses=cs.findAllCourses();
		request.setAttribute("courseList", courses);
		Map<String,Object> quest=qs.findQuestionPanDuanById(Integer.parseInt(panduanid));
		request.setAttribute("questionMap", quest);
		request.getRequestDispatcher("/teacher/quespanduanmodify.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String courseId=request.getParameter("courseId");
		String queType=request.getParameter("queType");
		String queTitle=request.getParameter("queTitle");
		String ans=request.getParameter("ans");
		QuestionPanDuan questionpanduan=new QuestionPanDuan();
		questionpanduan.setAns(ans);
		questionpanduan.setCourseId(Integer.parseInt(courseId));
		questionpanduan.setId(Integer.parseInt(id));
		questionpanduan.setQueExist(1);
		questionpanduan.setQueTitle(queTitle);
		questionpanduan.setQueType(Integer.parseInt(queType));
		qs.updateQuestionPanDuanInfo(questionpanduan);
		response.sendRedirect(request.getContextPath()+"/QuestionPanDuanQueryServlet");
	}

}
