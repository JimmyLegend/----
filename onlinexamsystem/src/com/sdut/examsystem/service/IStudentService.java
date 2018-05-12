package com.sdut.examsystem.service;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.po.Student;

public interface IStudentService { 
	public void addStudent(Student s);
	public void updateStudent(Student s);
	public Map<String, Object> findStudentById(int id);
	public List<Map<String, Object>> findAllStudentByName(String name);
	public List<Map<String,Object>> findAll();
}
