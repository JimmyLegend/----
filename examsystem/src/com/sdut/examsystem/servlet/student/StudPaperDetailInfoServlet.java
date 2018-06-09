package com.sdut.examsystem.servlet.student;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Student;
import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.service.teacher.PaperService;
import com.sdut.examsystem.service.teacher.QuestionService;
import com.sdut.examsystem.service.teacher.TestService;

@WebServlet("/StudPaperDetailInfoServlet")
public class StudPaperDetailInfoServlet extends HttpServlet {
	TestService ts=new TestService();
	QuestionService qs=new QuestionService();
	PaperService pService=new PaperService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student student=(Student) request.getSession().getAttribute("student");
		String studName=student.getName();
		request.setAttribute("studName", studName);
		String paperId=request.getParameter("paperId");
		String testId=request.getParameter("testId");
		request.setAttribute("testId", testId);
		request.setAttribute("paperId", paperId);
		//System.out.println(testId);
		Map<String, Object> test=ts.findTestByTestId(Integer.parseInt(testId));
		String testType=test.get("testtype").toString();
		if(Integer.parseInt(testType)==2)
		{
			
		    test=ts.findTestByStudTestId(Integer.parseInt(testId));
		}
		System.out.println(test);
		request.setAttribute("test", test);
		request.setAttribute("courseName",test.get("courseName"));
		request.setAttribute("classNames",test.get("classNames"));
		//System.out.println(test.get("questions").toString());
		List<Map<String, Object>> questions=qs.findQuestionByIds(1,test.get("questions").toString());
		List<Map<String, Object>> questionspanduan=qs.findQuestionByIds(2,test.get("questionspanduan").toString());
		List<Map<String, Object>> questionstiankong=qs.findQuestionByIds(3,test.get("questionstiankong").toString());
		List<Map<String, Object>> questionswenda=qs.findQuestionByIds(4,test.get("questionswenda").toString());
		
		
		Map<String, Object> paper=qs.findPaperById(Integer.parseInt(paperId));
		request.setAttribute("paper", paper);
		//选择
		String xuanzewrongid=null;
		xuanzewrongid=paper.get("wrongQueId").toString();
		String xuanzewrongans=null;
		xuanzewrongans=paper.get("wrongAns").toString();
		Map<Integer,String> xuanzeMap=new HashMap<Integer, String>();;
		if(!xuanzewrongid.equals(""))
		{
			String[] strsid=xuanzewrongid.split(",");
			String[] strsans=xuanzewrongans.split(",");
			for(int i=0,len=strsid.length;i<len;i++)
			{
				//System.out.println(strsid[i]);
				//System.out.println(strsans[i]);
				xuanzeMap.put(Integer.parseInt(strsid[i]), strsans[i]);
			}
		}
		request.setAttribute("xuanzeMap", xuanzeMap);
		System.out.println(xuanzeMap);
		
		//判断
		String panduanwrongid=null;
		panduanwrongid=paper.get("wrongpanduanqueid").toString();
		String panduanwrongans=null;
		panduanwrongans=paper.get("wrongpanduanans").toString();
		Map<Integer,String> panduanMap=new HashMap<Integer, String>();;
		if(!panduanwrongid.equals(""))
		{
			String[] strsid=panduanwrongid.split(",");
			String[] strsans=panduanwrongans.split(",");
			for(int i=0,len=strsid.length;i<len;i++)
			{
				//System.out.println(strsid[i]);
				//System.out.println(strsans[i]);
				panduanMap.put(Integer.parseInt(strsid[i]), strsans[i]);
			}
		}
		request.setAttribute("panduanMap", panduanMap);
		
		//填空
		String tiankongwrongid=null;
		tiankongwrongid=paper.get("wrongtiankongqueid").toString();
		String tiankongwrongans=null;
		tiankongwrongans=paper.get("wrongtiankongans").toString();
		Map<Integer,String> tiankongMap=new HashMap<Integer, String>();
		System.out.println("panduanwrongid:"+tiankongwrongid);
		if(!tiankongwrongid.equals(""))
		{
			String[] strsid=tiankongwrongid.split(",");
			String[] strsans=tiankongwrongans.split(",");
			for(int i=0,len=strsid.length;i<len;i++)
			{
				//System.out.println(strsid[i]);
				//System.out.println(strsans[i]);
				tiankongMap.put(Integer.parseInt(strsid[i]), strsans[i]);
			}
		}
		request.setAttribute("tiankongMap", tiankongMap);
		
		//问答
		String wendaans=paper.get("wendaans").toString();
		request.setAttribute("wendaans", wendaans);
		request.setAttribute("wendascore",paper.get("wendascore"));
		
		request.setAttribute("quesList", questions);
		request.setAttribute("quesPanDuanList", questionspanduan);
		request.setAttribute("quesTianKongList", questionstiankong);
		request.setAttribute("quesWenDaList", questionswenda);
		//System.out.println(questions.get(0));
		request.getRequestDispatcher("/student/viewpaper.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath()+"/pastTestServlet");
	}

}
