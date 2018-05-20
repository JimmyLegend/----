package com.sdut.examsystem.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.service.teacher.QuestionService;
import com.sdut.examsystem.service.teacher.TestService;
@WebServlet("/testDetailInfoServlet")
public class TestDetailInfoServlet extends HttpServlet {
	TestService ts=new TestService();
	QuestionService qs=new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String testId=req.getParameter("id");
		//System.out.println(testId);
		Teacher teacher=(Teacher) req.getSession().getAttribute("user");
		Map<String, Object> test=ts.findTestsById(Integer.parseInt(testId), teacher.getId());
		//System.out.println(test);
		req.setAttribute("test", test);
		req.setAttribute("courseName",test.get("courseName"));
		req.setAttribute("classNames",test.get("classNames"));
		//System.out.println(test.get("questions").toString());
		List<Map<String, Object>> questions=qs.findQuestionByIds(1,test.get("questions").toString());
		List<Map<String, Object>> questionspanduan=qs.findQuestionByIds(2,test.get("questionspanduan").toString());
		List<Map<String, Object>> questionstiankong=qs.findQuestionByIds(3,test.get("questionstiankong").toString());
		List<Map<String, Object>> questionswenda=qs.findQuestionByIds(4,test.get("questionswenda").toString());
		
		req.setAttribute("quesList", questions);
		req.setAttribute("quesPanDuanList", questionspanduan);
		req.setAttribute("quesTianKongList", questionstiankong);
		req.setAttribute("quesWenDaList", questionswenda);
		//System.out.println(questions.get(0));
		req.getRequestDispatcher("/teacher/viewtest.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
