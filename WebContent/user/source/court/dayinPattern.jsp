<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="java.net.URLEncoder"%><html>
<head>
<base href="<%=basePath%>">

<title>选取打印的详细信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript">
	function clos() {
		window.close();
	}
	$(function() {
		$("td:empty").remove();
		$("tr:empty").remove();
	});

	function printme() {
		document.body.innerHTML = document.getElementById("div1").innerHTML;
		window.print();
	}
</script>
</head>

<body>

<div id="div1">
<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr>
		<td align="left">&nbsp;&nbsp;<img
			src="/lawyer/images/flag3_16x16.gif" />&nbsp; <span class="title">选取打印的信息</span></td>
	</tr>
	<s:iterator value="#request.courtlist">
		<tr>
			<td>
			<table cellpadding="0" cellspacing="0" width="100%" align="left"
				class="search_table" border="1">
				<s:if test="#adayin!=null">
					<tr height="10" >
						<td class="title" align="center" colspan="2">执行法院：${execCourtName }</td>
					</tr>
					<tr  height="10">
						<td align="left" width="60%">${pname}</td>
						<td align="left">${caseCreateTime }</td>
					</tr>
					<tr  height="10">
						<td align="left" width="60%">${caseCode }</td>
						<td align="left">${execMoney}</td>
					</tr>
				</s:if>
				<s:if test="#cdayin!=null">
					<tr  height="10">
						<td align="left" width="60%">${ao.aoName }</td>
						<td align="left">${ao.aoName1 }</td>
					</tr>
					<tr  height="10">
						<td align="left" width="60%">${ao.aoPhone1 }</td>
						<td align="left">${ao.aoAddress }</td>
					</tr>
				</s:if>
			</table>
			</td>
		</tr>
	</s:iterator>
</table>
</div>
<table>
	<tr>
		<td colspan="5" align="right"><input type="button" value="打印"
			onclick="printme()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
			type="hidden" value="取消" onclick="clos()" /></td>
		<td>&nbsp;</td>
		<td><a
			href="down.action?filename=<%=URLEncoder.encode("案源信息模式1打印.xls", "utf-8")%>">下载打印文档</a></td>
	</tr>
</table>
</body>
</html>
