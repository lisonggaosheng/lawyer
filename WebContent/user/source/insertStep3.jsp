<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申请人(债权人)企业信息（注册信息）</title>
<link rel="stylesheet" href="../../css/public.css" />
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
		<td>&nbsp;&nbsp;<img src="../../images/flag3_(add)_16x16.gif" />&nbsp;
		<span class="title">添加申请人(债权人)企业信息（注册信息）</span></td>
	</tr>
	<tr>
		<td>
		<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="search_table" border="0">
			<tr>
				<td align="right" width="20%">案源信息编号：</td>
				<td>
				<h3>${param.casecodeself}</h3>
				</td>
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
				<form name="form3" method="post" action="insertAppInfo.action">
				<table class="form_table" align="center" cellpadding="0"
					cellspacing="0" width="100%" border="0">
					<tr>
						<td align="right" width="20%">注册号：</td>
						<td><input type="text" name="applierinfo.appRenumber" /></td>
					</tr>
					<tr>
						<td align="right">主体名称：</td>
						<td><input type="text" name="applierinfo.appName" /></td>
					</tr>
					<tr>
						<td align="right">企业类型：</td>
						<td><input type="text" name="applierinfo.appType" /></td>
					</tr>
					<tr>
						<td align="right">法定代表人/负责人：</td>
						<td><input type="text" name="applierinfo.appRepname" /></td>
					</tr>
					<!-- <tr>
						<td align="right">法定代表人/负责人身份证号：</td>
						<td><input type="text" name="applierinfo.appRepid" /></td>
					</tr> -->
					<tr>
						<td align="right">行政区划：</td>
						<td><input type="text" name="applierinfo.appDistrict" /></td>
					</tr>
					<tr>
						<td align="right">成立日期：</td>
						<td><input type="text" name="applierinfo.appDate"
							onClick="loadCalendar(this)" /></td>
					</tr>
					<tr>
						<td align="right">注册资本：</td>
						<td><input type="text" name="applierinfo.appFund"
							 /></td>
					</tr>
					<tr>
						<td align="right">经营期限自：</td>
						<td><input type="text" name="applierinfo.appDfrom"
							onClick="loadCalendar(this)"  /></td>
					</tr>
					<tr>
						<td align="right">经营期限至：</td>
						<td><input type="text" name="applierinfo.appDto"
							onClick="loadCalendar(this)"  /></td>
					</tr>
					<tr>
						<td align="right">登记机关：</td>
						<td><input type="text" name="applierinfo.appOrgan" /></td>
					</tr>
					<tr>
						<td align="right">地址/住所：</td>
						<td><input type="text" name="applierinfo.appAddress" /></td>
					</tr>
					<tr>
						<td align="right">企业状态：</td>
						<td><input type="text" name="applierinfo.appStatus" /></td>
					</tr>
					<tr>
						<td align="right">年检年度：</td>
						<td><input type="text" name="applierinfo.appAnnual" /></td>
					</tr>
					<tr>
						<td align="right">年检结果：</td>
						<td><input type="text" name="applierinfo.appResults" /></td>
					</tr>
					<tr>
						<td align="right">注销日期：</td>
						<td><input type="text" name="applierinfo.appCancellation" onClick="loadCalendar(this)"/></td>
					</tr><tr>
						<td align="right">吊销日期：</td>
						<td><input type="text" name="applierinfo.appRevoke" onClick="loadCalendar(this)"/></td>
					</tr>
					<tr>
						<td align="right">备注：</td>
						<td><input type="text" name="applierinfo.appRemark" /></td>
					</tr>
					<tr>
						<td><input type="text" style="display: none;"
							name="applierinfo.appCCasecodeself" value="${param.casecodeself}" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="hidden"
							name="caseId" value="${param.caseId}" /> <input type="submit"
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
						<td><input type="text" style="display: none;"
							name="applierinfo.appCCasecodeself" value="${param.casecodeself}" />
							<input type="hidden" name="caseId" value="${param.caseId}" /> 
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
