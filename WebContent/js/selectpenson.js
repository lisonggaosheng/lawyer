$(function(){
	$.ajax({
		type:"POST",
		cache:true,
		url:"/lawyer/selectPensons.action",
		success:function(msg){
			var jsonarr = eval(msg);
			$.each(jsonarr, function(n,obj) {
				$("#penson").append("<option id='lawyeruser' value='"+obj.mobile+"'>"+obj.rolename+"</option>");
		    });
		}
		
	});
});