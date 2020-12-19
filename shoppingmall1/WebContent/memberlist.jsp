<%@page import="com.lee.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "java.util.ArrayList" %>

<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String name = request.getParameter("name");

ArrayList<User> list = null;

Object obj = session.getAttribute("list");

if(obj == null) {
	list = new ArrayList<User>();
} else {
	list = (ArrayList<User>) obj;
}

for(int i = 0; i < list.size(); i++) {
	User user = list.get(i);
}
User user = new User();
user.setId(id);
user.setName(name);
list.add(user);

session.setAttribute("list", list);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>전체 회원 목록</h3>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>삭제</th>
			</tr>
			<tr>
			
			</tr>
			<tr>
				<td colspan="3">
					<input type="button" value="로그아웃" onclick="location.href='logout.jsp'"/>
					<input type="button" value="홈으로 이동"
					 onclick="location.href='home.jsp'"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>