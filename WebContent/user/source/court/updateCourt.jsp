<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>
 <script type="text/javascript" src="/lawyer/js/laydate/laydate.js"></script>
<title>修改案源</title>

<link rel="stylesheet" href="/lawyer/css/public.css" type="text/css"></link>
</head>
<script type="text/javascript">
	$(function(){
		$.ajax({
			   type: "POST",
			   cache: false,
			   url: "/lawyer/lawyerCourt/findFirstLawyerCourt.action",
			   success: function(msg){
			    	eval("lawyer_one="+msg);		    			    	
			    	for(i=0;i<lawyer_one.length;i++){
				    	$("#lawyer_one").append("<option id='flawyer' value='"+lawyer_one[i].lawyercourt_id+"'>"+lawyer_one[i].lawyercourt_court_name+"</option>");
			    	}
			   }
			});

		$("#lawyer_one").bind("change",function(){
			 $("#execCourtName").val($("#lawyer_one").find("option:selected").text());
			$.ajax({
				   type: "POST",
				   cache: false,
				   url: "/lawyer/lawyerCourt/finSecondLawyerCourt.action",
				   data: "fir_id="+$("#lawyer_one").val(),
				   success: function(msg){
					    $("#lawyer_tow").empty();
					    $("#lawyer_tow").append("<option value='0'>第二级</option>");
				    	eval("lawyer_tow="+msg);
				    	for(i=0;i<lawyer_tow.length;i++){
				    		$("#lawyer_tow").append("<option id='flawyer' value='"+lawyer_tow[i].lawyercourt_id+"'>"+lawyer_tow[i].lawyercourt_court_name+"</option>");
				    	}
				    	$("#courtcode").val($("#lawyer_one").val());
				   }
				});	
		});
		$("#lawyer_tow").bind("change",function(){
			$("#execCourtName").val($("#lawyer_one").find("option:selected").text() + $("#lawyer_tow").find("option:selected").text());
			$.ajax({
				   type: "POST",
				   cache: false,
				   url: "/lawyer/lawyerCourt/findThirdLawyerCourt.action",
				   data: "sec_id="+$("#lawyer_tow").val(),
				   success: function(msg){
					    $("#lawyer_three").empty();
					    $("#lawyer_three").append("<option value='0'>第三级</option>");
				    	eval("lawyer_three="+msg);
				    	for(i=0;i<lawyer_three.length;i++){
				    		$("#lawyer_three").append("<option id='flawyer' value='"+lawyer_three[i].lawyercourt_id+"'>"+lawyer_three[i].lawyercourt_court_name+"</option>");
				    	}
				    	$("#courtcode").val($("#lawyer_tow").val());
				   }
				});	
		});
		$("#lawyer_three").bind("change",function(){
			$("#execCourtName").val($("#lawyer_one").find("option:selected").text() + $("#lawyer_tow").find("option:selected").text() + $("#lawyer_three").find("option:selected").text());	
			$("#courtcode").val($("#lawyer_three").val());
			});
		
	});
	//日历显示
	function loadCalendar(field)
	{
		var rtn=window.showModalDialog("user/source/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
		if(rtn!=null)
			field.value=rtn;
	    return;
	}
	
	       
</script>
<body>

<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr>
		<td>&nbsp;&nbsp; <img src="/lawyer/images/flag3_(add)_16x16.gif" />
		&nbsp; <span class="title">修改案源信息&nbsp;|&nbsp;修改被执行人执行信息</span></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>
		<table align="left" cellpadding="0" cellspacing="0" width="90%"
			border="0">
			<tr>
				<td>
				<form name="courtform" method="post" action="toupdCourt1">
				<table class="form_table" align="center" cellpadding="0"
					cellspacing="0" width="100%" border="0">
					<tr>
						<td align="right" width="50%">被执行人姓名/名称：</td>
						<td width="50%"><input type="text" name="court.pname" value="${court.pname }" /></td>
					</tr>
					<tr>
						<td align="right">身份证号码/组织机构代码：</td>
						<td><input type="text" name="court.partyCardNum" value="${court.partyCardNum }" /></td>
					</tr>
					<tr>
						<td align="right">执行法院：</td>
						<td><input type="text" name="court.execCourtName"
							readonly="readonly" id="execCourtName" value="${court.execCourtName }" />  </td>
					</tr>
					<tr>
						<td></td>
						<td>
							<select name="select" id="lawyer_one">
							<option value="01">第一级</option>
						</select> <select name="select" id="lawyer_tow">
							<option value="1">第二级</option>
						</select> <select name="select" id="lawyer_three">
							<option value="2">第三级</option>
						</select>
						</td>
					</tr>
					<tr>
						<td align="right">立案时间：</td>
						<td><input type="text" name="court.caseCreateTime"
							id="caseCreateTime"
							onClick="laydate()" readonly="readonly" value="${court.caseCreateTime}" /></td>
					</tr>
					<tr>
						<td align="right">案号：</td>
						<td><input type="text" name="court.caseCode" value="${court.caseCode}" /></td>
					</tr>
					
					<tr>
						<td align="right">案件状态：</td>
						<td><select name="court.caseState">
							<option value="执行中" <s:if test="court.caseState==执行中">selected="selected"</s:if>>执行中</option>
							<option value="已结案" <s:if test="court.caseState==已结案">selected="selected"</s:if>>已结案</option>
						</select> </td>
					</tr>
					<tr>
						<td align="right">执行标的：</td>
						<td><input type="text" name="court.execMoney" value="${court.execMoney }"/></td>
					</tr>
					<tr>
						<td align="right">备注：</td>
						<td><textarea rows="5" cols="50" name="court.remark" >${court.remark}</textarea> </td>
					</tr>
					<tr>
						<td style="display: none;"><input type="text"
							name="court.courtcode" id="courtcode" value="${court.courtcode }" />
							<input type="hidden"
							name="court.casecodeself"  value="${court.casecodeself }" />
							<input type="hidden"
							name="court.id" value="${court.id }" />
							<input type="hidden"
							name="court.caseId"  value="${court.caseId }" />
							<input type="hidden"
							name="court.savetime" value="${court.savetime }" />
							<input type="hidden"
							name="court.beijingCourtState" value="${court.beijingCourtState }" />
							<input type="hidden"
							name="court.uid"  value="${court.uid }" />
							<input type="hidden"
							name="court.executestep"  value="${court.executestep }" />
							<input type="hidden"
							name="court.infoType"  value="${court.infoType }" />
							</td>
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
		</td>
		
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>

</body>
</html>
