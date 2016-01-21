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
            <s:iterator id="users" value="pageBean.list">
          <tr>
            <td><div align="center"> <s:property value="#users.UId"/></div></td>
            <td><div align="center"><s:property value="#users.UName"/></div></td>
            <td><div align="center"><s:property value="#users.UPassword"/></div></td>
            <td><div align="center"><s:property value="#users.URole"/></div></td>
            <td><div align="center"><s:property value="#users.USta"/></div></td>
            <td><div align="center"><s:property value="#users.roleName"/></div></td>
            <td><div align="center"><s:property value="#users.mobil"/></div></td>
            
            <td><div align="center"><a href="usersUpdate1?users.UId=<s:property value="#users.UId"/>">修改</a></div></td>
            <!--<td><div align="center"><a href="useresDelete?admin.UId=${admin.UId}&users.UId=<s:property value="#users.UId"/>">删除</a></div></td>  -->
            
            <td><div align="center"><a href="updateUSta?admin.UId=${admin.UId}&users.UId=<s:property value="#users.UId"/>"><s:if test="%{#users.USta == '禁用'}">启用 </s:if><s:else>禁用</s:else></a></div></td>
            <td><div align="center"><a href="userlp?lp.lp_user_name=<s:property value="#users.UName"/>">权限管理</a></div></td>
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
            <a href="usersShow?page=1">第一页</a>
            <a href="usersShow?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
            <a href="usersShow?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
            <a href="usersShow?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>
     	</td></tr>
        </table>
    	<br/>
  </body>
</html>
