<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>index</title>
</head>
<script type="text/javascript">
	
</script>
<body>
	<input type="button" value="회원가입" onclick="location.href='./member/memberJoinForm.do'"/>
	
	<c:if test="${member == null }">
		<input type="button" value="로그인" onclick="location.href='./member/login_form.do'"/>
	</c:if>
	
	<c:if test="${member != null }">
		<a href="/member/mypage.do">마이페이지(${member.id })</a>
		<input type="button" value="로그아웃" onclick="location.href='./member/logout.do'"/>
	</c:if>
	
	<a href="/board/board_list.do">게시판</a>
</body>
</html>