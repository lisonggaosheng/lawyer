<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript"><!--
	function yeshu(cp){
		document.getElementById("cp").value=cp;
		document.getElementById("fenye").submit();
	}
	function fenyebycourt(courtcode){
		document.getElementById("courtcode").value=courtcode;
		document.getElementById("fenye").submit();
	}
	function loadCalendar(field)
	{
		var rtn=window.showModalDialog("/lawyer/user/source/calender.jsp","","dialogWidth:350px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
		if(rtn!=null)
			field.value=rtn;
	   return;
	}
	
	function resultopt(){
		var executestep = document.getElementById("step").value;
		if(executestep==""){
			alert("请选择案源当前执行步骤!");
			return;
		}
		if(executestep=="1"){
			alert("案源执行步骤必须大于等于第二步（>=2）!");
			return;
		}
		var mes = "";
		var strTimeEvection = document.getElementById("strTimeEvection").value;
		var endTimeEvection = document.getElementById("endTimeEvection").value;
		if(strTimeEvection=="" && endTimeEvection==""){
				mes="所有时间段,";
		}else if(strTimeEvection!="" && endTimeEvection==""){
				mes=strTimeEvection+"以后,";
		}else if(endTimeEvection!="" && strTimeEvection==""){
				mes=endTimeEvection+"以前,";
		}else{
				mes="时间段"+strTimeEvection+"至"+endTimeEvection+"期间,";
		}
		mes+="当前操作为 \"";
		if(executestep=="1"){
			mes+="被执行人执行信息";
		}else if(executestep=="2"){
			mes+="被执行人企业信息";
		}else if(executestep=="3"){
			mes+="申请执行人企业信息";
		}else if(executestep=="4"){
			mes+="申请执行人网络信息";
		}else if(executestep=="5"){
			mes+="申请执行人自有信息";
		}
		mes+="\"的";
		var courtcode = document.getElementById("courtcode").value;//法院编号
		if(courtcode==""){
			mes+="所有案源,";
		}else{
			mes+="编号为"+courtcode+"法院下所有案源,";
		}
		mes+="将被系统生成文件,是否继续?";
		//入库时间
		var instrTimeEvection=document.getElementById("instrTimeEvection").value;
		var inendTimeEvection = document.getElementById("inendTimeEvection").value;
		//执行标的
		var minMoney = document.getElementById("minMoney").value;
		var maxMoney = document.getElementById("maxMoney").value;
		
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/createUpdateData.action",
				data:"court.courtcode="+courtcode+"&court.executestep="+executestep+"&startDate="+strTimeEvection+"&endDate="+endTimeEvection+"&instartDate="+instrTimeEvection+"&inendDate="+inendTimeEvection+"&minMoney="+minMoney+"&maxMoney="+maxMoney,
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	//企业状态更新
	function updateStutas(){
		var mes = "确定进行企业状态更新操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/updateStutas.action",
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	
	/*
	*法院编码更新
	*/
	function courtcodeUpdate(){
		var mes = "确定进行法院编码更新操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/courtcodeUpdate.action",
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	
	function tiao(){
		var cp = document.getElementById("tiaoye").value;
		if(isNaN(cp)){
			alert("请输入正确数字！");
			return;
		}
		document.getElementById("cp").value=cp;
		document.getElementById("fenye").submit();
	}
</script>
</head>
<body>

<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr>
		<td colspan="2">&nbsp;&nbsp;<img src="images/view_16x16.gif" />&nbsp;<span
			class="title">查询案源信息</span></td>
	</tr>
	<tr>
		<td colspan="2">
		<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="search_table" border="0">
			<tr>
				<td align="center" colspan="2">
				<form id="fenye" action="updateStutasByCourt.action" method="post">
				案源当前执行步骤: <select name="court.executestep" id="step">
					<option value="">请选择执行步骤</option>
					<option value="1" <s:if test="%{court.executestep==1}" >selected</s:if>>1.被执行人执行信息</option>
					
					
					<option value="2"
						<s:if test="%{court.executestep==2}" >selected</s:if>>2.被执行人企业信息</option>
					<option value="3"
						<s:if test="%{court.executestep==3}" >selected</s:if>>3.申请执行人企业信息</option>
					<option value="4"
						<s:if test="%{court.executestep==4}" >selected</s:if>>4.申请执行人网络信息</option>
					<option value="5"
						<s:if test="%{court.executestep==5}" >selected</s:if>>5.申请执行人自有信息</option>
					<option value="6"
						<s:if test="%{court.executestep==6}" >selected</s:if>>6.与申请人联系信息</option>
					<option value="7"
						<s:if test="%{court.executestep==7}" >selected</s:if>>7.已签约</option>
				</select>&nbsp;&nbsp;&nbsp; 立案时间从：<input name="startDate"
					value="${startDate }" type="text" id="strTimeEvection" size="20"
					readonly="readonly" /> <img src="/lawyer/images/date.gif"
					width="20" height="20"
					onClick="loadCalendar(fenye.strTimeEvection)"> 至：<input
					name="endDate" value="${endDate }" type="text" readonly="readonly"
					id="endTimeEvection" size="20" /> <img
					src="/lawyer/images/date.gif" width="20" height="20"
					onClick="loadCalendar(fenye.endTimeEvection)" /><br />
				入库时间从：<input name="instartDate" value="${instartDate }" type="text"
					id="instrTimeEvection" size="20" readonly="readonly" /> <img
					src="/lawyer/images/date.gif" width="20" height="20"
					onClick="loadCalendar(fenye.instrTimeEvection)"> 至：<input
					name="inendDate" value="${inendDate }" type="text"
					readonly="readonly" id="inendTimeEvection" size="20" /> <img
					src="/lawyer/images/date.gif" width="20" height="20"
					onClick="loadCalendar(fenye.inendTimeEvection)" /> 执行标的:<input
					type="text" id="minMoney" name="minMoney" value="${minMoney }" />元----<input
					type="text" id="maxMoney" name="maxMoney" value="${maxMoney }" />元
				<input type="hidden" name="cp" id="cp" /> <input type="hidden"
					name="court.courtcode" id="courtcode" value="${court.courtcode }"><br />
				<input type="submit" value="查询" />
				<c:if test="${userlp.lp_query_casesource_resultopts==1}">
					<input type="button" value="查询结果批量操作" onclick="resultopt()">&nbsp;&nbsp;&nbsp;
				</c:if>
				<input type="button" value="企业状态更新" onclick="updateStutas()">
				</form>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<table cellpadding="0" cellspacing="0" border="0" align="center"
	width="98%" class="result_table">
	<tr>
		<td colspan="2">&nbsp;&nbsp;<img src="images/view_16x16.gif" />&nbsp;
		<span class="title">案源信息</span></td>
	</tr>
	<tr class="title" align="center">
		<td>案源编号</td>
		<td>被执行人（债权人）</td>
				<td>执行法院</td>
				<td>立案时间</td>
				<td>案号</td>
				<td>操作</td>
	</tr>
	<s:iterator id="c" value="courts">
		<tr align="center">
			<td><s:property value="#c.casecodeself" /></td>
			<td><s:property value="#c.pname" /></td>
			<td><s:property value="#c.execCourtName" /></td>
			<td><s:property value="#c.caseCreateTime" /></td>
			<td><s:property value="#c.caseCode" /></td>
			<td>
			<c:if test="${userlp.lp_query_casesource_detail==1}">
				<a href="selectCourtById?users.id=${admin.UId}&court.casecodeself=<s:property value="#c.casecodeself"/>&court.caseId=<s:property value="#c.caseId"/>" target="content">查看详细信息</a>&nbsp;&nbsp; 
			</c:if>
			<c:if test="${userlp.lp_del==1}">
				<a href="#">删除</a>
			</c:if>
			</td>
		</tr>
	</s:iterator>
	<tr>
		<td colspan="6">第${cp }页/共${tp }页&nbsp;&nbsp;<a
			href="javascript:yeshu(1)">首页</a>&nbsp;<a
			href="javascript:yeshu('${cp-1 }')">上一页</a>&nbsp;<a
			href="javascript:yeshu('${cp+1 }')">下一页</a>&nbsp;<a
			href="javascript:yeshu('${tp }')">尾页</a>
			<input type="text" id="tiaoye" style="width: 40px;"/>
			<input type="button" onclick="tiao()" value="go" />	
		</td>
	</tr>
</table>

<table cellpadding="0" cellspacing="0" border="0" align="center"
		width="98%" class="result_table">
		<tr>
			<td colspan="2">&nbsp;&nbsp;<img src="images/view_16x16.gif" />&nbsp;
			<span class="title">法院代码更新操作</span></td>
		</tr>
			<tr>
				<td align="center" width="50%"><input type="button" value="法院代码更新"
					onclick="courtcodeUpdate()" /></td>
				<td align="left" width="50%"></td>
			</tr>
	</table>
</body>
</html>