package com.sdut.examsystem.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.catalina.filters.CsrfPreventionFilter;

import com.sdut.examsystem.dao.admin.CourseDao;
import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.TeacherCourse;
import com.sdut.examsystem.service.ICourseService;
import com.sdut.examsystem.vo.TeacherCourseView;

public class CourseService implements ICourseService {
	CourseDao cd = new CourseDao();
	@Override
	public List<TeacherCourseView> findAll() {
		// TODO Auto-generated method stub
		return cd.findAllTeaCourInfo();
	}

	@Override
	public Map<String, Object> findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return cd.findTeaCourInfoById(id);
	}

	@Override
	public Map<String, Object> findCourseById(int id) {
		// TODO Auto-generated method stub
		return cd.findCourseById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		List<Course> list = cd.findAllCourses();
		if (null == list)
			list = new ArrayList<Course>();
		return list;
	}

	@Override
	public List<Course> findAllCourses(String name) {
		// TODO Auto-generated method stub
		return cd.findAllCoursesByName(name);
	}

	@Override
	public void modifyTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		cd.updateTeacherCourse(tc);
	}

	@Override
	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey) {
		// TODO Auto-generated method stub
		return cd.findTeaCourInfoByCourseKey(courseKey);
	}

	@Override
	public void deleteTeacherCourse(int tcId) {
		// TODO Auto-generated method stub
		cd.deleteTourse(tcId);
	}

	@Override
	public void addCourse(String courseName) {
		// TODO Auto-generated method stub
		cd.addCourse(courseName);
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		cd.updateCourse(course);
	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		// TODO Auto-generated method stub
		cd.addTeacherCourse(tc);
	}

	@Override
	public Map<String, Object> findCourseByName(String name) {
		// TODO Auto-generated method stub
		return cd.findCourseByName(name);
	}

	@Override
	public List<Course> findAllCoursesByTeacherId(int id) {
		return cd.findAllCoursesByTeacherId(id);
	}

}
