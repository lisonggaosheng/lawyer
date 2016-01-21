<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'count.jsp' starting page</title>
    
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
	var rtn=window.showModalDialog("calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
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
            <span class="title">案件统计</span>
        </td>
    </tr>
    <tr>
    	<td>
        	<form name="searchForm" method="post" action="">
            	<table cellpadding="0" cellspacing="0" width="98%" align="center" class="search_table" border="0">
                	<tr>
                    	<td>
                        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        	开始日期：<input name="strTimeEvection" type="text" id="strTimeEvection" size="20" readonly="yes" />
                        	<img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(searchForm.strTimeEvection)">
                            结束日期：<input name="endTimeEvection" type="text" readonly="readonly" id="endTimeEvection" size="20" />
<img src="/lawyer/images/date.gif" width="20" height="20" onClick="loadCalendar(searchForm.endTimeEvection)" />
                            <input type="submit" value="统计"/>
                        </td>
                    </tr>
                </table>
            </form>	
        </td>
    </tr>
    <tr>
    	<td>
        	&nbsp;&nbsp;<img src="/lawyer/images/flag3_16x16.gif" />&nbsp;
            <span class="title">统计结果</span>
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
                    	基本信息
                    </td>
                    <td align="center">
                    	清算立案
                    </td>
                    <td align="center">
                    	清算结束
                    </td>
                    <td align="center">
                    	诉讼阶段
                    </td>
                    <td align="center">
                    	执行阶段
                    </td>
                </tr>
                <tr>
                	<td>10000</td>
                	<td align="center">
                		<table>
                			<tr>
                				<td>用户名</td>
                				<td>录入数量</td>
                				<td>所占比例</td>
                			</tr>
                			<tr>
                				<td>aaa</td>
                				<td>100</td>
                				<td>10%</td>
                			</tr>
                		</table>
                	</td>
                	<td align="center">
                		<table>
                			<tr>
                				<td>用户名</td>
                				<td>录入数量</td>
                				<td>所占比例</td>
                			</tr>
                			<tr>
                				<td>aa</td>
                				<td>100</td>
                				<td>10%</td>
                			</tr>
                		</table>
                	</td>
                	<td align="center">
                		<table>
                			<tr>
                				<td>用户名</td>
                				<td>录入数量</td>
                				<td>所占比例</td>
                			</tr>
                			<tr>
                				<td>bb</td>
                				<td>200</td>
                				<td>20%</td>
                			</tr>
                		</table>
                	</td>
                	<td align="center">
                		<table>
                			<tr>
                				<td>用户名</td>
                				<td>录入数量</td>
                				<td>所占比例</td>
                			</tr>
                			<tr>
                				<td>cc</td>
                				<td>300</td>
                				<td>30%</td>
                			</tr>
                		</table>
                	</td>
                	<td align="center">
                		<table>
                			<tr>
                				<td>用户名</td>
                				<td>录入数量</td>
                				<td>所占比例</td>
                			</tr>
                			<tr>
                				<td>cc</td>
                				<td>300</td>
                				<td>30%</td>
                			</tr>
                		</table>
                	</td>
   				</tr>
			</table>
		</td>
	</tr>
</table>
   
</body>
</html>
