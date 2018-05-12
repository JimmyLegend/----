package com.sdut.examsystem.dao;


import com.sdut.examsystem.po.Student;
import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.util.DBUtil;

public interface ILoginDao {

	public Teacher canLogin(Teacher t);
	
	public Student canLogin(Student s);
}
