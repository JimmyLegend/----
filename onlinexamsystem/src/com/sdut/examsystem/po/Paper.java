package com.sdut.examsystem.po;

import java.util.Date;

public class Paper {
	int id;
	int testId;
	int courseId;	
	String time;
	double score;
	double panduanscore;
	double tiankongscore;
	double wendascore;
	double totalscore;
	String wrongQueId;
	String wrongAns;
	String wrongpanduanqueid;
	String wrongpanduanans;
	String wrongtiankongqueid;
	String wrongtiankongans;
	String wendaans;
	int studentId;
	String  date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getWrongQueId() {
		return wrongQueId;
	}
	public void setWrongQueId(String wrongQueId) {
		this.wrongQueId = wrongQueId;
	}
	public String getWrongAns() {
		return wrongAns;
	}
	public void setWrongAns(String wrongAns) {
		this.wrongAns = wrongAns;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public double getPanDuanScore() {
		return panduanscore;
	}
	public void setPanDuanScore(double panduanscore) {
		this.panduanscore = panduanscore;
	}
	public double getTianKongScore() {
		return tiankongscore;
	}
	public void setTianKongScore(double tiankongscore) {
		this.tiankongscore = tiankongscore;
	}
	public double getWenDaScore() {
		return wendascore;
	}
	public void setWenDaScore(double wendascore) {
		this.wendascore = wendascore;
	}
	public double getTotalScore() {
		return totalscore;
	}
	public void setTotalScore(double totalscore) {
		this.totalscore = totalscore;
	}
	public String getPanDuanWrongQueId() {
		return wrongpanduanqueid;
	}
	public void setPanDuanWrongQueId(String wrongpanduanqueid) {
		this.wrongpanduanqueid = wrongpanduanqueid;
	}
	public String getPanDuanWrongAns() {
		return wrongpanduanans;
	}
	public void setPanDuanWrongAns(String wrongpanduanans) {
		this.wrongpanduanans = wrongpanduanans;
	}
	public String getTianKongWrongQueId() {
		return wrongtiankongqueid;
	}
	public void setTianKongWrongQueId(String wrongtiankongqueid) {
		this.wrongtiankongqueid = wrongtiankongqueid;
	}
	public String getTianKongWrongAns() {
		return wrongtiankongans;
	}
	public void setTianKongWrongAns(String wrongtiankongans) {
		this.wrongtiankongans = wrongtiankongans;
	}
	public String getWenDaAns() {
		return wendaans;
	}
	public void setWenDaAns(String wendaans) {
		this.wendaans = wendaans;
	}
}
