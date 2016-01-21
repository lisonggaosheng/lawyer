<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查询普通案源</title>
<link rel="stylesheet" href="/lawyer/css/public.css" />
<link rel="stylesheet" href="/lawyer/css/demo.css" type="text/css">
<link rel="stylesheet" href="/lawyer/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="/lawyer/js/ztree/jquery-1.4.4.min.js"></script>
<script type="text/javascript"
	src="/lawyer/js/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="/lawyer/js/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript"
	src="/lawyer/js/ztree/jquery.ztree.exedit-3.5.js"></script>
<style type="text/css">
#dtree {
	position: absolute;
	top: 10px;
}
</style>
<SCRIPT type="text/javascript">
	var setting = {
		check : {
			enable : true
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			onNodeCreated : onNodeCreated,
			onClick : onClick
		}
	};

	var dataMaker = function(count) {
		var nodes = [], pId = -1, min = 10, max = 90, level = 0, curLevel = [], prevLevel = [], levelCount, i = 0, j, k, l, m;

		$.ajax({
			type : "POST",
			cache : true,
			async : false,
			url : "/lawyer/lawyerCourt/findAllLawyerCourt.action",
			success : function(msg) {
				var courtlist = eval(msg);
				for ( var i = 0; i < courtlist.length; i++) {
					var court = courtlist[i];
					var pid = court.lawyercourt_pid;
					if (pid == "0") {
						pid = -1;
					}
					var n = {
						id : court.lawyercourt_id,
						pId : pid,
						name : court.lawyercourt_court_name,
						number : court.lawyercourt_number
					};
					nodes.push(n);
				}
			}
		});

		return nodes;
	}

	var ruler = {
		doc : null,
		ruler : null,
		cursor : null,
		minCount : 5000,
		count : 10000,
		stepCount : 500,
		minWidth : 30,
		maxWidth : 215,
		init : function() {
			ruler.doc = $(document);
			ruler.ruler = $("#ruler");
			ruler.cursor = $("#cursor");
			if (ruler.ruler) {
				ruler.ruler.bind("mousedown", ruler.onMouseDown);

			}
		},
		onMouseDown : function(e) {
			ruler.drawRuler(e, true);
			ruler.doc.bind("mousemove", ruler.onMouseMove);
			ruler.doc.bind("mouseup", ruler.onMouseUp);
			ruler.doc.bind("selectstart", ruler.onSelect);
			$("body").css("cursor", "pointer");
		},
		onMouseMove : function(e) {
			ruler.drawRuler(e);
			return false;
		},
		onMouseUp : function(e) {
			$("body").css("cursor", "auto");
			ruler.doc.unbind("mousemove", ruler.onMouseMove);
			ruler.doc.unbind("mouseup", ruler.onMouseUp);
			ruler.doc.unbind("selectstart", ruler.onSelect);
			ruler.drawRuler(e);
		},
		onSelect : function(e) {
			return false;
		},
		getCount : function(end) {
			var start = ruler.ruler.offset().left + 1;
			var c = Math.max((end - start), ruler.minWidth);
			c = Math.min(c, ruler.maxWidth);
			return {
				width : c,
				count : (c - ruler.minWidth) * ruler.stepCount + ruler.minCount
			};
		},
		drawRuler : function(e, animate) {
			var c = ruler.getCount(e.clientX);
			ruler.cursor.stop();
			if ($.browser.msie || !animate) {
				ruler.cursor.css({
					width : c.width
				});
			} else {
				ruler.cursor.animate({
					width : c.width
				}, {
					duration : "fast",
					easing : "swing",
					complete : null
				});
			}
			ruler.count = c.count;
			ruler.cursor.text(c.count);
		}
	}
	var showNodeCount = 0;
	function onNodeCreated(event, treeId, treeNode) {
		showNodeCount++;
	}

	function onClick(event, treeId, treeNode, clickFlag) {
		$("#court_number").val(treeNode.number);
		location.href = "findCourts.action?court.courtcode="+treeNode.number;
		/* $.ajax({
			   type: "POST",
			   url: "findCourts.action?court.courtcode=" + treeNode.number,
			   success: function(msg){
				   debugger;
			     	alert(msg);
			   }
			}); */
	}

	function createTree() {
		var zNodes = dataMaker(ruler.count);
		showNodeCount = 0;
		$("#treeDemo").empty();
		setting.check.enable = $("#showChk").attr("checked");
		var time1 = new Date();
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		var time2 = new Date();

	}

	$(document).ready(function() {
		ruler.init("ruler");
		createTree();

	});
</SCRIPT>
</head>
<body>

	<table cellspacing="0" cellpadding="0" border="0" width="100%"
		height="100%" class="content_table">
		<tr>
			<td width="200" valign="top">
				<!--树形菜单_start-->
				<div id="dtree">
					<ul id="treeDemo" class="ztree"></ul>
					<form id="courtForm" action="findCourts.action">
						<input id="court_number" type="hidden" value="" />
					</form>
				</div> <!--树形菜单_end-->
			</td>
			
			<td width="950" height="900" valign="top">
			<iframe name="allcourt"  src="/lawyer/user/source/court/result.jsp" frameborder="0" scrolling="no" width="900" height="900"></iframe>
		</td>
		</tr>
	</table>

</body>
</html>
