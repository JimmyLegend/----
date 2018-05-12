package com.sdut.examsystem.service;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.po.StuClass;

public interface IStuClassService {	

	public List<Map<String, Object>> findAll() ;
	
	public Map<String,Object> addstuClass(StuClass sc);
	public void updateStuClass(StuClass sc);
	public Map<String,Object> findStuClassById(int id);
	public List<Map<String, Object>> findAllStuClassByTeacherId(int id);
	public String findClassNamesByIds(String[] ids);
}
