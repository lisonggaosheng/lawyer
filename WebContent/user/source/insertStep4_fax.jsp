<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加第四步（与申请执行人联系信息——传真）页面</title>
<link rel="stylesheet" href="../../css/public.css"/>
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script language="javascript">

	function loadCalendar(data)
	{
	var rtn=window.showModalDialog("/lawyer/user/source/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
	if(rtn!=null){
		$(data).val(rtn);
	}
}
  </script>
</head>

<body>
	
<table cellspacing="0" cellpadding="0" border="0" width="100%" height="100%" class="content_table">
	
    <tr>
    	<td>
        	&nbsp;&nbsp;<img src="../../images/flag3_(add)_16x16.gif"/>&nbsp;
            <span class="title">添加与申请执行人联系信息</span>
        </td>
    </tr>
    <tr>
    	<td>
        	<table cellpadding="0" cellspacing="0" width="98%" align="center" class="search_table" border="0">
                	<tr>
                    	<td align="right" width="20%">案源信息编号：</td>
                        <td><strong>${param.casecodeself}</strong></td>
                    </tr>
                </table>
        </td>
    </tr>
    <tr>
    	<td>
        	<table align="center" cellpadding="0" cellspacing="0" width="98%" border="0">
            	<tr>
                    <td>
                    	<form name="form3" method="post" action="insertConFax" enctype="multipart/form-data">
                    	
                    	<table class="form_table" align="center" cellpadding="0" cellspacing="0" width="100%" border="0">
                        	<tr class="title">
                            	<td align="right"><img src="../../images/flag2_16x16.gif" />&nbsp;传真</td>
                                <td colspan="2">&nbsp;</td>
                            </tr>
                        	<tr>
                            	<td align="right" width="20%">发送人：</td>
                                <td colspan="2"><input type="text" name="contactFax.cfName" /></td>
                            </tr>
                            <tr>
                            	<td align="right">传真时间：</td>
                                <td colspan="2"><input type="text" name="contactFax.cfTime" onClick="loadCalendar(this)" readonly="readonly"/></td>
                            </tr>
                            <tr>
                            	<td align="right">发送结果：</td>
                                <td colspan="2"><input type="text" name="contactFax.cfResult"/></td>
                            </tr>
                            <tr>
                            	<td align="right">对方接收人：</td>
                                <td colspan="2"><input type="text" name="contactFax.cfReceive"/></td>
                            </tr>
                            <tr>
                            	<td align="right">备注：</td>
                                <td colspan="2">
                                	<textarea class="textarea_remarks" name="contactFax.cfRemark"></textarea>
                                </td>
                            </tr>
                            <tr>
                            	<td align="right">附件：</td>
                                <td colspan="2"><input type="file" name="attach"/></td>
                            </tr>
                           
                             <tr style="display:none;">
                            	<td ><input type="text" name="contactFax.cfCasecodeself" value="${param.casecodeself}"/></td>
                            </tr>
                            <tr>
                            	<td>&nbsp;</td>
                            	<td colspan="2">
                            	<input type="hidden"
							name="caseId" value="${param.caseId}" />
                                	<input type="submit" value="保存" />&nbsp;&nbsp;
                                    <input type="reset" value="重置" />
                                 </td>
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
