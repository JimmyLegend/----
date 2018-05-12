package com.sdut.examsystem.service;

import java.util.List;

import com.sdut.examsystem.po.Paper;

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
	
	public List getPaperCompare(int teaId);
}
