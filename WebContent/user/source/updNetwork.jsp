<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>添加第三步（申请执行人企业信息——网络信息）页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" href="/lawyer/css/public.css" type="text/css"></link>
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>

<script language="javascript">
	function loadCalendar(data) {
		var rtn = window
				.showModalDialog(
						"/lawyer/user/source/calender.jsp",
						"",
						"dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
		if (rtn != null) {
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
		<td width="50%">&nbsp;&nbsp;<img
			src="/lawyer/images/flag3_(add)_16x16.gif" />&nbsp; <span
			class="title">申请执行人自有信息</span></td>
	</tr>

	<tr>
		<td align="left" width="20%">案源信息编号： ${court.an.anCasecodeself}</td>
	</tr>
	<tr class="title">
		<td align="left"><img src="/lawyer/images/flag2_16x16.gif" />&nbsp;网络信息</td>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td>
		<table align="center" cellpadding="0" cellspacing="0" width="98%"
			border="0">
			<tr>
				<td>
				<form name="appnet" method="post" action="toupdnetwork">

				<table class="form_table" align="center" cellpadding="0"
					cellspacing="0" width="100%" border="0">

					<tr>
						<td align="right">主体名称：</td>
						<td><input type="text" name="court.an.anName"
							value="${court.an.anName }" /></td>
					</tr>
					<tr>
						<td align="right">地址/住所：</td>
						<td><input type="text" name="court.an.anAddress"
							value="${court.an.anAddress }" /></td>
					</tr>
					<tr>
						<td align="right">联系人：</td>
						<td><input type="text" name="court.an.anConname"
							value="${court.an.anConname }" /></td>
					</tr>
					<tr>
						<td align="right">电话：</td>
						<td><input type="text" name="court.an.anPhone"
							value="${court.an.anPhone }" /></td>
					</tr>
					<tr>
						<td align="right">传真：</td>
						<td><input type="text" name="court.an.anFax"
							value="${court.an.anFax }" /></td>
					</tr>
					<tr>
						<td align="right">邮件：</td>
						<td><input type="text" name="court.an.anMail"
							value="${court.an.anMail }" /></td>
					</tr>
					<tr style="display: none;">
						<td><input type="text" name="court.an.anCasecodeself"
							value="${court.an.anCasecodeself }" /> 
							
							<input type="hidden"
							name="court.an.anId"
							value="${court.an.anId }" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="submit"
							value="保存" />&nbsp;&nbsp; <input type="reset" value="重置" /></td>
						<td>&nbsp;</td>
					</tr>
				</table>
				</form>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		</td>

	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>

</table>
</body>
</html>
