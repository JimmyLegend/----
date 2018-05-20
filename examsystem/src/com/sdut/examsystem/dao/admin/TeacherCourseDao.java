package com.sdut.examsystem.dao.admin;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.ITeacherCourseDao;
import com.sdut.examsystem.util.DBUtil;

public class TeacherCourseDao implements ITeacherCourseDao {
	DBUtil db=new DBUtil();
	@Override
	public List<Map<String, Object>> findAllTeacherCourse(String name) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list=null;
		if(name==""){
			try {
				list = db.getQueryList("select tc.id tcId,c.name courseName,t.name teacherName,sc.name stuclassName from teachercourse tc ,teacher t,course c,stuclass sc where  tc.teaId=t.id and tc.courseId=c.id and tc.classId=sc.id");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			
		}
		return list;
	}

}
