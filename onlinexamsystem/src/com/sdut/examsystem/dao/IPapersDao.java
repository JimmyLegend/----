package com.sdut.examsystem.dao;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.po.Paper;
import com.sdut.examsystem.util.DBUtil;
import com.sdut.examsystem.util.ToolUtil;

public interface IPapersDao {
	
	public int save(Paper  paper);
	
	public List getPaperByStudentId(int studentId,int testId);
	
	public List getPaperByStudentId(int studentId);
	
	//所有的班级成绩。
	public List getPaperCompare(int teaId);
}
