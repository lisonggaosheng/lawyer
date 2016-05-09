<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加执行阶段</title>
<link rel="stylesheet" href="../../css/public.css" />
<link rel="stylesheet" href="/lawyer/css/demo.css" type="text/css">
<link rel="stylesheet" href="/lawyer/css/zTreeStyle/zTreeStyle.css"
	type="text/css">

<script type="text/javascript"
	src="/lawyer/js/ztree/jquery-1.4.4.min.js"></script>
<script type="text/javascript"
	src="/lawyer/js/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="/lawyer/js/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript"
	src="/lawyer/js/ztree/jquery.ztree.exedit-3.5.js"></script>

<script type="text/javascript" src="/lawyer/js/selectlawyer.js"></script>
<script type="text/javascript" src="/lawyer/js/createztree.js"></script>


<style type="text/css">
#bg {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.7;
	opacity: .70;
	filter: alpha(opacity = 70);
}

#dtree {
	display: none;
	position: absolute;
	top: 25%;
	left: 42%;
	width: 30%;
	height: 80%;
	padding: 8px;
	border: 8px solid #E8E9F7;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}
</style>

<script language="javascript">
function loadCalendar(data)
{
	var rtn=window.showModalDialog("/lawyer/user/lawCase/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
	if(rtn!=null){
		$(data).val(rtn);
	}		
   return;
}
function selectlawyer(){
	$("#lawyername").val($("#lawyerinfo").find("option:selected").text());	
	$("#lawyermobil").val($("#lawyerinfo").val());
}
function selectassisting(){
	$("#assistingName").val($("#assistinglawyer").find("option:selected").text());	
	$("#assistingTel").val($("#assistinglawyer").val());
}
function showdiv() {
	createTree();
	document.getElementById("bg").style.display = "block";
	document.getElementById("dtree").style.display = "block";
}
function hidediv() {
	document.getElementById("bg").style.display = 'none';
	document.getElementById("dtree").style.display = 'none';
}
$(document).ready(function() {
	ruler.init("ruler");

});
 </script>
</head>
<body>
<div id="bg"></div>
<div id="dtree">
	<ul id="treeDemo" class="ztree"></ul>
	<form id="courtForm" action="findCourts.action">
		<input id="court_number" type="hidden" value="" />
	</form>
</div>
<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr>
		<td>&nbsp;&nbsp;<img src="../../images/flag3_(add)_16x16.gif" />&nbsp;
		<span class="title">添加执行阶段</span></td>
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
			       <c:when test="${execute.excasecodeself != null}">
			              	<td align="left">案件信息编号：${execute.excasecodeself}</td>
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
				<form name="form3" method="post" action="addexecute" enctype="multipart/form-data">
				<table class="form_table" align="center" cellpadding="0"
					cellspacing="0" width="100%" border="0">
					<tr>
						<td align="right">案号：</td>
						<td><input type="text" name="execute.exnumber" value="${execute.exnumber}" /></td>
					</tr>
					<tr>
						<td align="right" width="20%">执行时间：</td>
						<td><input type="text" name="execute.exdate" 
							onclick="loadCalendar(this)" readonly="readonly" value="${execute.exdate}" /></td>
					</tr>
					<tr>
						<td align="right">承办法官：</td>
						<td><input type="text" name="execute.exjudge" value="${execute.exjudge}" /></td>
					</tr>
					<tr>
						<td align="right">法官联系电话：</td>
						<td><input type="text" name="execute.exjudgetel" value="${execute.exjudgetel}"
							 /></td>
					</tr>
					<tr>
						<td align="right">承办律师：</td>
						<td>
							<input type="text" id="lawyername" name="execute.exlawname"
							 readOnly="true" value="${execute.exlawname}"/>
							<select name="lawyerinfo" id="lawyerinfo" onchange="selectlawyer()">
								<option >请选择办案律师</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right">律师联系电话：</td>
						<td><input type="text" id="lawyermobil" name="execute.exlawtel"
						 readOnly="true" value="${execute.exlawtel}"/></td>
					</tr>
					<tr>
						<td align="right">协办人员：</td>
						<td>
							<input type="text" id="assistingName" name="execute.assistingName" readOnly="true"
								value="${execute.assistingName}" />
							<select name="assistinglawyer" id="assistinglawyer" onchange="selectassisting()">
								<option >请选择办案律师</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right">协办联系方式：</td>
						<td><input type="text" id="assistingTel" name="execute.assistingTel" readOnly="true"
						value="${execute.assistingTel}" /></td>
					</tr>
					<tr>
						<td align="right">管辖法院：</td>
						<td><input type="text" name="execute.competentCourt" id="competentCourt" 
						onClick="showdiv()" readOnly="readonly" value="${execute.competentCourt}" /></td>
					</tr>
					<tr>
						<td align="right">执行标的额：</td>
						<td><input type="text" name="execute.execMoney" value="${execute.execMoney}" /></td>
					</tr>
					<tr>
						<td align="right">案件结果：</td>
						<td><input type="text" name="execute.exfollowupresult" /></td>
					</tr>
					<tr>
						<td align="right">备注：</td>
						<td><textarea rows="5" cols="50" name="execute.exremark" ></textarea>
							<c:choose>
						       <c:when test="${param.Casecodeself != null}">
						            <input type="hidden" name="execute.excasecodeself"
										value="${param.Casecodeself}" />
						       </c:when>
						       <c:when test="${execute.excasecodeself != null}">
						              	<input type="hidden" name="execute.excasecodeself"
											value="${execute.excasecodeself}" />
						       </c:when>
							</c:choose>
					</tr>
					<tr>
						<td align="right">附件：</td>
						<td><input type="file" name="attach" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="submit"
							value="保存" />&nbsp;&nbsp; <input type="reset" value="重置" /></td>
					</tr>
				</table>
				</form>
				</td>
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
