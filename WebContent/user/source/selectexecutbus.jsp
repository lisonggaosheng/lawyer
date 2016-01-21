<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>被执行人(债务人)企业详细信息</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
</head>
<body>

<s:iterator value="businlist">
<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr class="title">
		<td colspan="4">&nbsp;&nbsp;<img
			src="/lawyer/images/flag2_16x16.gif" />&nbsp;被执行人(债务人)企业信息</td>
	</tr>
	<tr>
		<td>
		<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="search_table" border="0">
			<tr>
				<td align="right" width="20%">案源信息编号：</td>
				<td><h3>${ECCasecodeself}</h3></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td class="padding_td" valign="middle" colspan="4">
		<table cellpadding="0" cellspacing="0" width="100%" border="0"
			class="step_table">
			<tr>
				<td align="right" width="15%" class="td">注册号：</td>
				<td class="td">${ERenumber }</td>
			</tr>
			<tr>
				<td align="right" class="td">企业类型：</td>
				<td class="td">${EType }</td>
			</tr>
			<tr>
				<td align="right" class="td">主体名称：</td>
				<td class="td">${EName }</td>
			</tr>
			<tr>
				<td align="right" class="td">法定代表人/负责人：</td>
				<td class="td">${ERepname }</td>
			</tr>
			<tr>
				<td align="right" class="td">股东名录：</td>
				<td class="td">${shareholder }</td>
			</tr>
			<tr>
				<td align="right" class="td">行政区划：</td>
				<td class="td">${EDistrict }</td>
			</tr>
			<tr>
				<td align="right" class="td">成立日期：</td>
				<td class="td">${EDate}</td>
			</tr>
			<tr>
				<td align="right" class="td">注册资本：</td>
				<td class="td">${EFund }</td>
			</tr>
			<tr>
				<td align="right" class="td">经营期限自：</td>
				<td class="td">${EDfrom }</td>
			</tr>
			<tr>
				<td align="right" class="td">经营期限至：</td>
				<td class="td">${EDto }</td>
			</tr>
			<tr>
				<td align="right" class="td">登记机关：</td>
				<td class="td">${EOrgan }</td>
			</tr>
			<tr>
				<td align="right" class="td">地址/住所：</td>
				<td class="td">${EAddress }</td>
			</tr>
			<tr>
				<td align="right" class="td">企业状态：</td>
				<td class="td">${EStatus }</td>
			</tr>
			<tr>
				<td align="right" class="td">经营异常名录：</td>
				<td class="td">${exception }</td>
			</tr>
			<tr>
			<td align="right" class="td">注销日期：</td>
				<td class="td">${ECancellation }</td>
			</tr>
			<tr>
				<td align="right" class="td">吊销日期：</td>
				<td class="td">${ERevoke }</td>
			</tr>
			<tr>
				<td align="right" class="td">年检年度：</td>
				<td class="td">${EAnnual }</td>
			</tr>
			<tr>
				<td align="right" class="td">备注：</td>
				<td class="td">${ERemark }</td>
			</tr>
			<tr>
				<td class="td" align="right"><b>可执行操作</b>：</td>
				<td class="td"><a
					href="upexecutebus?court.eb.EId=${EId }&caseId=${caseId}">修改</a>&nbsp;&nbsp;
				<a href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a>&nbsp;&nbsp;
				</td>
			</tr>
		</table>

		</td>
	</tr>
</table>
</s:iterator>
</body>
</html>