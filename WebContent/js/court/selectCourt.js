function yeshu(cp){
		document.getElementById("cp").value=cp;
		document.getElementById("fenye").submit();
	}
	function fenyebycourt(courtcode){
		document.getElementById("courtcode").value=courtcode;
		document.getElementById("fenye").submit();
	}
	function loadCalendar(field)
	{
		if(navigator.userAgent.indexOf("Chrome") >0 ){
			var winOption = "height=250px,width=320px,status:no;help:no;scrolling=no;scrollbars=no";
    		window.open("/lawyer/user/source/calender.jsp","", winOption);
		}else{
			var rtn=window.showModalDialog("/lawyer/user/source/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
			if(rtn!=null){
				field.value=rtn;
			}
		}
		return;
	}
	
	function resultopt(){
		var executestep = document.getElementById("step").value;
	//	var status = document.getElementById("status").value;
		
		if(executestep==""){
			alert("请选择案源当前执行步骤!");
			return;
		}
		/* if(status==""){
			alert("请选择企业状态!");
			return;
		} */

		if(executestep=="2"||executestep=="4"||executestep=="5"){
			alert("暂无操作!");
			return;
		}
		var mes = "";
		var strTimeEvection = document.getElementById("strTimeEvection").value;
		var endTimeEvection = document.getElementById("endTimeEvection").value;
		if(strTimeEvection=="" && endTimeEvection==""){
				mes="所有时间段,";
		}else if(strTimeEvection!="" && endTimeEvection==""){
				mes=strTimeEvection+"以后,";
		}else if(endTimeEvection!="" && strTimeEvection==""){
				mes=endTimeEvection+"以前,";
		}else{
				mes="时间段"+strTimeEvection+"至"+endTimeEvection+"期间,";
		}
		mes+="当前操作为 \"";
		if(executestep=="1"){
			mes+="被执行人执行信息";
		}else if(executestep=="2"){
			mes+="被执行人企业信息";
		}else if(executestep=="3"){
			mes+="申请执行人企业信息";
		}else if(executestep=="4"){
			mes+="申请执行人网络信息";
		}else if(executestep=="5"){
			mes+="申请执行人自有信息";
		}
		mes+="\"的";
		var courtcode = document.getElementById("courtcode").value;//法院编号
		if(courtcode==""){
			mes+="所有案源,";
		}else{
			mes+="编号为"+courtcode+"法院下所有案源,";
		}
		mes+="将被系统生成文件,是否继续?";
		//入库时间
		var instrTimeEvection=document.getElementById("instrTimeEvection").value;
		var inendTimeEvection = document.getElementById("inendTimeEvection").value;
		//执行标的
		var minMoney = document.getElementById("minMoney").value;
		var maxMoney = document.getElementById("maxMoney").value;
		
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/createData.action",
				data:"court.courtcode="+courtcode+"&court.executestep="+executestep+"&startDate="+strTimeEvection+"&endDate="+endTimeEvection+"&instartDate="+instrTimeEvection+"&inendDate="+inendTimeEvection+"&minMoney="+minMoney+"&maxMoney="+maxMoney,
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	
	//改变案源信息的执行步骤
	function changeStep(){
		var executestep = document.getElementById("step").value;
		var courtStep = document.getElementById("courtStep").value;
		if(executestep==""){
			alert("请选择案源当前执行步骤!");
			return;
		}
		if(courtStep==""){
			alert("填写要改变的执行步骤!");
			return;
		}
		var mes = "";
		var courtcode = document.getElementById("courtcode").value;//法院编号
		var strTimeEvection = document.getElementById("strTimeEvection").value;
		var endTimeEvection = document.getElementById("endTimeEvection").value;
		if(strTimeEvection=="" && endTimeEvection==""){
				mes="所有时间段,";
		}else if(strTimeEvection!="" && endTimeEvection==""){
				mes=strTimeEvection+"以后,";
		}else if(endTimeEvection!="" && strTimeEvection==""){
				mes=endTimeEvection+"以前,";
		}else{
				mes="时间段"+strTimeEvection+"至"+endTimeEvection+"期间,";
		}	
		mes="将改变所查询出数据的执行步骤，是否继续?";
		//入库时间
		var instrTimeEvection=document.getElementById("instrTimeEvection").value;
		var inendTimeEvection = document.getElementById("inendTimeEvection").value;
		//执行标的
		var minMoney = document.getElementById("minMoney").value;
		var maxMoney = document.getElementById("maxMoney").value;
		
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/changeCourtStep.action",
				data:"court.courtcode="+courtcode+"&court.executestep="+executestep+"&startDate="+strTimeEvection+"&endDate="+endTimeEvection+"&instartDate="+instrTimeEvection+"&inendDate="+inendTimeEvection+"&minMoney="+minMoney+"&maxMoney="+maxMoney+"&courtStep="+courtStep,
				success:function(msg){
					alert(msg);
				}
			});
		}
	}

	//开启第一个软件
	function Run() 
	{ 
		alert("抱歉，请手动打开你所使用的软件");
	}  
	//被执行人执行信息批处理
	function insertCourts(){
		var mes = "确定进行被执行人执行信息批量操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertCourts.action",
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	//被执行人公告信息
	function insertNoteCourts(){
		var mes = "确定进行被执行人（债务人）公告信息导入操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertNoteCourts.action",
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	//被执行人企业信息批处理
	function insertEbs(){
		var mes = "确定进行被执行人企业信息批量操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertExecutes.action",
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	
	//申请执行人企业信息
	function insertApplierinfos(){
		var mes = "确定进行申请执行人企业信息批量操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertApplierinfos.action",
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	//申请执行人企业网络信息
	function insertApplierinfoNets(){
		var mes = "确定进行申请执行人企业网络信息批量操作？ ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertAppNets.action",
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	function tiao(){
		var cp = document.getElementById("tiaoye").value;
		if(isNaN(cp)){
			alert("请输入正确数字！");
			return;
		}
		document.getElementById("cp").value=cp;
		document.getElementById("fenye").submit();
	}