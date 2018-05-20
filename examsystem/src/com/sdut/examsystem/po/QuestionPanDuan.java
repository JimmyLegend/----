package com.sdut.examsystem.po;

public class QuestionPanDuan {
	private int id;
	private int courseId;
	private int queType;
	private String queTitle;
	private String ans;
	// 默认是存在的，当删除的时候改变状态
	private int queExist = 1;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getQueType() {
		return queType;
	}
	public void setQueType(int queType) {
		this.queType = queType;
	}
	public String getQueTitle() {
		return queTitle;
	}
	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public int getQueExist() {
		return queExist;
	}
	public void setQueExist(int queExist) {
		this.queExist = queExist;
	}

}
