<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>案源统计</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="/lawyer/css/public.css"/>
  <script language="javascript">
	function loadCalendar(field)
	{
	var rtn=window.showModalDialog("/lawyer/user/source/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
	if(rtn!=null)
		field.value=rtn;
   return;
}

	function count()
	{
		alert("抱歉，系统正在维护，此功能暂时关闭！");
	}
  </script>
</head>

<body>

<table cellspacing="0" cellpadding="0" border="0" width="100%" height="100%" class="content_table">
	<tr>
    	<td>
        	&nbsp;&nbsp;<img src="/lawyer/images/flag3_16x16.gif" />&nbsp;
            <span class="title">人工录入案源统计</span>
        </td>
    </tr>
    <tr>
    	<td>
        	<form name="form1" method="post" action="courtCountByTime.action">
            	<table cellpadding="0" cellspacing="0" width="98%" align="center" class="search_table" border="0">
                	<tr>
                    	<td>
                        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        	开始日期：<input name="startDate" type="text" id="strTimeEvection" size="20" readonly="readonly" />
                        	<img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(form1.strTimeEvection)">
                            结束日期：<input name="endDate" type="text" readonly="readonly" id="endTimeEvection" size="20" />
<img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(form1.endTimeEvection)" />

                            <input type="submit" value="统计"  />
                        </td>
                    </tr>
                </table>
            </form>	
        </td>
    </tr>
    <tr>
    	<td>
        	&nbsp;&nbsp;<img src="/lawyer/images/flag3_16x16.gif" />&nbsp;
            <span class="title">人工录入数据统计结果</span>
            &nbsp;&nbsp;&nbsp;&nbsp;<h5>时间段：${startDate }————${endDate }</h5>
        </td>    
    </tr>
    <tr> 	
    	<td>
        	<table cellpadding="0" cellspacing="0" width="98%" align="center" class="result_table" border="0">
            	<tr class="title">
                	<td align="center">
                    	案源数量
                    </td>
                    <td align="center">
                    	被执行人执行信息
                    </td>
                    <td align="center">
                    	被执行人企业信息
                    </td>
                    <td align="center">
                    	申请执行人企业信息
                    </td>
                    <td align="center">
                    	与申请执行人联系信息
                    </td>
                </tr>
                <tr>
                	<td align="center">${total }</td>
                	<td align="center">
                		<table>
                			<tr>
                				<td>用户名</td>
                				<td>录入数量</td>
                				<td>所占比例</td>
                				<td>执行操作</td>
                			</tr>
                			<s:iterator value="tjlist1">
                				<tr>
	                				<td><s:property value="user.UName" /></td>
	                				<td><s:property value="num" /></td>
	                				<td><s:property value="bili" /></td>
	                				<td><s:property value="info" /></td>
                				</tr>
                			</s:iterator>
                		</table>
                	</td>
                	<td align="center">
                		<table>
                			<tr>
                				<td>用户名</td>
                				<td>录入数量</td>
                				<td>所占比例</td>
                				<td>执行操作</td>
                			</tr>
                			<s:iterator value="tjlist2">
                				<tr>
	                				<td><s:property value="user.UName" /></td>
	                				<td><s:property value="num" /></td>
	                				<td><s:property value="bili" /></td>
	                				<td><s:property value="info" /></td>
                				</tr>
                			</s:iterator>
                		</table>
                	</td>
                	<td align="center">
                		<table>
                			<tr>
                				<td>用户名</td>
                				<td>录入数量</td>
                				<td>所占比例</td>
                				<td>执行操作</td>
                			</tr>
                			<s:iterator value="tjlist3">
                				<tr>
	                				<td><s:property value="user.UName" /></td>
	                				<td><s:property value="num" /></td>
	                				<td><s:property value="bili" /></td>
	                				<td><s:property value="info" /></td>
                				</tr>
                			</s:iterator>
                		</table>
                	</td>
                	<td align="center">
                		<table>
                			<tr>
                				<td>用户名</td>
                				<td>录入数量</td>
                				<td>所占比例</td>
                				<td>执行操作</td>
                			</tr>
                			<s:iterator value="tjlist4">
                				<tr>
	                				<td><s:property value="user.UName" /></td>
	                				<td><s:property value="num" /></td>
	                				<td><s:property value="bili" /></td>
	                				<td><s:property value="info" /></td>
                				</tr>
                			</s:iterator>
                		</table>
                	</td>
   				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
