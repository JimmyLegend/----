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
<title>增加试题</title>
<link rel="stylesheet" href="<%=basePath %>/common/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=basePath %>/common/kindeditor/plugins/code/prettify.css" />
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/js/calendar-blue.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.text2 {
	width: 700px;
	line-height: 40px;
	font-size: 16px;
	font-family: Arial, "宋体";
	margin: 0 auto;
	margin-top: 20px;
}

.paging {
	font-family: Arial, "宋体";
	font-size: 12px;
}
-->
</style>
</head>

<body onload="YearMonthDay()">
	<form id="form1" method="post" action="<%=path%>/AllQuestionQueryServlet">
		<h3 class="subTitle">
			题库管理
		</h3>	
		<br />
		<!--选择题  -->
		<table width="90%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table3">
			<tr align="center">
			<td colspan="8"><b>选择题</b></td>
			</tr>
			<tr align="center">
				<td><b>题号</b></td>
				<td><b>考试科目</b></td>
				<td><b>题型</b></td>
				<td><b>题干</b></td>
				<td><b>选项</b></td>
				<td><b>答案</b></td>
				<td><b>选择</b></td>
				<!-- <input type="checkbox" name="Bike"> -->
			</tr>
			<c:forEach var="que" items="${xuanzelist}">
				<tr align="left">
					<td width="5">${que.id}</td>
					<td width="20">${que.name}</td>
					<td width="20">单选题</td>
					<td width="150">${que.queTitle}</td>
					<td width="150"><p>A. ${que.choiceA}
							&nbsp;&nbsp;&nbsp;&nbsp; B. ${que.choiceB}</p>
						<p>C. ${que.choiceC} &nbsp;&nbsp;&nbsp;&nbsp; D.
							${que.choiceD}</p></td>
					<td width="20" align="center">${que.ans}</td>
					<td width="5"><input type="checkbox" name="xuanzeid" value="${que.id}"></td>
				</tr>
			</c:forEach>
			<br>
		</table>
		
		
		<!--判断题  -->
			<br>
		<table width="90%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table3">
			<tr align="center">
			<td colspan="8"><b>判断题</b></td>
			</tr>
			<tr align="center">
				<td><b>题号</b></td>
				<td><b>考试科目</b></td>
				<td><b>题型</b></td>
				<td><b>题干</b></td>
				<td><b>答案</b></td>
				<td><b>选择</b></td>
				<!-- <input type="checkbox" name="Bike"> -->
			</tr>
			<c:forEach var="que" items="${panduanlist}">
				<tr align="left">
					<td width="5">${que.id}</td>
					<td width="10">${que.name}</td>
					<td width="10">判断题</td>
					<td width="150">${que.queTitle}</td>
					<td width="10" align="center">${que.ans}</td>
					<td width="5"><input type="checkbox" name="panduanid" value="${que.id}"></td>
				</tr>
			</c:forEach>
			<br>
		</table>
		
		
		<!--填空题  -->
			<br>
		<table width="90%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table3">
			<tr align="center">
			<td colspan="8"><b>填空题</b></td>
			</tr>
			<tr align="center">
				<td><b>题号</b></td>
				<td><b>考试科目</b></td>
				<td><b>题型</b></td>
				<td><b>题干</b></td>
				<td><b>答案</b></td>
				<td><b>选择</b></td>
				<!-- <input type="checkbox" name="Bike"> -->
			</tr>
			<c:forEach var="que" items="${tiankonglist}">
				<tr align="left">
					<td width="5">${que.id}</td>
					<td width="10">${que.name}</td>
					<td width="10">填空题</td>
					<td width="150">${que.queTitle}</td>
					<td width="40" align="center">${que.ans}</td>
					<td width="5"><input type="checkbox" name="tiankongid" value="${que.id}"></td>
				</tr>
			</c:forEach>
			<br>
		</table>
		
		
		<!--问答题  -->
			<br>
		<table width="90%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table3">
			<tr align="center">
			<td colspan="8"><b>问答题</b></td>
			</tr>
			<tr align="center">
				<td><b>题号</b></td>
				<td><b>考试科目</b></td>
				<td><b>题型</b></td>
				<td><b>题干</b></td>
				<td><b>答案</b></td>
				<td><b>选择</b></td>
				<!-- <input type="checkbox" name="Bike"> -->
			</tr>
			<c:forEach var="que" items="${wendalist}">
				<tr align="left">
					<td width="5">${que.id}</td>
					<td width="10">${que.name}</td>
					<td width="10">问答题</td>
					<td width="150">${que.queTitle}</td>
					<td width="150" align="center">${que.ans}</td>
					<td width="5"><input type="checkbox" name="wendaid" value="${que.id}"></td>
				</tr>
			</c:forEach>
			<br>
		</table>
		
		
		<br>
		<!--  <table width="90%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table3">
			<tr align="center">
			<td>
			选择：<input type="text" name="xuanze" id="xuanze" value="" />
			&nbsp;&nbsp;
			判断：<input type="text" name="panduan" id="panduan" value="" />
			&nbsp;&nbsp;
			填空：<input type="text" name="tiankong" id="tiankong" value="" />
			&nbsp;&nbsp;
			问答：<input type="text" name="wenda" id="wenda" value="" />
			&nbsp;&nbsp;
			<input type="submit" name="button" class="btn_grey" id="button" value="增加试题" />
			</td>
			</tr>
			<br>
		</table>-->
		<div class="text2">
			<p>
				<label>考试科目为： <select name="courseid" id="courseid">
						<c:forEach var="course" items="${courseList }">
							<option value="${course.id}">${course.name}</option>
						</c:forEach>
				</select>
				</label>
			</p>

			<p>
				试卷名称为： <label> <input type="text" name="testname"
					id="testname" onblur="isNotNull('testname');" />
				</label> <br />
			</p>
			<%
				Date date = new Date();
			%>
			<p>
				考试截止时间为： <label><input name="enddate" type="text"
					id="control_date" size="20" maxlength="10" readonly="readonly"
					value='' />
					 </label><br />
			</p>

			<p>
				单项选择题（共<input name="sinscores" id="sinscores" type="text" size="1"
					onblur="isNotNull('sinscores');" />分） &nbsp;&nbsp; <label><input
					name="sinnum" type="text" id="sinnum" size="5"
					onblur="isNotNull('sinnum');" /></label> 道小题 <br />
			</p>
			
			<p>
				判断题（共<input name="panduanscores" id="panduanscores" type="text" size="1"
					onblur="isNotNull('sinscores');" />分） &nbsp;&nbsp; <label><input
					name="panduannum" type="text" id="panduannum" size="5"
					onblur="isNotNull('panduannum');" /></label> 道小题 <br />
			</p>
			
			<p>
				填空题（共<input name="tiankongscores" id="tiankongscores" type="text" size="1"
					onblur="isNotNull('sinscores');" />分） &nbsp;&nbsp; <label><input
					name="tiankongnum" type="text" id="tiankongnum" size="5"
					onblur="isNotNull('tiankongnum');" /></label> 道小题 <br />
			</p>
			
			<p>
				问答题（共<input name="wendascores" id="wendascores" type="text" size="1"
					onblur="isNotNull('sinscores');" />分） &nbsp;&nbsp; <label><input
					name="wendanum" type="text" id="wendanum" size="5"
					onblur="isNotNull('wendanum');" /></label> 道小题 <br />
			</p>
			
			<p>
				考试时间：<label><input name="testtime" id="testtime" value="45"
					type="text" size="5" onblur="isNotNull('testtime')" /></label>分钟
			</p>

			<p>
				面向班级：
				<c:forEach var="stuclass" items="${classesList}">
					<input type="checkbox" name="classCheck" value="${stuclass.id}" checked="checked"/>${stuclass.name}
				</c:forEach>
			</p>
			<p align="center">
				<input type="submit" class="btn_grey" value="自动出题" />&nbsp;&nbsp;&nbsp;&nbsp;<br />
			</p>
		</div>
		</form>
		<p>
<script type="text/javascript" src="<%=path%>/js/calendar.js"></script>
<script>
Calendar.setup({
inputField : "control_date",
ifFormat : "%Y-%m-%d %H:%M:%S",
showsTime : true,
timeFormat : "24"
});
</script>
	</p>
</body>
</html>