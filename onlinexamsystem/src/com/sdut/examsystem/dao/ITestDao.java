package com.sdut.examsystem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sdut.examsystem.po.Test;
import com.sdut.examsystem.util.DBUtil;
import com.sdut.examsystem.util.ToolUtil;

public interface ITestDao {

	public void createTest(Test t) ;

	public List<Map<String, Object>> findTestsByTeaId(int teaId);
	
	/**
	 * 添加teaid是为了防止用户查看非权限资源
	 * @param id
	 * @param teaId
	 * @return
	 */
	public Map<String, Object> findTestsById(int id, int teaId) ;
	
	public Map<String, Object> findTestByTestId(int testId) ;
	
	public Map<String, Object> findStudentTestsById(int studentid,int testid);
	public List<Map<String,Object>> getTestByStudent(int id,String currData);
}
