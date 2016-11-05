<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>案源高级查询结果</title>
<link rel="stylesheet" href="css/public.css" />

<script type="text/javascript" src="/lawyer/js/dtree.js"></script>
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<link rel="stylesheet" href="/lawyer/css/dtree.css" />
<script type="text/javascript">
	function dayin() {
		yayin.submit();

	}
	
	function quanxuan() {
		$("input[name='dayin']").attr("checked", true);
	}

	function fanxuan() {
		$("input[checked='true']").removeAttr("class").attr("checked", false);
		$(".xuan").attr("checked", true);
		$("input[name='dayin']").attr("class", "xuan");
	}

	function yanzhen(){
	var ye=$("#ye").val();
	ye=eval(ye+"+"+0);
	$("#ye").val(ye);
	yemian.submit();
	}
</script>
</head>


<body>

<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr>
		<td colspan="2">&nbsp;&nbsp;<img src="images/view_16x16.gif" />&nbsp;<span
			class="title">查询高级查询结果</span></td>
	</tr>
	<tr>
		<td></td>
		<td>&nbsp;&nbsp;<span onclick="quanxuan()">全选</span>&nbsp;&nbsp;<span
			onclick="fanxuan()">反选</span></td>
		<td colspan="2"><span onclick="dayin()">打印</span></td>
	</tr>

	<tr>
		<td width="5%"></td>
		<td valign="top">
		<form name="yayin" action="/lawyer/user/source/court/dayin.jsp"
			method="post">
		<table cellpadding="0" cellspacing="0" border="0" align="center"
			width="98%" class="result_table">
			<tr class="title" align="center">
			<c:if test="${showNote=='1' }">
				<td></td>
				<td>序号</td>
				<td>案源编号</td>
				<td>被执行人姓名</td>
				<td>公告法院</td>
				<td>公告时间</td>
				<td>法律文书号</td>
				<td>操作</td>
			</c:if>
			<c:if test="${showNote!='1' }">
				<td></td>
				<td>序号</td>
				<td>案源编号</td>
				<td>被执行人姓名</td>
				<td>执行法院</td>
				<td>立案时间</td>
				<td>案号</td>
				<td>操作</td>
			</c:if>	
			</tr>
			<s:set value="1" name="css"></s:set>

			<s:iterator value="#request.rs">

				<tr class="title" align="center">
					<td><input class="xuan" type="checkbox" name="dayin"
						value="<s:property value="casecodeself"></s:property>" /></td>
					<td><s:property value="#css"></s:property></td>
					<s:set value="#css+1" name="css"></s:set>
					<td><s:property value="casecodeself"></s:property></td>
					<td><s:property value="pname"></s:property></td>
					<td><s:property value="execCourtName"></s:property></td>
					<td><s:property value="caseCreateTime"></s:property></td>
					<td><s:property value="caseCode"></s:property></td>
					<td width="50"><a
						href="selectCourtById?users.id=${admin.UId}&&court.casecodeself=<s:property value="casecodeself"/>&court.caseId=<s:property value="caseId"/>"
						target="_blank">详情</a></td>
				</tr>
			</s:iterator>
		</table>
		</form>
		<s:set value="1" name="css"></s:set></td>
	</tr>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td></td>

		<td align="right">${Page}/${PageSize }&nbsp;&nbsp; <s:if
			test="%{Page!=1}">
			<a href="seniorSelectLawyerSource.action?Page=1">首页</a>
			&nbsp;&nbsp; <a href="seniorSelectLawyerSource.action?Page=${Page-1}">上页</a>
		</s:if><s:else>
			
		首页&nbsp;&nbsp;上页
		</s:else> <s:if test="%{Page!=PageSize}">&nbsp;&nbsp;
		<a href="seniorSelectLawyerSource.action?Page=${Page+1}">下页</a>
			<a href="seniorSelectLawyerSource.action?Page=${PageSize}">末页</a>
		</s:if><s:else>
		
		下页&nbsp;&nbsp;末页</s:else>
		<form name="yemian" action="seniorSelectLawyerSource.action"><input
			id="ye" style="width: 40px;" maxlength="10" name="Page"
			onkeyup="if(event.keyCode !=37 && event.keyCode != 39) value=value.replace(/\D/g,'')"
			onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/\D/g,''))" />
		<input type="button" onclick="yanzhen()" value="go" /></form>
		</td>
	</tr>
</table>

</body>
</html>
