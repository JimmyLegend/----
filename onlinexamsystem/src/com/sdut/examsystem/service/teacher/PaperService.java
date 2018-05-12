package com.sdut.examsystem.service.teacher;

import java.util.List;

import com.sdut.examsystem.dao.teacher.PapersDao;
import com.sdut.examsystem.po.Paper;
import com.sdut.examsystem.service.IPaperService;

public class PaperService implements IPaperService {
PapersDao pd=new PapersDao();
	@Override
	public int save(Paper paper) {
		// TODO Auto-generated method stub
		return pd.save(paper);
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return pd.getPaperByStudentId(studentId);
	}

	@Override
	public List getPaperCompare(int teaId) {
		// TODO Auto-generated method stub
		return pd.getPaperCompare(teaId);
	}

}
