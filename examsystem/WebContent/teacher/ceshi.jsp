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
<style type="text/css"> 
body{ 
font-size:12px; 
color:#333; 
} 
#content{ 
border:solid 1px #333; 
background:#ffc; 
} 
</style> 
<script type="text/javascript"> 
///*********************** 
///打印指定区域页面 
///说明：obj--通过getElementById或其它方式获取标签标识，打印此obj内的文字 
///开发：王洪剑 
///日期：2009-8-7 
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
<body onpaste="return false" onselectstart="return false">

    <button id="btnPrint" onclick="startPrint(document.getElementById('content'))">打印内容</button> 
<div id="content"> 
    <div style="font-size:12px;color:#333;"> 
    这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容这里是打印内容 
    </div> 
</div> 
</body>
</html>