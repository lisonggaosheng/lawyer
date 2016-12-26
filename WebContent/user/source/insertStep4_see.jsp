<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加第四步（与申请执行人联系信息——登门拜访）页面</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/lawyer/js/laydate/laydate.js"></script>
</head>

<body>

<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">

	<tr>
		<td>&nbsp;&nbsp;<img src="/lawyer/images/flag3_add_16x16.gif" />&nbsp;
		<span class="title">添加与申请执行人联系信息</span></td>
	</tr>
	<tr>
		<td>
		<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="search_table" border="0">
			<tr>
				<c:choose>
			       <c:when test="${param.casecodeself != null}">
			            <td align="left">案源信息编号：<strong>${param.casecodeself}</strong></td>
			       </c:when>
			       <c:when test="${contactSee.csCasecodeself != null}">
			             <td align="left">案源信息编号：<strong>${contactSee.csCasecodeself}</strong></td>
			       </c:when>
				</c:choose>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		<table align="center" cellpadding="0" cellspacing="0" width="98%"
			border="0">
			<tr>
				<td>
				<form name="form3" method="post" action="insertConSee.action"
					enctype="multipart/form-data">

				<table class="form_table" align="center" cellpadding="0"
					cellspacing="0" width="100%" border="0">
					<tr class="title">
						<td align="right"><img src="/lawyer/images/flag2_16x16.gif" />&nbsp;登门拜访</td>
						<td colspan="2">&nbsp;</td>
					</tr>					
					<tr>
						<td align="right">我方工作人员姓名：</td>
						<td colspan="2"><input type="text" name="contactSee.csName" value="${contactSee.csName }"/></td>
					</tr>
					<tr>
						<td align="right">对方工作人员姓名：</td>
						<td colspan="2"><input type="text" name="contactSee.csOthername" value="${contactSee.csOthername }"/></td>
					</tr>
					<tr>
						<td align="right">拜访结果：</td>
						<td colspan="2"><input type="text" name="contactSee.csResult" value="${contactSee.csResult }"/></td>
					</tr>
					<tr>
						<td align="right" width="20%">拜访时间：</td>
						<td colspan="2"><input type="text" name="contactSee.csDate" value="${contactSee.csDate }" 
						onClick="laydate()" readonly="readonly"/></td>
					</tr>
					<tr>
						<td align="right">备注：</td>
						<td colspan="2"><textarea class="textarea_remarks"
							name="contactSee.csRemark">${contactSee.csRemark}</textarea></td>
					</tr>
					<tr>
						<td align="right">附件：</td>
						<td colspan="2"><input type="file" name="attach" /></td>
					</tr>
					<tr style="display: none;">
						<td colspan="2">
							<c:choose>
						       <c:when test="${param.casecodeself != null}">
						            <input type="hidden" name="contactSee.csCasecodeself"
										value="${param.casecodeself}" />
									<input type="hidden" name="caseId"
											value="${param.caseId}" />
						       </c:when>
						       <c:when test="${contactSee.csCasecodeself != null}">
						              	<input type="hidden" name="contactSee.csCasecodeself"
											value="${contactSee.csCasecodeself}" />
										<input type="hidden" name="caseId"
											value="${caseId}" />
						       </c:when>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="保存" />&nbsp;&nbsp;
						<input type="reset" value="重置" /></td>
					</tr>
				</table>
				</form>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>

</table>

</body>
</html>
