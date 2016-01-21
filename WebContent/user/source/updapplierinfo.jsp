<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改申请执行人企业信息</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>

<script language="javascript">

	function loadCalendar(data)
	{
		var rtn=window.showModalDialog("/lawyer/user/lawCase/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
		if(rtn!=null){
			$(data).val(rtn);
		}	
	   return;
	}
  </script>
</head>

<body>

<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">

	<tr>
		<td>&nbsp;&nbsp;<img src="/lawyer/images/flag3_(add)_16x16.gif" />&nbsp;
		<span class="title">修改申请执行人企业信息 </span></td>
	</tr>
	<tr>
		<td>
		<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="search_table" border="0">
			<tr>
				<td align="left" width="20%">案源信息编号：</td>
				<td><h3>${court.ap.appCCasecodeself}</h3></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		<table align="center" cellpadding="0" cellspacing="0" width="98%"
			border="0">
			<tr class="title">
                   <td align="left"><img src="/lawyer/images/flag2_16x16.gif" />&nbsp;企业信息</td>
                   <td colspan="2">&nbsp;</td>
             </tr>
			<tr>
				<td>
				<form name="form3" method="post" action="toupdapplierinfo">
				<table class="form_table" align="center" cellpadding="0"
					cellspacing="0" width="100%" border="0">
					<tr>
						<td align="right" width="20%">注册号：</td>
						<td><input type="text" name="court.ap.appRenumber" value="${court.ap.appRenumber}"/></td>
					</tr>
					<tr>
						<td align="right">主体名称：</td>
						<td><input type="text" name="court.ap.appName" value="${court.ap.appName}"/></td>
					</tr>
					<tr>
						<td align="right">企业类型：</td>
						<td><input type="text" name="court.ap.appType" value="${court.ap.appType}"/></td>
					</tr>
					<tr>
						<td align="right">法定代表人/负责人：</td>
						<td><input type="text" name="court.ap.appRepname" value="${court.ap.appRepname}"/></td>
					</tr>
					<%-- <tr>
						<td align="right">法定代表人/负责人身份证号：</td>
						<td><input type="text" name="court.ap.appRepid" value="${court.ap.appRepid}"/></td>
					</tr> --%>
					<tr>
						<td align="right">行政区划：</td>
						<td><input type="text" name="court.ap.appDistrict" value="${court.ap.appDistrict}"/></td>
					</tr>
					<tr>
						<td align="right">成立日期：</td>
						<td><input type="text" name="court.ap.appDate"
							onClick="loadCalendar(this)"  value="${court.ap.appDate}"/></td>
					</tr>
					<tr>
						<td align="right">注册资本：</td>
						<td><input value="${court.ap.appFund}" type="text" name="court.ap.appFund" /></td>
					</tr>
					<tr>
						<td align="right">经营期限自：</td>
						<td><input type="text" name="court.ap.appDfrom"
							onClick="loadCalendar(this)" value="${court.ap.appDfrom}"/></td>
					</tr>
					<tr>
						<td align="right">经营期限至：</td>
						<td><input type="text" name="court.ap.appDto"
							onClick="loadCalendar(this)"  value="${court.ap.appDto}"/></td>
					</tr>
					<tr>
						<td align="right">登记机关：</td>
						<td><input type="text" name="court.ap.appOrgan" value="${court.ap.appOrgan}"/></td>
					</tr>
					<tr>
						<td align="right">地址/住所：</td>
						<td><input type="text" name="court.ap.appAddress" value="${court.ap.appAddress}"/></td>
					</tr>
					<tr>
						<td align="right">企业状态：</td>
						<td><input type="text" name="court.ap.appStatus" value="${court.ap.appStatus}"/></td>
					</tr>
					<tr>
						<td align="right">注销日期：</td>
						<td><input type="text" name="court.ap.appCancellation" 
						onClick="loadCalendar(this)" value="${court.ap.appCancellation}"/></td>
					</tr>
					<tr>
						<td align="right">吊销日期：</td>
						<td><input type="text" name="court.ap.appRevoke" 
						onClick="loadCalendar(this)" value="${court.ap.appRevoke}"/></td>
					</tr>
					<tr>
						<td align="right">年检年度：</td>
						<td><input type="text" name="court.ap.appAnnual" value="${court.ap.appAnnual}"/></td>
					</tr>
					<tr>
						<td align="right">备注：</td>
						<td><input type="text" name="court.ap.appRemark" value="${court.ap.appRemark}"/></td>
						<td><input type="hidden" name="court.ap.appCCasecodeself" value="${court.ap.appCCasecodeself}"/>
						<input type="hidden" name="court.ap.appId" value="${court.ap.appId}"/>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
						<input type="hidden" value="${court.caseId}" name="court.caseId">
						<input type="submit"
							value="保存" />&nbsp;&nbsp; <input type="reset" value="重置" /></td>
					</tr>
				</table>
				</form>
				</td>
				<td>
				<form name="appform" action="insertApp.action" method="post">
				<table>
					<tr>
						<td align="right">主体名称：</td>
						<td><input type="text" name="applierinfo.appName" /></td>
					</tr>
					<tr>
						<td><input type="hidden" 
							name="applierinfo.appCCasecodeself" value="${court.ap.appCCasecodeself}" />
							<input type="hidden"  name="caseId" value="${court.caseId}" /> 
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="submit"
							value="提交" />&nbsp;&nbsp; <input type="reset" value="重置" /></td>
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
