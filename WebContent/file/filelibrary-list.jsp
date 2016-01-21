<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link rel="stylesheet" href="/lawyer/css/public.css" />
	</head>

	<body>
		<table cellspacing="0" cellpadding="0" border="0" width="100%"
			height="100%" class="content_table">
			<tr>
				<td>
					&nbsp;&nbsp;
					<img src="/lawyer/images/flag3_16x16.gif" />
					&nbsp;
					<span class="title">查询文件库</span>
				</td>
			</tr>
			<tr>
				<td>
					<form name="searchForm" method="post" action="filelibrary-selectFilelibrary?i=filelibrary">
						<table cellpadding="0" cellspacing="0" width="90%" align="center"
							class="search_table" border="0">
							<tr>
								<td width="11%" align="right">
									文件库名：
								</td>
								<td width="21%">
									<input type="text" name="filelibrary.flName"/>
								</td>
								<td width="11%" align="right">
									文件库类别：
								</td>
								<td width="21%" >
								<input type="text" name="filelibrary.flCategory"/>
								</td>
								<td >
									<input type="submit" value="查询" />
								</td>
							</tr>

						</table>
					</form>
				</td>
			</tr>
			<tr>
				<td>&nbsp;
					
				</td>
			</tr>
			<tr>
				<td>
					<table cellpadding="0" cellspacing="0" width="90%" align="center"
						class="result_table" border="0">

						<tr class="title">
							<td width="18%" align="center">
								文件库编号
							</td>
							<td width="24%" align="center">
								文件库名
							</td>
							<td width="24%" align="center">
								文件库类别
							</td>
							<td width="34%" align="center">
								操作
							</td>
						</tr>
						<s:iterator id="f" value="pageBean.list">
							<tr align="center">
								<td>
									<s:property value="#f.flId" />
								</td>
								<td>
									<s:property value="#f.flName" />
								</td>
								<td>
								<s:property value="#f.flCategory" />
								</td>
								<td width="34%">
										<a href="filelibrary-updateInput?id=<s:property value="#f.flId"/>">修改</a>&nbsp;&nbsp;
									<a href="files-list?i=files&files1.fId=<s:property value="#f.flId"/>">查看文件信息</a>
								</td>
							</tr>
						</s:iterator>
					</table>
				</td>
			</tr>
			<tr>
				<td align="center">
				<%
				String i=(String)request.getAttribute("i");
				if(i.equals("null")){
				 %>
					<div style="width: 90%; text-align: right;">
						共 <s:property value="pageBean.allRow"/> 条记录，
        第<s:property value="pageBean.currentPage"/>页/共<s:property value="pageBean.totalPage"/> 页<br/>
        
        <s:if test="%{pageBean.currentPage == 1}">
            第一页 上一页
        </s:if>
        <s:else>
            <a href="filelibrary-selectFilelibrary?i=null&page=1">第一页</a>
            <a href="filelibrary-selectFilelibrary?i=null&page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
            <a href="filelibrary-selectFilelibrary?i=null&page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
            <a href="filelibrary-selectFilelibrary?i=null&page=<s:property value="pageBean.totalPage"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>
        <form method="post" action="filelibrary-selectFilelibrary?i=null">
						&nbsp;&nbsp; 第
						<input type="text" style="width: 30px;" name="page"/>
						页&nbsp;
						<input type="submit" value="Go"/>
						</form>
					</div>
					<%}else{ %>
					
					<div style="width: 90%; text-align: right;">
						共<s:property value="pageBean.allRow"/> 条记录
        共<s:property value="pageBean.totalPage"/> 页
        当前第<s:property value="pageBean.currentPage"/>页<br/>
        
        <s:if test="%{pageBean.currentPage == 1}">
            第一页 上一页
        </s:if>
        <s:else>
            <a href="filelibrary-selectFilelibrary?i=filelibrary&page=1">第一页</a>
            <a href="filelibrary-selectFilelibrary?i=filelibrary&page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
            <a href="filelibrary-selectFilelibrary?i=filelibrary&page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
            <a href="filelibrary-selectFilelibrary?i=filelibrary&page=<s:property value="pageBean.totalPage"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>
						<form method="post" action="filelibrary-selectFilelibrary?i=filelibrary">
						&nbsp;&nbsp; 第
						<input type="text" style="width: 30px;" name="page"/>
						页&nbsp;
						<input type="submit" value="Go"/>
						</form>
					</div>
					<%} %>
					
				</td>
			</tr>
		</table>
	
	</body>
</html>
