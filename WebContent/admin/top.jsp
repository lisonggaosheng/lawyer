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
<title>两高律师办公系统|欢迎登录</title>
<script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>
<style>
.menu_div{font-size:16px; height:40px; padding-left:10px; padding-right:10px; float:left;text-align:center; line-height:40px; cursor:pointer; font-family:Microsoft YaHei;}
/*.menu_div:hover{ background-color:rgb(37,131,231);}
*/
.hide{display:none;}
.hide a{ color:white; text-decoration:underline;}
</style>
<script type="text/javascript">
function hideOpt(){
	$(".menu_div").css({"color":"black","background-color":"rgb(180,202,205)"});	
	$(".hide").hide();	
}

function vali(){
	if(confirm("确认备份数据库么？")){
		location.href="backupDB";
	}
}


$(document).ready(function(){
	$("#userMag").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_userMag").show();						
	});		
	$("#journalMag").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_journalMag").show();
	});	
	$("#informationBackups").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_informationBackups").show();
	});
});
</script>
</head>

<body>
	
    <table cellpadding="0" cellspacing="0" width="100%" height="70" border="0" style="position:absolute; left:0px; top:0px;font-size:12px;">
    	<tr style="background-color:rgb(180,202,205);">
        	<td height="40" width="160" valign="middle" align="center">
            	<span style="font-size:14px; font-weight:700; width:150px; height:100%; text-align:center;margin-left:10px;">欢迎：${admin.UName }</span>
            </td>
            <td>
                <span class="menu_div" id="userMag">用户管理</span>
                <span class="menu_div" id="journalMag">日志管理</span>
                <span class="menu_div" id="informationBackups">数据备份</span>
            </td>
            <td width="50">
            	<a href="usersQuit?admin.UId=${admin.UId }" style=" font-size:16px;color:white; font-family:Microsoft YaHei; font-weight:700;" target="_top">退出</a>
            </td>
        </tr>
        <tr height="30" style="background-color:rgb(37,131,231); color:white; font-size:14px;">
      	<td width="100">&nbsp;</td>   
            	<td colspan="2">
                <span id="con_userMag" style="margin-left:10px;" class="hide">
                	<a href="admin/users/insertUsers.jsp" target="content">新建用户</a>&nbsp;&nbsp;
                    <a href="usersShow?admin.UId=${admin.UId}" target="content">查询用户</a>
                </span>
                <span id="con_journalMag" style="margin-left:80px;" class="hide">&nbsp;&nbsp;
                	<a href="logUersShow?admin.UId=${admin.UId}" target="content">用户操作日志</a>
					<a href="logAdminShow?admin.UId=${admin.UId}" target="content">管理员操作记录</a>
                </span>
        		<span id="con_informationBackups" style="margin-left:150px;" class="hide">
                	<a href="javascript:vali()">备份整个数据库数据</a>&nbsp;&nbsp;
                    <a href="admin/uploadDB.jsp" target="content">还原数据库数据</a>
                </span>
            </td>
        </tr>
    </table>

</body>
</html>
