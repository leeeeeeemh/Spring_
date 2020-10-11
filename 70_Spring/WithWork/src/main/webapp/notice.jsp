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
		
		setInterval(getNoticeList, 1000); // 1초 간격
		
		/* var scroll = document.getElementsByClassName("chatBox");
		scroll.scrollTop = scroll.scrollHeight; */

		var chatBoxId = document.getElementById("chatBoxId");
		chatBoxId.scrollTop = chatBoxId.scrollHeight;

		/* $(".chatBox").scrollTop(
			$(".chatBox")[0].scrollHeight
		); */
		
		$(".chatBtn").click(function(){
			getChatMember();
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
		
		/* getChatMember2(); */
		
	});
	
	/*====================================================================*/
	
	function insertNotice() {
		
		var message = $(".textarea").val();
		
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
	
	function getNoticeList() {
		$.ajax("getNoticeList.do", {
			type : "post",
			dataType : "json",
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
					a += "<a href='#' class='profileImg'>";
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
				var originTxt = $(".msgPopupB").html();
				var chatMember = "";
				
				$.each(data, function(){
					originTxt += "<a href='#' class='profileImg'>";
					originTxt += "<input type='hidden' name='room_id' value='" + this.room_id + "'>";
					originTxt += "<dl>";
					originTxt += "<dt class='memPopup'>" + this.g_name + " " + this.role + "</dt>";
					originTxt += "<dd class='onlineId'>" + this.content + "</dd>";
					originTxt += "</dl>";
					originTxt += "</a>";
				});
				
				$(".msgPopupB").html(originTxt);
			},
			error : function(){

			}
		});
	}
	
	
</script>
<body>
	<%@ include file="include/header.jsp" %>
    <section>
        <dl class="conTit">
            <dt class="conTitM">공지사항
                <a href="#" class="noticeImg1">
                    <img src="img/bell.png" alt="" width="24px">
                </a>
                <a href="#" class="noticeImg2">
                    <img src="img/user2.png" alt="" width="19px">
                </a>
            </dt>
            <dd>오늘의 공지사항을 확인해보세요.</dd>
        </dl>
        <div class="chatBox" id="chatBoxId">
            <!-- <dl>
                <dt>권은영 팀장</dt>
                <dd class="chatBoxCont1">여러분, 카트 덤비세요~</dd>
                <dd class="chatTime">오후 11:57</dd>
            </dl> -->
            
            <!-- <p>
                <span>2020년 12월 8일 화요일</span>
            </p> -->
            
            <%-- <c:forEach var="chat" items="${notice }">
	            <dl>
	                <dt>${chat.g_num } ${chat.role }</dt>
	                <dd class="chatBoxCont1">${chat.message }</dd>
	                <dd class="chatTime">${chat.time }</dd>
	            </dl>
            </c:forEach> --%>
           
            <!-- <ul>
                <li class="chatBoxCont2">ㄴㅇㅁ라ㅕㅈ마ㅓㅜ</li>
                <li class="chatTime2">오후 11:59</li>
            </ul>
            <ul>
                <li class="chatBoxCont2">ㄴㅁ려ㅑㅗ뮈ㅈ</li>
                <li class="chatTime2">오후 11:59</li>
            </ul> -->
            
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
        
        	<form action="insertNotice.do" method="post">
        	
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