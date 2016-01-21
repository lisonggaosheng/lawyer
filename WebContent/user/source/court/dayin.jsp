<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<title>选取打印详细信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript"><!--
	function quanxuan() {
		$("input[name='adayin'],input[name='bdayin'],input[name='cdayin'],input[name='ddayin']").attr("class", "xuan").attr("checked", true);
	}

	function fanxuan() {
		$("input[name='adayin'],input[name='bdayin'],input[name='cdayin'],input[name='ddayin']").attr("class", "xuan");
		$("input[checked='true']").removeAttr("class").attr("checked", false);
		$(".xuan").attr("checked", true);
		$("input[name='adayin'],input[name='bdayin'],input[name='cdayin'],input[name='ddayin']").attr("class", "xuan");
	}

	function clos(){
		 window.close();
	}
	
	function sub(){
		var a =  $("#pattern").val();
		if(a == "pattern1"){
			$("input[name='adayin'],input[name='bdayin'],input[name='cdayin'],input[name='ddayin']").attr("class", "xuan").attr("checked", true);
			searchForm.submit();
			 window.close();
		}else{
			searchForm.submit();
			 window.close();
		}
		
	}

</script>
</head>

<body>

<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr>
		<td>&nbsp;&nbsp;<img src="/lawyer/images/flag3_16x16.gif" />&nbsp;
		<span class="title">选取打印信息</span></td>
	</tr>
	<tr>
		<td><span class="title"><span onclick="quanxuan()">全选</span>&nbsp;&nbsp;&nbsp;<span
			onclick="fanxuan()">反选</span></span>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td >
		<form name="searchForm" method="post" action="daYin.action">
		<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="search_table" border="0">
			<tr><td>
				<select name="pattern" id = "pattern">
			<option value>请选择打印模式</option>
			<option value="pattern1">模式1</option>
			</select>
			</td></tr>
			<tr>
				<td colspan="6" class="title">&nbsp;&nbsp;被执行人执行信息</td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input type="checkbox"
					name="adayin" value="1" />&nbsp;&nbsp;被执行人姓名/名称</td>

				<td colspan="2" align="left"><input type="checkbox"
					name="adayin" value="2" />&nbsp;&nbsp;身份证号码/组织机构代码</td>

				<td colspan="2" align="left"><input type="checkbox"
					name="adayin" value="3" />&nbsp;&nbsp;执行法院</td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input type="checkbox"
					name="adayin" value="4" />&nbsp;&nbsp;立案时间</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="adayin" value="5" />&nbsp;&nbsp;案号</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="adayin" value="6" />&nbsp;&nbsp;执行标的</td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input type="checkbox"
					name="adayin" value="7" />&nbsp;&nbsp;案件状态</td>
			</tr>
			<tr>
				<td colspan="6" class="title">&nbsp;&nbsp;被执行人企业信息</td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input type="checkbox"
					name="bdayin" value="1" />&nbsp;&nbsp;被执行人注册号</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="bdayin" value="2" />&nbsp;&nbsp;企业类型</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="bdayin" value="3" />&nbsp;&nbsp;主体名称</td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input type="checkbox"
					name="bdayin" value="4" />&nbsp;&nbsp;法定代表人/负责人</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="bdayin" value="5" />&nbsp;&nbsp;行政区划</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="bdayin" value="6" />&nbsp;&nbsp;登记机关</td>

			</tr>
			<tr>
				<td colspan="2" align="left"><input type="checkbox"
					name="bdayin" value="7" />&nbsp;&nbsp;地址/住所</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="bdayin" value="8" />&nbsp;&nbsp;企业状态</td>
			</tr>
			<tr>
				<td colspan="6" class="title">&nbsp;&nbsp;申请执行人企业信息</td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input type="checkbox"
					name="cdayin" value="1" />&nbsp;&nbsp;申请人名称</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="cdayin" value="2" />&nbsp;&nbsp;申请人地址</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="cdayin" value="3" />&nbsp;&nbsp;联系人姓名</td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input type="checkbox"
					name="cdayin" value="4" />&nbsp;&nbsp;联系人电话</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="cdayin" value="5" />&nbsp;&nbsp;法定代表人/负责人</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="cdayin" value="6" />&nbsp;&nbsp;行政区划</td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input type="checkbox"
					name="cdayin" value="7" />&nbsp;&nbsp;登记机关</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="cdayin" value="8" />&nbsp;&nbsp;地址/住所</td>
			</tr>
			<tr>
				<td colspan="6" class="title">&nbsp;&nbsp;与申请执行人联系信息</td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input type="checkbox"
					name="ddayin" value="1" />&nbsp;&nbsp;邮件地址</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="ddayin" value="7" />&nbsp;&nbsp;邮件发件人</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="ddayin" value="8" />&nbsp;&nbsp;发件时间</td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input type="checkbox"
					name="ddayin" value="2" />&nbsp;&nbsp;快递号</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="ddayin" value="3" />&nbsp;&nbsp;电话联系结果</td>
			</tr>
			<tr>

				<td colspan="2" align="left"><input type="checkbox"
					name="ddayin" value="4" />&nbsp;&nbsp;签约号</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="ddayin" value="5" />&nbsp;&nbsp;签约时间</td>
				<td colspan="2" align="left"><input type="checkbox"
					name="ddayin" value="6" />&nbsp;&nbsp;签约联系人</td>
			</tr>
			<tr>
				<td colspan="10" align="right"><input type="button" value="浏览"
					onclick="sub()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="hidden" value="取消" onclick="clos()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


				<input name="courtstr" type="hidden"
					value="<s:property value="#parameters.dayin"/>" /></td>
			</tr>
		</table>

		</form>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>

</body>
</html>
