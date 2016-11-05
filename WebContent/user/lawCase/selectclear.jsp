<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>案件查询</title>
<link rel="stylesheet" href="css/public.css" />

<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>

<link rel="stylesheet" href="/lawyer/css/dtree.css" />
<script type="text/javascript">
function loadCalendar(field)
{
	var rtn=window.showModalDialog("/lawyer/user/lawCase/calender.jsp","","dialogWidth:350px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
	if(rtn!=null)
		field.value=rtn;
   return;
}

function yanzhen(){
	var lawyerName = $("#lawyerName").val();
	var ye=$("#gopage").val();
	
	if(lawyerName == ""){
		$("#page").val(ye);
		$("#courts").submit();
	}else{
		$("#namepage").val(ye);
		$("#lawyername").submit();
		
	}
}
	
function fenye(page){
	var lawyerName = $("#lawyerName").val();
	
	if(lawyerName == ""){
		$("#page").val(page);
		$("#courts").submit();
	}else{
		$("#namepage").val(page);
		$("#lawyername").submit();
		
	}
	
}

function searchCourts(){
	var startDate = $("#strTimeEvection").val();
	var endDate = $("#endTimeEvection").val();
	if(startDate != "" && endDate == ""){
		alert("时间区间需要都填写！");
		return;
	}
	if(startDate == "" && endDate != ""){
		alert("时间区间需要都填写！");
		return;
	}
	$("#courts").submit();
}

function searchCourtsByname(){
	var lawyerName = $("#lawyerName").val();
	if(lawyerName == ""){
		alert("承办律师不能为空！");
		return;
	}
	$("#lawyername").submit();
}

function searchCourtsClear(){
	$("#csId").val("");
	$("#csNo").val("");
	$("#csName").val("");
	$("#pname").val("");
	$("#appName").val("");
	$("#strTimeEvection").val("");
	$("#endTimeEvection").val("");
	
	$("#courts").submit();
}
</script>
</head>


<body>
<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr>
		<td colspan="2">&nbsp;&nbsp;<img src="images/view_16x16.gif" />&nbsp;<span
			class="title">案件查询</span></td>
	</tr>
	<tr>
		<td width="30px"></td>
		<td colspan="5" >
		<form id="lawyername" action="/lawyer/searchCourtsByname.action" method="post">
			<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="search_table" border="0">
				<tr>
					<td>
					承办律师：
					<input type="text" name="cont.lawyerName" id="lawyerName" value="${cont.lawyerName}"/>
					<input type="button" value="查询" onclick="searchCourtsByname()"/>
					</td>
				</tr>
				<tr style="display: none;"><td><input type="hidden" name="page" id="namepage" value="0"/></td></tr>
			</table>
		</form>
		<form id="courts" action="/lawyer/selectCourts.action" method="post">
			<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="search_table" border="0">
				<tr>
					<td>序号：<input type="text" name="cont.csId" id="csId" value="${cont.csId}"/></td>
					<td>对方联系人：<input type="text" name="cont.csName" id="csName" value="${cont.csName}"/></td>
				</tr>
				<tr>
					<td>被执行人：<input type="text" name="cont.pname" id="pname" value="${cont.pname}" size="50"/></td>
					<td>申请人：<input type="text" name="cont.appName" id="appName" value="${cont.appName}" size="50"/></td>
				</tr>
				<tr>
					<td>签约号：<input type="text" name="cont.csNo" id="csNo" value="${cont.csNo}"/></td>
					<td colspan="2">签约时间：<input name="startDate"
					value="${startDate }" type="text" id="strTimeEvection" size="20"
					readonly="readonly" onClick="loadCalendar(courts.strTimeEvection)"/>  至：<input
					name="endDate" value="${endDate }" type="text" readonly="readonly"
					id="endTimeEvection" size="20" onClick="loadCalendar(courts.endTimeEvection)"/> </td>
					<td align="right">
						<input type="button" value="查询" onclick="searchCourts()"/>
						<input type="button" value="清空查询" onclick="searchCourtsClear()"/>
					</td>
				</tr>
				<tr style="display: none;"><td><input type="hidden" name="page" id="page" value="0"/></td></tr>
			</table>
			</form>
		</td>
	</tr>
	<tr>
		<td width="20px"></td>
		<td valign="top">
		<table cellpadding="0" cellspacing="0" border="0" align="center"
			width="98%" class="result_table">
			<tr class="title" align="center">
				<td width="5%">序号</td>
				<td width="10%">被执行人</td>
				<td width="10%">申请人</td>
				<td width="10%">签约号</td>
				<td width="10%">签约时间</td>
				<td width="5%">对方联系人</td>
				<td width="10%">电话</td>
				<td width="30%">备注</td>
				<td width="8%">操作</td>
			</tr>
			<s:set value="1" name="css"></s:set>
			<s:iterator value="contractsign" var="sign">

				<tr class="title" align="center">
					<td>${sign[0]}</td>
					<td>${sign[8]}</td>
					<td>${sign[9]}</td>
					<td>${sign[4]}</td>
					<td>${sign[1]}</td>
					<td>${sign[2]}</td>
					<td>${sign[3]}</td>
					<td>${sign[5]}</td>
					<td>
					<a href="selectCourtById?users.id=${admin.UId}&court.casecodeself=${sign[6]}&court.caseId=${sign[7]}" 
						target="_blank">案源详细信息</a>
					<a href="selectDetail?users.id=${admin.UId}&cont.csCasecodeself=${sign[6]}"
						target="_blank">案件详细信息</a></td>
				</tr>
			</s:iterator>
		</table>
	</tr>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td></td>

		<td align="right">${page}/${pagesize}&nbsp;&nbsp; <s:if
			test="%{page!=1}">
			<a href="javascript:fenye(1)">首页</a>
			&nbsp;&nbsp; <a href="javascript:fenye(${page-1})">上页</a>
		</s:if><s:else>
			
		首页&nbsp;&nbsp;上页
		</s:else> <s:if test="%{page!=pagesize}">&nbsp;&nbsp;
		<a href="javascript:fenye(${page+1})">下页</a>
			<a href="javascript:fenye(${pagesize})">末页</a>
		</s:if><s:else>
		
		下页&nbsp;&nbsp;末页</s:else>
		<input type="text" id="gopage" style="width: 40px;"/>
		<input type="button" onclick="yanzhen()" value="go" />
		</td>
	</tr>
</table>

</body>
</html>
