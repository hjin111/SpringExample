<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보</title>
</head>
<body>
	
	<h1>${title}</h1>
	
	<table border="1">
		<tr>
			<td>id</td>
			<td>${result.id}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${result.name}</td><!-- EL태그가 알아서 name이라는 멤버 변수 값을 채워야 겠네 name은 어차피 private이라 직접 접근 못하니깐 이 name에 대한 getter로 호출을 해서 이 값 채워야지 하면서
										알아서 내부적으로 getter 메소드를 통해 값 채워 넣어주는 거임 절대 private인 멤버 변수를 직접 가져다 쓰는거 아님 내부적으로 getter를 호출한다 -->
		</tr>
		<tr>
			<td>이메일</td>
			<td>${result.email}</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${result.yyyymmdd}</td>
		</tr>
	</table>
</body>
</html>