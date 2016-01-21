<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>案件材料整理</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
</head>
<body>

	<table cellspacing="0" cellpadding="0" border="0" width="100%"
		height="100%" class="content_table">
		<tr class="title">
			<td colspan="4">&nbsp;&nbsp;<img
				src="/lawyer/images/flag2_16x16.gif" />&nbsp;案件材料整理</td>
		</tr>
		<s:iterator value="materials">
		<tr>
			<td class="padding_td" valign="middle" colspan="4">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				class="step_table">
				<tr>
					<td align="right" class="td" width="30%">是否邮寄：</td>
					<td class="td">
						<s:if test="%{isMail==0 }">未邮寄</s:if>
						<s:if test="%{isMail==1 }">已邮寄</s:if>
					</td>
				</tr>
				<tr>
					<td align="right" class="td" width="30%">邮寄人：</td>
					<td class="td">${sender}</td>
				</tr>
				<tr>
					<td align="right" class="td" width="30%">邮寄单号：</td>
					<td class="td">${sendNumber}</td>
				</tr>
				<tr>
					<td align="right" class="td">邮寄时间：</td>
					<td class="td">${sendDate }</td>
				</tr>
				<tr>
					<td align="right" class="td">材料返回时间：</td>
					<td class="td">${receiveDate}</td>
				</tr>
				<tr>
					<td align="right" class="td">备注：</td>
					<td class="td">${remark }</td>
				</tr>
				<tr>
					<td align="right" class="td">记录人员：</td>
					<td class="td">${users.UName }</td>
				</tr>
				<tr>
					<td align="right" class="td">保存时间：</td>
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