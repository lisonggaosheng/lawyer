<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>		
	</head>
	<body>
	<script type="text/javascript">
		<% 
		 String id = request.getParameter("flId");
		%>
		var flid = <%=id%>
		alert('添加成功！');
		location='files-list?i=files&files1.fId='+flid;
	</script>
	</body>
</html>
