package com.sdut.examsystem.dao.teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.sdut.examsystem.dao.IQuestionDao;
import com.sdut.examsystem.po.Question;
import com.sdut.examsystem.po.QuestionPanDuan;
import com.sdut.examsystem.util.DBUtil;

public class QuestionDao implements IQuestionDao {
//	if (null != searchValue)
//		searchValue = new String(searchValue.getBytes("ISO-8859-1"), "utf-8");对乱码进行转换

	DBUtil db=new DBUtil();
	@Override
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value) {
		// TODO Auto-generated method stub
//		List<Map<String, Object>> list = null;
//		try {
//			list = db.getQueryList("select id,name,deptName from stuclass ");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
		String sql = "";
		if (key == "" ||value == "")
			sql = "SELECT que.id ,c.name, que.queTitle,que.choiceA,que.choiceB,que.choiceC,que.choiceD,que.ans from questions que, course c where que.courseId = c.id";
		else 
			/**
			 * 页面检索得到两个信息，一个是key，一个是检索的值
			 * key有2个，一个是课程科目，一个是试题题目
			 * 从页面获取的key也有两种可能。但是获取的这个key就是我们
			 * 从数据库当中查询到的字段。这两个字段一个是name,一个是queTitle
			 */
			sql = "SELECT que.id ,c.name, que.queTitle,que.choiceA,que.choiceB,que.choiceC,que.choiceD,que.ans from questions que, course c where que.courseId = c.id and " + key + " like '%" + value + "%'";
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
		try {
			queList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queList;
	}
	public List<Map<String, Object>> findAllWenDaQuestionInfo(String key, String value) {
		// TODO Auto-generated method stub
//		List<Map<String, Object>> list = null;
//		try {
//			list = db.getQueryList("select id,name,deptName from stuclass ");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
		String sql = "";
		if (key == "" ||value == "")
			sql = "SELECT que.id ,c.name, que.queTitle,que.ans from questionwenda que, course c where que.courseId = c.id";
		else 
			/**
			 * 页面检索得到两个信息，一个是key，一个是检索的值
			 * key有2个，一个是课程科目，一个是试题题目
			 * 从页面获取的key也有两种可能。但是获取的这个key就是我们
			 * 从数据库当中查询到的字段。这两个字段一个是name,一个是queTitle
			 */
			sql = "SELECT que.id ,c.name, que.queTitle,que.choiceA,que.choiceB,que.choiceC,que.choiceD,que.ans from questions que, course c where que.courseId = c.id and " + key + " like '%" + value + "%'";
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
		try {
			queList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queList;
	}
	
	public List<Map<String, Object>> findAllPanDuanQuestionInfo(String key, String value) {
		// TODO Auto-generated method stub
//		List<Map<String, Object>> list = null;
//		try {
//			list = db.getQueryList("select id,name,deptName from stuclass ");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
		String sql = "";
		if (key == "" ||value == "")
			sql = "SELECT que.id ,c.name, que.queTitle,que.ans from questionpanduan que, course c where que.courseId = c.id";
		else 
			/**
			 * 页面检索得到两个信息，一个是key，一个是检索的值
			 * key有2个，一个是课程科目，一个是试题题目
			 * 从页面获取的key也有两种可能。但是获取的这个key就是我们
			 * 从数据库当中查询到的字段。这两个字段一个是name,一个是queTitle
			 */
			sql = "SELECT que.id ,c.name, que.queTitle,que.choiceA,que.choiceB,que.choiceC,que.choiceD,que.ans from questions que, course c where que.courseId = c.id and " + key + " like '%" + value + "%'";
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
		try {
			queList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queList;
	}
	
	public List<Map<String, Object>> findAllTianKongQuestionInfo(String key, String value) {
		// TODO Auto-generated method stub
//		List<Map<String, Object>> list = null;
//		try {
//			list = db.getQueryList("select id,name,deptName from stuclass ");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
		String sql = "";
		if (key == "" ||value == "")
			sql = "SELECT que.id ,c.name, que.queTitle,que.ans from questiontiankong que, course c where que.courseId = c.id";
		else 
			/**
			 * 页面检索得到两个信息，一个是key，一个是检索的值
			 * key有2个，一个是课程科目，一个是试题题目
			 * 从页面获取的key也有两种可能。但是获取的这个key就是我们
			 * 从数据库当中查询到的字段。这两个字段一个是name,一个是queTitle
			 */
			sql = "SELECT que.id ,c.name, que.queTitle,que.choiceA,que.choiceB,que.choiceC,que.choiceD,que.ans from questions que, course c where que.courseId = c.id and " + key + " like '%" + value + "%'";
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
		try {
			queList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queList;
	}
	@Override
	public void addQuestion(Question q) {
		// TODO Auto-generated method stub
		if(q.getQueType()==1)
		{
			String sql = "insert into questions(queType,queExist,queTitle,choiceA,choiceB,choiceC,choiceD,ans,courseId) values (?,?,?,?,?,?,?,?,?)";
		try {
			//System.out.println("111");
			db.execute(sql, new Object[]{q.getQueType(),1,q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns(),q.getCourseId()});
			//System.out.println("111");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		else if(q.getQueType()==2)
		{
			String sql = "insert into questionwenda(queType,queTitle,ans,courseId) values (?,?,?,?)";
			try {
				//System.out.println("11"+q.getQueType()+q.getQueTitle()+q.getAns()+q.getCourseId());
				db.execute(sql, new Object[]{q.getQueType(),q.getQueTitle(),q.getAns(),q.getCourseId()});
				//System.out.println("111");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(q.getQueType()==3)
		{
			String sql = "insert into questionpanduan(queType,queTitle,ans,courseId) values (?,?,?,?)";
			try {
				//System.out.println("11"+q.getQueType()+q.getQueTitle()+q.getAns()+q.getCourseId());
				db.execute(sql, new Object[]{q.getQueType(),q.getQueTitle(),q.getAns(),q.getCourseId()});
				//System.out.println("111");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(q.getQueType()==4)
		{
			String sql = "insert into questiontiankong(queType,queTitle,ans,courseId) values (?,?,?,?)";
			try {
				//System.out.println("11"+q.getQueType()+q.getQueTitle()+q.getAns()+q.getCourseId());
				db.execute(sql, new Object[]{q.getQueType(),q.getQueTitle(),q.getAns(),q.getCourseId()});
				//System.out.println("111");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		// TODO Auto-generated method stub
		Map<String, Object> list=null;
		try {
			String sql="select q.id,c.name,q.queTitle,q.choiceA,q.choiceB,q.choiceC,q.choiceD,q.ans,q.courseId from course c,questions q where q.id=? and q.courseId=c.id";
		list=db.getObject(sql,new Object[]{id});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}

	@Override
	public List<Map<String, Object>> findQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		String sql ="select * from questions where FIND_IN_SET(questions.id,?)";
		List<Map<String, Object>> list=null;
		try {
		list = db.getQueryList(sql, new Object[]{ids});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Map<String, Object>> findPanDuanQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		String sql ="select * from questionpanduan where FIND_IN_SET(questionpanduan.id,?)";
		List<Map<String, Object>> list=null;
		try {
		list = db.getQueryList(sql, new Object[]{ids});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Map<String, Object>> findTianKongQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		String sql ="select * from questiontiankong where FIND_IN_SET(questiontiankong.id,?)";
		List<Map<String, Object>> list=null;
		try {
		list = db.getQueryList(sql, new Object[]{ids});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Map<String, Object>> findWenDaQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		String sql ="select * from questionwenda where FIND_IN_SET(questionwenda.id,?)";
		List<Map<String, Object>> list=null;
		try {
		list = db.getQueryList(sql, new Object[]{ids});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateQuestionInfo(Question q) {
		// TODO Auto-generated method stub
		String sql = "update questions set queType=?,queExist=?,queTitle=?,choiceA=?,choiceB=?,choiceC=?,choiceD=?, ans=?,courseId=?  where id=?";
		try {
			db.execute(sql, new Object[]{q.getQueType(),q.getQueExist(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns(),q.getCourseId(),q.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
//		String sql = "select * from question where courseId="+courseId;
//		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
//		try {
//			queList = db.getQueryList(sql);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return queList;
		String sql = "select * from questions where courseId = ? order by id desc";
		List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
		try {
			map = db.getQueryList(sql, new Object[] { courseId });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;

	}

	@Override
	public List<Map<String, Object>> findPanDuanQuestionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
//		String sql = "select * from question where courseId="+courseId;
//		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
//		try {
//			queList = db.getQueryList(sql);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return queList;
		String sql = "select * from questionpanduan where courseId = ? order by id desc";
		List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
		try {
			map = db.getQueryList(sql, new Object[] { courseId });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;

	}
	
	@Override
	public List<Map<String, Object>> findTianKongQuestionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
//		String sql = "select * from question where courseId="+courseId;
//		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
//		try {
//			queList = db.getQueryList(sql);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return queList;
		String sql = "select * from questiontiankong where courseId = ? order by id desc";
		List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
		try {
			map = db.getQueryList(sql, new Object[] { courseId });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;

	}
	@Override
	public List<Map<String, Object>> findWenDaQuestionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
//		String sql = "select * from question where courseId="+courseId;
//		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
//		try {
//			queList = db.getQueryList(sql);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return queList;
		String sql = "select * from questionwenda where courseId = ? order by id desc";
		List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
		try {
			map = db.getQueryList(sql, new Object[] { courseId });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;

	}
	
	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		String sql="delete from questions where id=?";
		try {
			db.execute(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Map<String, Object>> collectQuestions(int queType,int courseId, int num) {
		// TODO Auto-generated method stub
		QuestionDao qd=new QuestionDao();
		List newQuesList = new ArrayList();
		if(queType==1)
		{
		List questionList = qd.findQuestionsByCourseId(courseId);
		if (null == questionList)
			return new ArrayList<Map<String, Object>>();
		// shuffle方法是对集合的对象打乱顺序
		Collections.shuffle(questionList);
		if (questionList.size() <= num)
			return questionList;
		
		for (int i = 0; i < num; i++) {
			newQuesList.add(questionList.get(i));
		}
		
		}
		else if(queType==2){
			List questionList = qd.findPanDuanQuestionsByCourseId(courseId);
			if (null == questionList)
				return new ArrayList<Map<String, Object>>();
			// shuffle方法是对集合的对象打乱顺序
			Collections.shuffle(questionList);
			if (questionList.size() <= num)
				return questionList;
			
			for (int i = 0; i < num; i++) {
				newQuesList.add(questionList.get(i));
			}
		}
		else if(queType==3){
			List questionList = qd.findTianKongQuestionsByCourseId(courseId);
			if (null == questionList)
				return new ArrayList<Map<String, Object>>();
			// shuffle方法是对集合的对象打乱顺序
			Collections.shuffle(questionList);
			if (questionList.size() <= num)
				return questionList;
			
			for (int i = 0; i < num; i++) {
				newQuesList.add(questionList.get(i));
			}
		}
		else if(queType==4){
			List questionList = qd.findWenDaQuestionsByCourseId(courseId);
			if (null == questionList)
				return new ArrayList<Map<String, Object>>();
			// shuffle方法是对集合的对象打乱顺序
			Collections.shuffle(questionList);
			if (questionList.size() <= num)
				return questionList;
			
			for (int i = 0; i < num; i++) {
				newQuesList.add(questionList.get(i));
			}
		}
		return newQuesList;
	}

	@Override
	public String testQuestionIds(List<Map<String, Object>> question) {
		// TODO Auto-generated method stub
		StringBuffer s=new StringBuffer();
		for(int i=0;i<question.size();i++){
			if(i<question.size()-1)
			s.append(question.get(i).get("id")+",");
			else {
				s.append(question.get(i).get("id"));
			}
		}
		return s.toString();
	}
	@Override
	public Map<String, Object> findPaperById(int paperId) {
		// TODO Auto-generated method stub
		Map<String, Object> list=null;
		try {
			String sql="select * from papers where papers.id=?";
		list=db.getObject(sql,new Object[]{paperId});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}
	@Override
	public Map<String, Object> findQuestionPanDuanById(int panDuanId) {
		// TODO Auto-generated method stub
		Map<String, Object> list=null;
		try {
			String sql="select * from questionpanduan where id=?";
		list=db.getObject(sql,new Object[]{panDuanId});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}
	@Override
	public void updateQuestionPanDuanInfo(QuestionPanDuan q) {
		// TODO Auto-generated method stub
		String sql = "update questionpanduan set queType=?,queTitle=?, ans=?,courseId=?  where id=?";
		try {
			db.execute(sql, new Object[]{q.getQueType(),q.getQueTitle(),q.getAns(),q.getCourseId(),q.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteQuestionPanDuan(int panDuanId) {
		// TODO Auto-generated method stub
		String sql="delete from questionpanduan where id=?";
		try {
			db.execute(sql, new Object[]{panDuanId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Map<String, Object> findQuestionTianKongById(int tianKongId) {
		// TODO Auto-generated method stub
		Map<String, Object> list=null;
		try {
			String sql="select * from questiontiankong where id=?";
		list=db.getObject(sql,new Object[]{tianKongId});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}
	@Override
	public void updateQuestionTianKongInfo(Question q) {
		// TODO Auto-generated method stub
		String sql = "update questiontiankong set queType=?,queTitle=?, ans=?,courseId=?  where id=?";
		try {
			db.execute(sql, new Object[]{q.getQueType(),q.getQueTitle(),q.getAns(),q.getCourseId(),q.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteQuestionTianKong(int tianKongId) {
		// TODO Auto-generated method stub
		String sql="delete from questiontiankong where id=?";
		try {
			db.execute(sql, new Object[]{tianKongId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Map<String, Object> findQuestionWenDaById(int wenDaId) {
		// TODO Auto-generated method stub
		Map<String, Object> list=null;
		try {
			String sql="select * from questionwenda where id=?";
		list=db.getObject(sql,new Object[]{wenDaId});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}
	@Override
	public void updateQuestionWenDaInfo(Question q) {
		// TODO Auto-generated method stub
		String sql = "update questionwenda set queType=?,queTitle=?, ans=?,courseId=?  where id=?";
		try {
			db.execute(sql, new Object[]{q.getQueType(),q.getQueTitle(),q.getAns(),q.getCourseId(),q.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteQuestionWenDa(int wenDaId) {
		// TODO Auto-generated method stub
		String sql="delete from questionwenda where id=?";
		try {
			db.execute(sql, new Object[]{wenDaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
