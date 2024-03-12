<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL function library</title>
</head>
<body>
	<h2>JSTL function library</h2>
	
	<%-- set 태그로 변수 만들기 --%>
	<c:set var="string1" value="No pain No gain." />
	<h3>1. 문자열 길이</h3>
	<h4>길이 : ${fn:length(string1)}</h4>
	
	<h3>2. 특정 문자열이 존재하는지 여부</h3>
	<h4>No가 존재하는지? ${fn:contains(string1, "No")}</h4>
	
	<c:if test="${fn:contains(string1, 'No') }" >
		<h4>No가 포함된 문자열</h4>
	</c:if>
	
	<h3>3. 특정문자열로 시작, 끝 나는지 확인</h3>
	<h4>No로 시작하는지? ${fn:startsWith(string1, "No")}</h4>
	<h4>gain. 으로 끝나는지? ${fn:endsWith(string1, "gain.")}</h4>
	
	<c:set var="string2" value="I love chicken" />
	
	<h3>4. 문자열 치환</h3><!-- 특정 문자열을 다른걸로 변환시키는 것 -->
	<h4>${fn:replace(string2, "chicken","pizza")}</h4><%--string2 라는 문자열 자체가 변환되는건 아니다. 변환된 문자열이 리턴이 되면서 EL 태그를 통해 리턴된 값이 태그에 포함 될 것이다. --%>
	<h4>${string2}</h4>
	
	<h3>5.문자열 자르기</h3>
	<h4>${fn:substring(string2, 2, 6) }</h4>
	
	<h3>6. 문자열 쪼개기</h3>
	<h4>${fn:split(string2, " ")[2] }</h4>
	<%-- 0번 인덱스에 I 1번 인덱스에 love 2번 인덱스에 chicken이 들어 있는 배열이 리턴된거임 --%>
	
	<h3>7. 문자열 앞뒤 공백 제거</h3>
	<c:set var="string3" value="                     hello          " />
	<h4>${string3}</h4>
	<textarea cols="80">${string3}</textarea>
	<textarea cols="80">${fn:trim(string3)}</textarea><%-- 대상이 되는 문자열을 인자로 받아주면 해당하는 문자열 안에 들어가있는 앞뒤 공백을 제거해서 리턴해준다. --%>
</body>
</html>