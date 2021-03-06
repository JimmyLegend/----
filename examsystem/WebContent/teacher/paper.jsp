<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<title>无标题文档</title>
<style>
</style>
<script>
	history.go(1);//屏蔽回退
	document.oncontextmenu = function(e) {
		if (e == null)
			e = window.event;
		e.cancelBubble = true;
		e.returnValue = false;
		return true;//右键屏蔽
	};
</script>
</head>

<body>
	<h3 class="subTitle">近期考试</h3>
	<br />
	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table3">
		<tr align="center">
		    <td width="81"><b>考生姓名</b></td>
			<td><b>考试科目</b></td>
			<td><b>考试名称</b></td>
			<td><b>考试截止时间</b></td>
			<td><b>考试时长</b></td>
			<td><b>考试对象</b></td>
			<td><b>考试分值</b></td>
		</tr>
		<c:forEach var="papers" items="${papersList }">
			<tr align="center">
			    <td width="81"><a href = '<%=path%>/PaperDetailInfoServlet?paperId=${papers.id}&testId=${papers.testId}&studentId=${papers.studentId}'>${papers.studentName }</a></td>
				<td>${papers.courseName }</td>
				<td>${papers.testName }</td>
				<td>${papers.endDate }</td>
				<td>${papers.testTime }</td>
				<td>${papers.className}</td>
				<td>${papers.totalScore }</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>