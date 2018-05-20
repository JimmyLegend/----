package com.sdut.examsystem.service.admin;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.admin.TeacherCourseDao;
import com.sdut.examsystem.service.ITeacherCourseService;

public class TeacherCourseService implements ITeacherCourseService {
TeacherCourseDao tcd=new TeacherCourseDao();

@Override
public List<Map<String, Object>> findAllTeacherCourse(String name) {
	// TODO Auto-generated method stub
	//List<Map<String, Object>> list=null;
	return tcd.findAllTeacherCourse(name);
}
}
