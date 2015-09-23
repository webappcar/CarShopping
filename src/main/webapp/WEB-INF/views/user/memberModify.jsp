<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberJoin</title>
<style type="text/css">
	#register {width:400px; height: 600px; margin:auto;}
</style>
</head>
<body>
		<form  method="post" action="">
			<table id="register" border="1">
				<tr>
					<th colspan="2">회원가입</th>
				</tr>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text">
						<input type="button" value="중복확인">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password"></td>
				</tr>
				<tr>
					<th>비밀번호확인</th>
					<td><input type="password"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text"></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td>
						<input type="text">
						<input type="button" value="중복확인">
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="입력">
						<input type="button" value="취소">
					</td>
				</tr>
			</table>
		</form>
</body>
</html>