<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exercise01</title>

<c:if test="${not empty SID}">
	<meta http-equiv="Refresh" content="3;url=/Ex1_Main" />
</c:if>

<link rel="stylesheet" href="/css/w3.css">
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<style>
</style>
<script type="text/javascript">
</script>
</head>
<body>
	<c:if test="${empty SID}">
		<form method="POST" action="/member/ex1_loginProc.exq" id="frm"  class="w3-col m6 w3-center w3-margin-top" >
			<div>
				I D : <input type="text" id="id" name="id">
			</div>
			<div>
				PW : <input type="password" id="pw" name="pw">
			</div>
			<input type="button" id="home" value="취소">
			<input type="submit" id="btn" value="로그인">	
		</form>
	</c:if>
	
	<c:if test="${not empty SID}">
				<div class="w3-col m6 w3-center" id="d1">
			<h3>${SID} 님은 이미 로그인 하셨습니다.</h3>
			<h6>메인 페이지로 이동합니다.</h6>
	</c:if>
</body>
</html>