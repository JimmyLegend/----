package com.sdut.examsystem.dao;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.po.Student;

public interface IStudentDao {
	
	public void addStudent(Student s);
	
	public void updateStudent(Student s);
	
	public Map<String, Object> findStudentById(int id);
	
	public List<Map<String, Object>> findAllStudentByName(String name);
	
	public List<Map<String,Object>> findAll();
}
