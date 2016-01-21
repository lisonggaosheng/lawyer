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
<title>查询公告案源</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<style type="text/css">
	#dtree{
		position:absolute;
		top:30px;
	}
</style>
<script type="text/javascript" src="/lawyer/js/dtree.js"></script>
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<link rel="stylesheet" href="/lawyer/css/dtree.css" />
</head>
<body>

<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="1600" class="content_table">
	<tr>
		<td width="200" valign="top">
		<!--树形菜单_start-->	
		<div id="dtree" >
          <script type="text/javascript">
          	d = new dTree('d');
				$(function(){
					$.ajax({
						type:"POST",
						cache:true,
						url:"/lawyer/lawyerCourt/findFirstLawyerCourt.action",
						success:function(msg){
							d.add(0,-1,'法院列表');
								eval("firCourts="+msg);
								for(i=0 ; i<firCourts.length; i++ ){
									//将一级法院添加到树形图
									//d.add(firCourts[i].lawyercourt_id+"self",0,firCourts[i].lawyercourt_court_name+"自身","findCourts.action?court.courtcode="+firCourts[i].lawyercourt_id,"","allcourt");
									d.add(firCourts[i].lawyercourt_id,0,firCourts[i].lawyercourt_court_name,"javascript:secondCourts('"+firCourts[i].lawyercourt_id+"')","","","img/folder.gif","img/folderopen.gif");
								}
							$("#dtree").append(d.toString());
						}
					});
				});

				function secondCourts(firId){
					$.ajax({
						type:"POST",
						cache:true,
						url:"/lawyer/lawyerCourt/finSecondLawyerCourt.action",
						data:"fir_id="+firId,
						success:function(msg){
								eval("secCourts="+msg);
								for(i=0 ; i<secCourts.length; i++ ){
									//将二级法院添加到树形图
									d.add(secCourts[i].lawyercourt_id+"self",firId,secCourts[i].lawyercourt_court_name+"自身","findNoteCourts.action?court.courtcode="+secCourts[i].lawyercourt_number,"","allcourt");
									d.add(secCourts[i].lawyercourt_id,firId,secCourts[i].lawyercourt_court_name,"javascript:thirdCourts('"+secCourts[i].lawyercourt_id+"')","","","img/folder.gif","img/folderopen.gif");
								}
								$("#dtree").empty();
								$("#dtree").append(d.toString());
						}
					});
				}

				function thirdCourts(secId){
					$.ajax({
						type:"POST",
						cache:true,
						url:"/lawyer/lawyerCourt/findThirdLawyerCourt.action",
						data:"sec_id="+secId,
						success:function(msg){
								eval("thirdCourts="+msg);
								for(i=0 ; i<thirdCourts.length; i++ ){
									//将三级法院添加到树形图
									d.add(thirdCourts[i].lawyercourt_id,secId,thirdCourts[i].lawyercourt_court_name,"findNoteCourts.action?court.courtcode="+thirdCourts[i].lawyercourt_number,"","allcourt");
								}
								$("#dtree").empty();
								$("#dtree").append(d.toString());
						}
					});
				}
		
			</script>
           </div>
        <!--树形菜单_end--> 
        </td>
		<td width="950" height="1800" valign="top">
			<iframe name="allcourt"  src="/lawyer/user/source/court/noteResult.jsp" frameborder="0" scrolling="no" width="900" height="1800"></iframe>
		</td>
	</tr>
	<tr>
		<td colspan="2"></td>
	</tr>
</table>

</body>
</html>
