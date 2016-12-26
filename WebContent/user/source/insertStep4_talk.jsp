<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加第四步（与申请执行人联系信息——约谈跟进情况）页面</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/lawyer/js/selectpenson.js"></script>
<script type="text/javascript" src="/lawyer/js/laydate/laydate.js"></script>
<script language="javascript">

	function selectpenson(){
		var pensonname = $("#penson").find("option:selected").text();
		$("#ctLawyerName").val(pensonname);	
	}
	
  </script>
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
			       <c:when test="${contactTalk.ctCasecodeself != null}">
			             <td align="left">案源信息编号：<strong>${contactTalk.ctCasecodeself}</strong></td>
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
				<form name="form3" method="post" action="insertConTalk.action"
					enctype="multipart/form-data">
				<table class="form_table" align="center" cellpadding="0"
					cellspacing="0" width="100%" border="0">
					<tr class="title">
						<td align="right"><img src="/lawyer/images/flag2_16x16.gif" />&nbsp;约谈跟进情况</td>
						<td colspan="2">&nbsp;</td>
					</tr>					
					<tr>
						<td align="right">对方联系人：</td>
						<td colspan="2"><input type="text" name="contactTalk.ctName" value="${contactTalk.ctName }"/></td>
					</tr>
					<tr>
						<td align="right">跟进人：</td>
						<td colspan="2">
							<input type="text" id="ctLawyerName" name="contactTalk.ctLawyerName" value="${contactTalk.ctLawyerName }" 
								readOnly="true"/>
							<select name="penson" id="penson" onchange="selectpenson()">
								<option >请选择跟进人</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right">跟进情况：</td>
						<td colspan="2"><input type="text" name="contactTalk.ctResult" value="${contactTalk.ctResult }"/></td>
					</tr>
					<tr>
						<td align="right" width="20%">时间：</td>
						<td colspan="2"><input type="text" name="contactTalk.ctDate" value="${contactTalk.ctDate }" 
						id="calendardate" onClick="laydate()" readonly="readonly"/></td>
					</tr>
					<tr>
						<td align="right">备注：</td>
						<td colspan="2"><textarea class="textarea_remarks"
							name="contactTalk.ctRemark">${contactTalk.ctRemark}</textarea></td>
					</tr>
					<tr>
						<td align="right">附件：</td>
						<td colspan="2"><input type="file" name="attach" /></td>
					</tr>
					<tr style="display: none;">
						<td colspan="2">
							<c:choose>
						       <c:when test="${param.casecodeself != null}">
						            <input type="hidden" name="contactTalk.ctCasecodeself"
										value="${param.casecodeself}" />
									<input type="hidden" name="caseId"
											value="${param.caseId}" />
						       </c:when>
						       <c:when test="${contactTalk.ctCasecodeself != null}">
						              	<input type="hidden" name="contactTalk.ctCasecodeself"
											value="${contactTalk.ctCasecodeself}" />
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
