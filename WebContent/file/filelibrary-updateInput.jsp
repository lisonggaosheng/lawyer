<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>无标题文档</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
</head>
<body>
	<table cellspacing="0" cellpadding="0" border="0" width="100%"
		height="100%" class="content_table">
		<tr>
			<td width="15%" colspan="2">&nbsp;&nbsp; <img
				src="/lawyer/images/flag3_(add)_16x16.gif" /> &nbsp; <span
				class="title">修改文件库</span></td>
		</tr>
		<tr>
			<td width="50%">
				<form method="post" action="filelibrary-update">
					<input type="hidden" name="filelibrary.flId"
						value="<s:property value="filelibrary.flId"/>" />
					<table width="90%" cellspacing="0" cellpadding="0" border="0"
						align="right" class="form_table">
						<tr>
							<td width="11%" align="right">文件库名：</td>
							<td width="89%"><input type="text" name="filelibrary.flName"
								value="<s:property value="filelibrary.flName"/>" /></td>
						</tr>
						<tr>
							<td align="right">文件类别：</td>
							<td><input type="text" name="filelibrary.flCategory"
								value="<s:property value="filelibrary.flCategory"/>" /></td>
						</tr>
						<tr>
							<td align="right">备注：</td>
							<td><textarea cols="60" rows="5" name="filelibrary.beizhu" value="<s:property value="filelibrary.beizhu"/>"></textarea>
								</td>
						</tr>

						<tr>
							<td colspan="2" align="center">

								<div align="left">
									<input type="submit" value="保存" /> &nbsp;&nbsp; <input
										type="reset" value="清空" />
								</div>
							</td>
						</tr>
					</table>
				</form></td>
		</tr>
	</table>
</body>
</html>
