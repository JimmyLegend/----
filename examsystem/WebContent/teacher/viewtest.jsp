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
<link rel="stylesheet" href="<%=basePath %>/common/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=basePath %>/common/kindeditor/plugins/code/prettify.css" />
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<style>
p {
	text-indent: 2em;
}
</style>
<script type="text/javascript">
function startPrint(obj) 
{ 
    var oWin=window.open("","_blank"); 
    var strPrint="<h4 style='font-size:18px; text-align:center;'>打印预览区</h4>\n"; 
     
    strPrint=strPrint + "<script type=\"text/javascript\">\n"; 
    strPrint=strPrint + "function printWin()\n"; 
    strPrint=strPrint + "{"; 
    strPrint=strPrint +    "var oWin=window.open(\"\",\"_blank\");\n"; 
    strPrint=strPrint + "oWin.document.write(document.getElementById(\"content\").innerHTML);\n"; 
    strPrint=strPrint + "oWin.focus();\n"; 
    strPrint=strPrint + "oWin.document.close();\n"; 
    strPrint=strPrint + "oWin.print()\n"; 
    strPrint=strPrint + "oWin.close()\n"; 
    strPrint=strPrint + "}\n"; 
    strPrint=strPrint + "<\/script>\n"; 
     
    strPrint=strPrint + "<hr size='1' />\n"; 
    strPrint=strPrint + "<div id=\"content\">\n"; 
    strPrint=strPrint + obj.innerHTML + "\n"; 
    strPrint=strPrint + "</div>\n"; 
    strPrint=strPrint + "<hr size='1' />\n"; 
    strPrint=strPrint + "<div style='text-align:center'><button onclick='printWin()' style='padding-left:4px;padding-right:4px;'>打 印</button><button onclick='window.opener=null;window.close();' style='padding-left:4px;padding-right:4px;'>关 闭</button></div>\n"; 
    oWin.document.write(strPrint); 
    oWin.focus(); 
    oWin.document.close(); 
} 
</script> 
</head>

<body>
	<div id="main_content">
		<form id="form1" name="form1" method="post"
			action="<%=path%>/testQueryServlet">
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
				<p>
					<font color="blue"> 正确答案：${que.ans }</font>
				</p>
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
			</c:forEach>

			<p class="text"></p>
			<p>&nbsp;</p>
			<label>
				<center>
					<input type="submit" name="button" id="button" class="btn_grey"
						value="返回" />
				</center>
			</label>
		</form>
	</div>
	<button id="btnPrint" onclick="startPrint(document.getElementById('main_content'))">打印内容</button>
</body>
</html>