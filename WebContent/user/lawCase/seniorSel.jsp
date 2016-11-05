<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'selectSource.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="/lawyer/css/public.css" />
 <script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript">
	document.onkeydown=function(event){
	  var e = event || window.event || arguments.callee.caller.arguments[0];
	       
	   if(e && e.keyCode==13){ // enter 键
		   search();
	  }
	};
	
	function search(){
		  var form = document.getElementById("searchForm");
		  form.submit();
	}

	function loadCalendar(field) {
		var rtn = window
				.showModalDialog(
						"/lawyer/user/lawCase/calender.jsp",
						field.id,
						"dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
		if (rtn != null)
			field.value = rtn;
		return;
	}
</script>
</head>

<body>

	<table cellspacing="0" cellpadding="0" border="0" width="100%"
		height="100%" class="content_table">
		<tr>
			<td>&nbsp;&nbsp;<img src="/lawyer/images/flag3_16x16.gif" />&nbsp;
				<span class="title">高级查询</span></td>
		</tr>
		<tr>
			<td>
				<form id="searchForm" name="searchForm" method="post" action="seniorSelect">
					<table cellpadding="0" cellspacing="0" width="98%" align="center"
						class="search_table" border="0">
						<tr>
							<td colspan="6" align="right">
								<input style="font-size:24" type="button" value="查询" onclick="search()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						<tr>
							<td colspan="6" class="title">&nbsp;&nbsp;签约信息</td>
						</tr>
						<tr>
							<td align="right">签约号：</td>
							<td><input type="text" name="cont.csNo" /></td>
							<td align="right">对方联系人名称：</td>
							<td><input type="text" name="cont.csName" /></td>
							<td align="right">电话：</td>
							<td><input type="text" name="cont.csTel" /></td>
						</tr>
						<tr>
							<td align="center" colspan="3">签约时间： <input type="text"
								name="cont.contMinTime" id="contMinTime"
								onclick="loadCalendar(this)" readonly="readonly" />至 <input
								type="text" name="cont.contMaxTime" id="contMaxTime"
								onclick="loadCalendar(this)" readonly="readonly" /></td>
						</tr>
						<tr>
							<td colspan="6" class="title">&nbsp;&nbsp;清算立案</td>
						</tr>
						<tr>
							<td align="right">立案案号：</td>
							<td><input type="text" name="cont.clearrecord.crnumber" />
							</td>
							<td align="right">联系法官：</td>
							<td><input type="text"
								name="cont.clearrecord.crcontactjudge" /></td>
							<td align="right">法官电话：</td>
							<td><input type="text" name="cont.clearrecord.crcontacttel" />
							</td>
						</tr>
						<tr>
							<td align="right">承办律师：</td>
							<td><input type="text" name="cont.clearrecord.crlawname" />
							</td>
							<td align="right">律师电话：</td>
							<td><input type="text" name="cont.clearrecord.crlawtel" />
							</td>
							<td align="right">案件进展：</td>
							<td><input type="text"
								name="cont.clearrecord.crfollowupresult" /></td>
						</tr>
						<tr>
							<td align="right">协办人员：</td>
							<td><input type="text" name="cont.clearrecord.assistingName" />
							</td>
							<td align="right">协办联系方式：</td>
							<td><input type="text" name="cont.clearrecord.assistingTel" />
							</td>
							<td align="right">管辖法院：</td>
							<td><input type="text" name="cont.clearrecord.competentCourt" /></td>
						</tr>
						<tr>
							<td align="center" colspan="3" width="40%">材料递交时间： <input
								type="text" name="cont.clearrecord.clearrecordMinTime"
								id="clearrecordMinTime" onclick="loadCalendar(this)"
								readonly="readonly" />至 <input type="text"
								name="cont.clearrecord.clearrecordMaxTime"
								id="clearrecordMaxTime" onclick="loadCalendar(this)"
								readonly="readonly" /></td>
						</tr>
						<tr>
							<td colspan="6" class="title">&nbsp;&nbsp;清算结束</td>
						</tr>
						<tr>
							<td align="right">立案案号：</td>
							<td><input type="text" name="cont.clearclear.ccnumber" /></td>
							<td align="right">承办法官：</td>
							<td><input type="text" name="cont.clearclear.ccjudge" /></td>
							<td align="right">法官电话：</td>
							<td><input type="text" name="cont.clearclear.ccjudgetel" />
							</td>
						</tr>
						<tr>
							<td align="right">承办律师：</td>
							<td><input type="text" name="cont.clearclear.cclawname" />
							</td>
							<td align="right">律师电话：</td>
							<td><input type="text" name="cont.clearclear.cclawnametel" />
							</td>
							<td align="right">案件进展：</td>
							<td><input type="text"
								name="cont.clearclear.ccfollowupresult" /></td>
						</tr>
						<tr>
							<td align="right">协办人员：</td>
							<td><input type="text" name="cont.clearclear.assistingName" />
							</td>
							<td align="right">协办联系方式：</td>
							<td><input type="text" name="cont.clearclear.assistingTel" />
							</td>
							<td align="right">管辖法院：</td>
							<td><input type="text" name="cont.clearclear.competentCourt" /></td>
						</tr>
						<tr>
							<td colspan="6" class="title">&nbsp;&nbsp;诉讼信息</td>
						</tr>
						<tr>
							<td align="right">立案案号：</td>
							<td><input type="text" name="cont.litigation.linumber" /></td>
							<td align="right">承办法官：</td>
							<td><input type="text" name="cont.litigation.lijudge" /></td>
							<td align="right">法官联系电话：</td>
							<td><input type="text" name="cont.litigation.lijudgetel" />
							</td>
						</tr>
						<tr>
							<td align="right">承办律师：</td>
							<td><input type="text" name="cont.litigation.lilawname" />
							</td>
							<td align="right">律师联系电话：</td>
							<td><input type="text" name="cont.litigation.lilawtel" /></td>
							<td align="right">案件进展：</td>
							<td><input type="text"
								name="cont.litigation.lifollowupresult" /></td>
						</tr>
						<tr>
							<td align="right">协办人员：</td>
							<td><input type="text" name="cont.litigation.assistingName" />
							</td>
							<td align="right">协办联系方式：</td>
							<td><input type="text" name="cont.litigation.assistingTel" />
							</td>
							<td align="right">管辖法院：</td>
							<td><input type="text" name="cont.litigation.competentCourt" /></td>
						</tr>
						<tr>
							<td align="center" colspan="3">立案时间： <input type="text"
								id="litigationMinTime" name="cont.litigation.litigationMinTime"
								onclick="loadCalendar(this)" readonly="readonly" />至 <input
								type="text" id="litigationMaxTime"
								name="cont.litigation.litigationMaxTime"
								onclick="loadCalendar(this)" readonly="readonly" /></td>
						</tr>
						<tr>
							<td align="center" colspan="3">立案费用： <input type="text"
								name="cont.litigation.litigationMinMoney" />至 <input type="text"
								name="cont.litigation.litigationMaxMoney" /></td>
						</tr>
						<tr>
							<td colspan="6" class="title">&nbsp;&nbsp;执行信息</td>
						</tr>
						<tr>
							<td align="right">立案案号：</td>
							<td><input type="text" name="cont.execute.exnumber" /></td>
							<td align="right">承办法官：</td>
							<td><input type="text" name="cont.execute.exjudge" /></td>
							<td align="right">法官联系电话：</td>
							<td><input type="text" name="cont.execute.exjudgetel" /></td>
						</tr>
						<tr>
							<td align="right">承办律师：</td>
							<td><input type="text" name="cont.execute.exlawname" /></td>
							<td align="right">律师联系电话：</td>
							<td><input type="text" name="cont.execute.exlawtel" /></td>
							<td align="right">案件进展：</td>
							<td><input type="text" name="cont.execute.exfollowupresult" />
							</td>
						</tr>
						<tr>
							<td align="right">协办人员：</td>
							<td><input type="text" name="cont.execute.assistingName" />
							</td>
							<td align="right">协办联系方式：</td>
							<td><input type="text" name="cont.execute.assistingTel" />
							</td>
							<td align="right">管辖法院：</td>
							<td><input type="text" name="cont.execute.competentCourt" /></td>
						</tr>
						<tr>
							<td align="center" colspan="3">执行时间： <input type="text"
								name="cont.execute.executeMinTime" id="executeMinTime"
								onclick="loadCalendar(this)" readonly="readonly" />至 <input
								type="text" name="cont.execute.executeMaxTime"
								id="executeMaxTime" onclick="loadCalendar(this)"
								readonly="readonly" /></td>
						</tr>
						<tr>
							<td align="center" colspan="3">执行标的额： <input type="text"
								name="cont.execute.executeMinMoney" />至 <input type="text"
								name="cont.execute.executeMaxMoney" /></td>
						</tr>
						<tr>
							<td colspan="6" class="title">&nbsp;&nbsp;结案信息</td>
						</tr>
						<tr>
							<td align="right">结案人：</td>
							<td><input type="text" name="cont.closerecord.crperson" />
							</td>
							<td align="right">结案人电话：</td>
							<td><input type="text" name="cont.closerecord.crpersontel" />
							</td>
						</tr>
						<tr>
							<td align="center" colspan="3">结案时间： <input type="text"
								name="cont.closerecord.closerecordMinTime" id="closerecordMinTime"
								onclick="loadCalendar(this)" readonly="readonly" />至 <input
								type="text" name="cont.closerecord.closerecordMaxTime" id="closerecordMaxTime"
								onclick="loadCalendar(this)" readonly="readonly" /></td>
						</tr>
						<tr>
							<td colspan="12" align="right"><input type="hidden"
								name="flog" value="0"> <input type="hidden" name="flog"
								value="0"> </td>
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
