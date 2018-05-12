package com.sdut.examsystem.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Paper;
import com.sdut.examsystem.po.Question;
import com.sdut.examsystem.po.Student;
import com.sdut.examsystem.service.teacher.PaperService;
import com.sdut.examsystem.service.teacher.QuestionService;
import com.sdut.examsystem.service.teacher.TestService;
@WebServlet("/studentTest")
public class StudentTest extends HttpServlet {
	TestService ts=new TestService();
	QuestionService qs=new QuestionService();
	PaperService ps=new PaperService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String testId=req.getParameter("testId");
		Student student =(Student) req.getSession().getAttribute("user");
		//System.out.println(student.getId()+testId);
		Map<String, Object> testMap=ts.findStudentTestsById(student.getId(), Integer.parseInt(testId));
		//System.out.println(testMap);
		List<Map<String, Object>> qList=qs.findQuestionByIds(1,testMap.get("questions").toString());
		List<Map<String, Object>> qPanDuanList=qs.findQuestionByIds(2,testMap.get("questionspanduan").toString());
		List<Map<String, Object>> qTianKongList=qs.findQuestionByIds(3,testMap.get("questionstiankong").toString());
		List<Map<String, Object>> qWenDaList=qs.findQuestionByIds(4,testMap.get("questionswenda").toString());
		
		req.setAttribute("scoreperques", 1.0*Integer.parseInt((String) (testMap.get("scores")))/qList.size());
		req.setAttribute("panduanscores", 1.0*Integer.parseInt((String) (testMap.get("panduanscores")))/qPanDuanList.size());
		req.setAttribute("tiankongscores", 1.0*Integer.parseInt((String) (testMap.get("tiankongscores")))/qTianKongList.size());
		req.setAttribute("wendascores", 1.0*Integer.parseInt((String) (testMap.get("wendascores")))/qWenDaList.size());
		
		req.getSession().setAttribute("test", testMap);
		req.getSession().setAttribute("quesList", qList);
		req.getSession().setAttribute("qPanDuanList", qPanDuanList);
		req.getSession().setAttribute("qTianKongList", qTianKongList);
		req.getSession().setAttribute("qWenDaList", qWenDaList);
		req.getRequestDispatcher("/manager/exam.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String time = req.getParameter("hidden1");
		//从session中获取试卷信息
		Map testMap = (Map) req.getSession().getAttribute("test");
		
		//选择题
		//从session中获取试题信息
		List quesList = (List) req.getSession().getAttribute("quesList");
		//判断
		List qPanDuanList = (List) req.getSession().getAttribute("qPanDuanList");
		//填空
		List qTianKongList = (List) req.getSession().getAttribute("qTianKongList");
		//问答
		List qWenDaList = (List) req.getSession().getAttribute("qWenDaList");
		
		/**
		 * 从session中能够获取试题集合
		 * 试题集合中有试题的id号和答案
		 * 页面上展示了试题信息，能够提供每道题的答案
		 * 页面上的试题和我们保存到session中的试题是一样的
		 * 通过迭代session中的试题，我们能够获得具体的每一道试题
		 * 通过当前试题的id号能够获取页面上这道题的答案。
		 * 通过页面上针对选项的标识--ques_+试题id号能够获得本道题的答案
		 * 试题答案和正确答案做对比，如果不一致，则记录试题的id号和错误答案
		 * 然后需要对wrongQueId和wrongAns 两个stringbuffer做处理
		 * 如果试卷全对，则这两个都是“”，否则会多一个逗号
		 * 需要把多余的逗号去掉
		 * 另外还需要记录错误题目的数量，用来计算分值
		 * 分值的计算方式为：试卷总分/试题数量*正确的题目数量
		 * 把以上信息封装成paper对象，持久化到数据库
		 */
		//选择
		if (null == quesList || quesList.size()<1)
			return ;
		
		
		
		//选择
		StringBuffer wrongQueId = new StringBuffer();
		StringBuffer wrongAns = new StringBuffer();
		//目的是遍历试卷中的试题的集合
		int wrongQueNum = 0;
		for (int i = 0 ; i < quesList.size();i++){
			Map<String, Object> q = (Map<String, Object>)quesList.get(i);
//			System.out.println(q.get("ans"));
			//页面接收的答案
			String ans = req.getParameter("ques_"+q.get("id").toString()).toUpperCase();
//			System.out.println(ans);
//			//如果和标准答案不匹配，则记录错误的题号和错误答案
			if (!q.get("ans").toString().toUpperCase().equals(ans)){
				wrongQueId.append(q.get("id").toString()).append(",");
				wrongAns.append(ans).append(",");
				wrongQueNum++;
			}
		}
		
		
		
		//判断
		StringBuffer wrongPanDuanQueId = new StringBuffer();
		StringBuffer wrongPanDuanAns = new StringBuffer();
		//目的是遍历试卷中的试题的集合
		int wrongPanDuanQueNum = 0;
		for (int i = 0 ; i < qPanDuanList.size();i++){
			Map<String, Object> q = (Map<String, Object>)qPanDuanList.get(i);
//			System.out.println(q.get("ans"));
			//页面接收的答案
			String ans = req.getParameter("ques_"+q.get("id").toString()).toUpperCase();
//			System.out.println(ans);
//			//如果和标准答案不匹配，则记录错误的题号和错误答案
			if (!q.get("ans").toString().toUpperCase().equals(ans)){
				wrongPanDuanQueId.append(q.get("id").toString()).append(",");
				wrongPanDuanAns.append(ans).append(",");
				wrongPanDuanQueNum++;
			}
		}
		
		
		//填空
		StringBuffer wrongTianKongQueId = new StringBuffer();
		StringBuffer wrongTianKongAns = new StringBuffer();
		//目的是遍历试卷中的试题的集合
		int wrongTianKongQueNum = 0;
		for (int i = 0 ; i < qTianKongList.size();i++){
			Map<String, Object> q = (Map<String, Object>)qTianKongList.get(i);
//			System.out.println(q.get("ans"));
			//页面接收的答案
			String ans = req.getParameter("tiankongans");
//			System.out.println(ans);
//			//如果和标准答案不匹配，则记录错误的题号和错误答案
			if (!q.get("ans").toString().equals(ans)){
				wrongTianKongQueId.append(q.get("id").toString()).append(",");
				wrongTianKongAns.append(ans).append(",");
				wrongTianKongQueNum++;
			}
		}
		
		//问答
		String wendaans=req.getParameter("paperTitle");
		System.out.println(wendaans);
		
		
//		System.out.println(wrongQueId.toString());
//		System.out.println(wrongAns.toString());
		
		Paper p = new Paper();
		p.setTestId((int) testMap.get("id"));
		p.setCourseId((int) testMap.get("courseId"));
		p.setTime(time);
		//获得试题的总分和错误试题的数量
		
		
		
		//选择
		if (quesList.size()>wrongQueNum)
			p.setScore(1.0*Integer.parseInt((String) (testMap.get("scores")))/quesList.size()*(quesList.size()-wrongQueNum));
		else
			p.setScore(0);
		/**
		 * 如果做的全对，那么wrongQueId和wrongAns，都是空
		 * 如果有错题，那么多带了一个逗号
		 */
		String wrongQueIdString = wrongQueId.toString();
		String wrongAnsString = wrongAns.toString();
		if (wrongQueIdString.endsWith(",")){
			wrongQueIdString = wrongQueIdString.substring(0, wrongQueIdString.length()-1);
			wrongAnsString = wrongAnsString.substring(0, wrongAnsString.length()-1);
		}
		
		p.setWrongQueId(wrongQueIdString);
		p.setWrongAns(wrongAnsString);
		
		
		
		//判断
		if (qPanDuanList.size()>wrongPanDuanQueNum)
			p.setPanDuanScore(1.0*Integer.parseInt((String) (testMap.get("panduanscores")))/qPanDuanList.size()*(qPanDuanList.size()-wrongPanDuanQueNum));
		else
			p.setPanDuanScore(0);
		/**
		 * 如果做的全对，那么wrongQueId和wrongAns，都是空
		 * 如果有错题，那么多带了一个逗号
		 */
		String wrongPanDuanQueIdString = wrongPanDuanQueId.toString();
		String wrongPanDuanAnsString = wrongPanDuanAns.toString();
		if (wrongPanDuanQueIdString.endsWith(",")){
			wrongPanDuanQueIdString = wrongPanDuanQueIdString.substring(0, wrongPanDuanQueIdString.length()-1);
			wrongPanDuanAnsString = wrongPanDuanAnsString.substring(0, wrongPanDuanAnsString.length()-1);
		}
		
		p.setPanDuanWrongQueId(wrongPanDuanQueIdString);
		p.setPanDuanWrongAns(wrongPanDuanAnsString);
		
		
		//填空
		if (qTianKongList.size()>wrongTianKongQueNum)
			p.setTianKongScore(1.0*Integer.parseInt((String) (testMap.get("tiankongscores")))/qTianKongList.size()*(qTianKongList.size()-wrongTianKongQueNum));
		else
			p.setTianKongScore(0);
		/**
		 * 如果做的全对，那么wrongQueId和wrongAns，都是空
		 * 如果有错题，那么多带了一个逗号
		 */
		String wrongTianKongQueIdString = wrongTianKongQueId.toString();
		String wrongTianKongAnsString = wrongTianKongAns.toString();
		if (wrongTianKongQueIdString.endsWith(",")){
			wrongTianKongQueIdString = wrongTianKongQueIdString.substring(0, wrongTianKongQueIdString.length()-1);
			wrongTianKongAnsString = wrongTianKongAnsString.substring(0, wrongTianKongAnsString.length()-1);
		}
		
		p.setTianKongWrongQueId(wrongTianKongQueIdString);
		p.setTianKongWrongAns(wrongTianKongAnsString);
		
		//问答
		p.setWenDaAns(wendaans);
		
		Student s = (Student) req.getSession().getAttribute("user");
		p.setStudentId(s.getId());
		ps.save(p);
		resp.sendRedirect(req.getContextPath()+"/student/index.jsp");
	}

}
