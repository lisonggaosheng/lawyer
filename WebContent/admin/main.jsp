<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
 <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>债转管理|欢迎登录</title>
<script type="text/javascript" src="../js/jquery-1.6.4.min.js"></script>
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
	$("#huanyingye").css({"color":"white","background-color":"rgb(37,131,231)"});
	$("#con_huanyingye").show();
	
	$("#huanyingye").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_huanyingye").show();						
	});	
	$("#anyuankuguanli").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_anyuankuguanli").show();						
	});	
	$("#anyuanxinxiguanli").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_anyuanxinxiguanli").show();
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
	$("#juankuguanli").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_juankuguanli").show();
	});	
	$("#anjuanguanli").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_anjuanguanli").show();
	});	
	$("#wenjianguanli").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_wenjianguanli").show();
	});	
	$("#anjiantongji").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_anjiantongji").show();
	});	
	$("#yonghuguanli").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_yonghuguanli").show();
	});	
	$("#shouquanshenqingguanli").click(function(){
		hideOpt();
		$(this).css({"color":"white","background-color":"rgb(37,131,231)"});
		$("#con_shouquanshenqingguanli").show();
	});	
});
</script>
</head>

<body>
    <table cellpadding="0" cellspacing="0" width="100%" height="100%" border="0" style="position:absolute; left:0px; top:0px; bottom:0px; font-size:12px;">
    	<tr style="background-color:rgb(180,202,205);">
        	<td height="40" width="160" valign="middle" align="center">
            	<span style="font-size:14px; font-weight:700; width:150px; height:100%; text-align:center;margin-left:10px;">您好，超级管理员！</span>
            </td>
            <td>
            	<span class="menu_div" id="huanyingye">欢迎页</span>
                <span class="menu_div" id="anyuankuguanli">案源库管理</span>
                <span class="menu_div" id="anyuanxinxiguanli">案源信息管理</span>
                <span class="menu_div" id="anyuanchaxun">案源查询</span>
                <span class="menu_div" id="anyuantongji">案源统计</span>
                <span class="menu_div" id="juankuguanli">卷库管理</span>
                <span class="menu_div" id="anjuanguanli">案卷管理</span>
                <span class="menu_div" id="wenjianguanli">文件管理</span>
                <span class="menu_div" id="anjiantongji">案件统计</span>
                <span class="menu_div" id="yonghuguanli">用户管理</span>
                <span class="menu_div" id="shouquanshenqingguanli">授权申请管理</span>
            </td>
        </tr>
        <tr height="30" style="background-color:rgb(37,131,231); color:white; font-size:14px;">
        	<td width="160">&nbsp;</td>
        	<td>
            	<span id="con_huanyingye" style="margin-left:10px;" class="hide">
                	欢迎您使用债转管理平台，请根据业务需要选取上面的菜单进行操作。
                </span>
                <span id="con_anyuankuguanli" style="margin-left:80px;" class="hide">
                	<a href="xinzenganyuanku.html">新增案源库</a>&nbsp;&nbsp;
                    <a href="chaxunanyuankku.html">查询案源库</a>
                </span>
                <span id="con_anyuanxinxiguanli" style="margin-left:180px;" class="hide">
                	<a href="xinzenganyuanxinxi.html">新增案源信息</a>&nbsp;&nbsp;
                    <a href="chaxunanyuanxinxi.html">查询案源信息</a>
                </span>
                <span id="con_anyuanchaxun" style="margin-left:300px;" class="hide">
                	<a href="anyuanmohuchaxun.html">模糊查询</a>&nbsp;&nbsp;
                    <a href="anyuangaojichaxun.html">高级查询</a>
                </span>
                <span id="con_anyuantongji" style="margin-left:370px;" class="hide">&nbsp;&nbsp;
                	<a href="anyuantongji.html">案源统计</a>
                </span>
                <span id="con_juankuguanli" style="margin-left:470px;" class="hide">
                	<a href="xinjianjuanku.html">新建卷库</a>&nbsp;&nbsp;
                    <a href="chaxunjuanku.html">查询卷库</a>
                </span>
                <span id="con_anjuanguanli" style="margin-left:550px;" class="hide">
                	<a href="xinjiananjuan.html">新建案卷</a>&nbsp;&nbsp;
                    <a href="chaxunanjuan.html">查询案卷</a>
                </span>
                <span id="con_wenjianguanli" style="margin-left:630px;" class="hide">
                	<a href="xinjianwenjian.html">新建文件</a>&nbsp;&nbsp;
                    <a href="chaxunwenjian.html">查询文件</a>
                </span>
                <span id="con_anjiantongji" style="margin-left:720px;" class="hide">
                	<a href="anjiantongji.html">案件统计</a>
                </span>
                <span id="con_yonghuguanli" style="margin-left:800px;" class="hide">
                	<a href="xinjianyonghu.html">新建用户</a>&nbsp;&nbsp;
                    <a href="chaxunyonghu.html">查询用户</a>
                </span>
                <span id="con_shouquanshenqingguanli" style="margin-left:880px;" class="hide">
                	<a href="chaxunyonghu.html">授权申请管理</a>
                </span>
            </td>
        </tr>
        <tr style="background-color:#f5f5f5;">
        	<td colspan="2">
            </td>
        </tr>
        <tr style="background-color:rgb(180,202,205);">
        	<td colspan="2" height="30" align="center">
            	债转管理平台&nbsp;&nbsp;CopyRight2013&nbsp;&nbsp;技术支持&nbsp;北京智蓝信息科技有限公司
            </td>
        </tr>
    </table>
</body>
</html>
