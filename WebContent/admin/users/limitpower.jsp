<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<title>用户权限页面</title>
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
</script>
</head>
<body>
	<h4>用户<s:property value="lp.lp_user_name"/>的权限</h4>
	<form action="upduserlp" method="post">
		<h4>案源相关：</h4>
		<input name="lp.lp_id" type="hidden" value="<s:property value="lp.lp_id"/>"/>
		<input name="lp.lp_user_name" type="hidden" value="<s:property value="lp.lp_user_name"/>"/>
	    <input name="lp.lp_add_casesource"  type="checkbox" value="1" <s:if test="%{lp.lp_add_casesource==1 }">checked="checked"</s:if> />新增案源&nbsp;&nbsp;
	    <input name="lp.lp_add_casesource_bat"  type="checkbox" value="1" <s:if test="%{lp.lp_add_casesource_bat==1 }">checked="checked"</s:if> />批量新增案源&nbsp;&nbsp;
	    <input name="lp.lp_query_casesource"  type="checkbox" value="1" <s:if test="%{lp.lp_query_casesource==1 }">checked="checked"</s:if>/>查询案源&nbsp;&nbsp;
	    <input name="lp.lp_query_casesource_detail"  type="checkbox" value="1" <s:if test="%{lp.lp_query_casesource_detail==1 }">checked="checked"</s:if>/>查询详细案源信息&nbsp;&nbsp;
	    <input name="lp.lp_query_casesource_resultopts"  type="checkbox" value="1" <s:if test="%{lp.lp_query_casesource_resultopts==1 }">checked="checked"</s:if> />案源查询结果批量操作&nbsp;&nbsp;
	    <input name="lp.lp_senior_query_casesource"  type="checkbox" value="1" <s:if test="%{lp.lp_senior_query_casesource==1 }">checked="checked"</s:if> />高级查询案源&nbsp;&nbsp;
	    <input name="lp.lp_statistics_casesource"  type="checkbox" value="1" <s:if test="%{lp.lp_statistics_casesource==1 }">checked="checked"</s:if> />案源统计&nbsp;&nbsp;<br/><br/>
	    <input name="lp.lp_exb_show_repid"  type="checkbox" value="1" <s:if test="%{lp.lp_exb_show_repid==1 }">checked="checked"</s:if> />被执行人企业信息法人身份证号&nbsp;&nbsp;<br/><br/>
	    
	    
	    <h4>案件相关：</h4>
	    <input name="lp.lp_add_case"  type="checkbox" value="1" <s:if test="%{lp.lp_add_case==1 }">checked="checked"</s:if> />新增案件&nbsp;&nbsp;
	    <input name="lp.lp_query_case"  type="checkbox" value="1" <s:if test="%{lp.lp_query_case==1 }">checked="checked"</s:if> />查询案件&nbsp;&nbsp;
	    <input name="lp.lp_query_case_detail"  type="checkbox" value="1" <s:if test="%{lp.lp_query_case_detail==1 }">checked="checked"</s:if> />查询详细案件信息&nbsp;&nbsp;
	    <input name="lp.lp_senior_query_case"  type="checkbox" value="1" <s:if test="%{lp.lp_senior_query_case==1 }">checked="checked"</s:if> />高级查询案件&nbsp;&nbsp;
	    <input name="lp.lp_statistics_case"  type="checkbox" value="1" <s:if test="%{lp.lp_statistics_case==1 }">checked="checked"</s:if> />案件统计&nbsp;&nbsp;<br/><br/>
	    
	    <h4>文件库相关：</h4>
	    <input name="lp.lp_add_filebase"  type="checkbox" value="1" <s:if test="%{lp.lp_add_filebase==1 }">checked="checked"</s:if> />新增文件库&nbsp;&nbsp;
	    <input name="lp.lp_query_filebase"  type="checkbox" value="1" <s:if test="%{lp.lp_query_filebase==1 }">checked="checked"</s:if> />查询文件库&nbsp;&nbsp;<br/><br/>
	    
	    <h4>附加权限：</h4>
	           限制查询的法院：<input name="lp.lp_limit_query_court" id="courtcode" type="text" value="<s:property value="lp.lp_limit_query_court"/>" />
	          		    <select name="select" id="lawyer_one"> 
							<option value="01">第一级</option>
						</select>
						<select name="select" id="lawyer_tow">
							<option value="1">第二级</option>
						</select> 
						<select name="select" id="lawyer_three">
							<option value="2">第三级</option>
						</select>&nbsp;&nbsp;<br>
	    <input name="lp.lp_upd"  type="checkbox" value="1" <s:if test="%{lp.lp_upd==1 }">checked="checked"</s:if> />所有修改&nbsp;&nbsp;
	    <input name="lp.lp_del"  type="checkbox" value="1" <s:if test="%{lp.lp_del==1 }">checked="checked"</s:if> />所有删除&nbsp;&nbsp;<br/><br/>
	    <input type="submit" value="保存"/>
	</form>
</body>
</html>