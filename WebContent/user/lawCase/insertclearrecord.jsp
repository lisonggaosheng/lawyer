<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加清算立案信息</title>
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
		<td>&nbsp;&nbsp;<img src="/lawyer/images/flag3_(add)_16x16.gif" />&nbsp;
		<span class="title">添加清算立案信息</span></td>
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
			       <c:when test="${clearRecord.crcasecodeself != null}">
			              	<td align="left">案件信息编号：${clearRecord.crcasecodeself}</td>
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
				<form name="form3"  method="post" enctype="multipart/form-data" action="addclearrecord">
				<table class="form_table" align="center" cellpadding="0"
					cellspacing="0" width="100%" border="0">
					<tr>
						<td align="right" width="20%">材料递交时间：</td>
						<td><input type="text" name="clearRecord.crdate"
							onclick="loadCalendar(this)" readonly="readonly" value="${clearRecord.crdate}" /></td>
					</tr>
					<tr>
						<td align="right">立案案号：</td>
						<td><input type="text"
							name="clearRecord.crnumber" value="${clearRecord.crnumber}" /></td>
					</tr>

					<tr>
						<td align="right">联系法官：</td>
						<td><input type="text"
							name="clearRecord.crcontactjudge" value="${clearRecord.crcontactjudge}" /></td>
					</tr>
					<tr>
						<td align="right">法官电话：</td>
						<td><input type="text" name="clearRecord.crcontacttel" value="${clearRecord.crcontacttel}"/></td>
					</tr>
					<tr>
						<td align="right">承办律师：</td>
						<td>
							<input type="text" id="lawyername" name="clearRecord.crlawname" readOnly="true" value="${clearRecord.crlawname}"/>
							<select name="lawyerinfo" id="lawyerinfo" onchange="selectlawyer()">
								<option >请选择办案律师</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right">律师电话：</td>
						<td><input type="text" id="lawyermobil" name="clearRecord.crlawtel" readOnly="true" value="${clearRecord.crlawtel}"/></td>
					</tr>
					<tr>
						<td align="right">协办人员：</td>
						<td>
							<input type="text" id="assistingName" name="clearRecord.assistingName" readOnly="true" value="${clearRecord.assistingName}"/>
							<select name="assistinglawyer" id="assistinglawyer" onchange="selectassisting()">
								<option >请选择办案律师</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right">协办联系方式：</td>
						<td><input type="text" id="assistingTel" name="clearRecord.assistingTel" readOnly="true" value="${clearRecord.assistingTel}"/></td>
					</tr>
					<tr>
						<td align="right">管辖法院：</td>
						<td><input type="text"  name="clearRecord.competentCourt" id="competentCourt" 
						onClick="showdiv()" readOnly="readonly" value="${clearRecord.competentCourt}"/></td>
					</tr>
					<tr>
						<td align="right">案件进展：</td>
						<td><input type="text" name="clearRecord.crfollowupresult" value="${clearRecord.crfollowupresult}" /></td>
					</tr>
					<tr>
						<td align="right">备注：</td>
						<td><textarea rows="5" cols="50" id="crremark" name="clearRecord.crremark" >${clearRecord.crremark}</textarea>
							<c:choose>
						       <c:when test="${param.Casecodeself != null}">
						            <input type="hidden" name="clearRecord.crcasecodeself"
										value="${param.Casecodeself}" />
						       </c:when>
						       <c:when test="${clearRecord.crcasecodeself != null}">
						              	<input type="hidden" name="clearRecord.crcasecodeself"
											value="${clearRecord.crcasecodeself}" />
						       </c:when>
							</c:choose>
						</td>
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
