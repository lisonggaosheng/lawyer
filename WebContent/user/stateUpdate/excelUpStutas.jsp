<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<title>使用excel更新企业状态</title>
</head>
<body>
	<form action="excelUpStutas.action" method="post" enctype="multipart/form-data">
		<table cellpadding="0" cellspacing="0" border="0" align="center"
		width="98%" class="result_table">
			<tr>
			<td colspan="2">&nbsp;&nbsp;<img src="../../images/view_16x16.gif" />&nbsp;
			<span class="title">导入excel执行企业状态更新</span></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="file" name="upd" /><input type="submit" value="excel企业状态更新"/>
				</td>
		</tr>
		</table>
	</form>
	<div style="margin-left: 20px;margin-top: 10px;"><span id="message" style="font-size:24px;color:blue;">${message}</span></div>
</body>
</html>