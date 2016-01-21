<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'applyShow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="css/public.css" rel="stylesheet" type="text/css">
  </head>
  
 <body>
  <form name="form1" method="post" action="applyDeclineShowUsers?admin.UId=${admin.UId }">
    <table width="100%" border="1">
      <tr>
        <td width="50%"><div align="right">用户名</div>
        <div align="center"></div></td>
        <td width="50%"><label>
          <input type="text" name="users.UName" id="name">
        </label></td>
      </tr>
      <tr>
        <td colspan="2"><div align="center">
          <label>
          <input type="submit" name="Submit" value="查询" >
          </label>
        </div></td>
      </tr>
    </table>
  </form>
  
  <!-- 套用源代码时修改对象字段值 -->
    	<table width="100%" border="1">
          <tr>
            <td><div align="center">用户ID</div></td>
            <td><div align="center">用户名</div></td>
            <td><div align="center">申请状态</div></td>
            <td><div align="center">申请时间</div></td>
            <td><div align="center">操作对象</div></td>
            <td><div align="center">申请的操作</div></td>
            <td><div align="center"></div></td>
            <td><div align="center"></div></td>
          </tr>
            <s:iterator id="apply" value="#request.list">
          <tr>
            <td><div align="center"> <s:property value="#apply.users.UId"/></div></td>
            <td><div align="center"><s:property value="#apply.users.UName"/></div></td>
            <td><div align="center"><s:property value="#apply.appSta"/></div></td>
            <td><div align="center"><s:property value="#apply.appDate"/></div></td>
            <td><div align="center"><s:property value="#apply.appTarget"/></div></td>
            <td><div align="center"><s:property value="#apply.appContent"/></div></td>
            <td><div align="center"><a href="applyDeclineUsers?admin.UId=${admin.UId}&apply.appId=<s:property value="#apply.appId"/>&users.UId=<s:property value="#apply.users.UId"/>">收回</a></div></td>
          </tr>
       </s:iterator>
        </table>
    	<br/>
  </body>
</html>
