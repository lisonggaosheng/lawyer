<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>拜访联系全部信息</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
</head>
<body>
<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr class="title">
		<td colspan="4">&nbsp;&nbsp;<img
			src="/lawyer/images/flag2_16x16.gif" />&nbsp;登门拜访联系信息</td>
	</tr>
	<s:iterator value="cseelist">
		<tr>
			<td class="padding_td" valign="middle" colspan="4">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				class="step_table">
				<tr>
					<td align="right" width="25%" class="td">我方工作人员：</td>
					<td class="td">${csName }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">对方工作人员：</td>
					<td class="td">${csOthername }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">拜访时间：</td>
					<td class="td">${csDate }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">拜访结果：</td>
					<td class="td">${csResult }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">备注：</td>
					<td class="td">${csRemark }</td>
				</tr>
				<tr>
					<td align="right" width="25%" class="td">附件：</td>
					<td class="td"><a
						href="downFile.action?filename=/uploads/案源文件库/${csAttach }">
						${csAttach } </a></td>
				</tr>
				<tr>
					<td class="td" align="right"><b>可执行操作</b>：</td>
					<td class="td"><a href="updConSee.action?court.csee.csCasecodeself=${csCasecodeself}&court.caseId=${caseId}">修改</a>&nbsp;&nbsp; <a
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