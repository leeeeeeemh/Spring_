<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="include/head.jsp" %>
</head>
<script>
	$(function(){
		
		var room_id = $(".room_id").val();
		getMessengerList(room_id);
		
		$(".sendBtn").click(function(){
			insertMessenger(room_id);
			getMessengerList(room_id);
		});
		
		$(".textarea").keypress(function(event){
		     if (event.which == 13) {
		         $(".sendBtn").click();
		         return false;
		     }
		});
		
		setInterval(getMessengerList(room_id), 1000); // 1초 간격
		
		$(".chatBtn").click(function(){
			getChatMember();
			getChatMember2();
		});
		
		$(document).on("click", ".profileImg", function (e) {
			var name = $(this).find(".memPopup").text();
			$(".msgPopupD li").eq(1).text(name);
			
			var condition = $(this).find(".onlineId").text();
			$(".msgPopupD li").eq(2).text(condition);
			
			var chatM_num = $(this).find("input").val();
			$(".chatM_num").val(chatM_num);
			console.log(".chatM_num : " + chatM_num);
			
			$(".chatProfile").show();
			$(".chatProfile2").hide();
	        $(".darkBack").show();
		});
		
		$(document).on("click", ".profileImg2", function (e) {
			var name = $(this).find(".memPopup2").text();
			$(".msgPopupD2 li").eq(1).text(name);
			
			var chatM_num = $(this).find("input").val();
			$(".chatM_num").val(chatM_num);
			console.log(".chatM_num : " + chatM_num);
			
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
		
	});
	
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
		var m_num = $(".chatM_num").val();
		var set = setChatMember2(m_num);
		if (set != null) {
			frm.action="getChatMember2_In.do?room_id=" + set;
			frm.submit;
		} else {
			alert("실패");
		}
	}
	
	/*===================================================================*/
	
	function insertMessenger(room_id) {
		
		var message = $(".textarea").val();
		
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
					dl += "<span>2020년 12월 8일 화요일</span>"
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
				var a = "";
				$.each(data, function(){
					a += "<a href='#' class='profileImg2'>";
					a += "<dl>";
					a += "<dt class='memPopup2'>이민형 부장, " + this.g_name + " " + this.role + "</dt>";
					a += "</dl>";
					a += "</a>";
				})
				
				$(".msgPopupB").html(a);
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
				$.each(data, function(){
					originTxt += "<a href='#' class='profileImg2'>";
					originTxt += "<input type='hidden' name='m_num' value='" + this.m_num + "'>";
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
	
</script>
<body>
    <%@ include file="include/header.jsp" %>
    <section>
    	<input type="hidden" class="room_id" value=${room_id }>
        <dl class="conTit">
            <dt class="conTitM">채팅
                <a href="#" class="noticeImg1">
                    <img src="img/bell.png" alt="" width="24px">
                </a>
                <a href="#" class="noticeImg2">
                    <img src="img/user2.png" alt="" width="19px">
                </a>
            </dt>
            <dd>멤버들과 대화의 장을 펼쳐보아요.</dd>
        </dl>
        <div class="chatBox">
        	<%-- <c:forEach var="chat" items="${chatList}">
				<dl>
	                <dt>${chat.g_name } ${chat.role }</dt>
					<dd class="chatBoxCont1">${chat.message }</dd>
					<dd class="chatTime">${chat.time }</dd>
				</dl>
        	</c:forEach> --%>
            <!-- <dl>
                <dt>권은영 팀장</dt>
                <dd class="chatBoxCont1">여러분, 카트 덤비세요~</dd>
                <dd class="chatTime">오후 11:57</dd>
            </dl>
            <dl>
                <dt>최은서 부사장</dt>
                <dd class="chatBoxCont1">아니 언니 !!! 코인이나 보내 빨리 ㅡㅡㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</dd>
                <dd class="chatTime">오후 11:59</dd>
            </dl>
            <ul>
                <li class="chatBoxCont2">ㄴㅇㅁ라ㅕㅈ마ㅓㅜ</li>
                <li class="chatTime2">오후 11:59</li>
            </ul>
            <ul>
                <li class="chatBoxCont2">ㄴㅁ려ㅑㅗ뮈ㅈ</li>
                <li class="chatTime2">오후 11:59</li>
            </ul> -->
            <!-- <p>
                <span>2020년 12월 8일 화요일</span>
            </p> -->            
            <!-- <dl>
                <dt>박실 대리</dt>
                <dd class="chatBoxCont1">ㅋㅋㅋ</dd>
                <dd class="chatTime">오전 09:37</dd>
            </dl>
            <dl>
                <dt>곽은진 과장</dt>
                <dd class="chatBoxCont1">나 속상해 ㅠㅠㅠ</dd>
                <dd class="chatTime">오전 09:41</dd>
            </dl>
            <dl>
                <dt>원윤희 사원</dt>
                <dd class="chatBoxCont1">왜그래요 은진씨</dd>
                <dd class="chatTime">오전 09:43</dd>
            </dl>
            <dl>
                <dt>유영준 인턴</dt>
                <dd class="chatBoxCont1">설문조사 하겠습니다.</dd>
                <dd class="chatTime">오전 09:50</dd>
            </dl>
            <dl>
                <dt>유영준 인턴</dt>
                <dd class="chatBoxCont1">설문조사 완료되면 제 자리에 갖다놔 주세요 반장님 ^^</dd>
                <dd class="chatTime">오전 09:51</dd>
            </dl>
            <dl>
                <dt>이민형 사원</dt>
                <dd class="chatBoxCont1">...네</dd>
                <dd class="chatTime">오전 10:26</dd>
            </dl> -->
        </div>
        <div class="chatFoot">
        
        	<form action="insertMessenger.do" method="post">
        
            <ul class="fileUpload">
                <li>
                    <a href="#">
                        <img src="img/plus2.png" alt="" width="30px">
                    </a>
                </li>
                <li class="chatSendBox">
                    <textarea rows="5px" placeholder="메세지를 입력하세요." name="message" class="textarea"></textarea>
                    <input type="button" value="전송" class="sendBtn">
                </li>
            </ul>
            
            </form>
            
        </div>
    </section>
    <%@ include file="include/footer.jsp" %>
</body>
</html>