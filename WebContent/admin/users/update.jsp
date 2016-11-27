<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href="css/public.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  <form name="form1" method="post" action="usersUpdate2?users.UId=${users.UId }&admin.UId=${admin.UId}">
    <table width="100%" border="1">
      <tr>
        <td width="50%"><div align="right">用户名：</div></td>
        <td width="50%"><label>
          <input type="text" readonly="readonly" name="users.UName" value="${users.UName }">
        </label></td>
      </tr>
      <tr>
        <td><div align="right">用户密码：</div></td>
        <td><input type="text" name="users.UPassword" value="${users.UPassword }"></td>
      </tr>
      <tr>
        <td><div align="right">用户身份：</div></td>
        <td>
        	<c:if test="${users.URole=='普通用户'}">
		        <label>
		          <input type="radio"  name="users.URole" value="管理员" id="role">管理员
		        </label>
		        <label>  
		          <input type="radio" name="users.URole"  value="普通用户" id="role" checked="checked">普通用户
		        </label>
		        <label>
		          <input type="radio"  name="users.URole" value="办案律师" id="role">办案律师
		        </label>
		        <label>
		          <input type="radio"  name="users.URole" value="市场办案律师" id="role">市场办案律师
		        </label>
	        </c:if>
	        <c:if test="${users.URole=='管理员'}">
		        <label>
		          <input type="radio"  name="users.URole" value="管理员" id="role" checked="checked">管理员
		        </label>
		        <label>  
		          <input type="radio" name="users.URole"  value="普通用户" id="role" >普通用户
		        </label>
		        <label>
		          <input type="radio"  name="users.URole" value="办案律师" id="role">办案律师
		        </label>
		        <label>
		          <input type="radio"  name="users.URole" value="市场办案律师" id="role">市场办案律师
		        </label>
	        </c:if>
	        <c:if test="${users.URole=='办案律师'}">
		        <label>
		          <input type="radio"  name="users.URole" value="管理员" id="role">管理员
		        </label>
		        <label>  
		          <input type="radio" name="users.URole"  value="普通用户" id="role">普通用户
		        </label>
		        <label>
		          <input type="radio"  name="users.URole" value="办案律师" id="role" checked="checked">办案律师
		        </label>
		        <label>
		          <input type="radio"  name="users.URole" value="市场办案律师" id="role">市场办案律师
		        </label>
	        </c:if>
	        <c:if test="${users.URole=='市场办案律师'}">
		        <label>
		          <input type="radio"  name="users.URole" value="管理员" id="role">管理员
		        </label>
		        <label>  
		          <input type="radio" name="users.URole"  value="普通用户" id="role">普通用户
		        </label>
		        <label>
		          <input type="radio"  name="users.URole" value="办案律师" id="role" >办案律师
		        </label>
		        <label>
		          <input type="radio"  name="users.URole" value="市场办案律师" id="role" checked="checked">市场办案律师
		        </label>
	        </c:if>
        </td>
      </tr>
      <tr>
        <td><div align="right">账号状态：</div></td>
        <td>
        	<c:if test="${users.USta=='启用'}">
		        <label>
		          <input type="radio" name="users.USta" value="启用" id="sta" checked="checked">启用
		        </label>
		        <label>
		          <input type="radio" name="users.USta" value="禁用" id="sta">禁用
		        </label>
		    </c:if>
		    <c:if test="${users.USta=='禁用'}">
		        <label>
		          <input type="radio" name="users.USta" value="启用" id="sta" >启用
		        </label>
		        <label>
		          <input type="radio" name="users.USta" value="禁用" id="sta" checked="checked">禁用
		        </label>
		    </c:if>
        </td>
      </tr>
      <tr>
        <td><div align="right">真实名称：</div></td>
        <td><input type="text" name="users.roleName" value="${users.roleName }"></td>
      </tr>
      <tr>
        <td><div align="right">联系电话：</div></td>
        <td><input type="text" name="users.mobile" value="${users.mobile }"></td>
      </tr>
      
      <tr>
        <td colspan="2"><div align="center">
          <label>
          <input type="submit" name="Submit" value="修改">
          </label>
          <label>
          <input type="reset" name="Submit2" value="重置">
          </label>
        </div></td>
      </tr>
    </table>
  </form>
  
  </body>
</html>
