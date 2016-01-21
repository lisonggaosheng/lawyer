<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>案件清算立案阶段</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
</head>
<body>

	<table cellspacing="0" cellpadding="0" border="0" width="100%"
		height="100%" class="content_table">
		<tr class="title">
			<td colspan="4">&nbsp;&nbsp;<img
				src="/lawyer/images/flag2_16x16.gif" />&nbsp;案件清算立案阶段更多</td>
		</tr>
		<s:iterator value="clearrecords">
		<tr>
			<td class="padding_td" valign="middle" colspan="4">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				class="step_table">
				<tr>
					<td align="right" class="td" width="40%">材料递交时间：</td>
					<td class="td">${crdate }</td>
				</tr>
				<tr>
					<td align="right" class="td">立案案号：</td>
					<td class="td">${crnumber }</td>
				</tr>

				<tr>
					<td align="right" class="td">联系法官：</td>
					<td class="td">${crcontactjudge }</td>
				</tr>
				<tr>
					<td align="right" class="td">法官电话：</td>
					<td class="td">${crcontacttel}</td>
				</tr>

				<tr>
					<td align="right" class="td">承办律师：</td>
					<td class="td">${crlawname}</td>
				</tr>
				<tr>
					<td align="right" class="td">律师电话：</td>
					<td class="td">${crlawtel}</td>
				</tr>
				<tr>
					<td align="right" class="td">协办人员：</td>
					<td class="td">${assistingName}</td>
				</tr>
				<tr>
					<td align="right" class="td">协办联系方式：</td>
					<td class="td">${assistingTel}</td>
				</tr>
				<tr>
					<td align="right" class="td">管辖法院：</td>
					<td class="td">${competentCourt}</td>
				</tr>
				<tr>
					<td align="right" class="td">案件进展：</td>
					<td class="td">${crfollowupresult }</td>
				</tr>
				<tr>
					<td align="right" class="td">备注：</td>
					<td class="td">${crremark }</td>
				</tr>
				<tr>
					<td align="right" class="td">附件：</td>
					<td class="td"><a
						href="downFile.action?filename=/uploads/案件文件库/${crattach}">${crattach}</a>
					</td>
				</tr>
				<tr>
					<td align="right" class="td">记录人员：</td>
					<td class="td">${users.UName }</td>
				</tr>
				<tr>
					<td align="right" class="td">记录时间：</td>
					<td class="td">${crSaveTime }</td>
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