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
<title>비밀번호 찾기</title>
</head>
<script type="text/javascript">
	
	
	
</script>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<form id="findForm" action="/member/find_pw.do" method="post">
				<div class="w3-center w3-large w3-margin-top">
					<h3>비밀번호 찾기</h3>
				</div>
				
				<div>
					<p>
						<label>아이디</label>
						<input class="w3-input" type="text" id="id" name="id" required="required"/>
					</p>
					
					<p>
						<label>이메일</label>
						<input class="w3-input" type="text" id="email" name="email" required="required"/>
					</p>
					
					<p class="w3-center">
						<button class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round" type="submit">비밀번호 찾기</button>
						<button class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round" type="button" onclick="history.go(-1);">취소</button>
					</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>