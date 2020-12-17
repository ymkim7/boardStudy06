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
<title>회원가입 폼</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#joinForm").submit(function(){
			if($("#pw").val() != $("#pw2").val()) {
				alert("비밀번호가 일치하지 않습니다.");
				$("#pw").val("").focus();
				$("#pw2").val("");
				return false;
			} else if($("#pw").val().length < 4) {
				alert("비밀번호는 4자 이상 설장해야 합니다.");
				$("#pw").val("").focus();
				return false;
			} else if($.trim($("#pw").val()) !== $("#pw").val()
					|| $.trim($("#email").val()) !== $("#email").val()
					|| $.trim($("#id").val()) !== $("#id").val()) {
				alert("공백은 입력이 불가능합니다.");
				return false;
			}
		});
		
		$("#id").keyup(function(){
			$.ajax({
				url : "../member/check_id.do"
				, type : "post"
				, data : {
					id : $("#id").val()
				}
				,success : function(result) {
					if(result == 1) {
						$("#id_check").html("중복된 아이디가 있습니다.");
						$("#joinBtn").attr("disabled", "disabled");
					} else {
						$("#id_check").html("");
						$("#joinBtn").removeAttr("disabled");
					}
				}
			});
		});
		
		$("#email").keyup(function(){
			$.ajax({
				url : "..member/check_email.do"
				, type : "post"
				, data : {
					email : $("#email").val()
				}
				,success : function(result) {
					if(result == 1) {
						$("#email_check").html("중복된 이메일이 있습니다.");
					} else {
						$("#email_check").html("");
					}
				}
			});
		});
		
	});
</script>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<h3>Member Join Form</h3>
			</div>
			
			<div>
				<form id="joinForm" action="/member/join_member.do" method="post">
					<p>
						<label>ID</label>
						<input class="w3-input" type="text" id="id" name="id" required="required"/>
						<span id="id_check" class="w3-text-red"></span>
					</p>
					
					<p>
						<label>PW</label>
						<input class="w3-input" type="password" id="pw" name="pw" required="required"/>
					</p>
					
					<p>
						<label>Confirm</label>
						<input class="w3-input" type="password" id="pw2" name="pw2" required="required"/>
					</p>
					
					<p>
						<label>Email</label>
						<input class="w3-input" type="text" id="email" name="email" required="required" placeholder="이메일 인증 후 로그인 가능합니다."/>
						<span id="email_check" class="w3-text-red"></span>
					</p>
					
					<p class="w3-center">
						<button class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round" type="submit" id="joinBtn" >회원가입</button>
						<button class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round" type="button" id="joinBtn" onclick="history.go(-1);">취소</button>
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>