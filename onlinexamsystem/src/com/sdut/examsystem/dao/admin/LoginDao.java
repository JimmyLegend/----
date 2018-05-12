package com.sdut.examsystem.dao.admin;

import java.util.ArrayList;
import java.util.List;

import com.sdut.examsystem.dao.ILoginDao;
import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.Student;
import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.util.DBUtil;

public class LoginDao implements ILoginDao {
	DBUtil db=new DBUtil();
	@Override
	public Teacher canLogin(Teacher t) {
		// TODO Auto-generated method stub
		List list =new ArrayList<>();
		String sql="select * from teacher where name=? and password=?";
		try {
			list = db.getQueryList(Teacher.class, sql, new Object[]{t.getName(),t.getPassword()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Teacher) list.get(0);
	}

	@Override
	public Student canLogin(Student s) {
		// TODO Auto-generated method stub
		List list =new ArrayList<>();
		String sql="select * from student where name=? and pwd=?";
		try {
			list = db.getQueryList(Student.class, sql, new Object[]{s.getName(),s.getPwd()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Student) list.get(0);
	}

}
