<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>添加第四步（与申请执行人联系信息——电话联系）页面</title>
<link rel="stylesheet" href="/lawyer/css/public.css"/>
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/lawyer/js/selectpenson.js"></script>
<script language="javascript">

	function loadCalendar(data)
		{
		var rtn=window.showModalDialog("/lawyer/user/source/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
		if(rtn!=null){
			$(data).val(rtn);
		}
		return;
	}
	
	function selectpenson(){
		var pensonname = $("#penson").find("option:selected").text();
		$("#pensonname").val(pensonname);	
	}
	
  </script>
</head>

<body>
	
<table cellspacing="0" cellpadding="0" border="0" width="100%" height="100%" class="content_table">
	
    <tr>
    	<td>
        	&nbsp;&nbsp;<img src="/lawyer/images/flag3_add_16x16.gif"/>&nbsp;
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
                    	<form name="form3" method="post" action="insertConTel" enctype="multipart/form-data">
                    	
                    	<table class="form_table" align="center" cellpadding="0" cellspacing="0" width="100%" border="0">
                        	<tr class="title">
                            	<td align="right"><img src="/lawyer/images/flag2_16x16.gif" />&nbsp;电话联系</td>
                                <td colspan="2">&nbsp;</td>
                            </tr>
                            <tr>
                            	<td align="right" width="20%">打电话人员：</td>
                                <td colspan="2">
                                	<input type="text" id="pensonname" name="contactTel.ctName" value="${contactTel.ctName }" readOnly="readonly"/>
                                	<select name="penson" id="penson" onchange="selectpenson()">
										<option >请选择打电话人员</option>
									</select>
                                </td>
                            </tr>
                        	<tr>
                            	<td align="right" width="20%">联系人1姓名：</td>
                                <td colspan="2"><input type="text" name="contactTel.ctName1" value="${contactTel.ctName1 }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">联系人1电话：</td>
                                <td colspan="2"><input  type="text" name="contactTel.ctTel1" value="${contactTel.ctTel1 }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">联系人2姓名：</td>
                                <td colspan="2"><input type="text" name="contactTel.ctName2" value="${contactTel.ctName2 }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">联系人2电话：</td>
                                <td colspan="2"><input  type="text" name="contactTel.ctTel2" value="${contactTel.ctTel2 }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">打电话时间：</td>
                                <td colspan="2"><input type="text" name="contactTel.ctTime" value="${contactTel.ctTime }"
                                 onClick="loadCalendar(this)" readonly="readonly"/></td>
                            </tr>
                            <tr>
                            	<td align="right">打电话结果：</td>
                                <td colspan="2"><input type="text" name="contactTel.ctResult" value="${contactTel.ctResult }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">打电话所用电话号码：</td>
                                <td colspan="2"><input  type="text" name="contactTel.ctTel3" value="${contactTel.ctTel3 }"/></td>
                            </tr>
                            <tr>
                            	<td align="right">备注：</td>
                                <td colspan="2">
                                	<textarea class="textarea_remarks" name="contactTel.ctRemark">${contactTel.ctRemark }</textarea>
                                </td>
                            </tr>
                            <tr>
                            	<td align="right">附件：</td>
                                <td colspan="2"><input type="file" name="attach"/></td>
                            </tr>
                             <tr style="display:none;">
                            	<td >
                            		<c:choose>
								       <c:when test="${param.casecodeself != null}">
								            <input type="hidden" name="contactTel.ctCasecodeself"
												value="${param.casecodeself}" />
											<input type="hidden" name="caseId"
													value="${param.caseId}" />
								       </c:when>
								       <c:when test="${contactTel.ctCasecodeself != null}">
								              	<input type="hidden" name="contactTel.ctCasecodeself"
													value="${contactTel.ctCasecodeself}" />
												<input type="hidden" name="caseId"
													value="${caseId}" />
								       </c:when>
									</c:choose>
                            	</td>
                            </tr>
                            <tr>
                            	<td>&nbsp;</td>
                            	<td colspan="2">
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