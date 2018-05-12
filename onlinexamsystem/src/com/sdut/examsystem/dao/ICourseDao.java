package com.sdut.examsystem.dao;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.TeacherCourse;
import com.sdut.examsystem.util.DBUtil;
import com.sdut.examsystem.vo.TeacherCourseView;

public interface ICourseDao {
	/**
	 * 修改为返回一个map
	 * @return
	 */
	public List<TeacherCourseView> findAllTeaCourInfo();

	/**
	 * 根据课程名称查询是否课程存在，如果存在则返回课程，不存在返回null
	 * 
	 * @param name
	 * @return
	 */
	public Map<String, Object> findCourseByName(String name);
	public TeacherCourse findTeacherCourseById(int id);
	public void addCourse(String name);
	
	public void updateCourse(Course course);
	
	public Map<String, Object> findCourseById(int id);
	
	public void addTeacherCourse(TeacherCourse tc);
	

	/**
	 * 修改为map
	 * @param teaCourId
	 * @return
	 */
	public Map<String, Object> findTeaCourInfoById(int id) ;
	

	/**
	 * 查找所有的课程
	 * 
	 * @return
	 */
	public List<Course> findAllCourses() ;
	
	/**
	 * 查找所有的课程
	 * 
	 * @return
	 */
	public List<Course> findAllCoursesByName(String name) ;
	/**
	 * 
	 * @param courseId
	 * @param teaId
	 * @param stuClassId
	 * @return true表示存在，false表示不存在
	 */
	public boolean isExitByAllIds(TeacherCourse tc ) ;

	

	public void updateTeacherCourse(TeacherCourse tc) ;

	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) ;

	public void deleteTourse(int tcId);
	
	public List<Course> findAllCoursesByTeacherId(int id) ;
}
