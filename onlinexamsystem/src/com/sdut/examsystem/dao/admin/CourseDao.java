package com.sdut.examsystem.dao.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.ICourseDao;
import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.po.TeacherCourse;
import com.sdut.examsystem.util.DBUtil;
import com.sdut.examsystem.vo.TeacherCourseView;
import com.sun.xml.internal.ws.util.xml.CDATA;

public class CourseDao implements ICourseDao {
	DBUtil dbutil=new DBUtil();
	@Override
	public List<TeacherCourseView> findAllTeaCourInfo() {
		// TODO Auto-generated method stub
		List list=null;
			try {
				list = dbutil.getQueryList("select tc.id tcId,c.name courseName,t.name teacherName,sc.name stuclassName from teachercourse tc ,teacher t,course c,stuclass sc where  tc.teaId=t.id and tc.courseId=c.id and tc.classId=sc.id order by tc.id");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}

	@Override
	public Map<String, Object> findCourseByName(String name) {
		// TODO Auto-generated method stub
		String sql="select * from where name=?";
		Map<String, Object> course=null;
		try {
			course=dbutil.getObject(sql,new Object[]{name});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCourse(String name) {
		// TODO Auto-generated method stub
		String sql = "insert into course(name) values (?)";
		try {
			dbutil.execute(sql, new Object[]{name});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		String sql = "update course set name=? where id=?";
		try {
			dbutil.execute(sql, new Object[]{course.getName(),course.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findCourseById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from course where id=?";
		Map<String, Object> map=new HashMap<String,Object>();
		try {
			map=dbutil.getObject(sql,new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		String sql = "insert into teacherCourse(teaId,courseId,classId) values (?,?,?)";
		try {
			dbutil.execute(sql, new Object[]{tc.getTeaId(),tc.getCourseId(),tc.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findTeaCourInfoById(int id) {
		// TODO Auto-generated method stub
		Map<String, Object> list=null;
		try {
			String sql="select tc.teaId teacherId,tc.classId stuclassId,tc.courseId courseId from teachercourse tc where id=?";
		list=dbutil.getObject(sql,new Object[]{id});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		List list = null;
		try {
			list = dbutil.getQueryList("select * from course ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

//	public static void main(String[] args) {
//		CourseDao dao = new CourseDao();
//		List l = dao.findAllCourses();
//		System.out.println(l.size());
//	}
	
	@Override
	public List<Course> findAllCoursesByName(String name) {
		// TODO Auto-generated method stub
		List list = null;
		CourseDao cd=new CourseDao();
		if(name==null)
		{
			list=cd.findAllCourses();
		}
		else{
			String sql = " select * from course where name like '%"+name+"%'";
			try {
				list = (List)dbutil.getQueryList(Course.class, sql, new Object[]{});
				//list = dbutil.getQueryList(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		String sql = "update teachercourse set teaId=?,classId=?,courseId=? where id=?";
		try {
			dbutil.execute(sql, new Object[]{tc.getTeaId(),tc.getClassId(),tc.getCourseId(),tc.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		// TODO Auto-generated method stub
		List list=null;
		if(courseKey==""){
			CourseDao courseDao=new CourseDao();
			list=courseDao.findAllTeaCourInfo();
		}
		else{
			try {
				String sql="select tc.id tcId,c.name courseName,t.name teacherName,sc.name stuclassName from teachercourse tc ,teacher t,course c,stuclass sc where  tc.teaId=t.id and tc.courseId=c.id and tc.classId=sc.id and "+"c.name like '%"+courseKey+"%' order by tc.id";
			list=dbutil.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		return list;
	}

	@Override
	public void deleteTourse(int tcId) {
		// TODO Auto-generated method stub
		String sql="delete from teachercourse where id=?";
		try {
			dbutil.execute(sql, new Object[]{tcId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> findAllCoursesByTeacherId(int id) {
		// TODO Auto-generated method stub
		List list = null;
		String sql="select distinct c.id,c.name from course c,teachercourse tc where tc.teaId="+id+" and tc.courseId=c.id";
		try {
			list = dbutil.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
