<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>修改第四步（联系信息--拜访）页面</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" href="/lawyer/css/public.css" type="text/css"></link>
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script language="javascript">

	function loadCalendar(data)
	{
		var rtn=window.showModalDialog("/lawyer/user/source/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
		if(rtn!=null){
			$(data).val(rtn);
		}
	}

	</script>
</head>

<body>
<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr>
	<td>&nbsp;&nbsp;<img src="/lawyer/images/flag3_(add)_16x16.gif" />&nbsp;
		<span class="title">修改拜访信息</span></td>
	</tr>
	<tr>
		<td>
		<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="search_table" border="0">
			<tr>
				<td align="left" width="20%">案源信息编号：</td>
				<td><strong>${court.csee.csCasecodeself}</strong></td>
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
				<form name="form3" method="post" action="toupdConSee.action">

				<table class="form_table" align="center" cellpadding="0"
					cellspacing="0" width="100%" border="0">
					<tr class="title">
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td align="right">我方工作人员姓名：</td>
						<td colspan="2"><input type="text" name="court.csee.csName" value="${court.csee.csName}"/></td>
					</tr>
					<tr>
						<td align="right">对方工作人员姓名：</td>
						<td colspan="2"><input type="text" name="court.csee.csOthername" value="${court.csee.csOthername}"/></td>
					</tr>
					<tr>
						<td align="right">拜访结果：</td>
						<td colspan="2"><input type="text" name="court.csee.csResult" value="${court.csee.csResult}"/></td>
					</tr>
					<tr>
						<td align="right" width="20%">拜访时间：</td>
						<td colspan="2"><input type="text" name="court.csee.csDate" value="${court.csee.csDate}"
						 onClick="loadCalendar(this)" readonly="readonly"/></td>
					</tr>
					<tr>
						<td align="right">备注：</td>
						<td colspan="2"><textarea class="textarea_remarks"
							name="court.csee.csRemark" value="${court.csee.csRemark}"></textarea></td>
						<td><input type="hidden" name="court.csee.csId"
							value="${court.csee.csId}" /> <input type="hidden"
							name="court.csee.csCasecodeself" value="${court.csee.csCasecodeself}" />
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td colspan="2"><input type="hidden" value="${court.caseId}"
							name="court.caseId"> <input type="submit" value="保存" />&nbsp;&nbsp;
						<input type="reset" value="重置" /></td>
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
