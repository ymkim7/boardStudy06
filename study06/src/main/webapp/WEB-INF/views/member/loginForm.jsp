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
<title>로그인 폼</title>
</head>
<script type="text/javascript">
	
	$(document).ready(function(){
		$("#find_id_btn").click(function(){
			location.href="/member/find_id_form.do";
		});
		
		$("#find_pw_btn").click(function(){
			location.href="/member/find_pw_form.do";
		});
	});
	
</script>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<h3>Log Form</h3>
			</div>
			
			<div>
				<form id="logForm" action="/member/login.do" method="post">
					<p>
						<label>ID</label>
						<span class="w3-right w3-button w3-hover-white" title="아이디 찾기" id="find_id_btn">
							<i class="fa fa-exclamation-triangle w3-hover-text-red w3-large"></i>
						</span>
						<input class="w3-input" type="text" id="id" name="id" required="required"/>
					</p>
					
					<p>
						<label>Password</label>
						<span class="w3-right w3-button w3-hover-white" title="비밀번호 찾기" id="find_pw_btn">
							<i class="fa fa-exclamation-triangle w3-hover-text-red w3-large"></i>
						</span>
						<input class="w3-input" type="password" id="pw" name="pw" required="required"/>
					</p>
					
					<p class="w3-center">
						<button class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round" type="submit">로그인</button>
						<button class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round" type="button" onclick="history.go(-1);">취소</button>
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>