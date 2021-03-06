package com.sdut.examsystem.service.teacher;

import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.teacher.QuestionDao;
import com.sdut.examsystem.po.Question;
import com.sdut.examsystem.po.QuestionPanDuan;
import com.sdut.examsystem.service.IQuestionService;

public class QuestionService implements IQuestionService {
	QuestionDao qd=new QuestionDao();
	@Override
	public List<Map<String, Object>> findAll(String key, String value) {
		// TODO Auto-generated method stub
		return qd.findAllQuestionInfo(key, value);
	}
	@Override
	public List<Map<String, Object>> findAllWenDa(String key, String value) {
		// TODO Auto-generated method stub
		return qd.findAllWenDaQuestionInfo(key, value);
	}
	@Override
	public List<Map<String, Object>> findAllPanDuan(String key, String value) {
		// TODO Auto-generated method stub
		return qd.findAllPanDuanQuestionInfo(key, value);
	}
	
	@Override
	public List<Map<String, Object>> findAllTianKong(String key, String value) {
		// TODO Auto-generated method stub
		return qd.findAllTianKongQuestionInfo(key, value);
	}

	@Override
	public void addQuestion(Question q) {
		// TODO Auto-generated method stub
		qd.addQuestion(q);
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		// TODO Auto-generated method stub
		return qd.findQuestionById(id);
	}

	@Override
	public void updateQuestionInfo(Question q) {
		// TODO Auto-generated method stub
		qd.updateQuestionInfo(q);
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		qd.deleteQuestion(id);
	}

	@Override
	public List<Map<String, Object>> collectQuestions(int queType,int courseId, int num) {
		// TODO Auto-generated method stub
		return qd.collectQuestions(queType,courseId, num);
	}

	@Override
	public String testQuestionIds(List<Map<String, Object>> list) {
		// TODO Auto-generated method stub
		return qd.testQuestionIds(list);
	}

	@Override
	public List<Map<String, Object>> findQuestionByIds(int queType,String ids) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> questions=null;
		if(queType==1)
		{
			questions=qd.findQuestionByIds(ids);
		}
		else if(queType==2){
			questions=qd.findPanDuanQuestionByIds(ids);
		}
		else if(queType==3){
			questions=qd.findTianKongQuestionByIds(ids);
		}
		else if(queType==4){
			questions=qd.findWenDaQuestionByIds(ids);
		}
		return questions;
	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return qd.findQuestionsByCourseId(courseId);
	}
	
	@Override
	public List<Map<String, Object>> findPanDuanQuestionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return qd.findQuestionsByCourseId(courseId);
	}
	
	@Override
	public List<Map<String, Object>> findTianKongQuestionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return qd.findQuestionsByCourseId(courseId);
	}
	
	@Override
	public List<Map<String, Object>> findWenDaQuestionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return qd.findQuestionsByCourseId(courseId);
	}
	@Override
	public Map<String, Object> findPaperById(int paperId) {
		// TODO Auto-generated method stub
		return qd.findPaperById(paperId);
	}
	@Override
	public Map<String, Object> findQuestionPanDuanById(int panDuanId) {
		// TODO Auto-generated method stub
		return qd.findQuestionPanDuanById(panDuanId);
	}
	@Override
	public void updateQuestionPanDuanInfo(QuestionPanDuan questionPanDuan) {
		// TODO Auto-generated method stub
		qd.updateQuestionPanDuanInfo(questionPanDuan);
	}
	@Override
	public void deleteQuestionPanDuan(int panDuanId) {
		// TODO Auto-generated method stub
		qd.deleteQuestionPanDuan(panDuanId);
	}
	@Override
	public Map<String, Object> findQuestionTianKongById(int tianKongId) {
		// TODO Auto-generated method stub
		return qd.findQuestionTianKongById(tianKongId);
	}
	@Override
	public void updateQuestionTianKongInfo(Question q) {
		// TODO Auto-generated method stub
		qd.updateQuestionTianKongInfo(q);
	}
	@Override
	public void deleteQuestionTianKong(int tianKongId) {
		// TODO Auto-generated method stub
		qd.deleteQuestionTianKong(tianKongId);
	}
	@Override
	public Map<String, Object> findQuestionWenDaById(int wenDaId) {
		// TODO Auto-generated method stub
		return qd.findQuestionWenDaById(wenDaId);
	}
	@Override
	public void updateQuestionWenDaInfo(Question q) {
		// TODO Auto-generated method stub
		qd.updateQuestionWenDaInfo(q);
	}
	@Override
	public void deleteQuestionWenDa(int wenDaId) {
		// TODO Auto-generated method stub
		qd.deleteQuestionWenDa(wenDaId);
	}

}
