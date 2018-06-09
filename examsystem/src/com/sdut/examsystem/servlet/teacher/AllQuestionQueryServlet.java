package com.sdut.examsystem.servlet.teacher;

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

@WebServlet("/AllQuestionQueryServlet")
public class AllQuestionQueryServlet extends HttpServlet {
	QuestionService qs=new QuestionService();
	CourseService cs=new CourseService();
	StuClassService ss=new StuClassService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher teacher=(Teacher) request.getSession().getAttribute("teacher");
		List<Course> clist=cs.findAllCoursesByTeacherId(teacher.getId());
		//System.out.println(teacher.getId());
		request.setAttribute("courseList", clist);
		List<Map<String, Object> > sclist=ss.findAllStuClassByTeacherId(teacher.getId());
		request.setAttribute("classesList", sclist);
		List<Map<String, Object>> xuanzelist=qs.findAll("","");
		request.setAttribute("xuanzelist", xuanzelist);
		List<Map<String, Object>> panduanlist=qs.findAllPanDuan("","");
		request.setAttribute("panduanlist", panduanlist);
		List<Map<String, Object>> tiankonglist=qs.findAllTianKong("","");
		request.setAttribute("tiankonglist", tiankonglist);
		List<Map<String, Object>> wendalist=qs.findAllWenDa("","");
		request.setAttribute("wendalist", wendalist);
		request.getRequestDispatcher("/teacher/allquestionmanage.jsp").forward(request, response);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stubs
		/*String[] str=req.getParameterValues("xuanzeid");
		for(int i=0; i<str.length;i++)
		{
			System.out.println(str[i]);
		}
		String[] str1=req.getParameterValues("panduanid");
		for(int i=0; i<str1.length;i++)
		{
			System.out.println(str1[i]);
		}*/
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
		t.setXuanXeNum(Integer.parseInt(sinnum));
		t.setPanDuanNum(Integer.parseInt(panduannum));
		t.setTianKongNum(Integer.parseInt(tiankongnum));
		t.setWenDaNum(Integer.parseInt(wendanum));
		t.setTestType(2);
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
		//System.out.println(courseid);
		String[] xuanzeid=req.getParameterValues("xuanzeid");
		StringBuffer xuanzes=new StringBuffer();
		for(int i=0;i<xuanzeid.length;i++)
		{
			//System.out.println("xuanze:"+xuanzeid[i]);
			if(i<xuanzeid.length-1)
			{
				xuanzes.append(xuanzeid[i]+",");
			}
			else
			{
				xuanzes.append(xuanzeid[i]);
			}
		}
		String questions=xuanzes.toString();
		
		String[] panduanid=req.getParameterValues("panduanid");
		StringBuffer panduans=new StringBuffer();
		for(int i=0;i<panduanid.length;i++)
		{
			//System.out.println("panduan:"+panduanid[i]);
			if(i<panduanid.length-1)
			{
				panduans.append(panduanid[i]+",");
			}
			else
			{
				panduans.append(panduanid[i]);
			}
		}
		String panduanquetions=panduans.toString();
		
		String[] tiankongId=req.getParameterValues("tiankongid");
		StringBuffer tiankongs=new StringBuffer();
		for(int i=0;i<tiankongId.length;i++)
		{
			//System.out.println("tiankong:"+tiankongId[i]);
			if(i<tiankongId.length-1)
			{
				tiankongs.append(tiankongId[i]+",");
			}
			else
			{
				tiankongs.append(tiankongId[i]);
			}
		}
		String tiankongquetions=tiankongs.toString();
		
		String[] wendaId=req.getParameterValues("wendaid");
		StringBuffer wendas=new StringBuffer();
		for(int i=0;i<wendaId.length;i++)
		{
			//System.out.println("wenda:"+wendaId[i]);
			if(i<wendaId.length-1)
			{
				wendas.append(wendaId[i]+",");
			}
			else
			{
				wendas.append(wendaId[i]);
			}
		}
		String wendaquetions=wendas.toString();
		
		t.setQuetions(questions);
		t.setPanDuanQuetions(panduanquetions);
		t.setTianKongQuetions(tiankongquetions);
		t.setWenDaQuetions(wendaquetions);
		
		//System.out.println(questions);
		//System.out.println(panduanquetions);
		//System.out.println(tiankongquetions);
		//System.out.println(wendaquetions);
		
		List<Map<String, Object>> questionslist=qs.findQuestionByIds(1,questions);
		List<Map<String, Object>> questionspanduanlist=qs.findQuestionByIds(2,panduanquetions);
		List<Map<String, Object>> questionstiankonglist=qs.findQuestionByIds(3,tiankongquetions);
		List<Map<String, Object>> questionswendalist=qs.findQuestionByIds(4,wendaquetions);
		
		req.setAttribute("quesList", questionslist);
		req.setAttribute("qPanDuanList", questionspanduanlist);
		req.setAttribute("qTianKongList", questionstiankonglist);
		req.setAttribute("qWenDaList", questionswendalist);
		
		req.getSession().setAttribute("course", course);
		req.getSession().setAttribute("test", t);
		req.setAttribute("test", t);
		req.setAttribute("classNames", className);
		req.getRequestDispatcher("/teacher/test.jsp").forward(req, resp);
	}

}
