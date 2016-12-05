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
		$("#competentCourt").val(treeNode.getParentNode().name+treeNode.name);
		hidediv();
	}

	function createTree() {
		var zNodes = dataMaker(ruler.count);
		showNodeCount = 0;
		$("#treeDemo").empty();
		setting.check.enable = $("#showChk").attr("checked");
		var time1 = new Date();
		$ztree.fn.zTree.init($("#treeDemo"), setting, zNodes);
		var time2 = new Date();

	}