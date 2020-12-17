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
<title>게시판 목록</title>
</head>
<script type="text/javascript">
	
	$(document).ready(function(){
		$("#write_btn").click(function(){
			location.href = "/board/board_write_form.do";
		});
	});
	
</script>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<c:if test="${member != null }">
				<p>
					<button class="w3-button w3-black w3-round" id="write_btn">글 작성</button>
				</p>
			</c:if>
			
			<div class="w3-center w3-large w3-margin-top">
				<h3>게시판 리스트</h3>
			</div>
		</div>
	</div>
</body>
</html>