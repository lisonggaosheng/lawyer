<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib prefix="s" uri="/struts-tags"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>无标题文档</title>
		<link rel="stylesheet" href="/lawyer/css/public.css" />
	</head>

	<body>

	<table cellspacing="0" cellpadding="0" border="0" width="100%"
			height="100%" class="content_table">
			<tr>
				<td width="15%" colspan="2">
					&nbsp;&nbsp;
					<img src="/lawyer/images/flag3_(add)_16x16.gif" />
					&nbsp;
					<span class="title">新建文件</span>
				</td>
			</tr>
			<tr>
				<td width="50%">
					<form name="addForm" action="files-update" method="post">
					 <input type="hidden" name="files1.FId"" value="<s:property value="files1.FId"/>"/> 
						<table width="90%" cellspacing="0" cellpadding="0" border="0" align="left" class="form_table">
							<tr>
								<td width="11%" align="right">文件标题：</td>
								<td width="89%">
									<input type="text" name="files1.FTitle" value="<s:property value="files1.FTitle"/>"/>
							  </td>
							</tr>
							<tr>
								<td align="right">
									文件类别：
								</td>
								<td>
									<input type="radio" name="files1.FType" value="历史" />
									历史&nbsp;&nbsp;
									<input type="radio" name="files1.FType" value="技术" />
									技术&nbsp;&nbsp;
									<input type="radio" name="files1.FType" value="教学" />
									教学&nbsp;&nbsp;
									
								</td>
							</tr>
							<tr>
								<td align="right">
									发布时间：
								</td>
								<td width="89%">
									<input type="text" name="files1.FReldate" value="<s:property value="files1.FReldate"/>"/>
									
							  </td>
							</tr>
												
							<tr>
								<td colspan="2" align="center">
									<div align="left">
  <input type="submit" value="保存" />
  &nbsp;&nbsp;
									  <input type="reset" value="清空" />
							        </div></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>

	</body>
</html>