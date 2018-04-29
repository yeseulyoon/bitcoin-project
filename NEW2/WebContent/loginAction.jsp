<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import="model.PeopleDAO" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<% request.setCharacterEncoding("EUC-KR"); %>

<% System.out.println("loginAction.jsp"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>loginAction.jsp</title>
</head>
<body>
	
	<%
	if(request.getAttribute("login").equals(1)){
	    session.setAttribute("id", request.getParameter("loginid"));
	    session.setMaxInactiveInterval(30*60);
	    response.sendRedirect("loginSucc.jsp");
	}else if(request.getAttribute("login").equals(0)){ %>
		<script>
			alert('wrong password')
			location.href ='index.html';
		</script>			
	<%}else if(request.getAttribute("login").equals(-1)){ %>
		<script>
			alert('no exist id');
			location.href ='index.html';
		</script>
	<% }else if(request.getAttribute("login").equals(-2)){ %>
		<script>
			alert('Hello :)');
			location.href ='index.html';
		</script>
	<% } %>
</body>
</html>