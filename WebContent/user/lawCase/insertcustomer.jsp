<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>添加维护客户</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/lawyer/js/laydate/laydate.js"></script>
<script type="text/javascript" src="/lawyer/js/selectpenson.js"></script>

<script language="javascript">
	function selectlawyer() {
		$("#serviceName").val($("#penson").find("option:selected").text());
		$("#servicePhone").val($("#penson").val());
	}
</script>
</head>

<body>
	<table cellspacing="0" cellpadding="0" border="0" width="100%"
		height="100%" class="content_table">

		<tr>
			<td>&nbsp;&nbsp;<img src="/lawyer/images/flag3_add_16x16.gif" />&nbsp;
				<span class="title">添加维护客户信息</span>
			</td>
		</tr>
		<tr>
			<td>
				<table cellpadding="0" cellspacing="0" width="98%" align="center"
					class="search_table" border="0">
					<tr>
						<c:choose>
					       <c:when test="${param.Casecodeself != null}">
					            <td align="left">案件信息编号：${param.Casecodeself}</td>
					       </c:when>
					       <c:when test="${customer.casecodeself != null}">
					              	<td align="left">案件信息编号：${customer.casecodeself}</td>
					       </c:when>
						</c:choose>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td>
				<table align="center" cellpadding="0" cellspacing="0" width="98%"
					border="0">
					<tr>
						<td>
							<form name="form3" method="post" enctype="multipart/form-data"
								action="addcustomer">
								<table class="form_table" align="center" cellpadding="0"
									cellspacing="0" width="100%" border="0">
									<tr>
										<td align="right" width="20%">对方联系人：</td>
										<td><input type="text" name="customer.contacts" value="${customer.contacts}" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">对方联系电话：</td>
										<td><input type="text" name="customer.contactPhone" value="${customer.contactPhone}" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">联系日期：</td>
										<td><input type="text" onClick="laydate()" class="form-control" name="customer.contactDate" value="${customer.contactDate}" readonly="readonly"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">服务人员：</td>
										<td>
											<input type="text" id="serviceName" name="customer.serviceUser" value="${customer.serviceUser}" />
											<select name="lawyerinfo" id="penson" onchange="selectlawyer()">
												<option >请选择办案律师</option>
											</select>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">服务人电话：</td>
										<td><input type="text" id="servicePhone" name="customer.servicePhone" value="${customer.servicePhone}" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">联系内容：</td>
										<td>
											<textarea rows="5" cols="50" name="customer.content" >${customer.content}</textarea>
										</td>
									</tr>
									<tr>
										<td>
											<c:choose>
										       <c:when test="${param.Casecodeself != null}">
										            <input type="hidden" name="customer.casecodeself"
														value="${param.Casecodeself}" />
										       </c:when>
										       <c:when test="${customer.casecodeself != null}">
										              	<input type="hidden" name="customer.casecodeself"
															value="${customer.casecodeself}" />
										       </c:when>
											</c:choose>
										</td>
									</tr>
									<tr>
										<td align="center" colspan="2"><input type="submit"
											value="保存" />&nbsp;&nbsp; <input type="reset" value="重置" />
										</td>
									</tr>
								</table>
							</form></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</body>
</html>
