<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String[] img={"img/man.png", "img/man.png", "img/man.png",};
String[] name={"여성옷1","여성옷2", "여성옷3"};
String[] price={"10000","20000","30000"};
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여성 옷</title>
<script type="text/javascript">
function fnCart(name, price) {
	if(confirm("장바구니에 담으시겠습니까?")) {
		location.href = "CartProcess.jsp?name="+name+"&price="+price;
	}
}
function fnView() {
	if(confirm("장바구니를 보시겠습니까?")) {
		location.href = "CartView.jsp";
	}
}
</script>

</head>
<body>
	<table>
		<tr>
			<td>
				<a href="home.jsp">홈</a>
				<a href="man.jsp">남성 옷</a>
				<a href="woman.jsp">여성 옷</a>
				<a href="login.jsp">로그인</a>
				<a href="join.jsp">회원 가입</a>
			</td>
		</tr>
	</table>
<div align="center">
	<table border="1">
		<tr align="right">
			<td colspan="3">
				<input type="button" value="장바구니 보기" onclick="fnView()" />
			</td>
		</tr>
		<%
		for(int i = 0; i < img.length; i++) {
			if(i % 3 == 0) { 
				out.println("<tr align='center'>");
			}
			out.println("<td>");
				out.println("<table>");
					out.println("<tr align='center'>");
						out.println("<td>");
							out.println("<img src = 'images/" + img[i] + "' width='150' height='150' />");
						out.println("</td>");
					out.println("</tr>");
					
					out.println("<tr align='center'>");
						out.println("<td>");
							out.println("<b>" + name[i] + "</b>");
						out.println("</td>");
					out.println("</tr>");
					
					out.println("<tr align='center'>");
						out.println("<td>");
							out.println("<b>￦" + price[i] + "원</b>");
						out.println("</td>");
					out.println("</tr>");
					
					out.println("<tr align='center'>");
						out.println("<td>");
							//한 줄로 쓰기
							//out.println("<input type='button' value='장바구니 담기' onclick='fnCart(\"" + name[i] + "\", \"" + price[i] + "\")' />");
							//두 줄로 쓰기, 닫는 큰 따옴표와 괄호 옆의 띄어쓰기 필수
							out.println("<input type='button' value='장바구니 담기' ");
							out.println("onclick='fnCart(\"" + name[i] + "\", \"" + price[i] + "\")' />");
						out.println("</td>");
					out.println("</tr>");
				out.println("</table>");
			out.println("</td>");
			if(i % 3 == 2) {
				out.println("</tr>");
			}
		}
		%>	
	</table>
</div>
</body>
</html>