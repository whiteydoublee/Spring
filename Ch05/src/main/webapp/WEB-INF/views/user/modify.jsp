<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>modify</title>
</head>
<body>
	<h3>User 수정</h3>
	<form action="/ch05/user/modify" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid" readonly value="${userVO.uid }"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${userVO.name }"/></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" value="${userVO.hp }"/></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" value="${userVO.age }"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정하기"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>