<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="testRequestMappingController/testRedirect">testRedirect</a>

	<br>
	<br>

	<form action="testRequestMappingController/updataUser">
		<input type="hidden" name="id" value="1"> name: <input
			type="text" name="name" value="${user.name}"> username: <input
			type="text" name="username" value="${user.username }">
		password: <input type="text" name="namepassword"
			value="${user.password }">

		<button type="submit">提交</button>


	</form>







	<!-- 测试testSessionAttribute -->
	<a href="testRequestMappingController/testSessionAttribute">testSessionAttribute</a>

	<br>
	<br>



	<!-- 测试Map -->
	<a href="testRequestMappingController/testMap">testMap</a>

	<br>
	<br>


	<!-- 测试ModelAndView -->
	<a href="testRequestMappingController/testModelAndView">testModelAndView</a>

	<br>
	<br>


	<!-- 测试servlet原生态api -->
	<a href="testRequestMappingController/testServletAPI">testServletAPI</a>

	<form action="testRequestMappingController/testPojo">

		name: <input type="text" name="name"> username: <input
			type="text" name="username"> password: <input type="text"
			name="namepassword"> city: <input type="text"
			name="address.city"> street: <input type="text"
			name="address.street">
		<button type="submit">提交</button>


	</form>
	<br>

	<form action="testRequestMappingController/testMethod" method="post">
		<button type="submit">提交</button>
	</form>
	<a href="testRequestMappingController/testRequestMapping">testRequestMapping</a>

	<a href="spring_mvc">spring_mvc</a>

	<a
		href="testRequestMappingController/testParams?userName=zhaoshunmin&passWord=123456">testParams</a>


	<a href="testRequestMappingController/testPathVar/1">testPathVar</a>

	<br>



	<br>

	<a href="testRequestMappingController/testRestGet/1">testRestGet</a>
	<br>



	<form action="testRequestMappingController/testRestPost" method="post">
		<button type="submit">testRestPost</button>
	</form>
	<br>

	<form action="testRequestMappingController/testRestDelete/3"
		method="post">

		<input type="hidden" name="_method" value="DELETE">
		<button type="submit">testRestDelete</button>
	</form>
	<br>


	<form action="testRequestMappingController/testRestPut/4" method="post">
		<input type="hidden" name="_method" value="PUT">
		<button type="submit">testRestPut</button>
	</form>
	<br>

	<a
		href="testRequestMappingController/testRequestParam?id=140321&username=zhaoashunmin">testRequestParam</a>
	<br>

</body>
</html>