<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>无标题文档</title>
		<script language="javascript">
	function addcheck(){	
		var name=document.getElementById("flName").value;
		var category=document.getElementById("flCategory").value;
		if(name==""){
			 alert("文件库名不能为空");
			 return;
		}
		if(category==""){
			 alert("文件库类别不能为空");
			 return;
		}
		else{
			fl.submit();
			}
	}
</script>
		<link rel="stylesheet" href="/lawyer/css/public.css" />
	</head>
	<body>
		<table cellspacing="0" cellpadding="0" border="0" width="100%"
			height="100%" class="content_table">
			<tr>
				<td width="15%" colspan="2">
					&nbsp;&nbsp;
					<img src="/lawyer/images/flag3_(add)_16x16.gif" />
					&nbsp;
					<span class="title">新建文件库</span>
				</td>
			</tr>
			<tr>
				<td width="50%">
					<form name="fl" method="post" action="filelibrary-add"  >
						<table width="90%" cellspacing="0" cellpadding="0" border="0" align="right" class="form_table">
							<tr>
								<td width="11%" align="right">文件库名：</td>
								<td ><input type="text" id="flName" name="filelibrary.flName" /> </td>
							</tr>
							<tr>
								<td align="right">文件库类别：</td>
								<td><input type="text" id="flCategory" name="filelibrary.flCategory" /></td>
							</tr>
							<tr>
								<td align="right">备注：</td>
								<td><textarea  id="beizhu" name="filelibrary.beizhu" rows="5" cols="50"></textarea></td>
							</tr>
							<tr>
								<td colspan="2" align="left">
  <input type="button" value="保存" onclick="addcheck()"/>
  &nbsp;&nbsp;
  <input type="reset" value="清空" /></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>

	</body>
</html>
