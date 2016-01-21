<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.net.URLEncoder"%>
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
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<title>申请人(债权人)企业网络信息</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript">
	function deleteAppNet(id){
		alert(id);
		if(confirm('确实要删除吗?')){
			location.href = "deleteAppnet.action?applierinfoNetwork.anId=" + id;
		}
	}
</script>
</head>
<body>
<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr>
		<td>
		<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="result_table" border="0">
			<tr class="title">
				<td colspan="6">&nbsp;&nbsp;<img
					src="/lawyer/images/flag2_16x16.gif" />&nbsp;申请人(债权人)企业网络信息</td>
			</tr>
			<tr>
				<s:if test="appnets!=null">
					<td colspan="2" width="35%">
					<s:iterator value="appnets">
					<table cellpadding="0" cellspacing="0" width="100%" border="0"
						class="step_table">
						<tr>
							<td align="right" width="40%" class="td">主体名称：</td>
							<td class="td"><s:property value="anName" /></td>
						</tr>
						<tr>
							<td align="right" width="25%" class="td">地址/住所：</td>
							<td class="td"><s:property value="anAddress" /></td>
						</tr>
						<tr>
							<td align="right" width="25%" class="td">联系人：</td>
							<td class="td"><s:property value="anConname" /></td>
						</tr>
						<tr>
							<td align="right" width="25%" class="td">电话：</td>
							<td class="td"><s:property value="anPhone" /></td>
						</tr>
						<tr>
							<td align="right" width="25%" class="td">传真：</td>
							<td class="td"><s:property value="anFax" /></td>
						</tr>
						<tr>
							<td align="right" width="25%" class="td">邮件：</td>
							<td class="td"><s:property value="anMail" /></td>
						</tr>
						<tr>
						<td class="td" align="right"><b>可执行操作</b>：</td>
						<td class="td">
						<a href="deleteAppnet.action?applierinfoNetwork.anId=<s:property value="anId" />&applierinfoNetwork.anCasecodeself=<s:property value="anCasecodeself" />">删除</a></td>
					</tr>
					</table>
					&nbsp;
					</s:iterator>
					</td>
				</s:if>
			</tr>
		</table>
</td>
</tr>
		</table>
</body>
</html>