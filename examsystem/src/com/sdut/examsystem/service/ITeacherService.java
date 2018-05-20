package com.sdut.examsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sdut.examsystem.po.Teacher;

public interface ITeacherService {		

	public List<Teacher> findAll(String name);
	public void addTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher,int oldid);
	public Map<String,Object> findTeacherInfo(int id) ;
	
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId);
}
