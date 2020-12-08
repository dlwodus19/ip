<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
String id = (String) session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<a href="home.jsp">HOME</a>
				<a href="login.jsp">LOGIN</a>
			</td>
		</tr>
	</table>
	
	<%
//세션 객체에 id 속성이 있으면 보여질 화면
if(id != null) { //세션에 id 값이 있다 ▶ 로그인 상태를 유지하는 화면 %>
	<%=id %>님 방문을 환영합니다!<br />
	<a href="logout.jsp">로그아웃</a>
<%} else { //세션에 id 값이 없다 ▶ 로그인 값이 없다%>
<form action="loginprocess.jsp" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" required="required"/></td>
			<td rowspan="2"><input type="submit" value="로그인"/></td>		
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw" required="required"/></td>		
		</tr>
	</table>
</form>
<%} %>
	
</body>
</html>