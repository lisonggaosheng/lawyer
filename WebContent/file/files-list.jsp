<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript">
	function loadCalendar(data)
	{
		if(navigator.userAgent.indexOf("Chrome") >0 ){
			var winOption = "height=250px,width=320px,status:no;help:no;scrolling=no;scrollbars=no";
    		var rtn = window.open("/lawyer/user/source/calender.jsp","", winOption);
		}else{
			var rtn=window.showModalDialog("/lawyer/user/source/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
			if(rtn!=null){
				$(data).val(rtn);
			}
		}
	}
</script>
</head>
<body>
	<table cellspacing="0" cellpadding="0" border="0" width="100%"
		height="100%" class="content_table">
		<tr>
			<td>&nbsp;&nbsp;<img src="/lawyer/images/flag3_16x16.gif" />&nbsp;
				<span class="title">查询文件</span></td>
		</tr>
		<tr>
			<td>
				<form name="searchForm" method="post" action="files-list?i=files&files1.fId=<s:property value="files1.filelibrary.flId"/>">
					<!-- action="files-selectFile?i=files2" -->
					<table cellpadding="0" cellspacing="0" width="90%" align="center"
						class="search_table" border="0">
						<tr>
							<!-- <td align="right">文件库编号：</td>
							<td><input type="text" name="files1.fId" />
							</td> -->
							<td align="right">文件标题：</td>
							<td><input type="text" name="files1.fTitle" />
							</td>
							<td align="right">添加时间：</td>
							<td><input type="text" name="starttime" id="calendardate" /><img
								src="/lawyer/images/date.gif" width="20" height="25"
								onClick="loadCalendar(searchForm.starttime)">至 <input
									type="text" name="endtime" id="calendardate" /><img
									src="/lawyer/images/date.gif" width="20" height="25"
									onClick="loadCalendar(searchForm.endtime)">
							</td>
						</tr>
						<tr>
							<td colspan="12" align="right"><input type="submit"
								value="查询" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						</tr>
					</table>
				</form></td>
		</tr>
		<tr>
			<td align="right"><div align="left">
					<!-- <a href="filelibrary-selectlist" target="content">添加文件</a> -->
					<a href="/lawyer/file/files.jsp?flid=<s:property value="files1.filelibrary.flId"/>&flname=<s:property value="files1.filelibrary.flName"/> ">添加文件</a>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<table cellpadding="0" cellspacing="0" width="90%" align="center"
					class="result_table" border="0">

					<tr class="title">
						<td width="17%" align="center">所属文件库</td>
						<td width="17%" align="center">文件编号</td>
						<td width="17%" align="center">文件类别</td>
						<td width="17%" align="center">文件标题</td>
						<td width="17%" align="center">添加时间</td>
						<td width="9%" align="center">操作</td>
					</tr>
					<s:iterator id="f" value="pageBean.list">
						<tr align="center">
							<td><s:property value="files1.filelibrary.flName" />
							</td>
							<td><s:property value="#f.FId" />
							</td>
							<td><s:property value="#f.FType" />
							</td>
							<td><s:property value="#f.FTitle" />
							</td>
							<td><s:property value="#f.FReldate" />
							</td>
							<td width="20%"><a
								href="files-delete?fid=<s:property value="#f.FId"/>">删除</a>&nbsp;&nbsp;
								<a
								href="downFile.action?filename=\\uploads\\<s:property value="#f.FType" />\\<s:property value="#f.FAttach" />">下载附件</a>
							</td>
						</tr>
					</s:iterator>
				</table></td>
		</tr>

		<tr>
			<td align="center">
				<div style="width: 90%; text-align: right;">
					共
					<s:property value="pageBean.allRow" />
					条记录 共
					<s:property value="pageBean.totalPage" />
					页 当前第
					<s:property value="pageBean.currentPage" />
					页<br />

					<s:if test="%{pageBean.currentPage == 1}">
            第一页 上一页
        </s:if>
					<s:else>
						<a href="files-list?i=files&page=1">第一页</a>
						<a
							href="files-list?i=files&page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
					</s:else>
					<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
						<a
							href="files-list?i=files&page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
						<a
							href="files-list?i=files&page=<s:property value="pageBean.totalPage"/>">最后一页</a>
					</s:if>
					<s:else>
            下一页 最后一页
        </s:else>
					<form method="post" action="files-list?i=files">
						&nbsp;&nbsp; 第 <input type="text" style="width: 30px;" name="page" />
						页&nbsp; <input type="submit" value="Go" />
					</form>
				</div> </td>
		</tr>
	</table>


</body>
</html>
