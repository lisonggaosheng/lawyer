<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>案件维护客户信息</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
</head>
<body>

	<table cellspacing="0" cellpadding="0" border="0" width="100%"
		height="100%" class="content_table">
		<tr class="title">
			<td colspan="4">&nbsp;&nbsp;<img
				src="/lawyer/images/flag2_16x16.gif" />&nbsp;案件维护客户信息</td>
		</tr>
		<s:iterator value="customers">
		<tr>
			<td class="padding_td" valign="middle" colspan="4">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				class="step_table">
				<tr>
					<td align="right" class="td" >对方联系人：</td>
					<td class="td">${contacts }</td>
				</tr>
				<tr>
					<td align="right" class="td" >对方联系电话：</td>
					<td class="td">${contactPhone }</td>
				</tr>
				<tr>
					<td align="right" class="td" >联系日期：</td>
					<td class="td">${contactDate }</td>
				</tr>
				<tr>
					<td align="right" class="td" >服务人员：</td>
					<td class="td">${serviceUser }</td>
				</tr>
				<tr>
					<td align="right" class="td" >服务人电话：</td>
					<td class="td">${servicePhone }</td>
				</tr>
				<tr>
					<td align="right" class="td" >联系内容：</td>
					<td class="td">${content }</td>
				</tr>

				<tr>
					<td align="right" class="td">记录人员：</td>
					<td class="td">${users.UName }</td>
				</tr>
				<tr>
					<td align="right" class="td">记录时间：</td>
					<td class="td">${savetime }</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td align="right" class="td">===================================================</td>
			<td class="td">=======================================================================</td>
		</tr>
		</s:iterator>
	</table>

</body>
</html>