<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core 제어문</title>
</head>
<body>
	
	<h2>조건문, 반복문</h2>
	
	<h3>1. if else if</h3>
	<%-- 몸무게가 70이하면 치킨, 80 이하면 샐러드, 그게 아니면 굶어 --%>
	
	<%-- 몸무게를 저장하는 변수 var 라는 속성에 변수 이름 , value 라는 속성에 값 --%>
	<c:set var="weight" value="75" />
	
	<!-- if, else-if, else로 표현 할 수 있는 조건문을 
		 core 라이브러리에 choose 라는 태그를 연다. -->
	<%-- 이 choose 사이에 말 그대로 선택이다 여러 조건들 중에 하나를 선택 한다 이런 개념이다
		 이 안에 when 이라는 태그를 추가 해서 test 속성이 들어간다.--%>
	<c:choose>
		<c:when test="${weight <= 70}">
			<h4>치킨</h4>
		</c:when>
		<c:when test="${wheight <= 80}">
			<h4>샐러드</h4>
		</c:when>
		<c:otherwise>
			<h4>굶어</h4>
		</c:otherwise>
	</c:choose>
	
	<h3>2. 반복문</h3>
	
	<%-- for(int i = 0; i < 5; i++){} --%>
	<c:forEach var="i" begin="0" end="4" step="1">
		${i}
	</c:forEach>
	
	<%-- for(String fruit:fruitList){} --%>
	<c:forEach var="fruit" items="${fruitList}" varStatus="status"><!-- varStatus 라는 속성을 통해서 변수를 하나 지정해 준다.
																		반복 상태에 대한 변수를 하나 만든다. 그러면 뒤에 따라오는 status 값을 통해서 반복 상태를 확인할 수가 있다.-->
		<h4>${fruit} :: ${status.count} ${status.index} ${status.first} ${status.last}</h4>
		<%-- count 라는 키워드는 그대로 반복 횟수를 확인시켜주는 변수 값
			 index 0부터 시작 해서 1씩 증가 하는 반복 횟수를 관리 하는 값
			 first 반복 상태가 처음인지 처음일 때는 true, 그렇지 않을 경우에는 다 false 
			 last는 그 반대로 반복에 가장 마지막인지 아닌지를 알려주는 것이다. --%>
	</c:forEach>
	
	<h3>사용자 리스트</h3>
	<table border="1">
		<thead>
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>취미</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.name}</td>
				<td>${user.age}</td>
				<td>${user.hobby}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
</body>
</html>