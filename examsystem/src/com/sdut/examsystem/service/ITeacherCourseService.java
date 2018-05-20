package com.sdut.examsystem.service;

import java.util.List;
import java.util.Map;

public interface ITeacherCourseService {
	public List<Map<String, Object>> findAllTeacherCourse(String name);
}
