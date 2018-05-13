package com.sdut.examsystem.dao.teacher;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.IPapersDao;
import com.sdut.examsystem.po.Paper;
import com.sdut.examsystem.util.DBUtil;
import com.sdut.examsystem.util.ToolUtil;
import com.sun.swing.internal.plaf.metal.resources.metal_zh_TW;

public class PapersDao implements IPapersDao {
DBUtil db=new DBUtil();
ToolUtil t=new ToolUtil();

//public static void main(String[] agrs){
////	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////	System.out.println(df.format(new Date()));
//	System.out.println(new Date());
//}
	@Override
	public int save(Paper paper) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=df.format(new Date());
		paper.setDate(date);
		//paper.setDate(date);
		String sql = "insert into papers (testId, courseId,time,score,panduanscore,tiankongscore,wendascore,totalscore,wrongQueId,wrongAns,"
				+ "wrongpanduanqueid,wrongpanduanans,wrongtiankongqueid,wrongtiankongans,wendaans,studentId,createDate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { paper.getTestId(), paper.getCourseId(), paper.getTime(), paper.getScore(),paper.getPanDuanScore(),
					paper.getTianKongScore(),paper.getWenDaScore(),paper.getTotalScore(),paper.getWrongQueId(), paper.getWrongAns(),
					paper.getPanDuanWrongQueId(),paper.getPanDuanWrongAns(),paper.getTianKongWrongQueId(),paper.getTianKongWrongAns(),paper.getWenDaAns(),
					paper.getStudentId(),paper.getDate()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId) {
		// TODO Auto-generated method stub
		String sql="SELECT distinct p.id,c.name as courseName ,t.name as testName,p.time,p.createDate,p.totalscore from papers p,test t,student s , course c WHERE t.id=p.testId and c.id=p.courseId and p.studentId = ? ORDER BY p.createDate";
		List<Map<String, Object>> list=null;
		try {
			list=db.getQueryList(sql,new Object[]{studentId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List getPaperCompare(int teaId) {
		// TODO Auto-generated method stub
		String sql="SELECT p.id, AVG(p.score) as avgScore,sc.name as className , c.name as courseName,t.name as testName, t.endDate ,sc.deptName from papers p, student as s , stuclass as sc , test t, course c where t.courseId = c.id and p.testId = t.id and s.classId = sc.id and s.id = p.studentId and p.testId in (SELECT t.id from test as t where t.teacherId = ?) GROUP BY className,testName ORDER BY testName";
		List paperList=null;
		try {
			paperList=db.getQueryList(sql,new Object[]{teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paperList;
	}

}
