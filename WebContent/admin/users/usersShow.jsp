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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>My JSP 'show.jsp.jsp' starting page</title>
    
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
  <form name="form1" method="post" action="usersSelectName?admin.UId=${admin.UId }">
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
          <input type="submit" name="Submit" value="查询" onClick="check()">
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
            <td><div align="center">用户密码</div></td>
            <td><div align="center">用户身份</div></td>
            <td><div align="center">账户状态</div></td>
            <td><div align="center">真实名称</div></td>
            <td><div align="center">联系电话</div></td>
            
            <td><div align="center"></div></td>
            <td><div align="center"></div></td>
            <td><div align="center"></div></td>
          </tr>
            <s:iterator id="users" value="#request.list">
          <tr>
            <td><div align="center"> <s:property value="#users.UId"/></div></td>
            <td><div align="center"><s:property value="#users.UName"/></div></td>
            <td><div align="center"><s:property value="#users.UPassword"/></div></td>
            <td><div align="center"><s:property value="#users.URole"/></div></td>
            <td><div align="center"><s:property value="#users.USta"/></div></td>
            <td><div align="center"><s:property value="#users.roleName"/></div></td>
            <td><div align="center"><s:property value="#users.mobil"/></div></td>
            
            <td><div align="center"><a href="usersUpdate1?users.UId=<s:property value="#users.UId"/>">修改</a></div></td>
            <td><div align="center"><a href="updateUSta?admin.UId=${admin.UId}&users.UId=<s:property value="#users.UId"/>"><s:if test="%{#users.USta == '禁用'}">启用 </s:if><s:else>禁用</s:else></a></div></td>
          </tr>
       </s:iterator>
        </table>
    	<br/>
  </body>
</html>
