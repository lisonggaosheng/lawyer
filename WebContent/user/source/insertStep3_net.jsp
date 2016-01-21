<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>添加第三步（申请执行人企业信息——网络信息）页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" href="../../css/public.css" type="text/css"></link>
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>

<script language="javascript">

	function loadCalendar(data)
	{
		var rtn=window.showModalDialog("/lawyer/user/source/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
		if(rtn!=null){
			$(data).val(rtn);
		}
		return;
	}



	
	 function yanzhen(){
		  var val1=$("#anMail").val();
		  var leng1=val1.length;


	if(leng1>0){
		 var at1= val1.indexOf("@");
		 var dian1= val1.indexOf(".");
		 var bool1=leng1>0&&at1<dian1&&at1!=0&&dian1!=0&&dian1-at1>1&&dian1!=leng1-1;
		 if(bool1==false){
			 alert("邮件格式有误!");
			 return;
		 }
	}

	
	appnet.submit();
			
	  }
	 

	
  </script>
</head>

<body>
<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">

	<tr>
		<td>&nbsp;&nbsp;<img src="../../images/flag3_(add)_16x16.gif" />&nbsp;
		<span class="title">添加申请执行人企业信息</span></td>
	</tr>
	<tr>
		<td>
		<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="search_table" border="0">
			<tr>
				<td align="right" width="20%">案源信息编号：</td>
				<td><strong>${param.casecodeself}</strong></td>
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
				<form name="appnet" method="post" action="insertAppNet">

				<table class="form_table" align="center" cellpadding="0"
					cellspacing="0" width="100%" border="0">
					<tr class="title">
						<td align="right"><img src="../../images/flag2_16x16.gif" />&nbsp;网络信息</td>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td align="right">主体名称：</td>
						<td><input type="text" name="applierinfoNetwork.anName" /></td>
					</tr>
					<tr>
						<td align="right">地址/住所：</td>
						<td><input type="text" name="applierinfoNetwork.anAddress" /></td>
					</tr>
					<tr>
						<td align="right">联系人：</td>
						<td><input type="text" name="applierinfoNetwork.anConname" /></td>
					</tr>
					<tr>
						<td align="right">电话：</td>
						<td><input
							
							type="text" name="applierinfoNetwork.anPhone" /></td>
					</tr>
					<tr>
						<td align="right">传真：</td>
						<td><input
							
							type="text" name="applierinfoNetwork.anFax" /></td>
					</tr>
					<tr>
						<td align="right">邮件：</td>
						<td><input id="anMail" type="text"
							name="applierinfoNetwork.anMail" /></td>
					</tr>
					<tr style="display: none;">
						<td><input type="text"
							name="applierinfoNetwork.anCasecodeself"
							value="${param.casecodeself}" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="hidden"
							name="caseId" value="${param.caseId}" /> <input
							onclick="yanzhen()" type="button" value="保存" />&nbsp;&nbsp; <input
							type="reset" value="重置" /></td>
						<td>&nbsp;</td>
					</tr>
				</table>
				</form>
				</td>
				<td>
				<form name="appform" action="insertAppnetOne.action" method="post">
				<table>
					<tr>
						<td align="right">主体名称：</td>
						<td><input type="text" name=applierinfoNetwork.anName /></td>
					</tr>
					<tr>
						<td><input type="text" style="display: none;"
							name="applierinfoNetwork.anCasecodeself" value="${param.casecodeself}" />
							<input  type="hidden" name="caseId" value="${param.caseId}" />
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
</table>
</body>
</html>
