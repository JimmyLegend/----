package com.sdut.examsystem.dao;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.po.Question;
import com.sdut.examsystem.po.QuestionPanDuan;

public interface IQuestionDao {

	public List<Map<String, Object>> findAllQuestionInfo(String key, String value);
	public List<Map<String, Object>> findAllWenDaQuestionInfo(String key, String value);
	
	public void addQuestion(Question q);

	public Map<String, Object> findQuestionById(int id);
	
	public Map<String, Object> findQuestionPanDuanById(int panDuanId);
	
	public Map<String, Object> findQuestionTianKongById(int tianKongId);
	
	public Map<String, Object> findQuestionWenDaById(int wenDaId);
	
	/**
	 * 在数据库存储的时候，题目集合作为一个字段以逗号分开
	 * @param ids
	 * @return
	 */
	public List<Map<String, Object>> findQuestionByIds(String ids) ;
	
	public List<Map<String, Object>> findPanDuanQuestionByIds(String ids) ;
	
	public List<Map<String, Object>> findTianKongQuestionByIds(String ids) ;
	
	public List<Map<String, Object>> findWenDaQuestionByIds(String ids) ;

	public void updateQuestionInfo(Question q);
	
	public void updateQuestionPanDuanInfo(QuestionPanDuan questionPanDuan);
	
	public void updateQuestionTianKongInfo(Question q);
	
	public void updateQuestionWenDaInfo(Question q);

	/**
	 * 根据课程名称提取试题ID
	 * 
	 * @param courseId
	 * @return
	 */
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId);
	
	public List<Map<String, Object>> findPanDuanQuestionsByCourseId(int courseId);
	
	public List<Map<String, Object>> findTianKongQuestionsByCourseId(int courseId);
	
	public List<Map<String, Object>> findWenDaQuestionsByCourseId(int courseId);
	
	public Map<String, Object> findPaperById(int paperId);

	public void deleteQuestion(int id) ;
	
	public void deleteQuestionPanDuan(int panDuanId) ;
	
	public void deleteQuestionTianKong(int tianKongId) ;
	
	public void deleteQuestionWenDa(int wenDaId);
	
	public List<Map<String, Object>> collectQuestions(int queType,int courseId, int num);
	
	public String testQuestionIds(List<Map<String, Object>> question);

}
