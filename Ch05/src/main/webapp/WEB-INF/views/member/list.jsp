<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>list</title>
</head>
<body>
	<h3>직원목록</h3>
	<a href="#">직원등록</a>
	<table border="1"> 
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>직급</th>
			<th>부서</th>
			<th>입사일</th>
			<th>기타</th>
		</tr>
			<tr>
				<td>A101</td>
				<td>홍길동</td>
				<td>010-5656-8989</td>
				<td>과장</td>
				<td>101</td>
				<td>2016-11-30</td>
				<td>
					<a href="#">수정</a>
					<a href="#">삭제</a>
				</td>
			</tr>
	</table>
</body>
</html>