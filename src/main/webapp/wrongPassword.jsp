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
	.ok a input[type="button"] {
	    background-color: green;
	    color: white;
	    padding: 10px 20px; 
	    text-decoration: none; 
	    border: none; 
	    cursor: pointer; 
	}

	.ok a input[type="button"]:hover {
	    background-color: darkgreen;
	}

</style>
<body>
<h1><marquee>Incorrect Password</marquee> </h1>
<h2>The password you entered is incorrect. <br> Please try again.</h2>

<div class = "ok">
<a href="login.html"> <input type = "button" value = "OK"> </a>
</div>

</body>
</html>