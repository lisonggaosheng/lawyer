<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
<title>申请人(债权人)企业信息详情</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript">
function clickRaido($item){
	var value = $item.value;
	if(value == 2){
		document.getElementById("markRemark").style.display = "";
	}else{
		document.getElementById("markRemark").style.display = "none";
	}
}

function markApplierinfo(){
    var markform =  document.getElementById("markform");
	mes="确认标记此条信息?";
	if(confirm(mes)){
		markform.submit();
	}
}
</script>
</head>
	<table cellpadding="0" cellspacing="0" width="100%" border="0"
		class="step_table">
		<tr class="title">
			<td colspan="4">&nbsp;&nbsp;<img
				src="/lawyer/images/flag2_16x16.gif" />&nbsp;申请人(债权人)企业信息</td>
		</tr>
		<tr>
			<td>
				案源信息编号：${applierinfo.appCCasecodeself}
			</td>
		</tr>
		<tr>
			<td>市场标记操作：
				<form action="markAppInfo.action" method="post" id="markform">
					<input type="hidden" id="appCCasecodeself" value="${applierinfo.appCCasecodeself}" name="applierinfo.appCCasecodeself"> 
					<input type="hidden" id="caseId" value="${caseId}" name="caseId">
					<!-- <input type="hidden" id="markvalue" name="applierinfo.usedMark"> -->
					<label><input name="applierinfo.usedMark" type="radio" value="1" onclick="clickRaido(this)"/>是 </label>
					<label><input name="applierinfo.usedMark" type="radio" value="0" onclick="clickRaido(this)"/>否</label>
					<label><input name="applierinfo.usedMark" type="radio" value="2" onclick="clickRaido(this)"/>其他 </label>
					<input type="text" name="applierinfo.markRemark" id="markRemark" style="width:300px; display: none;"/>
					<input type="button" value="确认标记" onclick="markApplierinfo()"/>
				</form>
		</td></tr>
		<s:iterator value="applierinfos">
		<tr>
			<td align="right" class="td">
			=========================================================================
			</td>
			<td  class="td">
			=========================================================================
			</td>
		</tr>
		<tr>
			<td align="right" width="45%" class="td">注册号：</td>
			<td class="td">${appRenumber }</td>
		</tr>
		<tr>
			<td align="right" class="td">主体名称：</td>
			<td class="td">${appName}</td>
		</tr>
		<tr>
			<td align="right" class="td">企业类型：</td>
			<td class="td">${appType }</td>
		</tr>
		<tr>
			<td align="right" class="td">法定代表人/负责人：</td>
			<td class="td">${appRepname }</td>
		</tr>
		<%-- <tr>
			<td align="right" class="td">法定代表人/负责人身份证号：</td>
			<td class="td">${appRepid }</td>
		</tr> --%>
		<tr>
			<td align="right" class="td">行政区划：</td>
			<td class="td">${appDistrict }</td>
		</tr>
		<tr>
			<td align="right" class="td">成立日期：</td>
			<td class="td">${appDate }</td>
		</tr>
		<tr>
			<td align="right" class="td">注册资本：</td>
			<td class="td">${appFund }</td>
		</tr>
		<tr>
			<td align="right" class="td">经营期限自：</td>
			<td class="td">${appDfrom }</td>
		</tr>
		<tr>
			<td align="right" class="td">经营期限至：</td>
			<td class="td">${appDto }</td>
		</tr>
		<tr>
			<td align="right" class="td">登记机关：</td>
			<td class="td">${appOrgan }</td>
		</tr>
		<tr>
			<td align="right" class="td">地址/住所：</td>
			<td class="td">${appAddress }</td>
		</tr>
		<tr>
			<td align="right" class="td">企业状态：</td>
			<td class="td">${appStatus }</td>
		</tr>
		<tr>
			<td align="right" class="td">注销日期：</td>
			<td class="td">${appCancellation }</td>
		</tr>
		<tr>
			<td align="right" class="td">吊销日期：</td>
			<td class="td">${appRevoke }</td>
		</tr>
		<tr>
			<td align="right" class="td">年检年度：</td>
			<td class="td">${appAnnual }</td>
		</tr>
		<tr>
			<td align="right" class="td">备注：</td>
			<td class="td">${appRemark }</td>
		</tr>
		<tr>
			<td align="right" class="td">市场标记：</td>
			<td class="td">
				<c:choose>
				    <c:when test="${usedMark == 1}">是</c:when>
				    <c:when test="${usedMark == 0}">否</c:when>
				    <c:when test="${usedMark == 2}">其他：${markRemark }</c:when>
				    <c:otherwise>
				    	还没有进行标记
				    </c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td align="right" class="td">市场标记时间：</td>
			<td class="td">${markTime }</td>
		</tr>
		<tr>
			<td class="td" align="right"><b>可执行操作</b>：</td>
			<td class="td"><a
				href="updapplierinfo?court.ap.appId=${appId }&court.caseId=${caseId}">修改</a>&nbsp;&nbsp;
			<a href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a>
			&nbsp;&nbsp;&nbsp;
		</td>
		</tr>
		</s:iterator>
	</table>
<body>

</body>
</html>
