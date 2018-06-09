package com.sdut.examsystem.servlet.teacher;

import java.awt.Checkbox;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.po.Test;
import com.sdut.examsystem.service.admin.CourseService;
import com.sdut.examsystem.service.admin.StuClassService;
import com.sdut.examsystem.service.teacher.QuestionService;
import com.sdut.examsystem.util.ToolUtil;
@WebServlet("/testAddServlet")
public class TestAddServlet extends HttpServlet {
	CourseService cs=new CourseService();
	StuClassService ss=new StuClassService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		Teacher teacher=(Teacher) req.getSession().getAttribute("teacher");
		List<Course> clist=cs.findAllCoursesByTeacherId(teacher.getId());
		//System.out.println(teacher.getId());
		req.setAttribute("courseList", clist);
		List<Map<String, Object> > sclist=ss.findAllStuClassByTeacherId(teacher.getId());
		req.setAttribute("classesList", sclist);
		req.getRequestDispatcher("/teacher/testadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		Teacher loginTeacher=(Teacher) req.getSession().getAttribute("teacher");
		String testtime=req.getParameter("testtime");
		String[] classCheck=req.getParameterValues("classCheck");
		String enddate=req.getParameter("enddate");
		String courseid=req.getParameter("courseid");
		String testname=req.getParameter("testname");
		//选择
		String sinscores=req.getParameter("sinscores");
		String sinnum=req.getParameter("sinnum");
		//判断
		String panduanscores=req.getParameter("panduanscores");
		String panduannum=req.getParameter("panduannum");
		System.out.println("判断："+panduanscores+" "+panduannum);
		//填空
		String tiankongscores=req.getParameter("tiankongscores");
		String tiankongnum=req.getParameter("tiankongnum");
		System.out.println("填空："+tiankongscores+" "+tiankongnum);
		//问答
		String wendascores=req.getParameter("wendascores");
		String wendanum=req.getParameter("wendanum");
		System.out.println("填空："+wendascores+" "+wendanum);
		
		Map<String, Object> course=cs.findCourseById(Integer.parseInt(courseid));
		String className=ss.findClassNamesByIds(classCheck);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		try {
			date = formatter.parse(enddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Test t = new Test();
		t.setTestType(1);
		t.setName(testname);
		t.setCourseId(Integer.parseInt(course.get("id").toString()));
//		System.out.println(course.get("id").toString());
		t.setEndDate(date);
		//选择分数
		t.setScores(sinscores);
		//判断分数
		t.setPanDuanScores(panduanscores);
		//填空分数
		t.setTianKongScores(tiankongscores);
		//问答分数
		t.setWenDaScores(wendascores);
		//总分
		Integer totalScores=Integer.parseInt(sinscores)+Integer.parseInt(panduanscores)+Integer.parseInt(tiankongscores)+Integer.parseInt(wendascores);
		t.setTotalScores(totalScores.toString());
		t.setTeacherId(loginTeacher.getId());
		t.setTestTime(Integer.parseInt(testtime));
		t.setClassIds(ToolUtil.arraytoString(classCheck));
		QuestionService qs=new QuestionService();
		List<Map<String, Object>> qList=qs.collectQuestions(1,Integer.parseInt(courseid), Integer.parseInt(sinnum));
		List<Map<String, Object>> qPanDuanList=qs.collectQuestions(2,Integer.parseInt(courseid), Integer.parseInt(panduannum));
		List<Map<String, Object>> qTianKongList=qs.collectQuestions(3,Integer.parseInt(courseid), Integer.parseInt(tiankongnum));
		List<Map<String, Object>> qWenDaList=qs.collectQuestions(4,Integer.parseInt(courseid), Integer.parseInt(wendanum));
		//System.out.println(courseid);
		String questions=qs.testQuestionIds(qList);
		String panduanquetions=qs.testQuestionIds(qPanDuanList);
		String tiankongquetions=qs.testQuestionIds(qTianKongList);
		String wendaquetions=qs.testQuestionIds(qWenDaList);
		
		t.setQuetions(questions);
		t.setPanDuanQuetions(panduanquetions);
		t.setTianKongQuetions(tiankongquetions);
		t.setWenDaQuetions(wendaquetions);
		
		req.setAttribute("quesList", qList);
		req.setAttribute("qPanDuanList", qPanDuanList);
		req.setAttribute("qTianKongList", qTianKongList);
		req.setAttribute("qWenDaList", qWenDaList);
		
		req.getSession().setAttribute("course", course);
		req.getSession().setAttribute("test", t);
		req.setAttribute("test", t);
		req.setAttribute("classNames", className);
		req.getRequestDispatcher("/teacher/test.jsp").forward(req, resp);
	}
}
