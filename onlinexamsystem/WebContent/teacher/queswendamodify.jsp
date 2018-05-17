<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="<%=basePath %>/common/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=basePath %>/common/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="<%=basePath %>/common/kindeditor/lang/jquery.min.js"></script>
<script charset="utf-8" src="<%=basePath %>/common/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="<%=basePath %>/common/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=basePath %>/common/kindeditor/plugins/code/prettify.js"></script>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
KindEditor.ready(function(K) {
            var editor1 = K.create('textarea[name="queTitle"]', {
                cssPath : '<%=basePath %>/common/kindeditor/plugins/code/prettify.css',
                uploadJson : '<%=basePath %>/common/kindeditor/jsp/upload_json.jsp',
                fileManagerJson : '<%=basePath %>/common/kindeditor/jsp/file_manager_json.jsp',
                allowFileManager : true,
                autoHeightMode : true,
                afterCreate : function() {
                    var self = this;
                    K.ctrl(document, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                    K.ctrl(self.edit.doc, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                }
            });
            var editor2 = K.create('textarea[name="ans"]', {
                cssPath : '<%=basePath %>/common/kindeditor/plugins/code/prettify.css',
                uploadJson : '<%=basePath %>/common/kindeditor/jsp/upload_json.jsp',
                fileManagerJson : '<%=basePath %>/common/kindeditor/jsp/file_manager_json.jsp',
                allowFileManager : true,
                autoHeightMode : true,
                afterCreate : function() {
                    var self = this;
                    K.ctrl(document, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                    K.ctrl(self.edit.doc, 13, function() {
                        self.sync();
                        document.forms['example'].submit();
                    });
                }
            });
            prettyPrint();
        });

</script>
<style>
p {
	text-indent: 2em;
}

textarea {
	　　resize: none;
}

.text2 {
	width: 1000px;
	line-height: 40px;
	font-size: 16px;
	font-family: Arial, "宋体";
	margin: 0 auto;
	margin-top: 20px;
}
</style>
</head>

<body>
	<div class="text2">
		<form id="form1" name="form1" method="post"
			action="QuestionWenDaModifyServlet" onsubmit="return verInput();">
			<input type="hidden" name = "id" value = "${questionMap.id}"/>
			<table border="0" align="center" class="word_darkGrey">
				<tr>
					<td width="100">科目：</td>
					<td><select name="courseId" id="courseId">
							<c:forEach var="course" items="${courseList}">
								<option value="${course.id}">${course.name}</option>
							</c:forEach>
					</select></td>
					<td align="center">&nbsp;</td>
				</tr>
				<tr>
					<td>题目类型：</td>
					<td><select name="queType" id="queType"
						onclick="selectChoice();">
							<option value="2" selected="selected">问答题</option>
							<!-- <option value="2">多项选择</option>
          <option value="3">判断对错</option> -->
					</select></td>
					<td align="center">&nbsp;</td>
				</tr>
				<tr>
					<td valign="top">题目：</td>
					<td><label> <textarea id="queTitle" name="queTitle" cols="100" rows="5" style="width:750px;height:260px;visibility:hidden;float:left;">${testQuestions.paperTitle}${questionMap.queTitle}</textarea>
					</label></td>
					<td width="182" align="center">&nbsp;</td>
				</tr>
				<tr>
					<td valign="top">正确答案：</td>
					<td><label> 
					<textarea id="ans" name="ans" cols="100" rows="5" style="width:750px;height:260px;visibility:hidden;float:left;">${testQuestions.paperTitle}${questionMap.ans}</textarea>
					</label></td>
					<td><font color="#FF0000" size="-1"><div id="ans_hint"></div></font></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><label> <input
							type="submit" name="button" class="btn_grey" id="button"
							value="修改试题" />
					</label></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>