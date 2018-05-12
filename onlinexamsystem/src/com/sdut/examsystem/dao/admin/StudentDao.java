package com.sdut.examsystem.dao.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.IStudentDao;
import com.sdut.examsystem.po.Course;
import com.sdut.examsystem.po.Student;
import com.sdut.examsystem.util.DBUtil;

public class StudentDao implements IStudentDao {
	DBUtil db=new DBUtil();
	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "insert into student values (?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{s.getId(),s.getName(),s.getPwd(),s.getSchool(),s.getDeptName(),s.getSex(),s.getBorn(),s.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "update student set name=?,pwd=?,school=?,deptName=?,sex=?,born=?,classId=? where id=?";
		try {
			db.execute(sql, new Object[]{s.getName(),s.getPwd(),s.getSchool(),s.getDeptName(),s.getSex(),s.getBorn(),s.getClassId(),s.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findStudentById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from student where id=?";
		Map<String, Object> map=new HashMap<String,Object>();
		try {
			map=db.getObject(sql,new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = null;
		try {
			list = db.getQueryList("select st.id,st.name,st.sex,st.born,st.pwd,st.school,st.deptName,sc.name className from student st,stuclass sc where st.classId=sc.id");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> findAllStudentByName(String name) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list=null;
		if(name==""){
			StudentDao sd=new StudentDao();
			list=sd.findAll();
		}
		else{
			try {
			list=db.getQueryList(" select * from student where name like '%"+name+"%'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		return list;
	}

}
