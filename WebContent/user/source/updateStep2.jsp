<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>被执行人企业信息</title>
<link rel="stylesheet" href="../../css/public.css"/>
</head>

<body>
	
<table cellspacing="0" cellpadding="0" border="0" width="100%" height="100%" class="content_table">
	
    <tr>
    	<td>
        	&nbsp;&nbsp;<img src="../../images/flag3_(add)_16x16.gif"/>&nbsp;
            <span class="title">修改被执行人企业信息</span>
        </td>
    </tr>
    <tr>
    	<td>
        	<table cellpadding="0" cellspacing="0" width="98%" align="center" class="search_table" border="0">
                	<tr>
                    	<td align="right" width="20%">案源信息编号：</td>
                        <td><strong>356_20120114_001</strong></td>
                    </tr>
                </table>
        </td>
    </tr>
    <tr>
    	<td>
        	<table align="center" cellpadding="0" cellspacing="0" width="98%" border="0">
            	<tr>
                    <td>
                    	<form name="form3" method="post" action="insertStep2">
                    	<table class="form_table" align="center" cellpadding="0" cellspacing="0" width="100%" border="0">
                        	<tr>
                            	<td align="right" width="20%">注册号：</td>
                                <td><input type="text" name="executebus.ERenumber" value=${executebus.ERenumber}/></td>
                            </tr>
                            <tr>
                            	<td align="right">企业类型：</td>
                                <td><input type="text" name="executebus.EType" value=${executebus.EType}/></td>
                            </tr>
                            <tr>
                            	<td align="right">主体名称：</td>
                                <td><input type="text" name="executebus.EName" value=${executebus.EName}/></td>
                            </tr>
                            <tr>
                            	<td align="right">法定代表人/负责人：</td>
                                <td><input type="text" name="executebus.ERepname" value=${executebus.ERepname}/></td>
                            </tr>
                            <!-- <tr>
                            	<td align="right">法定代表人/负责人身份证号：</td>
                                <td><input type="text" name="executebus.ERepid" value=${executebus.ERepid}/></td>
                            </tr> -->	
                            <tr>
                            	<td align="right">行政区划：</td>
                                <td><input type="text" name="executebus.EDistrict" value=${executebus.EDistrict}/></td>
                            </tr>
                            <tr>
                            	<td align="right">成立日期：</td>
                                <td><input type="text" name="executebus.EDate" value=${executebus.EDate}/></td>
                            </tr>
                            <tr>
                            	<td align="right">注册资本：</td>
                                <td><input type="text" name="executebus.EFund" value=${executebus.EFund}/></td>
                            </tr>
                            <tr>
                            	<td align="right">经营期限自：</td>
                                <td><input type="text" name="executebus.EDfrom" value=${executebus.EDfrom}/></td>
                            </tr>
                            <tr>
                            	<td align="right">经营期限至：</td>
                                <td><input type="text" name="executebus.EDto" value=${executebus.EDto}/></td>
                            </tr>
                            <tr>
                            	<td align="right">登记机关：</td>
                                <td><input type="text" name="executebus.EOrgan" value=${executebus.EOrgan}/></td>
                            </tr>
                            <tr>
                            	<td align="right">地址/住所：</td>
                                <td><input type="text" name="executebus.EAddress" value=${executebus.EAddress}/></td>
                            </tr>
                            <tr>
                            	<td align="right">企业状态：</td>
                                <td><input type="text" name="executebus.ECaseState" value=${executebus.ECaseState}/></td>
                            </tr>
                            <tr>
                            	<td align="right">经营异常名录：</td>
                                <td><input type="text" name="executebus.exception" value=${executebus.exception}/></td>
                            </tr>
                            <tr>
                            	<td align="right">注销日期：</td>
                                <td><input type="text" name="executebus.ECancellation" value=${executebus.ECancellation}/></td>
                            </tr>
                            <tr>
                            	<td align="right">吊销日期：</td>
                                <td><input type="text" name="executebus.ERevoke" value=${executebus.ERevoke}/></td>
                            </tr>
                            <tr>
                            	<td align="right">年检年度：</td>
                                <td><input type="text" name="executebus.EAnnual" value=${executebus.EAnnual}/></td>
                            </tr>
                            <tr>
                            	<td align="right">备注：</td>
                                <td><input type="text" name="executebus.ERemark" value=${executebus.ERemark}/></td>
                            </tr>
                            <tr>
                            	<td align="center" colspan="2">
                                	<input type="submit" value="修改" />&nbsp;&nbsp;
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
