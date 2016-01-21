<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
 <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

</head>

<body>
	
    <table cellpadding="0" cellspacing="0" width="100%" height="30" border="0" style="position:absolute; left:0px; bottom:0px;font-size:12px;">
        <tr style="background-color:rgb(180,202,205);">
        	<td colspan="2" height="30" align="center">
            	债转管理平台&nbsp;&nbsp;CopyRight2013&nbsp;&nbsp;技术支持&nbsp;北京智蓝信息科技有限公司
            </td>
        </tr>
    </table>

</body>
</html>
