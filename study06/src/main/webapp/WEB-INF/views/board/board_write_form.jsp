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
	
	
	
</script>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<h3>게시판 글 작성</h3>
			</div>
			
			<div>
				<form action="/board/board_write.do" method="post">
					<input class="w3-input w3-border w3-round" id="subject" name="subject" type="text" placeholder="subject" required="required"/>
					<br/>
					
					<textarea class="w3-input w3-border w3-round" id="content" name="content" rows="10" placeholder="content" style="resize:none;" required="required"></textarea>
					<input type="hidden" name="id" value="${member.id }"/>
					
					<p class="w3-center">
						<button class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round" type="submit">확인</button>
						<button class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round w3-margin-bottom" onclic="history.go(-1)">취소</button>
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>