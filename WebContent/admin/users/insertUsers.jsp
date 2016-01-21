<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insertUsers.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
   <link href="css/public.css" rel="stylesheet" type="text/css">
    <style type="text/css">
<!--
.STYLE1 {font-size: 36px}
-->
    </style>
	<script language="javascript">
		function check(){
			var name=document.getElementById("name").value;
			var pwd=document.getElementById("pwd").value;
			var pwd2=document.getElementById("pwd2").value;
			var roleName=document.getElementById("roleName").value;
			var mobile=document.getElementById("mobile").value;
			
			if(name==""){
				alert("用户名不能为空");
				return false;
				//document.form1.action="admin/users/insertUsers.jsp";
			}
			if(pwd=="" || pwd2==""){
				alert("密码不能为空");
				return false;
			}
			 if(pwd!=pwd2){
				alert("两次密码输入不一致");
				return false;
			}
			if(roleName==""){
				alert("真实名称不能为空");
				return false;
			}
			if(mobile==""){
				alert("真实名称不能为空");
				return false;
			}
			 if(mobile.length!=11)
        	{
             	alert("请输入有效的手机号码！");
             	return false;
            }
			
			document.getElementById("userform").submit();
		}
	</script>
</head>
  
  <body >
  <form name="form1" id="userform" method="post" action="insertUsers?admin.UId=${admin.UId }">
    <table width="100%" border="1">
      <tr>
        <td colspan="2"><div align="center" class="STYLE1">添加新用户</div></td>
      </tr>
      <tr>
        <td width="50%"><div align="right">用户名：</div></td>
        <td width="50%"><label>
          <input type="text" name="users.UName" id="name" >
        </label></td>
      </tr>
      <tr>
        <td><div align="right">密码：</div></td>
        <td><input type="password" name="users.UPassword" id="pwd"></td>
      </tr>
      <tr>
        <td><div align="right">确认密码：</div></td>
        <td><input type="password" name="textfield3" id="pwd2"></td>
      </tr>
      <tr>
        <td><div align="right">用户身份：</div></td>
        <td>
	        <label>
	          <input type="radio"  name="users.URole" value="管理员" id="role">管理员
	        </label> 
         <label>
          	<input type="radio" name="users.URole"  value="普通用户" id="role" checked="checked">普通用户
        </label>
        <label>
          	<input type="radio" name="users.URole"  value="办案律师" id="role">办案律师
        </label>
        </td>
      </tr>
      <tr>
        <td><div align="right">账户状态：</div></td>
        <td><label>
          <input type="radio" name="users.USta" value="启用" id="sta" checked="checked">启用
        </label>
          <label>
          <input type="radio" name="users.USta" value="禁用" id="sta"> 禁用</label>
          </td>
      </tr>
      <tr>
        <td><div align="right">真实名称：</div></td>
        <td><input type="text" name="users.roleName" id="roleName" ></td>
      </tr>
      <tr>
        <td><div align="right">联系电话：</div></td>
        <td><input type="text" name="users.mobile" id="mobile" ></td>
      </tr>
      
      <tr>
        <td colspan="2"><div align="center">
          <input type="button" name="Submit" value="添加" onClick="check()">
          <label>
          <input type="reset" name="Submit2" value="重置">
          </label>
        </div></td>
      </tr>
    </table>
  </form>
  	
  </body>
</html>
