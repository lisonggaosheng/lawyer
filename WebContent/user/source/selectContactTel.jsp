<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电话联系全部信息</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
</head>
<body>
<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr class="title">
		<td colspan="4">&nbsp;&nbsp;<img
			src="/lawyer/images/flag2_16x16.gif" />&nbsp;电话联系信息</td>
	</tr>
	<s:iterator value="ctels">
		<tr>
			<td class="padding_td" valign="middle" colspan="4">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				class="step_table">
				<tr>
					<td align="right" width="40%" class="td">打电话人姓名：</td>
					<td class="td">${ctName}</td>
				</tr>
				<tr>
					<td align="right" width="40%" class="td">联系人1姓名：</td>
					<td class="td">${ctName1 }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">联系人1电话：</td>
					<td class="td">${ctTel1 }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">联系人2姓名：</td>
					<td class="td">${ctName2 }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">联系人2电话：</td>
					<td class="td">${ctTel2 }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">打电话时间：</td>
					<td class="td">${ctTime }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">打电话结果：</td>
					<td class="td">${ctResult }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">打电话所用电话号码：</td>
					<td class="td">${ctTel3 }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">备注：</td>
					<td class="td">${ctRemark }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">附件：</td>
					<td class="td"><a
						href="downFile.action?filename=/uploads/案源文件库/${ctAttach }">
					${ctAttach }</a></td>
				</tr>
				<tr>
					<td class="td" align="right"><b>可执行操作</b>：</td>
					<td class="td"><a
									href="updConTel.action?court.ct.ctCasecodeself=${ctCasecodeself}&court.caseId=${caseId}">修改</a>&nbsp;&nbsp; <a
						href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a>&nbsp;&nbsp;
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</s:iterator>
</table>

</body>
</html>