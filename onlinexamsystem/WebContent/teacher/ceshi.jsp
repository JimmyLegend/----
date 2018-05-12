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
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增试题</title>
<!-- web编辑器str -->
<link rel="stylesheet" href="<%=basePath %>/common/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=basePath %>/common/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="<%=basePath %>/common/kindeditor/lang/jquery.min.js"></script>
<script charset="utf-8" src="<%=basePath %>/common/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="<%=basePath %>/common/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=basePath %>/common/kindeditor/plugins/code/prettify.js"></script>
<!-- web编辑器end -->

<script type="text/javascript">
KindEditor.ready(function(K) {
            var editor1 = K.create('textarea[name="paperTitle"]', {
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
</head>
<body>

    <div class="control-group" >
    <form id="form1" name="form1" method="post"
			action="ceshi" onsubmit="return verInput();">
        <label class="control-label" style="float:left;">
                试题题目：
        </label>
        <textarea id="paperTitle" name="paperTitle" cols="100" rows="5" style="width:750px;height:260px;visibility:hidden;float:left;">${testQuestions.paperTitle}</textarea>
         <div class="clear"></div>
         <label> <input type="submit" name="button" class="btn_grey" id="button" value="增加试题" />
		</label>
         </form>
    </div>
<span class="mathquill-rendered-math" style="font-size:20px;"><span class="textarea"></span><span class="fraction non-leaf"><span class="numerator">a</span><span class="denominator">b</span><span>&nbsp;</span></span></span><span>&nbsp;</span>
</body>
</html>