package com.sdut.examsystem.service.admin;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.admin.StudentDao;
import com.sdut.examsystem.po.Student;
import com.sdut.examsystem.service.IStudentService;

public class StudentService implements IStudentService {
StudentDao sd=new StudentDao();
	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		sd.addStudent(s);
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		sd.updateStudent(s);
	}

	@Override
	public Map<String, Object> findStudentById(int id) {
		// TODO Auto-generated method stub
		return sd.findStudentById(id);
	}

	@Override
	public List<Map<String, Object>> findAll() {
		// TODO Auto-generated method stub
		return sd.findAll();
	}

	@Override
	public List<Map<String, Object>> findAllStudentByName(String name) {
		// TODO Auto-generated method stub
		return sd.findAllStudentByName(name);
	}

}
