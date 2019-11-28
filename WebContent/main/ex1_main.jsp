<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex1_Main</title>
<link rel="stylesheet" href="/css/w3.css">
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<style>
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$('#login').click(function(){
			$(location).attr('href', '/Exercise01/member/ex1_login.exq');
		});
		
		$('#join').click(function(){
			$(location).attr('href', '/Exercise01/member/ex1_join.exq');
		});
	});

</script>
</head>
<body>
<h1 class="w3-col w3-center">Ex1_Main Page</h1>
<button class="w3-col m3 w3-red w3-center w3-button" name="login" id="login">로그인</button>
<button class="w3-col m3 w3-red w3-center w3-button" name="join" id="join">회원가입</button>

</body>
</html>