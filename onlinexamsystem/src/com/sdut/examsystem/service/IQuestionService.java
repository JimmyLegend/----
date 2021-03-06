package com.sdut.examsystem.service;
 
import java.util.List;
import java.util.Map;

import com.sdut.examsystem.po.Question;
import com.sdut.examsystem.po.QuestionPanDuan;

public interface IQuestionService {
	 

	public List<Map<String,Object>> findAll(String key, String value);
	
	public List<Map<String,Object>> findAllWenDa(String key, String value);
	
	public List<Map<String,Object>> findAllPanDuan(String key, String value);
	public List<Map<String,Object>> findAllTianKong(String key, String value);
	
	public void addQuestion(Question q);
	
	public Map<String, Object> findQuestionById(int id);
	
	public Map<String, Object> findQuestionPanDuanById(int panDuanId);
	
	public Map<String, Object> findQuestionTianKongById(int tianKongId);
	
	public Map<String, Object> findQuestionWenDaById(int wenDaId);
	
	public void updateQuestionInfo(Question q);
	
	public void updateQuestionPanDuanInfo(QuestionPanDuan questionPanDuan);
	
	public void updateQuestionTianKongInfo(Question q);
	
	public void updateQuestionWenDaInfo(Question q);
	
	public void deleteQuestion(int id);
	
	public void deleteQuestionPanDuan(int panDuanId);
	
	public void deleteQuestionTianKong(int tianKongId);
	
	public void deleteQuestionWenDa(int wenDaId);
	//生成试卷，需要的信息，考试科目
	public List<Map<String, Object>> collectQuestions(int queType,int courseId,int num);
	
	public String testQuestionIds(List<Map<String, Object>> list);
	
	public List<Map<String, Object>> findQuestionByIds(int queType,String ids) ;
	
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId);
	
	public List<Map<String, Object>> findPanDuanQuestionsByCourseId(int courseId);
	
	public List<Map<String, Object>> findTianKongQuestionsByCourseId(int courseId);
	
	public List<Map<String, Object>> findWenDaQuestionsByCourseId(int courseId);
	
	public Map<String, Object> findPaperById(int paperId);
	
}
