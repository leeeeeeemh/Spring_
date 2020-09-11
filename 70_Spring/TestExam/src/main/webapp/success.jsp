<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
<style>
	#container {
		width: 400px;
		margin: 0 auto;
	}
	#h2 {
		text-align: center;
		margin-top: 120px;
		padding: 10px 0px 10px 0px;
		background-color: #FFC0CB;
		margin-bottom: 20px;
	}
	table, th, td {
		padding-bottom: 15px;
		margin: 0 auto;
	}
	th { 
		text-align: left; 
	}
	td {
		padding-left: 50px;
		text-align: center;
	}
	#p {
		text-align: center;
	}
</style>
</head>
<body>

<div id="container">

	<div id="h2">
		<h2>Welcome !!</h2>
	</div>

	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" name="id" value="${model. id }"></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><input type="text" name="name" value="${model. name }"></td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td><input type="text" name="email" value="${model. email }"></td>
		</tr>
		<tr>
			<th>NICKNAME</th>
			<td><input type="text" name="nikname" value="${model. nikname }"></td>
		</tr>

	</table>

</div>

<p id="p"><a href="index.jsp">메인페이지로 이동</a></p>
</body>
</html>