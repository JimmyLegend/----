package com.sdut.examsystem.service.admin;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.admin.TeacherDao;
import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.service.ITeacherService;

public class TeacherService implements ITeacherService {
	TeacherDao td=new TeacherDao();
	@Override
	public List<Teacher> findAll(String name) {
		// TODO Auto-generated method stub
		return td.findAllTeacherInfo(name);
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		td.addTeacher(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldid) {
		// TODO Auto-generated method stub
		td.updateTeacher(teacher, oldid);
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		// TODO Auto-generated method stub
		return td.findTeacherInfo(id);
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

}
