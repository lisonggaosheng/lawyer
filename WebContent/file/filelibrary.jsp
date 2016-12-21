<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>无标题文档</title>
		<link rel="stylesheet" href="/lawyer/css/public.css" />
		<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
		<script language="javascript">
	function clickRaido($item){
		var value = $item.value;
		if(value == 3){
			$("#flCategory").show();
		}else{
			$('#flCategory').val("");
			$("#flCategory").hide();
		}
	}
	function addcheck(){	
		var name=$("#flName").value;
		var category=$('input:radio:checked').val();
		if(name==""){
			 alert("文件库名不能为空");
			 return;
		}
		if(category != "" && category != null){
			if(category==1){
				$('#flCategory').val("案源");
			}else if(category==2){
				$('#flCategory').val("案件");
			}else if(category==3){
				var flCategory=$('#flCategory').val();
				if(flCategory == ""){
					alert("文件库类别选中其他需要重新命名！");
					return;
				}
			}
		}else{
			alert("文件库类别不能为空");
			return;
		}
		
		fl.submit();
	}
</script>
	</head>
	<body>
		<table cellspacing="0" cellpadding="0" border="0" width="100%"
			height="100%" class="content_table">
			<tr>
				<td width="15%" colspan="2">
					&nbsp;&nbsp;
					<img src="/lawyer/images/flag3_add_16x16.gif" />
					&nbsp;
					<span class="title">新建文件库</span>
				</td>
			</tr>
			<tr>
				<td width="50%">
					<form name="fl" method="post" action="filelibrary-add"  >
						<table width="90%" cellspacing="0" cellpadding="0" border="0" align="right" class="form_table">
							<tr>
								<td width="11%" align="right">文件库名：</td>
								<td ><input type="text" id="flName" name="filelibrary.flName" /> </td>
							</tr>
							<tr>
								<td align="right">文件库类别：</td>
								<td>
									<label><input name="filelibrary.type" type="radio" value="1" onclick="clickRaido(this)"/>案源 </label>
									<label><input name="filelibrary.type" type="radio" value="2" onclick="clickRaido(this)"/>案件 </label>
									<label><input name="filelibrary.type" type="radio" value="3" onclick="clickRaido(this)"/>其他 </label>
									<input type="text" name="filelibrary.flCategory" id="flCategory" style="width:300px; display: none;"/>
								</td>
							</tr>
							<tr>
								<td align="right">备注：</td>
								<td><textarea  id="beizhu" name="filelibrary.beizhu" rows="5" cols="50"></textarea></td>
							</tr>
							<tr>
								<td colspan="2" align="left">
  <input type="button" value="保存" onclick="addcheck()"/>
  &nbsp;&nbsp;
  <input type="reset" value="清空" /></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>

	</body>
</html>
