<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
 <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>两高律师办公系统|欢迎登录</title>
<script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>
<style>
.menu_div{font-size:16px; height:40px; padding-left:10px; padding-right:10px; float:left;text-align:center; line-height:40px; cursor:pointer; font-family:Microsoft YaHei;}
/*.menu_div:hover{ background-color:rgb(37,131,231);}
*/
.hide{display:none;}
.hide a{ color:white; text-decoration:underline;}
</style>
<script type="text/javascript">
function hideOpt(){
	$(".menu_div").css({"color":"black","background-color":"rgb(180,202,205)"});	
	$(".hide").hide();	
}
$(document).ready(function(){
	
	$("#anyuanguanli").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_anyuanguanli").show();
	});	
	$("#anyuanchaxun").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_anyuanchaxun").show();
	});	
	$("#anyuantongji").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_anyuantongji").show();
	});		
	$("#anjianguanli").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_anjianguanli").show();
	});	
	$("#anjianchaxun").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_anjianchaxun").show();
	});	
	$("#anjiantongji").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_anjiantongji").show();
	});	
	$("#wenjiankuguanli").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_wenjiankuguanli").show();
	});	
	$("#otherservice").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_otherservice").show();
		$("#con_otherservice").show();
	});	
});
</script>
</head>

<body>
	
    <table cellpadding="0" cellspacing="0" width="100%" height="70" border="0" style="position:absolute; left:0px; top:0px;font-size:12px;">
    	<tr style="background-color:rgb(180,202,205);">
        	<td height="40" width="160" valign="middle" align="center">
            	<span style="font-size:14px; font-weight:700; width:150px; height:100%; text-align:center;margin-left:10px;">欢迎：${admin.UName }</span>
            </td>
            <td>
                <span class="menu_div" id="anyuanguanli">案源管理</span>
                <span class="menu_div" id="anyuanchaxun">案源查询</span>
                <span class="menu_div" id="anyuantongji">案源统计</span>
                <span class="menu_div" id="anjianguanli">案件管理</span>
                <span class="menu_div" id="anjianchaxun">案件查询</span>
				<span class="menu_div" id="anjiantongji">案件统计</span>
                <span class="menu_div" id="wenjiankuguanli">文件库管理</span>
                <span class="menu_div" id="otherservice">其他服务</span>
            </td>
            <td width="50">
            	<a href="usersQuit" style=" font-size:16px;color:white; font-family:Microsoft YaHei; font-weight:700;" target="_top">退出</a>
            </td>
        </tr>
        <tr height="30" style="background-color:rgb(37,131,231); color:white; font-size:14px;">
      	<td width="100">&nbsp;</td>   
            	<td colspan="2">
                <span id="con_anyuanguanli" style="margin-left:0px;" class="hide">
                	<c:if test="${userlp.lp_add_casesource==1}"><a href="/lawyer/user/source/court/insertCourt.jsp" target="content">新增案源</a></c:if>
                	<c:if test="${userlp.lp_add_casesource==0}">新增案源</c:if>&nbsp;&nbsp;
                	<c:if test="${userlp.lp_query_casesource==1}"><a href="/lawyer/user/source/court/selectCourt.jsp" target="content">查询案源</a> </c:if>
                	<c:if test="${userlp.lp_query_casesource==0}">查询普通案源</c:if>
                	<a href="/lawyer/user/source/court/selectNoteCourt.jsp" target="content">查询公告案源</a>
                	       
               <!--      <a href="/lawyer/user/source/court/selectCourt2.jsp" target="content">查询案源</a>  -->
                </span>
                <span id="con_anyuanchaxun" style="margin-left:80px;" class="hide">&nbsp;&nbsp;
                	<c:if test="${userlp.lp_senior_query_casesource==1}"><a href="/lawyer/user/source/seniorResult.jsp"target="content">高级查询</a></c:if>
                	<c:if test="${userlp.lp_senior_query_casesource==0}">高级查询</c:if>
               		
                </span>
                <span id="con_anyuantongji" style="margin-left:170px;" class="hide">&nbsp;&nbsp;
                	<c:if test="${userlp.lp_statistics_casesource==1}"><a href="/lawyer/courtCount.action" target="content">案源统计</a></c:if>
                	<c:if test="${userlp.lp_statistics_casesource==0}">案源统计</c:if>
                	
                </span>
                <span id="con_anjianguanli" style="margin-left:250px;" class="hide">&nbsp;&nbsp;
                	<c:if test="${userlp.lp_add_case==1}"><a href="/lawyer/user/lawCase/addCase.jsp" target="content">新增案件</a></c:if>
                	<c:if test="${userlp.lp_add_case==0}">新增案件</c:if>&nbsp;&nbsp;
                	<c:if test="${userlp.lp_query_case==1}"><a href="/lawyer/selectCourts.action" target="content">查询案件</a></c:if>
                	<c:if test="${userlp.lp_query_case==0}">查询案件</c:if>
                    
                </span>
               <span id="con_anjianchaxun" style="margin-left:340px;" class="hide">&nbsp;&nbsp;
              		<c:if test="${userlp.lp_senior_query_case==1}"><a href="/lawyer/user/lawCase/seniorSel.jsp" target="content">高级查询</a></c:if>
                	<c:if test="${userlp.lp_senior_query_case==0}">高级查询</c:if>
                </span>  
                <span id="con_anjiantongji" style="margin-left:402px;" class="hide">&nbsp;&nbsp;
                	<c:if test="${userlp.lp_statistics_case==1}"><a href="/lawyer/user/lawCase/count.jsp" target="content">案件统计</a></c:if>
                	<c:if test="${userlp.lp_statistics_case==0}">案件统计</c:if>
                </span>
				<span id="con_wenjiankuguanli" style="margin-left:502px;" class="hide">&nbsp;&nbsp;
					<c:if test="${userlp.lp_add_filebase==1}"><a href="/lawyer/file/filelibrary.jsp" target="content">新增文件库</a></c:if>
                	<c:if test="${userlp.lp_add_filebase==0}">新增文件库</c:if>&nbsp;&nbsp;
                	<c:if test="${userlp.lp_query_filebase==1}"><a href="filelibrary-list?i=null" target="content">查询文件库</a></c:if>
                	<c:if test="${userlp.lp_query_filebase==0}">查询文件库</c:if>
                </span>  
                <span id="con_otherservice" style="margin-left:502px;" class="hide">&nbsp;&nbsp;
                	<a href="/lawyer/selectTasks.action" target="content">代办事项</a>
					<a href="/lawyer/user/stateUpdate/updateStutas.jsp" target="content">企业状态更新</a>
					<a href="/lawyer/user/stateUpdate/excelUpStutas.jsp" target="content">excel企业状态更新</a>
					<a href="/lawyer/user/source/court/excelCourts.jsp" target="content">excel被执行信息</a>
                </span>
                 </td>
        </tr>
    </table>

</body>
</html>
