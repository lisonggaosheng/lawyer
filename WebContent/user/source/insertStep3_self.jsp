<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>添加第三步（申请执行人企业信息——自有信息）页面</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" href="../../css/public.css" type="text/css"></link>
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript">
  
  function yanzhen(){
	  var val1=$("#aoMail1").val();
	  var leng1=val1.length;

	  var val2=$("#aoMail2").val();
	  var leng2=val2.length;
	
	

if(leng1>0){
	 var at1= val1.indexOf("@");
	 var dian1= val1.indexOf(".");
	 var bool1=leng1>0&&at1<dian1&&at1!=0&&dian1!=0&&dian1-at1>1&&dian1!=leng1-1;
	 if(bool1==false){
		 alert("联系人1邮件格式有误!");
		 return;
	 }
}


if(leng2>0){
	 var at2= val2.indexOf("@");
	 var dian2= val2.indexOf(".");
	 var bool2=leng2>0&&at2<dian2&&at2!=0&&dian2!=0&&dian2-at2>1&&dian2!=leng2-1;
	 if(bool2==false){
		 alert("联系人2邮件格式有误!");
		 return;
	 }
}
		
form3.submit();
		
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
				<form name="form3" method="post" action="insertAppOnself">

				<table class="form_table" align="center" cellpadding="0"
					cellspacing="0" width="100%" border="0">
					<tr class="title">
						<td align="right"><img src="../../images/flag2_16x16.gif" />&nbsp;自有信息</td>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td align="right" width="20%">申请人名称：</td>
						<td colspan="2"><input type="text"
							name="applierinfoOnself.aoName" /></td>
					</tr>
					<tr>
						<td align="right">申请人地址：</td>
						<td colspan="2"><input type="text"
							name="applierinfoOnself.aoAddress" /></td>
					</tr>
					<tr>
						<td align="right">联系人1姓名：</td>
						<td colspan="2"><input type="text"
							name="applierinfoOnself.aoName1" /></td>
					</tr>
					<tr>
						<td align="right">联系人1电话：</td>
						<td colspan="2"><input
				
							type="text" name="applierinfoOnself.aoPhone1" /></td>
					</tr>
					<tr>
						<td align="right">联系人1传真：</td>
						<td colspan="2"><input
							
							type="text" name="applierinfoOnself.aoFax1" /></td>
					</tr>
					<tr>
						<td align="right">联系人1邮件：</td>
						<td colspan="2"><input id="aoMail1" type="text"
							name="applierinfoOnself.aoMail1" /></td>
					</tr>
					<tr>
						<td align="right">联系人2姓名：</td>
						<td colspan="2"><input type="text"
							name="applierinfoOnself.aoName2" /></td>
					</tr>
					<tr>
						<td align="right">联系人2电话：</td>
						<td colspan="2"><input
							
							type="text" name="applierinfoOnself.aoPhone2" /></td>
					</tr>
					<tr>
						<td align="right">联系人2传真：</td>
						<td colspan="2"><input
					
							type="text" name="applierinfoOnself.aoFax2" /></td>
					</tr>
					<tr>
						<td align="right">联系人2邮件：</td>
						<td colspan="2"><input id="aoMail2" type="text"
							name="applierinfoOnself.aoMail2" /></td>
					</tr>
					<tr>
						<td align="right">备注：</td>
						<td colspan="2"><textarea rows="5" cols="60" id="aoRemark" 
						 name="applierinfoOnself.aoRemark"></textarea></td>
					</tr>
					<tr style="display: none;">
						<td><input type="text"
							name="applierinfoOnself.aoCasecodeself"
							value="${param.casecodeself}" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td colspan="2">
						<input type="hidden"
							name="caseId" value="${param.caseId}" /> 
						<input type="button" value="保存"
							onclick="yanzhen()" />&nbsp;&nbsp; <input type="reset"
							value="重置" /></td>
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
