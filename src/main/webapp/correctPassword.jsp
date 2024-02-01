<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	body {
        background-color: rgb(33, 33, 32);
        color: whitesmoke;
        font-family: Arial, sans-serif;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
    }
</style>
<body>
<h1><marquee>Login successfuly</marquee></h1>

<% 
String name = (String)session.getAttribute("name"); 
%>
<h2>Hey <%=name %>, you have login to this WebApp</h2>
</body>
</html>