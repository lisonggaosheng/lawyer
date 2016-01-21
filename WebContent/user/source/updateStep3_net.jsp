<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改第三步（申请执行人企业信息——网络信息）页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
  <link rel="stylesheet" href="../../css/public.css" type="text/css"></link>
  </head>
  
  <body>
    <table cellspacing="0" cellpadding="0" border="0" width="100%" height="100%" class="content_table">
	
    <tr>
    	<td>
        	&nbsp;&nbsp;<img src="../../images/flag3_(add)_16x16.gif"/>&nbsp;
            <span class="title">修改申请执行人企业信息</span>
        </td>
    </tr>
    <tr>
    	<td>
        	<table cellpadding="0" cellspacing="0" width="98%" align="center" class="search_table" border="0">
                	<tr>
                    	<td align="right" width="20%">案源信息编号：</td>
                        <td><strong>356_20130114_001</strong></td>
                    </tr>
                </table>
        </td>
    </tr>
    <tr>
    	<td>
        	<table align="center" cellpadding="0" cellspacing="0" width="98%" border="0">
            	<tr>
                    <td>
                    	<form name="form3" method="post" action="updateStep1-3_net">
                    	
                    	<table class="form_table" align="center" cellpadding="0" cellspacing="0" width="100%" border="0">
                        	<tr class="title">
                            	<td align="right"><img src="../../images/flag2_16x16.gif" />&nbsp;网络信息</td>
                                <td colspan="2">&nbsp;</td>
                            </tr>
                            
                            <tr>
                            	<td align="right">法定代表人/负责人：</td>
                                <td><input type="text" name="applierinfoNetwork.anName"/></td>
                                <td width="50%" rowspan="8" align="center">
                                	<textarea cols="60" rows="15" class="textarea_analyse"></textarea>
                                </td>
                            </tr>
                            <tr>
                            	<td align="right">法定代表人/负责人身份证号：</td>
                                <td><input type="text" name="applierinfoNetwork.anIdentify" value="${applierinfoNetwork.anIdentify}" /></td>
                            </tr>
                            <tr>
                            	<td align="right">行政区划：</td>
                                <td><input type="text" name="applierinfoNetwork.anDistrict" value="${applierinfoNetwork.anDistrict}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">成立日期：</td>
                                <td><input type="text" name="applierinfoNetwork.anDate" value="${applierinfoNetwork.anDate}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">注册资本：</td>
                                <td><input type="text" name="applierinfoNetwork.anFund" value="${applierinfoNetwork.anFund}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">经营期限自：</td>
                                <td><input type="text" name="applierinfoNetwork.anDfrom" value="${applierinfoNetwork.anDfrom}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">经营期限至：</td>
                                <td><input type="text" name="applierinfoNetwork.anDto" value="${applierinfoNetwork.anDto}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">登记机关：</td>
                                <td><input type="text" name="applierinfoNetwork.anOrgan" value="${applierinfoNetwork.anOrgan}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">地址/住所：</td>
                                <td><input type="text" name="applierinfoNetwork.anAddress" value="${applierinfoNetwork.anAddress}"/></td>
                                <td align="right"><input type="button" value="一键分析" />&nbsp;&nbsp;</td>
                            </tr>
                            <tr>
                            	<td align="center" colspan="2">
                                	<input type="submit" value="修改" />&nbsp;&nbsp;
                                    <input type="reset" value="重置" />
                                 </td>
                                 <td>&nbsp;</td>
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
