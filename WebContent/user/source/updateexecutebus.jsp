<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改被执行人企业信息</title>
<link rel="stylesheet" href="/lawyer/css/public.css"/>
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>

<script language="javascript">
	function loadCalendar(data)
	{
		var rtn=window.showModalDialog("/lawyer/user/lawCase/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
		if(rtn!=null){
			$(data).val(rtn);
		}		
	   return;
	}
 </script>
</head>

<body>
<table cellspacing="0" cellpadding="0" border="0" width="100%" height="100%" class="content_table">
    <tr>
    	<td>
        	&nbsp;&nbsp;<img src="/lawyer/images/flag3_(add)_16x16.gif"/>&nbsp;
            <span class="title">修改被执行人企业信息</span>
        </td>
    </tr>
    <tr>
    	<td>
        	<table cellpadding="0" cellspacing="0" width="98%" align="center" class="search_table" border="0">
                	<tr>
                    	<td align="right" width="20%">案源信息编号：</td>
                        <td><strong>${court.eb.ECCasecodeself}</strong></td>
                    </tr>
                </table>
        </td>
    </tr>
    <tr>
    	<td>
        	<table align="center" cellpadding="0" cellspacing="0" width="98%" border="0">
            	<tr>
                    <td>
                    	<form name="form3" method="post" action="toupexecutebus">
                    	<table class="form_table" align="center" cellpadding="0" cellspacing="0" width="100%" border="0">
                        	<tr>
                            	<td align="right" width="20%">注册号：</td>
                                <td><input type="text" name="court.eb.ERenumber" value="${court.eb.ERenumber}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">企业类型：</td>
                                <td><input type="text" name="court.eb.EType" value="${court.eb.EType}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">主体名称：</td>
                                <td><input type="text" name="court.eb.EName" value="${court.eb.EName}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">法定代表人/负责人：</td>
                                <td><input type="text" name="court.eb.ERepname" value="${court.eb.ERepname}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">成立日期：</td>
                                <td><input type="text" name="court.eb.EDate" value="${court.eb.EDate}" onClick="loadCalendar(this)"/></td>
                            </tr>
                            <tr>
                            	<td align="right">注册资本：</td>
                                <td><input type="text" name="court.eb.EFund" value="${court.eb.EFund}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">实收资本：</td>
                                <td><input type="text" name="court.eb.paidFund" value="${court.eb.paidFund}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">经营期限自：</td>
                                <td><input type="text" name="court.eb.EDfrom" value="${court.eb.EDfrom}" onClick="loadCalendar(this)"/></td>
                            </tr>
                            <tr>
                            	<td align="right">经营期限至：</td>
                                <td><input type="text" name="court.eb.EDto" value="${court.eb.EDto}" onClick="loadCalendar(this)"/></td>
                            </tr>
                            <tr>
                            	<td align="right">登记机关：</td>
                                <td><input type="text" name="court.eb.EOrgan" value="${court.eb.EOrgan}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">地址/住所：</td>
                                <td><input type="text" name="court.eb.EAddress" value="${court.eb.EAddress}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">企业状态：</td>
                                <td><input type="text" name="court.eb.EStatus" value="${court.eb.EStatus}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">经营异常名录：</td>
                                <td><input type="text" name="court.eb.exception" value="${court.eb.exception}"/></td>
                            </tr>
                             <tr>
                            	<td align="right">年检年度：</td>
                                <td><input type="text" name="court.eb.EAnnual" value="${court.eb.EAnnual}"/></td>
                            </tr>
                             <tr>
                            	<td align="right">年检结果：</td>
                                <td><input type="text" name="court.eb.EResults" value="${court.eb.EResults}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">注销日期：</td>
                                <td><input type="text" name="court.eb.ECancellation" value="${court.eb.ECancellation}" onClick="loadCalendar(this)"/></td>
                            </tr>
                            <tr>
                            	<td align="right">吊销日期：</td>
                                <td><input type="text" name="court.eb.ERevoke" value="${court.eb.ERevoke}" onClick="loadCalendar(this)"/></td>
                            </tr>
                            <tr>
                            	<td align="right">组织机构代码：</td>
                                <td><input type="text" name="court.eb.organization_code" value="${court.eb.organization_code}"/></td>
                            </tr>
                            <tr>
                            	<td align="right">代码证颁发机关：</td>
                                <td><input type="text" name="court.eb.organization_code_issuing_agencies" value="${court.eb.organization_code_issuing_agencies}"/></td>
                            </tr>
                           
                            <tr>
                            	<td align="right">备注：</td>
                                <td><input type="text" name="court.eb.ERemark" value="${court.eb.ERemark}"/>
                                <input type="hidden" name="court.eb.ECCasecodeself" value="${court.eb.ECCasecodeself}"/>
                                 <input type="hidden" name="court.eb.EId" value="${court.eb.EId}"/>
                                </td>
                            </tr>
                            <tr>
                            	<td align="center" colspan="2">
                            	
                            	<input type="hidden" value="${court.caseId}" name="court.caseId">
                                	<input type="submit" value="修改" />&nbsp;&nbsp;
                                    <input type="reset" value="重置" />
                                 </td>
                            </tr>
                        </table>
                        </form>
                    </td>
                    <td>
				<form name="ebform" action="insertEb.action" method="post">
				<table>
					<tr>
						<td align="right">主体名称：</td>
						<td><input type="text" name="executebus.EName" /></td>
					</tr>
					<tr>
						<td><input type="hidden" 
							name="executebus.ECCasecodeself" value="${court.eb.ECCasecodeself}" />
							<input type="hidden" name="caseId" value="${court.caseId}" />
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="submit"
							value="提交" />&nbsp;&nbsp; <input type="reset" value="重置" /></td>
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
</table>    
</body>
</html>
