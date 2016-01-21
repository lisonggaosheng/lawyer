<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加材料整理</title>
<link rel="stylesheet" href="../../css/public.css" />
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/lawyer/js/selectlawyer.js"></script>

<script language="javascript">
function loadCalendar(data)
{
	var rtn=window.showModalDialog("/lawyer/user/lawCase/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
	if(rtn!=null){
		$(data).val(rtn);
	}		
   return;
}

</script>
</head>

<body>
<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">

	<tr>
		<td>&nbsp;&nbsp;<img src="/lawyer/images/flag3_(add)_16x16.gif" />&nbsp;
		<span class="title">添加材料整理信息</span></td>
	</tr>
	<tr>
		<td>
		<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="search_table" border="0">
			<tr>
				<td align="left">案源信息编号：${param.Casecodeself}</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		<table align="center" cellpadding="0" cellspacing="0" width="98%"
			border="0">
			<tr>
				<td>
				<form name="form3" method="post" action="addMaterial">
				<table class="form_table" align="center" cellpadding="0"
					cellspacing="0" width="100%" border="0">
					<tr>
						<td align="right" width="20%">材料是否邮寄：</td>
						<td>
							<input name="material.isMail" type="radio" value="1" />是
							<input name="material.isMail" type="radio" value="0" />否
						</td>
					</tr>
					<tr>
						<td align="right" width="20%">邮寄人：</td>
						<td><input type="text" name="material.sender" /></td>
					</tr>
					<tr>
						<td align="right">邮寄单号：</td>
						<td><input type="text" name="material.sendNumber" /></td>
					</tr>
					<tr>
						<td align="right">邮寄时间：</td>
						<td><input type="text" name="material.sendDate" onClick="loadCalendar(this)"/></td>
					</tr>
					<tr>
						<td align="right">材料返回时间：</td>
						<td><input type="text" name="material.receiveDate" onClick="loadCalendar(this)"/></td>
					</tr>
					<tr>
						<td align="right">备注：</td>
						<td><textarea rows="5" cols="50" name="material.remark"></textarea>
						<input type="hidden" name="material.casecodeself"
							value="${param.Casecodeself}" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="submit"
							value="保存" />&nbsp;&nbsp; <input type="reset" value="重置" /></td>
					</tr>
				</table>
				</form>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>
</body>
</html>
