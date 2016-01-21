<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<title>新建案源</title>

<link rel="stylesheet" href="/lawyer/css/public.css" type="text/css"></link>
</head>
<script type="text/javascript">
	$(function(){
		$.ajax({
			   type: "POST",
			   cache: false,
			   url: "/lawyer/lawyerCourt/findFirstLawyerCourt.action",
			   success: function(msg){
				$("#lawyer_one").empty();
				$("#lawyer_one").append("<option id='flawyer' >请选择省份</option>");	
			    	eval("lawyer_one="+msg);
			    	for(i=0;i<lawyer_one.length;i++){
				    	$("#lawyer_one").append("<option id='flawyer' value='"+lawyer_one[i].lawyercourt_id+"'>"+lawyer_one[i].lawyercourt_court_name+"</option>");
				    }

			    	$("#lawyer_one1").empty();
					$("#lawyer_one1").append("<option id='flawyer' >请选择省份</option>");	
				    	eval("lawyer_one1="+msg);	
				    	for(i=0;i<lawyer_one1.length;i++){
					    	$("#lawyer_one1").append("<option id='flawyer' value='"+lawyer_one[i].lawyercourt_id+"'>"+lawyer_one[i].lawyercourt_court_name+"</option>");
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
					    $("#lawyer_tow").append("<option id='flawyer' >请选择一级法院</option>");
				    	eval("lawyer_tow="+msg);
				    	for(i=0;i<lawyer_tow.length;i++){
				    		$("#lawyer_tow").append("<option id='flawyer' value='"+lawyer_tow[i].lawyercourt_id+"'>"+lawyer_tow[i].lawyercourt_court_name+"</option>");
					    }
				   }
				});	
		});
		$("#lawyer_one1").bind("change",function(){
			 $("#noticeCourt").val($("#lawyer_one1").find("option:selected").text());
			$.ajax({
				   type: "POST",
				   cache: false,
				   url: "/lawyer/lawyerCourt/finSecondLawyerCourt.action",
				   data: "fir_id="+$("#lawyer_one1").val(),
				   success: function(msg){
					    $("#lawyer_tow1").empty();
					    $("#lawyer_tow1").append("<option id='flawyer' >请选择一级法院</option>");
				    	eval("lawyer_tow1="+msg);
				    	for(i=0;i<lawyer_tow1.length;i++){
				    		$("#lawyer_tow1").append("<option id='flawyer' value='"+lawyer_tow1[i].lawyercourt_id+"'>"+lawyer_tow1[i].lawyercourt_court_name+"</option>");
					    }
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
					    $("#lawyer_three").append("<option id='flawyer' >请选择二级法院</option>");
				    	eval("lawyer_three="+msg);
				    	for(i=0;i<lawyer_three.length;i++){
				    		$("#lawyer_three").append("<option id='flawyer' value='"+lawyer_three[i].lawyercourt_number+"'>"+lawyer_three[i].lawyercourt_court_name+"</option>");
						}
				    	$("#courtcode").val($("#lawyer_tow").val());
				   }
				});	
		});
		$("#lawyer_tow1").bind("change",function(){
			$("#noticeCourt").val($("#lawyer_one1").find("option:selected").text() + $("#lawyer_tow1").find("option:selected").text());
			$.ajax({
				   type: "POST",
				   cache: false,
				   url: "/lawyer/lawyerCourt/findThirdLawyerCourt.action",
				   data: "sec_id="+$("#lawyer_tow1").val(),
				   success: function(msg){
					    $("#lawyer_three1").empty();
					    $("#lawyer_three1").append("<option id='flawyer' >请选择二级法院</option>");
				    	eval("lawyer_three1="+msg);
				    	for(i=0;i<lawyer_three1.length;i++){
				    		$("#lawyer_three1").append("<option id='flawyer' value='"+lawyer_three1[i].lawyercourt_number+"'>"+lawyer_three1[i].lawyercourt_court_name+"</option>");
						}
				    	$("#courtcode").val($("#lawyer_tow1").val());
				   }
				});	
		});
		$("#lawyer_three").bind("change",function(){
			$("#execCourtName").val($("#lawyer_one").find("option:selected").text() + $("#lawyer_tow").find("option:selected").text() + $("#lawyer_three").find("option:selected").text());	
			$("#courtcode").val($("#lawyer_three").val());
		});
		$("#lawyer_three1").bind("change",function(){
			$("#noticeCourt").val($("#lawyer_one1").find("option:selected").text() + $("#lawyer_tow1").find("option:selected").text() + $("#lawyer_three1").find("option:selected").text());	
			$("#courtcode").val($("#lawyer_three1").val());
		});
	});
	//日历显示
	function loadCalendar(field)
	{
		var rtn=window.showModalDialog("/lawyer/user/source/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
		if(rtn!=null)
			field.value=rtn;
	    return;
	}
	function yanzhen() {
		var val=$("#infoType").val();
		var val3=$("#execCourtName").val();
		var val4=$("#caseCreateTime").val();

		var val1=$("#noticeCourt").val();
		var val2=$("#noticeTime").val();
		if(val.length>0){
			if(val == "1"){
				if(val3.length>0 && val4.length>0){
					courtform.submit();
				}else{
					alert("执行法院和立案时间不能为空");
				}
			}
			if(val == "2"){
				if(val1.length>0 && val2.length>0){
					courtform.submit();
				}else{
					alert("公告法院和公告时间不能为空");
				}
			}
		}else{
			alert("请选择信息类型!");
		}
		
	}
</script>
<body>

<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr>
		<td>&nbsp;&nbsp; <img src="/lawyer/images/flag3_(add)_16x16.gif" />
		&nbsp; <span class="title">新增案源信息&nbsp;|&nbsp;添加被执行人执行信息</span></td>
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
				<form name="courtform" method="post" action="insertCourt">
				<table class="form_table" align="center" cellpadding="0"
					cellspacing="0" width="100%" border="0">
					<tr>
						<td align="right" width="40%">信息类型：</td>
						<td>
							<select name="court.infoType" id="infoType">
								<option value="">请选择信息类型</option>
								<option value="1">普通信息</option>
								<option value="2">公告信息</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right" width="40%">被执行人（债务人）名称：</td>
						<td width="50%"><input type="text" id="pname" name="court.pname" /></td>
					</tr>
					<tr>
						<td align="right" width="40%">债权人名称：</td>
						<td width="50%"><input type="text" id="creditor" name="court.creditor" /></td>
					</tr>
					<tr>
						<td align="right" width="40%">公告法院：</td>
						<td width="50%"><input type="text" id="noticeCourt" name="court.noticeCourt" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<select name="select1" id="lawyer_one1">
							<option value="001">请选择省份</option>
						</select> <select name="select" id="lawyer_tow1">
							<option value="01">请选择一级法院</option>
						</select> <select name="select" id="lawyer_three1">
							<option value="02">请选择二级法院</option>
						</select>
						</td>
					</tr>
					<tr>
						<td align="right" width="40%">公告时间：</td>
						<td width="50%"><input type="text" id="noticeTime" name="court.noticeTime" 
						 onClick="loadCalendar(courtform.noticeTime)" readonly="readonly"/></td>
					</tr>
					<tr>
						<td align="right" width="40%">法律文书号：</td>
						<td width="50%"><input type="text" id="lawDocumentNum" name="court.lawDocumentNum" /></td>
					</tr>
					<tr>
					<td colspan="2">——————————————————————————————————————————
					————————————————————————————————</td>
					</tr>
					<tr>
						<td align="right">身份证号码/组织机构代码：</td>
						<td><input type="text" id="partyCardNum" name="court.partyCardNum" /></td>
					</tr>
					<tr>
						<td align="right">执行法院：</td>
						<td><input type="text" name="court.execCourtName"
							readonly="readonly" id="execCourtName" />  </td>
					</tr>
					<tr>
						<td></td>
						<td>
							<select name="select" id="lawyer_one">
							<option value="01">请选择省份</option>
						</select> <select name="select" id="lawyer_tow">
							<option value="1">请选择一级法院</option>
						</select> <select name="select" id="lawyer_three">
							<option value="2">请选择二级法院</option>
						</select>
						</td>
					</tr>
					<tr>
						<td align="right">立案时间：</td>
						<td><input type="text" name="court.caseCreateTime"
							id="caseCreateTime"
							onClick="loadCalendar(courtform.caseCreateTime)" readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right">案号：</td>
						<td><input type="text" id="caseCode" name="court.caseCode" /></td>
					</tr>
					<tr>
						<td align="right">案件状态：</td>
						<td><select name="court.caseState">
							<option value="执行中" >执行中</option>
							<option value="已结案">已结案</option>
						</select> </td>
					</tr>
					<tr>
						<td align="right">执行标的：</td>
						<td><input type="text" id="execMoney" name="court.execMoney" onkeyup="if(event.keyCode !=37 && event.keyCode != 39) value=value.replace(/\D/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/\D/g,''))"/></td>
						<td ><input type="hidden" name="court.courtcode" id="courtcode" /></td>
					</tr>
					<tr>
						<td align="right">备注：</td>
						<td>
							<textarea rows="5" cols="50" id="remark" name="court.remark" ></textarea>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="button"
							value="保存" onclick="yanzhen()"/>&nbsp;&nbsp; <input type="reset" value="重置" /></td>
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
