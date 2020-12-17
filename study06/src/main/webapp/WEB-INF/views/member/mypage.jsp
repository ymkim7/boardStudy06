<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset-UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>마이페이지</title>
</head>
<script type="text/javascript">
	
	$(document).ready(function(){
		if(${msg ne null}) {
			alert("${msg}");
		}
		
		if($("#pwForm").submit(function(){
			if($("#pw").val() !== $("#pw2").val()) {
				alert("비밀번호가 다릅니다.");
				$("#pw").val("").focus();
				$("#pw2").val("")
				return false;
			} else if($("#pw").val().length < 4) {
				alert("비밀번호는 4자리 이상이어야 합니다.");
				$("#pw").val("").focus();
				return false;
			} else if($.trim($("#pw").val()) !== $("#pw").val()) {
				alert("공백은 입력이 불가능합니다.");
				return false;
			}
		}));
		
		if($("#wdForm").submit(function(){
			if(!confirm("탈퇴하시겠습니까?")){
				return false;
			}
		}));
	});
	
</script>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<h3>마이페이지</h3>
			</div>
			
			<div>
				<form id="myForm" action="/member/update_mypage.do" method="post">
					<p>
						<label>아이디</label>
						<input class="w3-input" type="text" id="id" name="id" value="${member.id }" required="required"/>
						<span id="id_check" class="w3-text-red"></span>
					</p>
					
					<p>
						<label>이메일</label>
						<input class="w3-input" type="text" id="email" name="email" value="${member.email }" required="required"/>
						<span id="email_check" class="w3-text-red"></span>
					</p>
					
					<p class="w3-center">
						<button class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round" type="submit">회원정보 변경</button>
					</p>
				</form>
				<br/>
				
				<form id="pwForm" action="/member/update_pw.do" method="post">
					<input type="hidden" name="id" value="${member.id }"/>
					
					<p>
						<label>비밀번호</label>
						<input class="w3-input" type="password" id="old_pw" name="old_pw" required="required"/>
					</p>
					
					<p>
						<label>새비밀번호</label>
						<input class="w3-input" type="password" id="pw" name="pw" required="required"/>
					</p>
					
					<p>
						<label>Confirm</label>
						<input class="w3-input" type="password" id="pw2" name="pw2" required="required"/>
					</p>
					
					<p class="w3-center">
						<button class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round" type="submit" id="joinBtn">비밀번호 변경</button>
					</p>
				</form>
				<br/>
				
				<form id="wdForm" action="/member/withdrawal.do" method="post">
					<input type="hidden" name="id" value="${member.id }"/>
					
					<p>
						<label>비밀번호</label>
						<input class="w3-input" type="password" id="pw" name="pw" required="required"/>
					</p>
					
					<p class="w3-center">
						<button class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round" type="submit" id="joinBtn">회원탈퇴</button>
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>