<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>成功了</h1>

	date :<a> ${date}</a>
    name :<a>${name}</a>
	<br>
	<br>
	<br>
	<!-- 测试testSessionAttribute -->
	   <a> ${requestScope.name}</a>
	    <a> ${sessionScope.name}</a>
	    <br>
	      <a>${requestScope.user}</a>
	   <a> ${sessionScope.user}</a>
	  
	  
	 
</body>
</html>