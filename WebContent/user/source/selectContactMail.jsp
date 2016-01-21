<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>被执行人企业详细信息</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
</head>
<body>

	<table cellspacing="0" cellpadding="0" border="0" width="100%"
		height="100%" class="content_table">
		<tr class="title">
			<td colspan="4">&nbsp;&nbsp;<img
				src="/lawyer/images/flag2_16x16.gif" />&nbsp;电子邮件联系信息</td>
		</tr>
		<s:iterator value="cms">
		<tr>
			<td class="padding_td" valign="middle" colspan="4">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				class="step_table">
				<tr>
					<td align="right" width="40%" class="td">邮件地址：</td>
					<td class="td">${cmMail }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">发送人：</td>
					<td class="td">${cmMsender }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">发送时间：</td>
					<td class="td">${cmDate }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">发送结果：</td>
					<td class="td">${cmResult }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">备注：</td>
					<td class="td">${cmRemark }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">附件：</td>
					<td class="td"><a
						href="downFile.action?filename=/uploads/案源文件库/${cmAttach }">
					${cmAttach } </a></td>
				</tr>
				<tr>
					<td class="td" align="right"><b>可执行操作</b></td>
					<td class="td"><a
									href="updConMail.action?court.cm.cmCasecodeself=${cmCasecodeself}&court.caseId=${caseId}">修改</a>&nbsp;&nbsp;
					<a href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a></td>
				</tr>
			</table>
			</td>
		</tr>
		</s:iterator>
	</table>

</body>
</html>