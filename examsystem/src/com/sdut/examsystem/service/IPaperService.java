package com.sdut.examsystem.service;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.po.Paper;
import com.sdut.examsystem.po.StuClass;

public interface IPaperService { 
	
	public int save(Paper paper);
	/**
	 * 学生试题
	 * @return
	 */
	public List getPaperByStudentId(int studentId,int testId);
	
	/**
	 * 学生以往答过的试卷
	 * @return
	 */
	public List getPaperByStudentId(int studentId);
	
	public List getPaperByKey(int studentId,String key);
	
	public List<Map<String, Object>> findPapersByTeaId(int teaId,int testId) ;
	
	public Map<String, Object> findPaperByPaperId(int paperId) ;
	
	public List getPaperCompare(int teaId);
	
	public void updatePaperByPaperId(int paperId,int wendascore,int totalscore);
}
