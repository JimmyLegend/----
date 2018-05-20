<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.sdut.examsystem.po.Question"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 查看试卷时候使用 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<style>
p {
	text-indent: 2em;
}
</style>
</head>

<body>
	<div id="main_content">
		<form id="form1" name="form1" method="post"
			action="<%=path%>/PaperDetailInfoServlet">
			<input type="hidden" name="id" id="id" value="${testId}"/>
			<input type="hidden" name="paperId" id="paperId" value="${paperId}"/>
			<h1>
				<center>
					试卷名称：${test.name}<br />
				</center>
			</h1>
			<h3>
				<center>
					考试科目：${courseName}<br />
					考试班级：${classNames}<br /> 考试截止时间：${test.endDate}<br />
					考试时长：${test.testTime}min<br />
					考生姓名：${studentName}<br/>
				</center>
			</h3>
			<p>
				<b>1.单项选择题</b>
			</p>
			<c:forEach var="que" items="${quesList}" varStatus="status">

				<p></p>
				<p class="text">${status.index + 1} .${que.queTitle}</p>
				<p></p>

				<p>A.${que.choiceA }</p>
				<p>B.${que.choiceB }</p>
				<p>C.${que.choiceC }</p>
				<p>D.${que.choiceD }</p>
				<p>D.${que.id }</p>
				<p>
					<font color="blue"> 正确答案：${que.ans }</font>
				</p>
				<c:set var="ans" scope="session" value="${xuanzeMap[que.id]}"/>
				<c:if test='${xuanzeMap[que.id]!=null}'>
                     <p>
                                                   答案: <font color="red"><c:out value="${ans}"/></font>
                     <p>
                </c:if>
                <c:set var="ans" scope="session" value="${que.ans}"/>
				<c:if test='${xuanzeMap[que.id]==null}'>
                     <p>
                                                   答案: <font color="blue"><c:out value="${ans}"/></font>
                     <p>
                </c:if>
			</c:forEach>
			
			<p>
				<b>2.判断题</b>
			</p>
			<c:forEach var="que" items="${quesPanDuanList}" varStatus="status">

				<p></p>
				<p class="text">${status.index + 1} .${que.queTitle}</p>
				<p></p>
				<p>
					<font color="blue"> 正确答案：${que.ans }</font>
				</p>
				
				<c:set var="ans" scope="session" value="${panduanMap[que.id]}"/>
				<c:if test="${panduanMap[que.id]!=null}">
                     <p>
                                                   答案: <font color="red"><c:out value="${ans}"/></font>
                     <p>
                </c:if>
                <c:set var="ans" scope="session" value="${que.ans}"/>
				<c:if test='${panduanMap[que.id]==null}'>
                     <p>
                                                   答案: <font color="blue"><c:out value="${ans}"/></font>
                     <p>
                </c:if>
				
			</c:forEach>
			
			
			<p>
				<b>3.填空题</b>
			</p>
			<c:forEach var="que" items="${quesTianKongList}" varStatus="status">

				<p></p>
				<p class="text">${status.index + 1} .${que.queTitle}</p>
				<p></p>
				<p>
					<font color="blue"> 正确答案：${que.ans }</font>
				</p>
				
				<c:set var="ans" scope="session" value="${tiankongMap[que.id]}"/>
				<c:if test="${tiankongMap[que.id]!=null}">
                     <p>
                                                   答案: <font color="red"><c:out value="${ans}"/></font>
                     <p>
                </c:if>
                <c:set var="ans" scope="session" value="${que.ans}"/>
				<c:if test='${tiankongMap[que.id]==null}'>
                     <p>
                                                   答案: <font color="blue"><c:out value="${ans}"/></font>
                     <p>
                </c:if>
				
			</c:forEach>
			
			
			<p>
				<b>4.问答题</b>
			</p>
			<c:forEach var="que" items="${quesWenDaList}" varStatus="status">

				<p></p>
				<p class="text">${status.index + 1} .${que.queTitle}</p>
				<p></p>
				<p>
					<font color="blue"> 正确答案：${que.ans }</font>
				</p>
				<p>
					<font color="blue">答案：${wendaans }</font>
				</p>
				
			</c:forEach>
			<p>
				问答题分数：${test.wendascores}
			</p>
			<p>
				问答得分：<input type="text" value="${wendascore}" name="wendascores" id="wendascores"/>
			</p>
			<p class="text"></p>
			<p>&nbsp;</p>
			<label>
				<center>
				    <input type="submit" name="button" id="button" class="btn_grey"
						value="确认" />
					<input type="submit" name="button" id="button" class="btn_grey"
						value="返回" />
				</center>
			</label>
		</form>
	</div>
</body>
</html>