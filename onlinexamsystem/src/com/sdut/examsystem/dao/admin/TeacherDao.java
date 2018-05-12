package com.sdut.examsystem.dao.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.ITeacherDao;
import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.util.DBUtil;

public class TeacherDao implements ITeacherDao {
	DBUtil db=new DBUtil();
	@Override
	public List<Teacher> findAllTeacherInfo(String name) {
		// TODO Auto-generated method stub
		List list = null;
		if(name=="")
		{
		try {
			list = db.getQueryList("select id,name,password,deptName from teacher ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else{
			String sql = " select id,name,password,deptName from teacher where name like '%"+name+"%'";
			try {
				list = (List)db.getQueryList(Teacher.class, sql, new Object[]{});
				//list = dbutil.getQueryList(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql = "insert into teacher values (?,?,?,?)";
		try {
			db.execute(sql, new Object[]{teacher.getId(),teacher.getName(),teacher.getPassword(),teacher.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldId) {
		// TODO Auto-generated method stub
		String sql = "update teacher set name=?,deptName=?,password=? where id=?";
		try {
			db.execute(sql, new Object[]{teacher.getName(),teacher.getDeptName(),teacher.getPassword(),teacher.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		// TODO Auto-generated method stub
		String sql="select * from teacher where id=?";
		Map<String, Object> map=new HashMap<String,Object>();
		try {
			map=db.getObject(sql,new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

}
