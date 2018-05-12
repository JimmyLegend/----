package com.sdut.examsystem.dao.admin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.IStuClassDao;
import com.sdut.examsystem.po.StuClass;
import com.sdut.examsystem.util.DBUtil;

public class StuClassDao implements IStuClassDao {
	DBUtil db=new DBUtil();
	@Override
	public List<Map<String, Object>> findAllStuClassInfo() {
		// TODO Auto-generated method stub

		List<Map<String, Object>> list = null;
		try {
			list = db.getQueryList("select id,name,deptName from stuclass ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public Map<String, Object> findStuClassById(int classId) {
		// TODO Auto-generated method stub
		String sql="select * from stuclass where id=?";
		Map<String, Object> map=new HashMap<String,Object>();
		try {
			map=db.getObject(sql,new Object[]{classId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public void addStuClassById(StuClass sc) {
		// TODO Auto-generated method stub
		String sql = "insert into stuclass values (?,?,?)";
		try {
			db.execute(sql, new Object[]{sc.getId(),sc.getName(),sc.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStuClassById(StuClass sc) {
		// TODO Auto-generated method stub
		String sql = "update stuclass set name=?,deptName=? where id=?";
		try {
			db.execute(sql, new Object[]{sc.getName(),sc.getDeptName(),sc.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String findClassNamesByIds(String[] ids) {
		// TODO Auto-generated method stub
		StringBuffer s = new StringBuffer();
		for(int i=0;i<ids.length;i++)
		{
			StuClassDao stuClassDao=new StuClassDao();
			Map<String, Object>stu=stuClassDao.findStuClassById(Integer.parseInt(ids[i]));
			s.append(stu.get("name"));
			if (i != ids.length - 1)
				s.append(",");
		}
		return s.toString();
	}

	@Override
	public List<Map<String, Object>> findAllStuClassByTeacherId(int id) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = null;
		String sql="select distinct sc.id,sc.name,deptName from stuclass sc,teachercourse tc where tc.teaId="+id+" and tc.classId=sc.id";
		try {
			list = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
