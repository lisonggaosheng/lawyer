<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>添加第四步（与申请执行人联系信息——电子邮件）页面</title>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/lawyer/js/laydate/laydate.js"></script>
<script language="javascript">
	function yanzhen() {
		var val1 = $("#cmMail").val();
		var leng1 = val1.length;
		if (leng1 > 0) {
			var at1 = val1.indexOf("@");
			var dian1 = val1.indexOf(".");
			var bool1 = leng1 > 0 && at1 < dian1 && at1 != 0 && dian1 != 0
					&& dian1 - at1 > 1 && dian1 != leng1 - 1;
			if (bool1 == false) {
				alert("邮件格式有误!");
				return;
			}
		}
		form3.submit();
	}
</script>
</head>
<body>
	<table cellspacing="0" cellpadding="0" border="0" width="100%"
		height="100%" class="content_table">
		<tr>
			<td>&nbsp;&nbsp;<img src="/lawyer/images/flag3_add_16x16.gif" />&nbsp;
				<span class="title">添加与申请执行人联系信息（电子邮箱）</span></td>
		</tr>
		<tr>
			<td>
        		<table cellpadding="0" cellspacing="0" width="98%" align="center" class="search_table" border="0">
                	<tr>
                    	<c:choose>
					       <c:when test="${param.casecodeself != null}">
					            <td align="left">案源信息编号：<strong>${param.casecodeself}</strong></td>
					       </c:when>
					       <c:when test="${contactMail.cmCasecodeself != null}">
					             <td align="left">案源信息编号：<strong>${contactMail.cmCasecodeself}</strong></td>
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
							<form name="form3" method="post" action="insertConMail"
								enctype="multipart/form-data">

								<table class="form_table" align="center" cellpadding="0"
									cellspacing="0" width="100%" border="0">
									<tr class="title">
										<td align="right"><img src="/lawyer/images/flag2_16x16.gif" />&nbsp;电子邮件</td>
										<td colspan="2">&nbsp;</td>
									</tr>
									<tr>
										<td align="right" width="20%">邮件地址：</td>
										<td colspan="2"><input id="cmMail" type="text"
											name="contactMail.cmMail" value="${contactMail.cmMail}"/></td>
									</tr>
									<tr>
										<td align="right">发送人：</td>
										<td colspan="2"><input type="text"
											name="contactMail.cmMsender" value="${contactMail.cmMsender}"/></td>
									</tr>
									<tr>
										<td align="right">发送时间：</td>
										<td colspan="2"><input type="text"
											name="contactMail.cmDate" onClick="laydate()"
											readonly="readonly" value="${contactMail.cmDate}"/></td>
									</tr>
									<tr>
										<td align="right">发送结果：</td>
										<td colspan="2"><input type="text"
											name="contactMail.cmResult" value="${contactMail.cmResult}"/></td>
									</tr>
									<tr>
										<td align="right">备注：</td>
										<td colspan="2"><textarea class="textarea_remarks"
												name="contactMail.cmRemark">${contactMail.cmRemark}</textarea></td>
									</tr>
									<tr>
										<td align="right">附件：</td>
										<td colspan="2"><input type="file" name="attach" /></td>
									</tr>
									<tr style="display: none;">
										<td colspan="2">
											<c:choose>
										       <c:when test="${param.casecodeself != null}">
										            <input type="hidden" name="contactMail.cmCasecodeself"
														value="${param.casecodeself}" />
													<input type="hidden" name="caseId"
															value="${param.caseId}" />
										       </c:when>
										       <c:when test="${contactMail.cmCasecodeself != null}">
										              	<input type="hidden" name="contactMail.cmCasecodeself"
															value="${contactMail.cmCasecodeself}" />
														<input type="hidden" name="caseId"
															value="${caseId}" />
										       </c:when>
											</c:choose>
										</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td colspan="2"> <input onclick="yanzhen()"
											type="button" value="保存" />&nbsp;&nbsp; <input type="reset"
											value="重置" /></td>
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
