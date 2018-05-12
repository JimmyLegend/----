package com.sdut.examsystem.po;

import java.util.Date;

public class Test {
	private int id;
	private String name;
	private int courseId;
	private int depId;//待定
	private Date endDate;
	private String quetions;
	private String panduanquetions;
	private String tiankongquetions;
	private String wendaquetions;
	private int teacherId;
	private String classIds;
	private int testTime;
	//考虑设置多个题型
	//选择分数
	private String scores;
	//判断分数
	private String panDuanScores;
	//填空分数
	private String tianKongScores;
	//问答分数
	private String wenDaScores;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getQuetions() {
		return quetions;
	}
	public void setQuetions(String quetions) {
		this.quetions = quetions;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getClassIds() {
		return classIds;
	}
	public void setClassIds(String classIds) {
		this.classIds = classIds;
	}
	public int getTestTime() {
		return testTime;
	}
	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}
	//选择
	public String getScores() {
		return scores;
	}
	public void setScores(String scores) {
		this.scores = scores;
	}
	//判断
	public String getPanDuanScores() {
		return panDuanScores;
	}
	public void setPanDuanScores(String panDuanScores) {
		this.panDuanScores = panDuanScores;
	}
	public String getPanDuanQuetions() {
		return panduanquetions;
	}
	public void setPanDuanQuetions(String panduanquetions) {
		this.panduanquetions = panduanquetions;
	}
	//填空
	public String getTianKongScores() {
		return tianKongScores;
	}
	public void setTianKongScores(String tianKongScores) {
		this.tianKongScores = tianKongScores;
	}
	public String getTianKongQuetions() {
		return tiankongquetions;
	}
	public void setTianKongQuetions(String tiankongquetions) {
		this.tiankongquetions = tiankongquetions;
	}
	//问答
	public String getWenDaScores() {
		return wenDaScores;
	}
	public void setWenDaScores(String wenDaScores) {
		this.wenDaScores = wenDaScores;
	}
	public String getWenDaQuetions() {
		return wendaquetions;
	}
	public void setWenDaQuetions(String wendaquetions) {
		this.wendaquetions = wendaquetions;
	}
}
