<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  <style type="text/css">
<!--
.STYLE1 {font-size: 36px}
.STYLE2 {font-size: 24px}
-->
  </style>
<script language="javascript">
	function check(){
	
		var name=document.getElementById("name").value;
		var pwd=document.getElementById("pwd").value;
		if(name==""){
			 alert("用户名不能为空");
			 document.form1.action="login.jsp";
		}
		if(pwd==""){
			 alert("密码不能为空");
			 document.form1.action="login.jsp";
		}
	}
</script>
  <link href="css/public.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  <h3>${startDate}</h3>
  <form name="form1" method="post" action="usersLogin">
    <table width="100%" border="1">
      <tr>
        <td height="45" colspan="2"><div align="center" class="STYLE1">两高律师事务所</div></td>
      </tr>
      <tr>
        <td width="50%"><div align="right" class="STYLE2">用户名：</div></td>
        <td width="50%"><label>
          <input type="text" name="admin.UName" id="name">
        </label></td>
      </tr>
      <tr>
        <td><div align="right" class="STYLE2">密码：</div></td>
        <td><label>
          <input type="password" name="admin.UPassword" id="pwd">
        </label></td>
      </tr>
      <tr>
        <td colspan="2"><div align="center">
          <label>
          <input type="submit" name="Submit" value="登陆" onClick="check()">
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
