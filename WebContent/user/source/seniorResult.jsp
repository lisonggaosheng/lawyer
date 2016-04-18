<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>案源高级查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <link rel="stylesheet" href="/lawyer/css/public.css"/>
  <script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
  <script type="text/javascript">
  $(function(){
	  var coll = document.getElementsByName("exclude");
	  for(var i = 0; i < coll.length; i++)
	       coll[i].checked = false;
  });

  function search(){
	  var form = document.getElementById("searchForm");
	  if(document.getElementById("exclude3").checked){
		  document.getElementById("showNote").value = '1';
	  }
	  if(document.getElementById("exclude1").checked){
		  document.getElementById("showPe").value = '1';
	  }
	  if(document.getElementById("exclude2").checked){
		  document.getElementById("excludeInfo").value = '2';
	  }
	  form.submit();
}
  function loadCalendar(field)
	{
		var rtn=window.showModalDialog("/lawyer/user/source/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
		if(rtn!=null)
			field.value=rtn;
	   return;
	}
  </script>
</head>
<body>
<table cellspacing="0" cellpadding="0" border="0" width="100%" height="100%" class="content_table">
	<tr>
    	<td>
        	&nbsp;&nbsp;<img src="/lawyer/images/flag3_16x16.gif" />&nbsp;
            <span class="title">高级查询</span>
        </td>
    </tr>
    <tr>
    	<td>
        	<form id="searchForm" name="searchForm" method="post" action="seniorSelectLawyerSource">
            	<table cellpadding="0" cellspacing="0" width="98%" align="center" class="search_table" border="0">
                	<tr>
                		<td colspan="6" align="right">
                    	<input type="hidden" name="flog" value="0">
                    	<input type="hidden" id="showNote" name="showNote">
                    	<input type="hidden" id="showPe" name="showPe">
                    	<input type="hidden" id="excludeInfo" name="excludeInfo">
                    	<input type="checkbox" id="exclude3" name="exclude" value ="3" >公告信息&nbsp;&nbsp;
                    	<input type="checkbox" id="exclude1" name="exclude" value ="1" >显示暂时排除信息&nbsp;&nbsp;
                    	<input type="checkbox" id="exclude2" name="exclude" value ="2" >排除企业状态&nbsp;&nbsp;
                        <input style="font-size:24" type="button" value="查询" onclick="search()"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                	</tr>
                	<tr>
                    	<td colspan="6" class="title">&nbsp;&nbsp;被执行人执行信息</td>
                    </tr>
                    <tr>
                    	<td align="right">案件唯一标识：</td>
                        <td><input type="text" name="court.casecodeself" /></td>
                    </tr>
                	<tr>
                    	<td align="right">被执行人姓名/名称：</td>
                        <td><input type="text" name="court.pname" /></td>
                        <td align="right">身份证号码/组织机构代码：</td>
                        <td><input type="text" name="court.partyCardNum" /></td>
                        <td align="right">执行法院：</td>
                        <td><input type="text" name="court.execCourtName" /></td>
                    </tr>
                    <tr>
                        <td align="right">案号：</td>
                        <td><input type="text" name="court.caseCode" /></td>
                        <td align="right">执行标的：</td>
                        <!-- <td><input type="text" name="court.execMoney" /></td> -->
                        <td colspan="3"><input type="text" name="minmoney" />至<input type="text" name="maxmoney"/></td>
                    </tr>
                    <tr>
                    	<td align="right">案件状态：</td>
                        <td>
                        	<input type="text" name="court.caseState"  />
                        </td>
                        <td align="right">立案时间：</td>
                        <!--  <td><input type="text" name="court.caseCreateTime" /></td>-->
                        <td colspan="3">
                        	<input type="text" name="startliantime" id="startliantime" /><img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(searchForm.startliantime)">至
                        	<input type="text" name="endliantime" id="endliantime"/><img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(searchForm.endliantime)">
                        </td>
                    </tr>
                    <tr>
                    	<td colspan="6" class="title">&nbsp;&nbsp;被执行人企业信息</td>
                    </tr>
                    <tr>
                    	<td align="right">被执行人注册号：</td>
                        <td><input type="text" name="executebusiness.ERenumber" /></td>
                        <td align="right">企业类型：</td>
                        <td><input type="text" name="executebusiness.EType" /></td>
                        <td align="right">主体名称：</td>
                        <td><input type="text" name="executebusiness.EName" /></td>
                    </tr>
                    <tr>
                    	<td align="right">法定代表人/负责人：</td>
                        <td><input type="text" name="executebusiness.ERepname" /></td>
                        <td align="right">行政区划：</td>
                        <td><input type="text" name="executebusiness.EDistrict" /></td>
                        <td align="right">登记机关：</td>
                        <td><input type="text" name="executebusiness.EOrgan" /></td>
                    </tr>
                    <tr>
                    	<td align="right">地址/住所：</td>
                        <td><input type="text" name="executebusiness.EAddress" /></td>
                        <td align="right">企业状态：</td>
                        <td colspan="3"><input type="text" name="executebusiness.EStatus"/></td>
                    </tr>
                    <tr>
                    	<td colspan="6" class="title">&nbsp;&nbsp;申请人(债务人)信息</td>
                    </tr>
                    <tr>
                    	<td align="right">市场标记：</td>
                        <td>
                        	<select name="applierinfo.usedMark">
                        	   <option value="">请选择标记</option>
							   <option value="1">是</option>
							   <option value="0">否</option>
							   <option value="3">北京</option>
							   <option value="2">其他</option>
							</select> 
                        </td>
                        <td align="right">标记时间：</td>
                        <td colspan="3">
                        	<input type="text" name="startmarkTime" id="startmarkTime" /><img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(searchForm.startmarkTime)">至
                        	<input type="text" name="endmarkTime" id="endmarkTime"><img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(searchForm.endmarkTime)">
                        </td>
                    </tr>
                    <tr>
                    	<td align="right">申请企业主体名称：</td>
                        <td><input type="text" name="applierinfo.appName" /></td>
                        <td align="right">法定代表人/负责人：</td>
                        <td><input type="text" name="applierinfo.appRepname" /></td>
                        <td align="right">行政区划：</td>
                        <td><input type="text" name="applierinfo.appDistrict" /></td>
                    </tr>
                     <tr>
                    	<td align="right">登记机关：</td>
                        <td><input type="text" name="applierinfo.appOrgan" /></td>
                    	<td align="right">地址/住所：</td>
                        <td ><input type="text" name="applierinfo.appAddress" /></td>
                    	<td align="right">申请人名称：</td>
                        <td><input type="text" name="applierinfoOnself.aoName" /></td>
                    </tr>
                    <tr>
                        <td align="right">申请人地址：</td>
                        <td><input type="text" name="applierinfoOnself.aoAddress" /></td>
                        <td align="right">联系人姓名：</td>
                        <td><input type="text" name="applierinfoOnself.aoName1" /></td>
                        <td align="right">联系人电话：</td>
                        <td><input type="text" name="applierinfoOnself.aoPhone1" /></td>
                    </tr>
                    <tr>
                    	<td colspan="6" class="title">&nbsp;&nbsp;与申请执行人联系信息</td>
                    </tr>
                    <tr>
                    	<td align="right">邮件地址：</td>
                        <td><input type="text" name="contactMail.cmMail" /></td>
                    </tr>
                    <tr>
                    	<td align="right">快递发送人：</td>
                        <td><input type="text" name="contactExpress.ceName" /></td>
                        <td align="right">快递发送时间：</td>
                        <td>
                        	<input type="text" name="startSentEmstime" id="startSentEmstime" /><img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(searchForm.startSentEmstime)">至
                        	<input type="text" name="endSentEmstime" id="endSentEmstime"><img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(searchForm.endSentEmstime)">
                        </td>
                        <td align="right">快递号：</td>
                        <td><input type="text" name="contactExpress.ceNumber" /></td>
                    </tr>
                    <tr>
                    	<td align="right">打电话人姓名：</td>
                        <td><input type="text" name="contactTel.ctName" /></td>
                        <td align="right">打电话时间：</td>
                        <td>
                        	<input type="text" name="startctTime" id="startctTime" /><img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(searchForm.startctTime)">至
                        	<input type="text" name="endctTime" id="endctTime"><img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(searchForm.endctTime)">
                        	<!-- <input type="text" name="contactTel.ctTime" /> -->
                        </td>
                    </tr>
                    <tr>
                    	<td align="right">联系人1姓名：</td>
                        <td><input type="text" name="contactTel.ctName1" /></td>
                        <td align="right">联系人1电话：</td>
                        <td><input type="text" name="contactTel.ctTel1" /></td>
                    </tr>
                    <tr>
                        <td align="right">签约联系人：</td>
                        <td><input type="text" name="contractSign.csName" /></td>
                        <td align="right">签约号：</td>
                        <td><input type="text" name="contractSign.csNo" /></td>
                        <td align="right">签约时间：</td>
                        <td>
                        	<input type="text" name="startqianyuetime" id="startqianyuetime" /><img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(searchForm.startqianyuetime)">至
                        	<input type="text" name="endqianyuetime" id="endqianyuetime"><img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(searchForm.endqianyuetime)">
                        </td>
                    </tr>
                   
                </table>
            </form>	
        </td>
    </tr>
    <tr>
    	<td>&nbsp;</td>
    </tr>
</table>    

</body>
</html>
