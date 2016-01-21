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

			<s:iterator value="#request.contractsigns">
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" width="100%" align="left"
							class="search_table" border="0">
							<tr height="5">
								<td colspan="5" height="5">
									<h4>${csCasecodeself}</h4>
								</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>

							<s:if test="#adayin!=null">
								<tr height="10">
									<td class="title">签约信息</td>
								</tr>

								<tr height="10">
									<td align="left">${csNo}</td>
									<td align="left">${csAle}</td>
									<td align="left">${csName}</td>
									<td align="left">${csTel}</td>
									<td align="left">${csDate}</td>

								</tr>
							</s:if>
							<s:if test="#bdayin!=null">
								<tr height="10">
									<td class="title">清算立案信息</td>
								</tr>
								<s:iterator value="clearrecords">
									<tr height="10">
										<td align="left" width="200xp">${crnumber}</td>
										<td align="left">${crcontactjudge}</td>
										<td align="left">${crcontacttel}</td>
										<td align="left">${crlawname}</td>
										<td align="left">${crlawtel}</td>
										<td align="left">${crfollowupresult}</td>
										<td align="left">${crdate}</td>
									</tr>
								</s:iterator>
								<s:if test="clearrecords==null">
									<tr height="10">
										<td align="left">还没有添加！</td>
									</tr>
								</s:if>
							</s:if>
							<s:if test="#cdayin!=null">
								<tr height="10">
									<td class="title">清算结束信息</td>
								</tr>
								<s:iterator value="clearclears">
									<tr height="10">
										<td align="left">${ccnumber}</td>
										<td align="left">${ccjudge}</td>
										<td align="left">${ccjudgetel}</td>
										<td align="left">${cclawname}</td>
										<td align="left">${cclawnametel}</td>
										<td align="left">${ccfollowupresult}</td>
									</tr>
								</s:iterator>
								<s:if test="clearclears==null">
									<tr height="10">
										<td align="left">还没有添加！</td>
									</tr>
								</s:if>

							</s:if>

							<s:if test="#ddayin!=null">
								<tr height="10">
									<td class="title">诉讼信息</td>
								</tr>
								<s:iterator value="litigations">
									<tr height="10">
										<td align="left">${linumber}</td>
										<td align="left">${lijudge}</td>
										<td align="left">${lijudgetel}</td>
										<td align="left">${lilawname}</td>
										<td align="left">${lilawtel}</td>
										<td align="left">${lifollowupresult}</td>
										<td align="left">${lidate}</td>
										<td align="left">${liremark}</td>
									</tr>
								</s:iterator>

								<s:if test="litigations==null">
									<tr height="10">
										<td align="left">还没有添加！</td>
									</tr>
								</s:if>
							</s:if>


							<s:if test="#edayin!=null">
								<tr height="10">
									<td class="title">执行信息</td>
								</tr>
								<s:iterator value="executes">
									<tr height="10">
										<td align="left">${exnumber}</td>
										<td align="left">${exjudge}</td>
										<td align="left">${exjudgetel}</td>
										<td align="left">${exlawname}</td>
										<td align="left">${exlawtel}</td>
										<td align="left">${exfollowupresult}</td>
										<td align="left">${exdate}</td>
									</tr>
								</s:iterator>
								<s:if test="executes==null">
									<tr height="10">
										<td align="left">还没有添加！</td>
									</tr>
								</s:if>
							</s:if>
							<s:if test="#fdayin!=null">
								<tr height="10">
									<td class="title">结案信息</td>
								</tr>
								<s:if test="executes==null">
									<tr height="10">
										<td align="left">还没有添加！</td>
									</tr>
								</s:if>
								<s:else>
									<tr height="10">
										<td align="left">${closerecord.crperson}</td>
										<td align="left">${closerecord.crpersontel}</td>
										<td align="left">${closerecord.crtime}</td>

									</tr>
								</s:else>
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
				href="down.action?filename=<%=URLEncoder.encode("案件信息打印.xls", "utf-8")%>">下载打印文档</a></td>
		</tr>
	</table>
</body>
</html>
