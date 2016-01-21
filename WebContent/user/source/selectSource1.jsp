<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.net.URLEncoder"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="/lawyer/js/jquery-1.6.4.min.js"></script>
<title>查看案源详细信息</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<script type="text/javascript">
	//改变案源信息的执行步骤
	function changeStep(){
		var casecodeself = document.getElementById("casecodeself").value;
		var courtid = document.getElementById("courtid").value;
		var courtStep = document.getElementById("courtStep").value;
		if(courtStep==""){
			alert("填写要改变的执行步骤!");
			return;
		}
		mes="将改变所查询出数据的执行步骤，是否继续?";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/changeOneStep.action",
				data:"court.casecodeself="+casecodeself+"&court.id="+courtid+"&courtStep="+courtStep,
				success:function(msg){
					alert(msg);
					location.reload(true);
				}
			});
		}
	}

	//数据暂时排除
	function presentExclude(){
		var casecodeself = document.getElementById("casecodeself").value;
		var courtid = document.getElementById("courtid").value;
		mes="是否进行数据暂时性排除?";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/presentExclude.action",
				data:"court.casecodeself="+casecodeself+"&court.id="+courtid,
				success:function(msg){
					alert(msg);
					location.reload(true);
				}
			});
		}
	}

	//数据永久排除
	function perpetualExclude(){
		var casecodeself = document.getElementById("casecodeself").value;
		var courtid = document.getElementById("courtid").value;
		mes="是否进行数据永久排除?";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/perpetualExclude.action",
				data:"court.casecodeself="+casecodeself+"&court.id="+courtid,
				success:function(msg){
					alert(msg);
					location.reload(true);
				}
			});
		}
	}

	//数据恢复
	function dataRecover(){
		var casecodeself = document.getElementById("casecodeself").value;
		var courtid = document.getElementById("courtid").value;
		mes="是否对数据进行恢复?";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/dataRecover.action",
				data:"court.casecodeself="+casecodeself+"&court.id="+courtid,
				success:function(msg){
					alert(msg);
					location.reload(true);
				}
			});
		}
	}
</script>
</head>
<body>
<table cellspacing="0" cellpadding="0" border="0" width="100%"
	height="100%" class="content_table">
	<tr>
		<td>&nbsp;&nbsp;<img src="/lawyer/images/view_16x16.gif" />&nbsp;
		<span class="title">编号为${court.casecodeself }的案源信息详情</span></td>
	</tr>
	<tr>
		<td>
			<input type="button" value="改变执行步骤：" onclick="changeStep()">
			<input type="text" id="courtStep" name="courtStep" />（填写要改变的步骤）
			<input type="hidden" id="casecodeself" name="casecodeself" value="${court.casecodeself }"/>
			<input type="hidden" id="courtid" name="courtid" value="${court.id}"/>
		</td>
		<td align="center">
			<s:if test="court.excludeStatus == 0 ">
				<input type="button" value="暂时排除" onclick="presentExclude()">
				<input type="button" value="永久排除" onclick="perpetualExclude()">
			</s:if>
			<s:if test="court.excludeStatus == 1 ">
				<input type="button" value="数据恢复" onclick="dataRecover()">
			</s:if>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<table cellpadding="0" cellspacing="0" width="98%" align="center"
			class="result_table" border="0">
			<tr class="title">
				<td colspan="6">&nbsp;&nbsp;<img
					src="/lawyer/images/flag2_16x16.gif" />&nbsp;被执行人(债务人)信息</td>
			</tr>
			<tr>
				<td class="padding_td" valign="top" colspan="6">
				<table cellpadding="0" cellspacing="0" width="100%" border="0"
					class="step_table">
					<tr>
						<s:if test="court.infoType == 1 ">
							<td class="td" colspan="2">普通信息</td>
						</s:if>
						<s:else>
							<td class="td" colspan="2">公告信息</td>
						</s:else>
					</tr>
					<tr>
						<td align="right"  class="td">被执行人（债务人）名称：</td>
						<td class="td">${court.pname}</td>
					</tr>
					<tr>
						<td align="right"  class="td">债权人名称名称：</td>
						<td class="td">${court.creditor}</td>
					</tr>
					<tr>
						<td align="right" class="td">公告法院：</td>
						<td class="td">${court.noticeCourt}</td>
					</tr>
					<tr>
						<td align="right"  class="td">公告时间：</td>
						<td class="td">${court.noticeTime}</td>
					</tr>
					<tr>
						<td align="right" class="td">法律文书号：</td>
						<td class="td">${court.lawDocumentNum}</td>
					</tr>
					<tr>
						<td align="right" class="td">身份证号/组织机构代码：</td>
						<td class="td">${court.partyCardNum }</td>
					</tr>
					<tr>
						<td align="right" class="td">执行法院：</td>
						<td class="td">${court.execCourtName }</td>
					</tr>
					<tr>
						<td align="right" class="td">案件状态：</td>
						<td class="td">${court.caseState }</td>
					</tr>
					<tr>
						<td align="right" class="td">案号：</td>
						<td class="td">${ court.caseCode }</td>
					</tr>
					<tr>
						<td align="right" class="td">执行标的：</td>
						<td class="td">${court.execMoney }</td>
					</tr>
					<tr>
						<td align="right" class="td">立案时间：</td>
						<td class="td">${court.caseCreateTime }</td>
					</tr>
					<tr>
						<td align="right" class="td">备注：</td>
						<td class="td">${court.remark}</td>
					</tr>
					<tr>
						<td class="td" align="right"><b>可执行操作</b>：</td>
						<td class="td"><a
							href="updCourt1?court.caseId=${court.caseId}">修改</a>&nbsp;&nbsp;
						<a href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a></td>
					</tr>
				</table>

				</td>
			</tr>
			<tr class="title">
				<td colspan="6">&nbsp;&nbsp;<img
					src="/lawyer/images/flag2_16x16.gif" />&nbsp;被执行人(债务人)企业信息</td>
			</tr>

			<!-- 被执行人企业信息=================================== -->
			<!--一层if  -->
			<s:if test="court.eb!=null">
				<tr>
					<td class="padding_td" valign="top" colspan="6">

					<table cellpadding="0" cellspacing="0" width="100%" border="0"
						class="step_table">
						<tr>
							<td align="right" width="15%" class="td">注册号：</td>
							<td class="td">${court.eb.ERenumber }</td>
						</tr>
						<tr>
							<td align="right" class="td">企业类型：</td>
							<td class="td">${court.eb.EType }</td>
						</tr>
						<tr>
							<td align="right" class="td">主体名称：</td>
							<td class="td">${court.eb.EName }</td>
						</tr>
						<tr>
							<td align="right" class="td">法定代表人/负责人：</td>
							<td class="td">${court.eb.ERepname }  ${userlp.lp_exb_show_repid}</td>
						</tr>
						<c:if test="${userlp.lp_exb_show_repid == 1}">
							<tr>
								<td align="right" class="td">法人身份证号：</td>
								<td class="td">${court.eb.ERepid }</td>
							</tr> 
						</c:if>
						<tr>
							<td align="right" class="td">股东名录：</td>
							<td class="td">${court.eb.shareholder}</td>
						</tr>
						<tr>
							<td align="right" class="td">成立日期：</td>
							<td class="td">${court.eb.EDate}</td>
						</tr>
						<tr>
							<td align="right" class="td">注册资本：</td>
							<td class="td">${court.eb.EFund }</td>
						</tr>
						<tr>
							<td align="right" class="td">实收资本：</td>
							<td class="td">${court.eb.paidFund }</td>
						</tr>
						<tr>
							<td align="right" class="td">经营期限自：</td>
							<td class="td">${court.eb.EDfrom }</td>
						</tr>
						<tr>
							<td align="right" class="td">经营期限至：</td>
							<td class="td">${court.eb.EDto }</td>
						</tr>
						<tr>
							<td align="right" class="td">登记机关：</td>
							<td class="td">${court.eb.EOrgan }</td>
						</tr>
						<tr>
							<td align="right" class="td">地址/住所：</td>
							<td class="td">${court.eb.EAddress }</td>
						</tr>
						<tr>
							<td align="right" class="td">企业状态：</td>
							<td class="td">${court.eb.EStatus }</td>
						</tr>
						<tr>
							<td align="right" class="td">经营异常名录：</td>
							<td class="td">${court.eb.exception }</td>
						</tr>
						<tr>
							<td align="right" class="td">年检年度：</td>
							<td class="td">${court.eb.EAnnual }</td>
						</tr>
						<tr>
							<td align="right" class="td">年检结果：</td>
							<td class="td">${court.eb.EResults }</td>
						</tr>
						<tr>
							<td align="right" class="td">注销日期：</td>
							<td class="td">${court.eb.ECancellation }</td>
						</tr>
						<tr>
							<td align="right" class="td">吊销日期：</td>
							<td class="td">${court.eb.ERevoke }</td>
						</tr>
						<tr>
							<td align="right" class="td">组织机构代码：</td>
							<td class="td">${court.eb.organization_code }</td>
						</tr>
						<tr>
							<td align="right" class="td">代码证颁发机关：</td>
							<td class="td">${court.eb.organization_code_issuing_agencies }</td>
						</tr>
						<tr>
							<td align="right" class="td">不良司法信息：</td>
							<td class="td">${court.eb.adverse_judicial_information}</td>
						</tr>
						<tr>
							<td align="right" class="td">行政处罚信息：</td>
							<td class="td">${court.eb.administrative_sanction_information }</td>
						</tr>
						<tr>
							<td align="right" class="td">投资人信息：</td>
							<td class="td">${court.eb.investor_information }</td>
						</tr>
						<tr>
							<td align="right" class="td">再投资信息：</td>
							<td class="td">${court.eb.reinvestment_information }</td>
						</tr>
						<tr>
							<td align="right" class="td">备注：</td>
							<td class="td">${court.eb.ERemark}</td>
						</tr>
						<tr>
							<td class="td" align="right"><b>可执行操作</b>：</td>
							<td class="td"><a href="upexecutebus?court.eb.EId=${court.eb.EId }&court.caseId=${court.caseId}">修改</a>&nbsp;
								<a href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a>&nbsp;
							<form method="post" name="ebusiness" action="selexecutebusiness">
							<a href="javascript:ebusiness.submit()">查看全部数据</a>
							<input type="hidden" value="${court.eb.ECCasecodeself}"
								name="executebus.ECCasecodeself"> <input type="hidden"
								value="${court.eb.EName}" name="executebus.EName">
								<input type="hidden"
								value="${court.caseId}" name="caseId">
								</form>
							</td>
						</tr>
					</table>
					</td>
				</tr>
				<tr class="title">
					<td colspan="6">&nbsp;&nbsp;<img
						src="/lawyer/images/flag2_16x16.gif" />&nbsp;申请人(债权人)信息</td>
				</tr>
				<!--申请执行人信息==========================  -->


				<!--申请人企业  -->

				<tr align="center">
					<td colspan="2" width="35%"><b>企业信息</b></td>

					<td colspan="2" width="35%"><b>网络信息</b></td>

					<td colspan="2"><b>自有信息</b></td>
				</tr>
				<!--二层if - -->
				<s:if test="court.ap&&court.an&&court.ao">
					<tr>
						<td colspan="2" class="padding_td" valign="top">

						<table cellpadding="0" cellspacing="0" width="100%" border="0"
							class="step_table">
							<tr>
								<td align="right" width="45%" class="td">注册号：</td>
								<td class="td">${court.ap.appRenumber }</td>
							</tr>
							<tr>
								<td align="right" class="td">主体名称：</td>
								<td class="td">${court.ap.appName }</td>
							</tr>
							<tr>
								<td align="right" class="td">企业类型：</td>
								<td class="td">${court.ap.appType }</td>
							</tr>
							<tr>
								<td align="right" class="td">法定代表人/负责人：</td>
								<td class="td">${court.ap.appRepname }</td>
							</tr>
							<%-- <tr>
									<td align="right" class="td">法定代表人/负责人身份证号：</td>
									<td class="td">${court.ap.appRepid }</td>
								</tr> --%>
							<tr>
								<td align="right" class="td">行政区划：</td>
								<td class="td">${court.ap.appDistrict }</td>
							</tr>
							<tr>
								<td align="right" class="td">成立日期：</td>
								<td class="td">${court.ap.appDate }</td>
							</tr>
							<tr>
								<td align="right" class="td">注册资本：</td>
								<td class="td">${court.ap.appFund }</td>
							</tr>
							<tr>
								<td align="right" class="td">经营期限自：</td>
								<td class="td">${court.ap.appDfrom }</td>
							</tr>
							<tr>
								<td align="right" class="td">经营期限至：</td>
								<td class="td">${court.ap.appDto }</td>
							</tr>
							<tr>
								<td align="right" class="td">登记机关：</td>
								<td class="td">${court.ap.appOrgan }</td>
							</tr>
							<tr>
								<td align="right" class="td">地址/住所：</td>
								<td class="td">${court.ap.appAddress }</td>
							</tr>
							<tr>
								<td align="right" class="td">企业状态：</td>
								<td class="td">${court.ap.appStatus }</td>
							</tr>
							<tr>
								<td align="right" class="td">年检年度：</td>
								<td class="td">${court.ap.appAnnual }</td>
							</tr>
							<tr>
								<td align="right" class="td">注销日期：</td>
								<td class="td">${court.ap.appCancellation }</td>
							</tr>
							<tr>
								<td align="right" class="td">吊销日期：</td>
								<td class="td">${court.ap.appRevoke }</td>
							</tr>
							<tr>
								<td align="right" class="td">备注：</td>
								<td class="td">${court.ap.appRemark }</td>
							</tr>
							<tr>
								<td align="right" class="td">市场标记：</td>
								<td class="td">
									<c:choose>
									    <c:when test="${court.ap.usedMark == 1}">是</c:when>
									    <c:when test="${court.ap.usedMark == 0}">否</c:when>
									    <c:when test="${court.ap.usedMark == 2}">其他：${court.ap.markRemark }</c:when>
									    <c:otherwise>
									    	还没有进行标记
									    </c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td align="right" class="td">市场标记时间：</td>
								<td class="td">${court.ap.markTime }</td>
							</tr>
							<tr>
								<td class="td" align="right"><b>可执行操作</b>：</td>
								<td class="td">
									<a href="updapplierinfo?court.ap.appId=${court.ap.appId }&court.caseId=${court.caseId}">修改</a>&nbsp;&nbsp;
									<a href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a>
									&nbsp;&nbsp;&nbsp;
									<a href="selap.action?applierinfo.appCCasecodeself=${applierinfo.appCCasecodeself}&caseId=${court.caseId}">查看全部数据</a>
								</td>
							</tr>
						</table>
						</td>
						<!--网络信息===  -->
						<td class="padding_td" valign="top" colspan="2">
						<table cellpadding="0" cellspacing="0" width="100%" border="0"
							class="step_table">
							<tr>
								<td align="right" width="30%" class="td">主体名称：</td>
								<td class="td">${court.an.anName }</td>
							</tr>
							<tr>
								<td align="right" width="20%" class="td">地址/住所：</td>
								<td class="td">${court.an.anAddress }</td>
							</tr>
							<tr>
								<td align="right" width="20%" class="td">联系人：</td>
								<td class="td">${court.an.anConname }</td>
							</tr>
							<tr>
								<td align="right" width="20%" class="td">电话：</td>
								<td class="td">${court.an.anPhone }</td>
							</tr>
							<tr>
								<td align="right" width="20%" class="td">传真：</td>
								<td class="td">${court.an.anFax }</td>
							</tr>
							<tr>
								<td align="right" width="20%" class="td">邮件：</td>
								<td class="td">${court.an.anMail }</td>
							</tr>
							<tr>
								<td class="td" align="right"><b>可执行操作</b>：</td>
								<td class="td"><a href="javascript:alert('业务不支持修改操作');">修改</a>&nbsp;&nbsp;
								<a href="javascript:confirm('确实要删除吗?'){alert('业务不支持全部删除');};">删除</a></td>
							</tr>
						</table>
						<a
							href="findAllAppNets.action?applierinfoNetwork.anCasecodeself=${court.casecodeself }"
							target="_blank">查看全部数据</a></td>
						<!-- 自有信息==== -->

						<td class="padding_td" valign="top" colspan="2">

						<table cellpadding="0" cellspacing="0" width="100%" border="0"
							class="step_table">
							<tr>
								<td align="right" width="40%" class="td">申请人名称：</td>
								<td class="td">${court.ao.aoName }</td>
							</tr>
							<tr>
								<td align="right" width="25%" class="td">申请人地址：</td>
								<td class="td">${court.ao.aoAddress }</td>
							</tr>
							<tr>
								<td align="right" width="25%" class="td">联系人1姓名：</td>
								<td class="td">${court.ao.aoName1 }</td>
							</tr>
							<tr>
								<td align="right" width="25%" class="td">联系人1电话：</td>
								<td class="td">${court.ao.aoPhone1 }</td>
							</tr>
							<tr>
								<td align="right" width="25%" class="td">联系人1传真：</td>
								<td class="td">${court.ao.aoFax1 }</td>
							</tr>
							<tr>
								<td align="right" width="25%" class="td">联系人1邮件：</td>
								<td class="td">${court.ao.aoMail1 }</td>
							</tr>
							<tr>
								<td align="right" width="25%" class="td">联系人2姓名：</td>
								<td class="td">${court.ao.aoName2 }</td>
							</tr>
							<tr>
								<td align="right" width="25%" class="td">联系人2电话：</td>
								<td class="td">${court.ao.aoPhone2 }</td>
							</tr>
							<tr>
								<td align="right" width="25%" class="td">联系人2传真：</td>
								<td class="td">${court.ao.aoFax2 }</td>
							</tr>
							<tr>
								<td align="right" width="25%" class="td">联系人2邮件：</td>
								<td class="td">${court.ao.aoMail2 }</td>
							</tr>
							<tr>
								<td align="right" width="25%" class="td">备注：</td>
								<td class="td">${court.ao.aoRemark }</td>
							</tr>
							<tr>
								<td class="td" align="right"><b>可执行操作</b>：</td>
								<td class="td"><a
									href="updapplierinfoonself?court.ao.aoCasecodeself=${court.ao.aoCasecodeself }&court.caseId=${court.caseId}">修改</a>&nbsp;&nbsp;
								<a href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a></td>
							</tr>
						</table>
						</td>
					</tr>

					<!--与申请执行人联系信息 ==============================  -->
					<tr class="title">
						<td colspan="6">&nbsp;&nbsp;<img
							src="/lawyer/images/flag2_16x16.gif" />&nbsp;与申请人(债务人)联系信息</td>
					</tr>
					<!-- 第三层if -->
					<s:if
						test="court.cm!=null||court.ct!=null||court.ce!=null||court.cf!=null||court.csee!=null||court.ctalk!=null">
						<s:if test="court.csign==null">

							<tr align="center">
								<td colspan="3"><b>电子邮件</b></td>
								<td colspan="3"><b>电话联系</b></td>
							</tr>
							<tr>
								<s:if test="court.cm!=null">
									<td class="padding_td" valign="top" colspan="3"><s:iterator
										value="court.cm">
										<table cellpadding="0" cellspacing="0" width="100%" border="0"
											class="step_table">
											<tr>
												<td align="right" width="40%" class="td">邮件地址：</td>
												<td class="td"><s:property value="cmMail" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">发送人：</td>
												<td class="td"><s:property value="cmMsender" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">发送时间：</td>
												<td class="td"><s:property value="cmDate" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">发送结果：</td>
												<td class="td"><s:property value="cmResult" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">备注：</td>
												<td class="td"><s:property value="cmRemark" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">附件：</td>
												<td class="td"><a
													href="downFile.action?filename=/uploads/案源文件库/<s:property value="cmAttach" />">
												<s:property value="cmAttach" /></a></td>
											</tr>

											<tr>
												<td class="td" align="right"><b>可执行操作：</b></td>
												<td class="td">
												<a href="selectConMail.action?contactMail.cmCasecodeself=${court.casecodeself }&caseId=${court.caseId}"
														target="_blank">查看全部电子邮件信息</a>
											</td>
											</tr>
											<tr>
												<td class="td"></td>
												<td class="td"></td>
											</tr>
										</table>
									</s:iterator><a
										href="/lawyer/user/source/insertStep4_email.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">继续添加</a></td>

								</s:if>
								<s:else>
									<td class="padding_td" valign="top" colspan="3"><a
										href="/lawyer/user/source/insertStep4_email.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
								</s:else>
								<s:if test="court.ct!=null">
									<td class="padding_td" valign="top" colspan="3"><s:iterator
										value="court.ct">
										<table cellpadding="0" cellspacing="0" width="100%" border="0"
											class="step_table">
											<tr>
												<td align="right" width="40%" class="td">打电话人姓名：</td>
												<td class="td"><s:property value="ctName" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">打电话时间：</td>
												<td class="td"><s:property value="ctTime" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">打电话结果：</td>
												<td class="td"><s:property value="ctResult" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">打电话所用电话号码：</td>
												<td class="td"><s:property value="ctTel3" /></td>
											</tr>
											<tr>
												<td align="right" width="40%" class="td">联系人1姓名：</td>
												<td class="td"><s:property value="ctName1" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">联系人1电话：</td>
												<td class="td"><s:property value="ctTel1" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">联系人2姓名：</td>
												<td class="td"><s:property value="ctName2" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">联系人2电话：</td>
												<td class="td"><s:property value="ctTel2" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">备注：</td>
												<td class="td"><s:property value="ctRemark" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">附件：</td>
												<td class="td"><a
													href="downFile.action?filename=/uploads/案源文件库/<s:property value="ctAttach" />">
												<s:property value="ctAttach" /></a></td>
											</tr>
											<tr>
												<td class="td" align="right"><b>可执行操作</b>：</td>
												<td class="td">
												<a href="selectConTel.action?contactTel.ctCasecodeself=${court.casecodeself }&caseId=${court.caseId}"
														target="_blank">查看全部电话联系信息</a>
											</td>
											</tr>
											<tr>
												<td class="td"></td>
												<td class="td"></td>
											</tr>
										</table>
									</s:iterator> <a
										href="/lawyer/user/source/insertStep4_tel.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">继续添加</a></td>
								</s:if>
								<s:else>
									<td class="padding_td" valign="top" colspan="3"><a
										href="/lawyer/user/source/insertStep4_tel.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
								</s:else>
							</tr>
							<tr align="center">
								<td colspan="3" colspan="3"><b>快递</b></td>
								<td colspan="3" colspan="3"><b>传真</b></td>
							</tr>
							<tr>
								<s:if test="court.ce!=null">
									<td class="padding_td" valign="top" colspan="3"><s:iterator
										value="court.ce">
										<table cellpadding="0" cellspacing="0" width="100%" border="0"
											class="step_table">
											<tr>
												<td align="right" width="40%" class="td">发送人：</td>
												<td class="td"><s:property value="ceName" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">发送时间：</td>
												<td class="td"><s:property value="ceDate" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">发送结果：</td>
												<td class="td"><s:property value="ceResult" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">对方接收人：</td>
												<td class="td"><s:property value="ceAccepter" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">接收时间：</td>
												<td class="td"><s:property value="ceTime" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">运单号码：</td>
												<td class="td"><s:property value="ceNumber" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">备注：</td>
												<td class="td"><s:property value="ceRemark" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">附件：</td>
												<td class="td"><a
													href="downFile.action?filename=/uploads/案源文件库/<s:property value="ceAttach" />"><s:property
													value="ceAttach" /></a></td>
											</tr>

											<tr>
												<td class="td" align="right"><b>可执行操作</b>：</td>
												<td class="td">
												<a href="selectConExpress.action?contactExpress.ceCasecodeself=${court.casecodeself }&caseId=${court.caseId}"
														target="_blank">查看全部快递信息</a>
											</td>
											</tr>
											<tr>
												<td class="td"></td>
												<td class="td"></td>
											</tr>
										</table>
									</s:iterator> <a
										href="/lawyer/user/source/insertStep4_ems.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">继续添加</a></td>
								</s:if>

								<s:else>
									<td class="padding_td" valign="top" colspan="3"><a
										href="/lawyer/user/source/insertStep4_ems.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
								</s:else>
								<s:if test="court.cf!=null">
									<td class="padding_td" valign="top" colspan="3"><s:iterator
										value="court.cf">
										<table cellpadding="0" cellspacing="0" width="100%" border="0"
											class="step_table">
											<tr>
												<td align="right" width="25%" class="td">发送人：</td>
												<td class="td"><s:property value="cfName" /></td>
											</tr>
											<tr>
												<td align="right" width="40%" class="td">传真时间：</td>
												<td class="td"><s:property value="cfTime" /></td>
											</tr>

											<tr>
												<td align="right" width="25%" class="td">发送结果：</td>
												<td class="td"><s:property value="cfResult" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">对方接收人：</td>
												<td class="td"><s:property value="cfReceive" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">备注：</td>
												<td class="td"><s:property value="cfRemark" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">附件：</td>
												<td class="td"><a
													href="downFile.action?filename=/uploads/案源文件库/<s:property value="cfAttach" />"><s:property
													value="cfAttach" /></a></td>
											</tr>
											<tr>
												<td class="td" align="right"><b>可执行操作</b>：</td>
												<td class="td" >
												<a href="selectConFax.action?contactFax.cfCasecodeself=${court.casecodeself }&caseId=${court.caseId}"
														target="_blank">查看全部传真信息</a>
											</td>
											</tr>
											<tr>
												<td class="td"></td>
												<td class="td"></td>
											</tr>
										</table>
									</s:iterator><a
										href="/lawyer/user/source/insertStep4_fax.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">继续添加</a></td>
								</s:if>
								<s:else>
									<td class="padding_td" valign="top" colspan="3"><a
										href="/lawyer/user/source/insertStep4_fax.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
								</s:else>
							</tr>
							<tr align="center">
								<td colspan="3"><b>登门拜访</b></td>
								<td colspan="3"><b>约谈跟进情况</b></td>
							</tr>
							<tr>
								<s:if test="court.csee!=null">
									<td class="padding_td" valign="top" colspan="3"><s:iterator
										value="court.csee">
										<table cellpadding="0" cellspacing="0" width="100%" border="0"
											class="step_table">
											<tr>
												<td align="right" width="40%" class="td">拜访时间：</td>
												<td class="td"><s:property value="csDate" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">我方工作人员姓名：</td>
												<td class="td"><s:property value="csName" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">对方工作人员姓名：</td>
												<td class="td"><s:property value="csOthername" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">拜访结果：</td>
												<td class="td"><s:property value="csResult" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">备注：</td>
												<td class="td"><s:property value="csRemark" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">附件：</td>
												<td class="td"><a
													href="downFile.action?filename=/uploads/案源文件库/<s:property value="csAttach" />"><s:property
													value="csAttach" /> </a></td>
											</tr>
											<tr>
												<td class="td" align="right"><b>可执行操作</b>：</td>
												<td class="td">
												<a href="selectConSee.action?contactSee.csCasecodeself=${court.casecodeself }&caseId=${court.caseId}"
														target="_blank">查看全部拜访信息</a>
											</td>
											</tr>
											<tr>
												<td class="td"></td>
												<td class="td"></td>
											</tr>
										</table>
									</s:iterator><a
										href="/lawyer/user/source/insertStep4_see.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">继续添加</a></td>
								</s:if>
								<s:else>
									<td class="padding_td" valign="top" colspan="3"><a
										href="/lawyer/user/source/insertStep4_see.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
								</s:else>
								<s:if test="court.ctalk!=null">
									<td class="padding_td" valign="top" colspan="3"><s:iterator
										value="court.ctalk">
										<table cellpadding="0" cellspacing="0" width="100%" border="0"
											class="step_table">
											<tr>
												<td align="right" width="40%" class="td">时间：</td>
												<td class="td"><s:property value="ctDate" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">对方联系人：</td>
												<td class="td"><s:property value="ctName" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">跟进人：</td>
												<td class="td"><s:property value="ctLawyerName" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">跟进情况：</td>
												<td class="td"><s:property value="ctResult" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">备注：</td>
												<td class="td"><s:property value="ctRemark" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">附件：</td>
												<td class="td"><a
													href="downFile.action?filename=/uploads/案源文件库/<s:property value="ctAttach" />"><s:property
													value="ctAttach" /> </a></td>
											</tr>
											<tr>
												<td class="td" align="right"><b>可执行操作</b>：</td>
												<td class="td">
												<a href="selectConTalk.action?contactTalk.ctCasecodeself=${court.casecodeself }&caseId=${court.caseId}"
														target="_blank">查看全部拜访信息</a>
											</td>
											</tr>
											<tr>
												<td class="td"></td>
												<td class="td"></td>
											</tr>
										</table>
									</s:iterator><a
										href="/lawyer/user/source/insertStep4_talk.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">继续添加</a></td>
								</s:if>
								<s:else>
									<td class="padding_td" valign="top" colspan="3"><a
										href="/lawyer/user/source/insertStep4_talk.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
								</s:else>
							</tr>
							<tr align="center">
								<td colspan="3"><b>签约情况</b></td>
							</tr>
							<tr>
								<td colspan="3"><a
									href="/lawyer/user/source/insertStep4_sign.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
								<!---签约-->
							</tr>
						</s:if>
						<!---签约if-->
						<s:else>
							<tr align="center">
								<td colspan="3"><b>电子邮件</b></td>
								<td colspan="3"><b>电话联系</b></td>
							</tr>
							<tr>
								<s:if test="court.cm!=null">
									<td class="padding_td" valign="top" colspan="3"><s:iterator
										value="court.cm">
										<table cellpadding="0" cellspacing="0" width="100%" border="0"
											class="step_table">
											<tr>
												<td align="right" width="40%" class="td">邮件地址：</td>
												<td class="td"><s:property value="cmMail" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">发送人：</td>
												<td class="td"><s:property value="cmMsender" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">发送时间：</td>
												<td class="td"><s:property value="cmDate" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">发送结果：</td>
												<td class="td"><s:property value="cmResult" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">备注：</td>
												<td class="td"><s:property value="cmRemark" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">附件：</td>
												<td class="td"><a
													href="downFile.action?filename=/uploads/案源文件库/<s:property value="cmAttach" />">
												<s:property value="cmAttach" /></a></td>
											</tr>
											<tr>
												<td class="td" align="right"><b>可执行操作</b></td>
												<td class="td">
												<a href="selectConMail.action?contactMail.cmCasecodeself=${court.casecodeself }&caseId=${court.caseId}"
														target="_blank">查看全部电子邮件信息</a>
											</td>
											</tr>
										</table>
									</s:iterator></td>
								</s:if>
								<s:else>
									<td class="padding_td" valign="top" colspan="3"></td>
								</s:else>
								<s:if test="court.ct!=null">
									<td class="padding_td" valign="top" colspan="3"><s:iterator
										value="court.ct">
										<table cellpadding="0" cellspacing="0" width="100%" border="0"
											class="step_table">
											<tr>
												<td align="right" width="40%" class="td">打电话人姓名：</td>
												<td class="td"><s:property value="ctName" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">打电话时间：</td>
												<td class="td"><s:property value="ctTime" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">打电话结果：</td>
												<td class="td"><s:property value="ctResult" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">打电话所用电话号码：</td>
												<td class="td"><s:property value="ctTel3" /></td>
											</tr>
											<tr>
												<td align="right" width="40%" class="td">联系人1姓名：</td>
												<td class="td"><s:property value="ctName1" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">联系人1电话：</td>
												<td class="td"><s:property value="ctTel1" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">联系人2姓名：</td>
												<td class="td"><s:property value="ctName2" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">联系人2电话：</td>
												<td class="td"><s:property value="ctTel2" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">备注：</td>
												<td class="td"><s:property value="ctRemark" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">附件：</td>
												<td class="td"><a
													href="downFile.action?filename=/uploads/案源文件库/<s:property value="ctAttach" />">
												<s:property value="ctAttach" /></a></td>
											</tr>
											<tr>
												<td class="td" align="right"><b>可执行操作</b>：</td>
												<td class="td">
												<a href="selectConTel.action?contactTel.ctCasecodeself=${court.casecodeself }&caseId=${court.caseId}"
														target="_blank">查看全部电话联系信息</a>
											</td>
											</tr>
											<tr>
												<td class="td"></td>
												<td class="td"></td>
											</tr>
										</table>
									</s:iterator></td>
								</s:if>
								<s:else>
									<td class="padding_td" valign="top" colspan="3"></td>
								</s:else>
							</tr>
							<tr align="center">
								<td colspan="3" colspan="3"><b>快递</b></td>
								<td colspan="3" colspan="3"><b>传真</b></td>
							</tr>
							<tr>
								<s:if test="court.ce!=null">
									<td class="padding_td" valign="top" colspan="3"><s:iterator
										value="court.ce">
										<table cellpadding="0" cellspacing="0" width="100%" border="0"
											class="step_table">
											<tr>
												<td align="right" width="40%" class="td">发送人：</td>
												<td class="td"><s:property value="ceName" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">发送时间：</td>
												<td class="td"><s:property value="ceDate" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">发送结果：</td>
												<td class="td"><s:property value="ceResult" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">对方接收人：</td>
												<td class="td"><s:property value="ceAccepter" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">接收时间：</td>
												<td class="td"><s:property value="ceTime" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">运单号码：</td>
												<td class="td"><s:property value="ceNumber" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">备注：</td>
												<td class="td"><s:property value="ceRemark" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">附件：</td>
												<td class="td"><a
													href="downFile.action?filename=/uploads/案源文件库/<s:property value="ceAttach" />"><s:property
													value="ceAttach" /></a></td>
											</tr>

											<tr>
												<td class="td" align="right"><b>可执行操作</b>：</td>
												<td class="td">
												<a href="selectConExpress.action?contactExpress.ceCasecodeself=${court.casecodeself }&caseId=${court.caseId}"
														target="_blank">查看全部快递信息</a>
											</td>
											</tr>
											<tr>
												<td class="td"></td>
												<td class="td"></td>
											</tr>
										</table>
									</s:iterator></td>
								</s:if>

								<s:else>
									<td class="padding_td" valign="top" colspan="3"></td>
								</s:else>
								<s:if test="court.cf!=null">
									<td class="padding_td" valign="top" colspan="3"><s:iterator
										value="court.cf">
										<table cellpadding="0" cellspacing="0" width="100%" border="0"
											class="step_table">

											<tr>
												<td align="right" width="25%" class="td">发送人：</td>
												<td class="td"><s:property value="cfName" /></td>
											</tr>
											<tr>
												<td align="right" width="40%" class="td">传真时间：</td>
												<td class="td"><s:property value="cfTime" /></td>
											</tr>

											<tr>
												<td align="right" width="25%" class="td">发送结果：</td>
												<td class="td"><s:property value="cfResult" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">对方接收人：</td>
												<td class="td"><s:property value="cfReceive" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">备注：</td>
												<td class="td"><s:property value="cfRemark" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">附件：</td>
												<td class="td"><a
													href="downFile.action?filename=/uploads/案源文件库/<s:property value="cfAttach" />"><s:property
													value="cfAttach" /></a></td>
											</tr>

											<tr>
												<td class="td" align="right"><b>可执行操作</b>：</td>
												<td class="td">
												<a href="selectConFax.action?contactFax.cfCasecodeself=${court.casecodeself }&caseId=${court.caseId}"
														target="_blank">查看全部传真信息</a>
											</td>
											</tr>
											<tr>
												<td class="td"></td>
												<td class="td"></td>
											</tr>
										</table>
									</s:iterator></td>
								</s:if>
								<s:else>
									<td class="padding_td" valign="top" colspan="3"></td>
								</s:else>
							</tr>
							<tr align="center">
								<td colspan="3"><b>登门拜访</b></td>
								<td colspan="3"><b>约谈跟进情况</b></td>
							</tr>
							<tr>
								<s:if test="court.csee!=null">
									<td class="padding_td" valign="top" colspan="3"><s:iterator
										value="court.csee">
										<table cellpadding="0" cellspacing="0" width="100%" border="0"
											class="step_table">
											<tr>
												<td align="right" width="40%" class="td">拜访时间：</td>
												<td class="td"><s:property value="csDate" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">我方工作人员姓名：</td>
												<td class="td"><s:property value="csName" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">对方工作人员姓名：</td>
												<td class="td"><s:property value="csOthername" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">拜访结果：</td>
												<td class="td"><s:property value="csResult" /></td>
											</tr>

											<tr>
												<td align="right" width="25%" class="td">备注：</td>
												<td class="td"><s:property value="csRemark" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">附件：</td>
												<td class="td"><a
													href="downFile.action?filename=/uploads/案源文件库/<s:property value="csAttach" />"><s:property
													value="csAttach" /> </a></td>
											</tr>
											<tr>
												<td class="td" align="right"><b>可执行操作</b>：</td>
												<td class="td" >
												<a href="selectConSee.action?contactSee.csCasecodeself=${court.casecodeself }&caseId=${court.caseId}"
														target="_blank">查看全部拜访信息</a>
											</td>
											</tr>
											<tr>
												<td class="td"></td>
												<td class="td"></td>
											</tr>
										</table>
									</s:iterator></td>
								</s:if>
								<s:else>
									<td class="padding_td" valign="top" colspan="3"></td>
								</s:else>
								<s:if test="court.ctalk!=null">
									<td class="padding_td" valign="top" colspan="3"><s:iterator
										value="court.ctalk">
										<table cellpadding="0" cellspacing="0" width="100%" border="0"
											class="step_table">
											<tr>
												<td align="right" width="40%" class="td">时间：</td>
												<td class="td"><s:property value="csDate" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">对方联系人：</td>
												<td class="td"><s:property value="csName" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">跟进人：</td>
												<td class="td"><s:property value="csOthername" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">跟进情况：</td>
												<td class="td"><s:property value="csResult" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">备注：</td>
												<td class="td"><s:property value="csRemark" /></td>
											</tr>
											<tr>
												<td align="right" width="25%" class="td">附件：</td>
												<td class="td"><a
													href="downFile.action?filename=/uploads/案源文件库/<s:property value="ctAttach" />"><s:property
													value="ctAttach" /> </a></td>
											</tr>
											<tr>
												<td class="td" align="right"><b>可执行操作</b>：</td>
												<td class="td">
												<a href="selectConTalk.action?contactTalk.ctCasecodeself=${court.casecodeself }&caseId=${court.caseId}"
														target="_blank">查看全部拜访信息</a>
											</td>
											</tr>
											<tr>
												<td class="td"></td>
												<td class="td"></td>
											</tr>
										</table>
									</s:iterator>
									</td>
								</s:if>
								<s:else>
									<td class="padding_td" valign="top" colspan="3"></td>
								</s:else>
							<tr align="center">
								<td colspan="3"><b>签约情况</b></td>
						</tr>
						<tr>
							<td class="padding_td" valign="top" colspan="3">
								<table cellpadding="0" cellspacing="0" width="100%" border="0"
									class="step_table">
									<tr>
										<td align="right" width="40%" class="td">签约人：</td>
										<td class="td">${court.csign.csMyName}</td>
									</tr>
									<tr>
										<td align="right" width="40%" class="td">签约时间：</td>
										<td class="td">${court.csign.csDate}</td>
									</tr>
									<tr>
										<td align="right" width="25%" class="td">签约比例：</td>
										<td class="td">${court.csign.csAle}</td>
									</tr>
									<tr>
										<td align="right" width="25%" class="td">对方联系人名称：</td>
										<td class="td">${court.csign.csName}</td>
									</tr>
									<tr>
										<td align="right" width="25%" class="td">电话：</td>
										<td class="td">${court.csign.csTel}</td>
									</tr>

									<tr>
										<td align="right" width="25%" class="td">签约号：</td>
										<td class="td">${court.csign.csNo}</td>
									</tr>
									<tr>
										<td align="right" width="25%" class="td">备注：</td>
										<td class="td">${court.csign.csRemark}</td>
									</tr>
									<tr>
										<td align="right" width="25%" class="td">附件：</td>
										<td class="td"><a
											href="downFile.action?filename=/uploads/案源文件库/${court.csign.csAttach}">${court.csign.csAttach}</a></td>
									</tr>

									<tr>
										<td class="td" align="right"><b>可执行操作</b>：</td>
										<td class="td"><a href="javascript:alert('业务不支持修改操作');">修改</a>&nbsp;&nbsp;
										<a href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a></td>
									</tr>
								</table>
								</td>
						</tr>
						</s:else>
						
					</s:if>
					<!--三层if结束  -->
					<!-- 三层else -->
					<s:else>

						<tr align="center">
							<td colspan="3"><b>电子邮件</b></td>
							<td colspan="3"><b>电话联系</b></td>
						</tr>
						<tr>
							<td colspan="3" width="35%"><a
								href="/lawyer/user/source/insertStep4_email.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>

							<td colspan="3" width="35%"><a
								href="/lawyer/user/source/insertStep4_tel.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
						</tr>
						<tr align="center">
							<td colspan="3" colspan="3"><b>快递</b></td>
							<td colspan="3" colspan="3"><b>传真</b></td>
						</tr>
						<tr>
							<td colspan="3" width="35%"><a
								href="/lawyer/user/source/insertStep4_ems.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
							<td colspan="3" width="35%"><a
								href="/lawyer/user/source/insertStep4_fax.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
						</tr>
						<tr align="center">
							<td colspan="3"><b>登门拜访</b></td>
							<td colspan="3"><b>约谈跟进情况</b></td>
						</tr>
						<tr>
							<td colspan="3" width="35%"><a
								href="/lawyer/user/source/insertStep4_see.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
							<td colspan="3" width="35%"><a
								href="/lawyer/user/source/insertStep4_talk.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
						</tr>
						<tr align="center">
							<td colspan="3"><b>签约情况</b></td>
						</tr>
						<tr>
							<td colspan="3" width="35%">不可操作</td>
						</tr>

					</s:else>
					<!-- 三层if结束 -->
				</s:if>
				<!-- 二层if结束 -->
				<!-- 二层else -->
				<s:else>
					<tr>
						<s:if test="court.ap!=null">
							<td colspan="2" width="35%">
							<table cellpadding="0" cellspacing="0" width="100%" border="0"
								class="step_table">
								<tr>
									<td align="right" width="45%" class="td">注册号：</td>
									<td class="td">${court.ap.appRenumber }</td>
								</tr>
								<%-- <tr>
									<td align="right" class="td">企业类型：</td>
									<td class="td">${court.ap.appType }</td>
								</tr> --%>
								<tr>
									<td align="right" class="td">主体名称：</td>
									<td class="td">${court.ap.appName }</td>
								</tr>
								<tr>
									<td align="right" class="td">法定代表人/负责人：</td>
									<td class="td">${court.ap.appRepname }</td>
								</tr>
								<%-- <tr>
									<td align="right" class="td">法定代表人/负责人身份证号：</td>
									<td class="td">${court.ap.appRepid }</td>
								</tr> --%>
								<tr>
									<td align="right" class="td">行政区划：</td>
									<td class="td">${court.ap.appDistrict }</td>
								</tr>
								<tr>
									<td align="right" class="td">成立日期：</td>
									<td class="td">${court.ap.appDate }</td>
								</tr>
								<tr>
									<td align="right" class="td">注册资本：</td>
									<td class="td">${court.ap.appFund }</td>
								</tr>
								<tr>
									<td align="right" class="td">经营期限自：</td>
									<td class="td">${court.ap.appDfrom }</td>
								</tr>
								<tr>
									<td align="right" class="td">经营期限至：</td>
									<td class="td">${court.ap.appDto }</td>
								</tr>
								<tr>
									<td align="right" class="td">登记机关：</td>
									<td class="td">${court.ap.appOrgan }</td>
								</tr>
								<tr>
									<td align="right" class="td">地址/住所：</td>
									<td class="td">${court.ap.appAddress }</td>
								</tr>
								<tr>
									<td align="right" class="td">企业状态：</td>
									<td class="td">${court.ap.appStatus }</td>
								</tr>
								<tr>
									<td align="right" class="td">年检年度：</td>
									<td class="td">${court.ap.appAnnual }</td>
								</tr>
								<tr>
									<td align="right" class="td">注销日期：</td>
									<td class="td">${court.ap.appCancellation }</td>
								</tr>
								<tr>
									<td align="right" class="td">吊销日期：</td>
									<td class="td">${court.ap.appRevoke }</td>
								</tr>
								<tr>
									<td align="right" class="td">吊销、注销日期/年检年度/备注：</td>
									<td class="td">${court.ap.appRemark }</td>
								</tr>
								<tr>
									<td align="right" class="td">市场标记：</td>
									<td class="td">
										<c:choose>
										    <c:when test="${court.ap.usedMark == 1}">是</c:when>
										    <c:when test="${court.ap.usedMark == 0}">否</c:when>
										    <c:when test="${court.ap.usedMark == 2}">其他：${court.ap.markRemark }</c:when>
										    <c:otherwise>
										    	还没有进行标记
										    </c:otherwise>
										</c:choose>
									</td>
								</tr>
								<tr>
									<td align="right" class="td">市场标记时间：</td>
									<td class="td">${court.ap.markTime }</td>
								</tr>
								<tr>
									<td class="td" align="right"><b>可执行操作</b>：</td>
									<td class="td"><a
										href="updapplierinfo?court.ap.appId=${court.ap.appId }&court.caseId=${court.caseId}">修改</a>&nbsp;&nbsp;
									<a href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a>
										&nbsp;&nbsp;&nbsp;
									<a href="selap.action?applierinfo.appCCasecodeself=${court.ap.appCCasecodeself}&caseId=${court.caseId}">查看全部数据</a>
									</td>
								</tr>
							</table>
							</td>
						</s:if>
						<s:else>
							<td colspan="2" width="35%"><a
								href="/lawyer/user/source/insertStep3.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
						</s:else>


						<s:if test="court.an!=null">
							<td colspan="2" width="35%">
							<table cellpadding="0" cellspacing="0" width="100%" border="0"
								class="step_table">
								<tr>
									<td align="right" width="30%" class="td">主体名称：</td>
									<td class="td">${court.an.anName }</td>
								</tr>
								<tr>
									<td align="right" width="20%" class="td">地址/住所：</td>
									<td class="td">${court.an.anAddress }</td>
								</tr>
								<tr>
									<td align="right" width="20%" class="td">联系人：</td>
									<td class="td">${court.an.anConname }</td>
								</tr>
								<tr>
									<td align="right" width="20%" class="td">电话：</td>
									<td class="td">${court.an.anPhone }</td>
								</tr>
								<tr>
									<td align="right" width="20%" class="td">传真：</td>
									<td class="td">${court.an.anFax }</td>
								</tr>
								<tr>
									<td align="right" width="20%" class="td">邮件：</td>
									<td class="td">${court.an.anMail }</td>
								</tr>
								<tr>
									<td class="td" align="right"><b>可执行操作</b>：</td>
									<td class="td">
									<a href="javascript:confirm('确实要修改吗?'){alert('业务不支持修改操作');};">修改</a>&nbsp;&nbsp;
									<a href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a></td>
								</tr>
							</table>
							<a
								href="findAllAppNets.action?applierinfoNetwork.anCasecodeself=${court.casecodeself }"
								target="_blank">查看全部数据</a></td>
						</s:if>
						<s:else>
							<td colspan="2" width="35%"><a
								href="/lawyer/user/source/insertStep3_net.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
						</s:else>

						<s:if test="court.ao!=null">
							<td colspan="2" width="35%">
							<table cellpadding="0" cellspacing="0" width="100%" border="0"
								class="step_table">
								<tr>
									<td align="right" width="40%" class="td">申请人名称：</td>
									<td class="td">${court.ao.aoName }</td>
								</tr>
								<tr>
									<td align="right" width="25%" class="td">申请人地址：</td>
									<td class="td">${court.ao.aoAddress }</td>
								</tr>

								<tr>
									<td align="right" width="25%" class="td">联系人1姓名：</td>
									<td class="td">${court.ao.aoName1 }</td>
								</tr>
								<tr>
									<td align="right" width="25%" class="td">联系人1电话：</td>
									<td class="td">${court.ao.aoPhone1 }</td>
								</tr>
								<tr>
									<td align="right" width="25%" class="td">联系人1传真：</td>
									<td class="td">${court.ao.aoFax1 }</td>
								</tr>
								<tr>
									<td align="right" width="25%" class="td">联系人1邮件：</td>
									<td class="td">${court.ao.aoMail1 }</td>
								</tr>
								<tr>
									<td align="right" width="25%" class="td">联系人2姓名：</td>
									<td class="td">${court.ao.aoName2 }</td>
								</tr>
								<tr>
									<td align="right" width="25%" class="td">联系人2电话：</td>
									<td class="td">${court.ao.aoPhone2 }</td>
								</tr>
								<tr>
									<td align="right" width="25%" class="td">联系人2传真：</td>
									<td class="td">${court.ao.aoFax2 }</td>
								</tr>
								<tr>
									<td align="right" width="25%" class="td">联系人2邮件：</td>
									<td class="td">${court.ao.aoMail2 }</td>
								</tr>
								<tr>
								<td align="right" width="25%" class="td">备注：</td>
								<td class="td">${court.ao.aoRemark }</td>
							</tr>
								<tr>
									<td class="td" align="right"><b>可执行操作</b>：</td>
									<td class="td"><a href="updapplierinfoonself?court.ao.aoCasecodeself=${court.ao.aoCasecodeself }&court.caseId=${court.caseId}">修改</a>&nbsp;&nbsp;
									<a href="javascript:confirm('确实要删除吗?'){alert('业务不支持删除操作');};">删除</a></td>
								</tr>
							</table>
							</td>
						</s:if>
						<s:else>
							<td colspan="2" width="35%"><a
								href="/lawyer/user/source/insertStep3_self.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
						</s:else>
					</tr>
					<tr class="title">
						<td colspan="6">&nbsp;&nbsp;<img
							src="/lawyer/images/flag2_16x16.gif" />&nbsp;与申请执行人联系信息</td>
					</tr>

					<tr align="center">
						<td colspan="3"><b>电子邮件</b></td>
						<td colspan="3"><b>电话联系</b></td>
					</tr>
					<tr>
						<td class="padding_td" valign="top" colspan="3">不可操作</td>
						<td class="padding_td" valign="top" colspan="3">不可操作</td>
					</tr>
					<tr align="center">
						<td colspan="3" colspan="3"><b>快递</b></td>
						<td colspan="3" colspan="3"><b>传真</b></td>
					</tr>
					<tr>
						<td class="padding_td" valign="top" colspan="3">不可操作</td>
						<td class="padding_td" valign="top" colspan="3">不可操作</td>
					</tr>

					<tr align="center">
						<td colspan="3"><b>登门拜访</b></td>
						<td colspan="3"><b>签约情况</b></td>
					</tr>
					<tr>
						<td class="padding_td" valign="top" colspan="3">不可操作</td>
						<td class="padding_td" valign="top" colspan="3">不可操作</td>
					</tr>

				</s:else>
			</s:if>
			<!--一层if结束 -->

			<!-- 三层else -->
			<s:else>
				<tr class="title">
					<td colspan="6"><a
						href="/lawyer/user/source/insertStep2.jsp?casecodeself=${court.casecodeself}&caseId=${court.caseId}">点击添加</a></td>
				</tr>
				<tr class="title">
					<td colspan="6">&nbsp;&nbsp;<img
						src="/lawyer/images/flag2_16x16.gif" />&nbsp;申请执行人信息</td>
				</tr>
				<tr align="center">
					<td colspan="2" width="35%"><b>企业信息</b></td>

					<td colspan="2" width="35%"><b>网络信息</b></td>

					<td colspan="2"><b>自有信息</b></td>
				</tr>

				<tr align="center">
					<td colspan="2" width="35%">不可操作</td>

					<td colspan="2" width="35%">不可操作</td>

					<td colspan="2">不可操作</td>
				</tr>

				<tr class="title">
					<td colspan="6">&nbsp;&nbsp;<img
						src="/lawyer/images/flag2_16x16.gif" />&nbsp;与申请执行人联系信息</td>
				</tr>

				<tr align="center">
					<td colspan="3"><b>电子邮件</b></td>
					<td colspan="3"><b>电话联系</b></td>
				</tr>
				<tr>
					<td class="padding_td" valign="top" colspan="3">不可操作</td>
					<td class="padding_td" valign="top" colspan="3">不可操作</td>
				</tr>
				<tr align="center">
					<td colspan="3" colspan="3"><b>快递</b></td>
					<td colspan="3" colspan="3"><b>传真</b></td>
				</tr>
				<tr>
					<td class="padding_td" valign="top" colspan="3">不可操作</td>
					<td class="padding_td" valign="top" colspan="3">不可操作</td>
				</tr>
				<tr align="center">
					<td colspan="3"><b>登门拜访</b></td>
					<td colspan="3"><b>签约情况</b></td>
				</tr>
				<tr>
					<td class="padding_td" valign="top" colspan="3">不可操作</td>
					<td class="padding_td" valign="top" colspan="3">不可操作</td>
				</tr>
			</s:else>
		</table>
		</td>
	</tr>
</table>
</body>
</html>