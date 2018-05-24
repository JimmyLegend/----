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
	
	public List getPaperByKey(int studentId,String key);
	
	public List<Map<String, Object>> findPapersByTeaId(int teaId,int testId) ;
	
	public Map<String, Object> findPaperByPaperId(int paperId) ;
	//所有的班级成绩。
	public List getPaperCompare(int teaId);
	
	public void updatePaperByPaperId(int paperId,int wendascore,int totalscore);
}
