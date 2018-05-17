package com.sdut.examsystem.service.teacher;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.teacher.TestDao;
import com.sdut.examsystem.po.Test;
import com.sdut.examsystem.service.ITestService;

public class TestService implements ITestService {
	TestDao td=new TestDao();
	@Override
	public void createTest(Test t) {
		// TODO Auto-generated method stub
		td.createTest(t);
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		// TODO Auto-generated method stub
		return td.findTestsByTeaId(teaId);
	}

	@Override
	public Map<String, Object> findTestsById(int id, int teaId) {
		// TODO Auto-generated method stub
		return td.findTestsById(id, teaId);
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		// TODO Auto-generated method stub
		return td.findStudentTestsById(studentid, testid);
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		// TODO Auto-generated method stub
		return td.getTestByStudent(id, currData);
	}

	@Override
	public Map<String, Object> findTestByTestId(int testId) {
		// TODO Auto-generated method stub
		return td.findTestByTestId(testId);
	}

}
