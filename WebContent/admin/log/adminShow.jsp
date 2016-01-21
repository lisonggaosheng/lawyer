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
  <form name="form1" method="post" action="logSelectAdminName?admin.UId=${admin.UId }">
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
            <td><div align="center">日志ID</div></td>
            <td><div align="center">日期</div></td>
            <td><div align="center">用户ID</div></td>
            <td><div align="center">用户姓名</div></td>
            <td><div align="center">用户身份</div></td>
            <td><div align="center">操作内容</div></td>
            <td><div align="center">操作对象</div></td>
          </tr>
            <s:iterator id="log" value="pageBean.list">
          <tr>
            <td><div align="center"> <s:property value="#log.logId"/></div></td>
            <td><div align="center"><s:property value="#log.logDate"/></div></td>
            <td><div align="center"><s:property value="#log.logUid"/></div></td>
            <td><div align="center"><s:property value="#log.logUname"/></div></td>
            <td><div align="center"><s:property value="#log.logUrole"/></div></td>
            <td><div align="center"><s:property value="#log.logContent"/></div></td>
            <td><div align="center"><s:property value="#log.logTarget"/></div></td>
          </tr>
       </s:iterator>
       <tr>
       <td colspan="8" align="center">
           共 <s:property value="pageBean.allRow"/> 条记录
        共<s:property value="pageBean.totalPage"/> 页
        当前第<s:property value="pageBean.currentPage"/>页<br/>
        <s:if test="%{pageBean.currentPage == 1}">
            第一页 上一页
        </s:if>
        <!-- 套用源代码时修改跳转的Action-->
        <s:else>
            <a href="logAdminShow?page=1">第一页</a>
            <a href="logAdminShow?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
            <a href="logAdminShow?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
            <a href="logAdminShow?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>
     	</td></tr>
        </table>
    	<br/>
  </body>
</html>
