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

@WebServlet("/QuestionTianKongModifyServlet")
public class QuestionTianKongModifyServlet extends HttpServlet {
	QuestionService qs=new QuestionService();
	CourseService cs=new CourseService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String panduanid=request.getParameter("id");
		List<Course> courses=cs.findAllCourses();
		request.setAttribute("courseList", courses);
		Map<String,Object> quest=qs.findQuestionTianKongById(Integer.parseInt(panduanid));
		request.setAttribute("questionMap", quest);
		request.getRequestDispatcher("/teacher/questiankongmodify.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String courseId=request.getParameter("courseId");
		String queType=request.getParameter("queType");
		String queTitle=request.getParameter("queTitle");
		String ans=request.getParameter("ans");
		Question questiontiankong=new Question();
		questiontiankong.setAns(ans);
		questiontiankong.setCourseId(Integer.parseInt(courseId));
		questiontiankong.setId(Integer.parseInt(id));
		questiontiankong.setQueExist(1);
		questiontiankong.setQueTitle(queTitle);
		questiontiankong.setQueType(Integer.parseInt(queType));
		qs.updateQuestionTianKongInfo(questiontiankong);
		response.sendRedirect(request.getContextPath()+"/QuestionTianKongQueryServlet");
	}

}
