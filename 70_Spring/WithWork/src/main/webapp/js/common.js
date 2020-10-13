function set101(frm){
	var m_num = $(".chatM_num").val();
	var set = setChatMember2(m_num);
	if (set != null) {
		frm.action="getChatMember2_In.do?room_id=" + set;
		frm.submit();
	} else {
	    frm.action="insert11Chat.do";
	    frm.submit();
	}
}

function set202(frm){
	var room_id = $(".chatRoom_id").val();
		frm.action="getChatMember2_In.do?room_id=" + room_id;
		frm.submit();
}

//------------------------ ajax ------------------------------	

function insertNotice() {
	
	var message = $(".textarea").val();
	
	if(message == ""){
		alert("메세지를 입력하세요");
		return;
	}
	
	$.ajax("insertNotice.do", {
		type : "post",
		dataType : "json",
		data : "message=" + message,
		success : function(data) {
			
			console.log("data : " + data);
			$(".textarea").val("");
		},
		error : function(){
			
		}
	});
}

function updateNotice() {
	
	var content = $(".conText").val();
	
	$.ajax("updateNotice.do", {
		type : "post",
		dataType : "json",
		data : "content=" + content,
		success : function(data) {
			
		},
		error : function(){
			
		}
	});
}

/* function getConditionMsg() {
	$.ajax("getChatMember.do", {
		type : "post",
		dataType : "json",
		success : function(data){
			var a = "";

				a += "<li>";
				a += "<img src='img/profile.png' width='110px'>";
				a += "</li>";
				a += "<li>" + this.g_name + "</li>";
				a += "<li>";
				a += "<a href='#' class='conMsg'>" + this.content + "</a>";
				a += "</li>";
				
			$(".msgPopupD").html(a);
		},
		error : function(){
			
		}		
	});
} */

function getNoticeList() {
	$.ajax("getNoticeList.do", {
		type : "post",
		dataType : "json",
		success : function(data){
			var dl = "";
				dl += "<p>"
				dl += "<span>2020년 10월 15일 목요일</span>"
				dl += "</p>"
			$.each(data, function(){
				dl += "<dl>";
				dl += "<dt>" + this.g_name + " " + this.role + "</dt>";
				dl += "<dd class='chatBoxCont1'>" + this.message + "</dd>";
				dl += "<dd class='chatTime'>" + this.time + "</dd>";
				dl += "</dl>";
			})
			
			$(".chatBox").html(dl);
		},
		error : function(){

		}
	});
}

function getNoticeList_Search() {
	
	var searchMember = $(".searchBoxx").val();
	
	$.ajax("getNoticeList_Search.do", {
		type : "post",
		dataType : "json",
		data : "searchMember=" + searchMember,
		success : function(data){
			if(searchMember != ""){
				var a = "";
					a += "<div class='projectSearch searchMemberChat'>"
		            a += "<input type='text' placeholder='멤버를 검색하세요.' name='searchMember' class='searchBoxx'>"
		            a += "<input type='button' value='' class='searchBtnn'>"
			        a += "</div>"
				$.each(data, function(){
					a += "<a href='#' class='profileImg'>";
					a += "<input type='hidden' name='m_num' value='" + this.m_num + "'>";
					a += "<dl>";
					a += "<dt class='memPopup'>" + this.g_name + " " + this.role + "</dt>";
					a += "<dd class='onlineId'>" + this.content + "</dd>";
					a += "</dl>";
					a += "</a>";
				})
			}else{
				getChatMember();
			}
			
			$(".msgPopupA").html(a);
		},
		error : function(){
			
		}
	});	
}

function getNoticeList_Search2() {
	
	var searchMember = $(".searchBoxx2").val();
	
	$.ajax("getNoticeList_Search.do", {
		type : "post",
		dataType : "json",
		data : "searchMember=" + searchMember,
		success : function(data){
			if(searchMember != ""){
				var a = "";
					a += "<div class='projectSearch searchMemberChat'>"
		            a += "<input type='text' placeholder='대화방을 검색하세요.' name='searchMember' class='searchBoxx2'>"
		            a += "<input type='button' value='' class='searchBtnn2'>"
			        a += "</div>"
				$.each(data, function(){
					a += "<a href='#' class='profileImg2'>";
					a += "<input type='hidden' name='room_id' value='" + this.room_id + "'>";
					a += "<dl>";
					a += "<dt class='memPopup2'>이민형 부장, " + this.g_name + " " + this.role + "</dt>";
					a += "</dl>";
					a += "</a>";
				})
			}else{
				getChatMember2();
			}
			
			$(".msgPopupB").html(a);
		},
		error : function(){
			
		}
	});	
}

function insertMessenger(room_id) {
	
	var message = $(".textarea").val();
	
	if(message == ""){
		alert("메세지를 입력하세요");
		return;
	}
	
	$.ajax("insertMessenger.do", {
		type : "post",
		dataType : "json",
		data : "message=" + message + "&room_id=" + room_id,
		success : function(data) {
			
			console.log("data : " + data);
			$(".textarea").val("");
		},
		error : function(){
			
		}
	});
}

function getMessengerList(room_id) {
	$.ajax("getMessengerList.do", {
		type : "post",
		dataType : "json",
		data : { "room_id":  room_id },
		success : function(data){
			var dl = "";
				dl += "<p>"
				dl += "<span>2020년 10월 15일 목요일</span>"
				dl += "</p>"
			$.each(data, function(){
				dl += "<dl>";
				dl += "<dt>" + this.g_name + " " + this.role + "</dt>";
				dl += "<dd class='chatBoxCont1'>" + this.message + "</dd>";
				dl += "<dd class='chatTime'>" + this.time + "</dd>";
				dl += "</dl>";
			})
			
			$(".chatBox").html(dl);
		},
		error : function(){

		}
	});
}

function getChatMember() {
	$.ajax("getChatMember.do", {
		type : "post",
		dataType : "json",
		success : function(data){
			var a = "";
				a += "<div class='projectSearch searchMemberChat'>";
	            a += "<input type='text' placeholder='멤버를 검색하세요.' name=searchMember class='searchBoxx'>"
	            a += "<input type='button' value='' class='searchBtnn'>"
		        a += "</div>"
			$.each(data, function(){
				a += "<a href='#' class='profileImg'>";
				a += "<input type='hidden' name='m_num' value='" + this.m_num + "'>";
				a += "<dl>";
				a += "<dt class='memPopup'>" + this.g_name + " " + this.role + "</dt>";
				a += "<dd class='onlineId'>" + this.content + "</dd>";
				a += "</dl>";
				a += "</a>";
			})
			
			$(".msgPopupA").html(a);
		},
		error : function(){
			
		}		
	});
}

function getChatMember2() {
	$.ajax("getChatMember2.do", {
		type : "post",
		dataType : "json",
		success : function(data){
			var originTxt = "";
				originTxt += "<div class='projectSearch searchMemberChat'>"
	            originTxt += "<input type='text' placeholder='대화방을 검색하세요.' name=searchMember class='searchBoxx2'>"
	            originTxt += "<input type='button' value='' class='searchBtnn2'>"
		        originTxt += "</div>"
			$.each(data, function(){
				originTxt += "<a href='#' class='profileImg2'>";
				originTxt += "<input type='hidden' name='room_id' value='" + this.room_id + "'>";
				originTxt += "<dl>";
				originTxt += "<dt class='memPopup2'>이민형 부장, " + this.g_name + " " + this.role + "</dt>";
				originTxt += "</dl>";
				originTxt += "</a>";
				
			})
			
			$(".msgPopupB").html(originTxt);
		},
		error : function(){

		}
	});
}

function setChatMember2(m_num) {
		var set;
	$.ajax("setChatMember2.do", {
		type : "post",
		dataType : "json",
		async: false,
		success : function(data){
			$.each(data, function(){
				if (m_num == this.m_num) {
					set = this.room_id;
				} 
			})
		},
		error : function(request,status,error){
			    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	
	return set;
}
	

$().ready(function(){

    // 팝업 닫기
    $(".pop dt a, .darkBack").click(function(){
        $(".pop").removeClass("show");
        $(".darkBack").hide();
        $(".conditionMsg").hide();
    });

    // 팝업닫기
    $(".popupOK, .darkBack").click(function(){
        $(".popup").hide();
        $(".popupM").removeClass("show");
        $(".popupP").hide();
        $(".darkBack").hide();
    });

    /********** 멤버팝업(은진) **********/

    // 아이콘 클릭 -> 팝업창띄우기 
    $(".members").click(function(){
        $(".pop").addClass("show");
        $(".darkBack").show();
        $(".memberCont .tab_content > div").hide();
        $(".memberCont .tab_content > div").eq(0).show();
        $(".memberCont .tabs li").removeClass("active");
        $(".memberCont .tabs li").eq(0).addClass("active"); 
    });
    
    // 첫 팝업창에서 전체보기 default
    $(".memberCont .tabs li:first").click(function(){
        $(this).addClass("active").show();
        $(".memberCont .allTap").show();
    });
    
    // 탭메뉴 선택
    $(".memberCont .tabs li").click(function(){
        var idx = $(this).index();
        $(".memberCont .tab_content > div").hide()
        $(".memberCont .tab_content > div").eq(idx).show();
        $(".memberCont .tabs li").removeClass("active");
        $(this).addClass("active");
        $(".memberCont .sel option").prop("selected", false);
        
    });

    // 전체보기에서 토글
    $(".memberTeam").each(function(){
        var team = $(this).find("li:first-child");
        var member = $(this).find("li:nth-child(2)");
        team.click(function(){
            member.toggle();
            $(this).toggleClass("active");
        });
    });    

    /********** 채팅팝업(민형) **********/

    // 팝업열기
    $(".chatBtn a").click(function(){
        $(".msgPopup").toggleClass("show");
        $(".msgPopupAll > div").hide();
        $(".msgPopupAll > div").eq(0).show();
        $(".msgPopupC li").removeClass("active");
        $(".msgPopupC li").eq(0).addClass("active");
        $(".darkBack").show();
    });

    //채팅 멤버/대화방 탭
    $(".msgPopupC li").click(function(){
        var idx = $(this).index(); // --> 0
        $(".msgPopupC li").removeClass("active");
        $(this).addClass("active");
        $(".msgPopupAll > div").hide();
        $(".msgPopupAll > div").eq(idx).show();
    });
    
    //프로필 창 열기
    $(".profileImg").click(function(){
    	$(".chatProfile2").hide();
        $(".chatProfile").show();
        $(".darkBack").show();
    });
    
    $(".profileImg2").click(function(){
    	$(".chatProfile").hide();
        $(".chatProfile2").show();
        $(".darkBack").show();
    });
    
    //프로필 창 닫기
    $(".popupOK1").click(function(){
        $(".chatProfile").hide();
        $(".chatProfile2").hide();
        $(".msgPopup").show();
    });
    
    //상태메세지 수정 창
    $(".conMsg").click(function(){
    	$(".conditionMsg").show();
    	$(".darkBack").show();
    });
    
    $(".set44").click(function(){
    	$(".conditionMsg").hide();
    });
    
    //-------------- notice.jsp -------------------------
    
    $(".sendBtn").click(function(){
		insertNotice();
		getNoticeList();
	});
	
	$(".textarea").keypress(function(event){
	     if (event.which == 13) {
	         $(".sendBtn").click();
	         return false;
	     }
	});
	
	
		
	/* var scroll = document.getElementsByClassName("chatBox");
	scroll.scrollTop = scroll.scrollHeight; */

	/* var chatBoxId = document.getElementById("chatBoxId");
	chatBoxId.scrollTop = chatBoxId.scrollHeight; */

	/* $(".chatBox").scrollTop(
		$(".chatBox")[0].scrollHeight
	); */
	
	$(".chatBtn").click(function(){
		getChatMember();
		getChatMember2();
	});
	
	$(document).on("click", ".profileImg", function (e) {
		/* getConditionMsg(); */
		
		var name = $(this).find(".memPopup").text();
		$(".msgPopupD li").eq(1).text(name);

		/* var condition = $(this).find(".onlineId").text();
		$(".msgPopupD li").eq(2).text(condition); */
					
		var chatM_num = $(this).find("input").val();
		$(".chatM_num").val(chatM_num);
		console.log(".chatM_num : " + chatM_num);
		
		$(".chatProfile2").hide();
		$(".chatProfile").show();
        $(".darkBack").show();
	});
	
	$(document).on("click", ".profileImg2", function (e) {
	
		var name = $(this).find(".memPopup2").text();
		$(".msgPopupD2 li").eq(1).text(name);
		
		var chatRoom_id = $(this).find("input").val();
		$(".chatRoom_id").val(chatRoom_id);
		console.log(".chatRoom_id : " + chatRoom_id);
		
		$(".chatProfile").hide();
		$(".chatProfile2").show();
        $(".darkBack").show();
	});
	
	$(".searchBtnn").click(function(){
		getNoticeList_Search();
	});
	
	$(".searchBoxx").keypress(function(event){
	     if (event.which == 13) {
	         $(".searchBtnn").click();
	         return false;
	     }
	});
	
	$(".set99").click(function(){
		/* updateNotice(); */
		$(".conditionMsg").hide();
	});
	

	//------------------ messenger.jsp -------------------------
	
	var room_id = $(".room_id").val();
	/*getMessengerList(room_id);*/
	
	$(".sendBtn2").click(function(){
		insertMessenger(room_id);
		getMessengerList(room_id);
	});
	
	$(".textarea2").keypress(function(event){
	     if (event.which == 13) {
	         $(".sendBtn2").click();
	         return false;
	     }
	});
	
	$(".searchBtnn2").click(function(){
		getNoticeList_Search2();
	});
	
	$(".searchBoxx2").keypress(function(event){
	     if (event.which == 13) {
	         $(".searchBtnn2").click();
	         return false;
	     }
	});
})


