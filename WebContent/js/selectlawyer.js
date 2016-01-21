$(function(){
	$.ajax({
		type:"POST",
		cache:true,
		url:"/lawyer/selectLawyers.action",
		success:function(msg){
			var jsonarr = eval(msg);
			$.each(jsonarr, function(n,obj) {
				$("#lawyerinfo").append("<option id='lawyeruser' value='"+obj.mobile+"'>"+obj.rolename+"</option>");
				$("#assistinglawyer").append("<option id='lawyeruser' value='"+obj.mobile+"'>"+obj.rolename+"</option>");
		    });
		}
		
	});
});