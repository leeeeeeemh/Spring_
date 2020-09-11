<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
		margin: 0 auto;
		padding-bottom: 15px;
	}
	th {
		text-align: left;
	}
	td {
		padding-left: 50px;
		text-align: center;
	}
	#bt {
		margin-top: 20px;
		text-align: center;
	}
</style>
</head>
<body>

<div id="container">
	
	<div id="h2">
		<h2>J O I N</h2>
	</div>
	
	<form action="signup.do" method="post">
	
	<table>
		<tr>
			<th width="50">ID</th>
			<td>
				<input type="text" name="id">
			</td>
		</tr>
		<tr>
			<th>NAME</th>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<th>PW</th>
			<td>
				<input type="password" name="password">
			</td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td>
				<input type="email" name="email">
			</td>
		</tr>
		<tr>
			<th>NICKNAME</th>
			<td>
				<input type="text" name="nikname">
			</td>
		</tr>
	</table>
	
	<div id="bt">
		<input type="submit" value="JOIN">
	</div>
	
	</form>
	
</div>

</body>
</html>











