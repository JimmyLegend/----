package com.sdut.examsystem.dao.teacher;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.ITestDao;
import com.sdut.examsystem.po.Test;
import com.sdut.examsystem.util.DBUtil;
import com.sdut.examsystem.util.ToolUtil;

import sun.text.normalizer.UBiDiProps;

public class TestDao implements ITestDao {
	DBUtil db=new DBUtil();
	@Override
	public void createTest(Test t) {
		// TODO Auto-generated method stub
		String sql="insert into test(name,courseId,endDate,testTime,questions,questionspanduan,questionstiankong,questionswenda,teacherId,classIds,scores,panduanscores,tiankongscores,wendascores,totalscores) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{t.getName(),t.getCourseId(),t.getEndDate(),t.getTestTime(),t.getQuetions(),t.getPanDuanQuetions(),t.getTianKongQuetions(),t.getWenDaQuetions(),t.getTeacherId(),t.getClassIds(),t.getScores(),t.getPanDuanScores(),t.getTianKongScores(),t.getWenDaScores(),t.getTotalScores()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		// TODO Auto-generated method stub
		String currentTime=ToolUtil.getCurrentDate();
		String sql="SELECT t.id,t.name as name,c.name as courseName,t.endDate,t.questions,t.classIds,GROUP_CONCAT(sc.name) as classNames,t.testTime,t.totalscores from test t , course c , stuclass as sc where t.courseId = c.id  and FIND_IN_SET(sc.id,t.classIds) and t.endDate>?  and t.teacherId = ? GROUP BY t.id";
		List<Map<String, Object>> list=null;
		try {
			list=db.getQueryList(sql,new Object[]{currentTime,teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Map<String, Object> findTestsById(int id, int teaId) {
		// TODO Auto-generated method stub
		String sql="SELECT t.id,t.name as name,c.name as courseName,t.endDate,t.questions,t.questionspanduan,t.questionstiankong,t.questionswenda,t.classIds,GROUP_CONCAT(sc.name) as classNames,t.testTime,t.scores,t.wendascores from test t , course c , stuclass as sc where t.courseId = c.id  and FIND_IN_SET(sc.id,t.classIds)  and  t.id= ? and t.teacherId=? GROUP BY t.id";
		Map<String, Object> map=null;
		try {
			map=db.getObject(sql,new Object[]{id,teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		// TODO Auto-generated method stub
		String sql = "SELECT t.id,t.name as testName, c.name as courseName,c.id as courseId ,t.endDate,t.questions,t.questionspanduan,t.questionstiankong,t.questionswenda,t.testTime,t.scores,t.panduanscores,t.tiankongscores,t.wendascores, sc.name as className from test t,student s , course c, stuclass as sc where t.id = ? and FIND_IN_SET(s.classId,t.classIds) and s.id=? and t.courseId = c.id and s.classId = sc.id";
		Map<String, Object> map = null;
//		System.out.println(studentid);
//		System.out.println(testid);
		try {
			map = db.getObject(sql, new Object[]{testid,studentid});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		// TODO Auto-generated method stub
		System.out.println(currData);
		//String sql2="SELECT DISTINCT t.id,c.name as courseName ,t.name as testName,t.endDate ,t.questions from test t,student s , course c , papers p WHERE t.courseId = c.id and FIND_IN_SET(s.classId,t.classIds) and s.id = ? and t.endDate >? and t.id not in(SELECT papers.testId from papers where s.id = ?) ORDER BY s.id";
		String sql1="SELECT papers.testId from papers where papers.studentId = ?";
		List<Map<String, Object>> list1=null;
		try {
			list1=db.getQueryList(sql1,new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2=null;
		List<Map<String, Object>> list2=null;
		if(list1.size()!=0)
		    {
			sql2="SELECT DISTINCT t.id,c.name as courseName ,t.name as testName,t.endDate ,t.questions from test t,student s , course c , papers p WHERE t.courseId = c.id and FIND_IN_SET(s.classId,t.classIds) and s.id = ? and t.endDate >? and t.id not in(SELECT papers.testId from papers where s.id = ?) ORDER BY s.id";
			try {
				list2=db.getQueryList(sql2,new Object[]{id,currData,id});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    }
		else
			{
			System.out.println("0");
			sql2="SELECT DISTINCT t.id,c.name as courseName ,t.name as testName,t.endDate ,t.questions from test t,student s , course c WHERE t.courseId = c.id and FIND_IN_SET(s.classId,t.classIds) and s.id = ? and t.endDate >? ORDER BY s.id";
			try {
				list2=db.getQueryList(sql2,new Object[]{id,currData});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		return list2;
	}

	@Override
	public Map<String, Object> findTestByTestId(int testId) {
		// TODO Auto-generated method stub
		String sql = "SELECT t.id,t.name as name,c.name as courseName,t.endDate,t.questions,t.questionspanduan,t.questionstiankong,t.questionswenda,t.classIds,GROUP_CONCAT(sc.name) as classNames,t.testTime,t.scores,t.wendascores,teach.name as teacherName from test t , course c , stuclass as sc , teacher as teach where t.courseId = c.id  and FIND_IN_SET(sc.id,t.classIds)  and  t.id= ? and teach.id=t.teacherId";
		Map<String, Object> map = null;
//		System.out.println(studentid);
//		System.out.println(testid);
		try {
			map = db.getObject(sql, new Object[]{testId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
