<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<table>
	<tr>
		<td>
			<a href="home.jsp">홈</a>
			<a href="man.jsp">남성 옷</a>
			<a href="woman.jsp">여성 옷</a>
			<a href="login.jsp">로그인</a>
		</td>
	</tr>
</table>
<div align="center">
	<h2>회원가입 페이지</h2>
	<form action="UserController" method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="member_id" required="required"/></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="member_pw" required="required"/></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="member_name" required="required"/></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="number" name="member_age" required="required" min="0" /></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="member_gender" value="남" checked="checked" />남자
					<input type="radio" name="member_gender" value="여" />여자
				</td>
			</tr>
			<tr>
				<th>이메일 주소</th>
				<td><input type="text" name="member_email" maxlength="30"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="회원가입"/>
					<input type="reset" value="다시 작성"/>
					
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>