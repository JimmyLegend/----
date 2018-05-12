package com.sdut.examsystem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sdut.examsystem.po.StuClass;
import com.sdut.examsystem.util.DBUtil;

public interface IStuClassDao {

	public List<Map<String, Object>> findAllStuClassInfo();
	
	public List<Map<String, Object>> findAllStuClassByTeacherId(int id);

	public Map<String, Object> findStuClassById(int classId) ;

	public void addStuClassById(StuClass sc) ;

	public void updateStuClassById(StuClass sc) ;
	
	public String findClassNamesByIds(String[] ids);
}
