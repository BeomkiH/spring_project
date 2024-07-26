
$(function(){
	
	 $("#btn4").click(function(){
        var basket = [
            {"seq":"1", "product":"냉장고", "price":"195000"},
            {"seq":"2", "product":"세탁기", "price":"287000"},
            {"seq":"10", "product":"에어프라이어", "price":"97000"}
        ];
        
        $.ajax({
            url: "./ajaxok4.do",
            type: "POST",
            cache: false,
            dataType: "json", // 서버에서 JSON 형식으로 응답을 받을 예정이므로 "json"으로 설정
            contentType: "application/json",
            data: JSON.stringify(basket),
            success: function(result){
                console.log(result);
            },
            error: function(){
                console.log("Error::::");
            }
        });
    });
});

$("#btn3").click(function(){
	
	var $arr = [
            ["10%", "20%", "30%"],
            ["30", "40", "50"]
        ];
        
	$.ajax({
		url : "./ajaxok3.do",
		type : "POST",
		cache : false,
		dataType : "TEXT",
		contentType : "application/json",
		data : JSON.stringify($arr),
		success : function($result){
			console.log($result);
		},
		error : function(){
			console.log("Error::::");
		}
	});
		
	});
	





	
$("#btn2").click(function(){
	
	var $data = new Array();
	$data[0] = "홍길동";
	$data[1] = "강감찬";
	$data[2] = "이순신";
	
	$.ajax({
		url : "./ajaxok2.do",
		type : "POST",
		cache : false,
		dataType : "JSON",
		contentType : "application/json",
		data : JSON.stringify({
			"all_data" : $data
		}),
		success : function($result){
			console.log($result);
		},
		error : function(){
			console.log("Error::::");
		}
	});
});
	

$("#btn").click(function(){
	
	var $data =new Array();
	$data[0] = "20";
	$data[1] = "30";
	$data[2] = "40";
	//console.log($data.join(","));
	
	$.ajax({
		url : "./ajaxok.do",
		cache : false,
		dataType : "json",
		contentType : "application/json",
		type : "GET",
		data : {
			"alldata" : $data.join(",")
		},
		success : function($result){
			console.log($result)
		}	,
		error : function(){
			console.log("Error::::::::")
		}
	});
});

