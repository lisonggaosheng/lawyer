<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改第三步（申请执行人企业信息——自有信息）页面</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  <link rel="stylesheet" href="/lawyer/css/public.css" type="text/css"></link>
  </head>
  
  <body>
    <table cellspacing="0" cellpadding="0" border="0" width="100%" height="100%" class="content_table">
	
    <tr>
    	<td>
        	&nbsp;&nbsp;<img src="/lawyer/images/flag3_(add)_16x16.gif"/>&nbsp;
            <span class="title">修改申请执行人自有信息</span>
        </td>
    </tr>
    <tr>
    	<td>
        	<table cellpadding="0" cellspacing="0" width="98%" align="center" class="search_table" border="0">
                	<tr>
                    	<td align="left" width="20%">案源信息编号：</td>
                        <td><strong>${court.ao.aoCasecodeself}</strong></td>
                    </tr>
                </table>
        </td>
    </tr>
    <tr>
    	<td>
        	<table align="center" cellpadding="0" cellspacing="0" width="98%" border="0">
            	<tr>
                    <td>
                    	<form name="form3" method="post" action="toupdapplierinfoonself">
                    	
                    	<table class="form_table" align="center" cellpadding="0" cellspacing="0" width="100%" border="0">
                            <tr class="title">
                            	<td align="left"><img src="/lawyer/images/flag2_16x16.gif" />&nbsp;自有信息</td>
                                <td colspan="2">&nbsp;</td>
                            </tr>
                        	<tr>
                            	<td align="right" width="20%">申请人名称：</td>
                                <td colspan="2"><input type="text" name="court.ao.aoName" value="${court.ao.aoName }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">申请人地址：</td>
                                <td colspan="2"><input type="text" name="court.ao.aoAddress" value="${court.ao.aoAddress }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">联系人1姓名：</td>
                                <td colspan="2"><input type="text" name="court.ao.aoName1" value="${court.ao.aoName1 }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">联系人1电话：</td>
                                <td colspan="2"><input type="text" name="court.ao.aoPhone1" value="${court.ao.aoPhone1 }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">联系人1传真：</td>
                                <td colspan="2"><input type="text" name="court.ao.aoFax1" value="${court.ao.aoFax1 }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">联系人1邮件：</td>
                                <td colspan="2"><input type="text" name="court.ao.aoMail1" value="${court.ao.aoMail1  }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">联系人2姓名：</td>
                                <td colspan="2"><input type="text" name="court.ao.aoName2" value="${court.ao.aoName2 }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">联系人2电话：</td>
                                <td colspan="2"><input type="text" name="court.ao.aoPhone2" value="${court.ao.aoPhone2 }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">联系人2传真：</td>
                                <td colspan="2"><input type="text" name="court.ao.aoFax2" value="${court.ao.aoFax2 }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">联系人2邮件：</td>
                                <td colspan="2"><input type="text" name="court.ao.aoMail2" value="${court.ao.aoMail2 }"/>
                                <input type="hidden" name="court.ao.aoId" value="${court.ao.aoId }"/>
                                <input type="hidden" name="court.ao.aoCasecodeself" value="${court.ao.aoCasecodeself }"/>
                                </td>
                            </tr>
                            <tr>
								<td align="right">备注：</td>
								<td colspan="2"><textarea rows="5" cols="60" value="${court.ao.aoRemark}" 
								 name="court.ao.aoRemark"></textarea></td>
							</tr>
                            <tr>
                            	<td>&nbsp;</td>
                            	<td colspan="2">
                            	<input  type="hidden" value="${court.caseId}" name="court.caseId">
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
