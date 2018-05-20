package com.sdut.examsystem.dao;

import java.util.List;
import java.util.Map;

public interface ITeacherCourseDao {
	public List<Map<String, Object>> findAllTeacherCourse(String name);
}
