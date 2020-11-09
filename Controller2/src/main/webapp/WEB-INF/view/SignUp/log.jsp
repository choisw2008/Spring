<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/domain.jsp" method="post">
		<ul>
			<li>
				<label for="name">아이디</label><br><input type="text" id="name">
			</li>
			<li>
				<label for="age">비밀번호</label><br><input type="text" id="age">
			</li>
			<li>
				<label for="id">비밀번호 확인</label><br><input type="text" id="id">
			</li>
			<li>
				<label for="pw">주소</label><br><input type="text" id="pw">
			</li>
			<li>
				<label for="pw">휴대폰번호</label><br><input type="text" id="pw">
			</li>
			<li>
				<label for="pw">회사번호</label><br><input type="text" id="pw">
			</li>
			<li>
				<label for="pw">팩스번호</label><br><input type="text" id="pw">
			</li>
		</ul>
		<label><input type="checkbox" name="color" value="blue"> 회원가입 동의</label>
      	<label><input type="checkbox" name="color" value="red"> 비 동의</label><br>
		
		<input type="button" value="가입" onClick="location.href='/main">
		<input type="button" value="취소" onClick="location.href='/main">
	</form>
</body>
</html>