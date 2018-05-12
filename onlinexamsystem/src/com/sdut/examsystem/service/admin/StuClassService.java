package com.sdut.examsystem.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.admin.StuClassDao;
import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.StuClass;
import com.sdut.examsystem.service.IStuClassService;
import com.sun.xml.internal.ws.api.server.SDDocument;

public class StuClassService implements IStuClassService {
	StuClassDao studClassDao=new StuClassDao();
	@Override
	public List<Map<String, Object>> findAll() {
		// TODO Auto-generated method stub
		return studClassDao.findAllStuClassInfo();
	}

	@Override
	public Map<String, Object> addstuClass(StuClass sc) {
		// TODO Auto-generated method stub
		studClassDao.addStuClassById(sc);
		return null;
	}

	@Override
	public void updateStuClass(StuClass sc) {
		// TODO Auto-generated method stub
		studClassDao.updateStuClassById(sc);
	}

	@Override
	public Map<String, Object> findStuClassById(int id) {
		// TODO Auto-generated method stub
		return studClassDao.findStuClassById(id);
	}
	@Override
	public List<Map<String, Object>> findAllStuClassByTeacherId(int id) {
		// TODO Auto-generated method stub
		return studClassDao.findAllStuClassByTeacherId(id);
	}

	@Override
	public String findClassNamesByIds(String[] ids) {
		// TODO Auto-generated method stub
		return studClassDao.findClassNamesByIds(ids);
	}
}