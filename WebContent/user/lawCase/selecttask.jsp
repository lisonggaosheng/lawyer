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
<title>代办事项查询</title>
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
	$("#page").val(page);
	$("#courts").submit();
	
}

function searchCourts(){
	$("#courts").submit();
}

function searchCourtsClear(){
	$("#lawyername").val("");
	$("#courts").submit();
}

function sendSms(taskid,status) {
	if(status == 0){
		alert("此事项已停用，请启用后再用！");
	}

	$.ajax({
		type : "POST",
		cache : false,
		url : "/lawyer/smsremind.action",
		data : "taskid=" + taskid,
		success : function(msg) {
			var obj = eval('(' + msg + ')');
			if (obj.result == 1) {
				alert(obj.message);
				hidediv();
			} else {
				alert(obj.message);
			}
		}
	});
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
		<form id="courts" action="/lawyer/selectTasks.action" method="post">
			<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="search_table" border="0">
				<tr>
					<td>办案律师：<input type="text" name="usertask.lawyername" id="lawyername" value="${usertask.lawyername}"/></td>
				</tr>
				<tr style="display: none;"><td><input type="hidden" name="page" id="page" value="0"/></td></tr>
			</table>
			</form>
		</td>
	</tr>
		</td>
	</tr>
	<tr>
		<td width="20px"></td>
		<td valign="top">
		<table cellpadding="0" cellspacing="0" border="0" align="center"
			width="98%" class="result_table">
			<tr class="title" align="center">
				<td width="5%">序号</td>
				<td width="10%">办案律师</td>
				<td width="10%">联系电话</td>
				<td width="10%">提醒日期</td>
				<td width="30%">内容</td>
				<td width="10%">提醒次数</td>
				<td width="5%">状态</td>
				<td width="8%">操作</td>
			</tr>
			<s:set value="1" name="css"></s:set>
			<s:iterator value="tasks" var="task" status="index">
				<tr class="title" align="center">
					<td>${id}</td>
					<td>${lawyername}</td>
					<td>${lawyermobile}</td>
					<td>${remindTime}</td>
					<td>${content}</td>
					<td>${times}</td>
					<td>
						<s:if test="%{status==1 }">启用</s:if>
						<s:if test="%{status==0 }">停用</s:if>
					</td>
					<td>
					<a href="javascript:void(0);" onclick="sendSms('${id}','${status}')"
						target="content">提醒</a>
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
