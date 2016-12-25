<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib prefix="s" uri="/struts-tags"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link rel="stylesheet" href="/lawyer/css/public.css" />
		<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
		<script language="javascript">
		/* $(document).ready(function() {
			
			$("#targetFile").change(function(){  
	            var filename = $(this).val();  
	            $("#title").val(filename);  
	        }); 
		
		}); */
 </script>
	</head>
	<body>
		<table cellspacing="0" cellpadding="0" border="0" width="100%"
			height="100%" class="content_table">
			<tr>
				<td width="15%" colspan="2">
					&nbsp;&nbsp;
					<img src="/lawyer/images/flag3_add_16x16.gif" />
					&nbsp;
					<span class="title">新建文件</span>
				</td>
			</tr>
			<tr>
				<td width="100%">
					<form name="addForm" action="files-add?filelibrary.flId=<s:property value="#parameters.flid"/>" 
						method="post" enctype="multipart/form-data">
					 
						<table width="90%" cellspacing="0" cellpadding="0" border="0" align="left" class="form_table">
							<tr>
								<td  align="right">文件标题：</td>
								<td ><input type="text" name="files1.FTitle" id="title"/></td>
							</tr>
							<tr>
								<td align="right">所属文件库：</td>
								<td>
									<%
										String flname = new String(request.getParameter("flname").getBytes("ISO-8859-1"),"utf-8");
									%>
									<input type="text" name="files1.FType" value="<%=flname %>" readonly="readonly"/>
								</td>
							</tr>						
							<tr>
								<td align="right">上传附件：</td>
								<td>
									<input type="file" name="upload" id="targetFile"/>
								</td>
							</tr>
							<tr>
								<td align="right">备注：</td>
								<td colspan="10"><textarea  name="files1.remark"></textarea></td>
							</tr>
							<tr>
								<td  align="right">
  									<input type="submit" value="保存" />
  										&nbsp;&nbsp;
									  <input type="reset" value="清空" /></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>
