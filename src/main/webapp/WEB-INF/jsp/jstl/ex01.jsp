<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl core library를 포함시키는 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core library</title>
</head>
<body>
	
	<!-- 이 내용 고대로 response에 담겨서 우리가 태그 구성 문제 없는지
	확인 하기 위해서는 이 내용 고대로 response에 담도록 해주는 controller 메소드 만들기 -->
	<h2>JSTL core library</h2>
	
	<h3>1. 변수 만들기</h3>
	<!-- jstl 태그 라이브러리를 통해서 변수를 만들어 써보도록 하자 -->
	<!-- 변수를 만들 때 쓰는 태그 이름은 set 이다. 
		 변수 이름은 var 속성에다가 지정
		 여기 변수에 저장할 값은 value 라는 속성에다가 지정해준다. 
		 타입은 따로 지정 안 해줘도 됨 -->
	<c:set var="number1" value="100" />
	<c:set var="number2">200</c:set>
	
	<h4>숫자1 : ${number1}</h4>
	<h4>숫자2 : ${number2}</h4>
	
	<h3>2. 변수 출력하기</h3>
	<!-- core 라이브러리는 c:으로 시작하고 출력하는건 out 이라는 태그이다.
		 태그 이름 뒤에 필요한 속성이 들어가면 되고 
		 "" 안에 들어가 있는 값이 출력이 되는거고 출력된 값은 변수니깐 
		 ${number1} 이렇게 표현해준다. -->
	<h4>숫자 1 : <c:out value="${number1}" /></h4>
	
	<%-- <script>alert("안녕")</script> --%>
	<!-- 위에 내용을 태그로 동작하도록 하는게 아니라 위에 내용 그대로를 화면에
		보여 주고 싶을 때 out 태그를 활용하면 좋음 -->
	
	<c:out value="<script>alert('안녕')</script>"></c:out>
	<%-- <c:out value="<script>alert('안녕')</script>" escapeXml="false" /> 
		escapeXml을 true로 하면 xml을 취소한다. <script>alert('안녕')</script> 여기 보여지는 태그 구성을 다 취소한다.
		false로 하면 원래대로 태그 자체로 표현이 된다. --%>
	
	<h3>3.조건문</h3>
	
	<%-- if(true) {} if 괄호 안에 true/false 값을 test 라는 속성 안에 들어가면 됨 --%>
	<c:if test="true">
	<!-- 이 사이에다가 태그를 포함시키면 해당 하는 태그가 이 if 조건에 따라서 화면에 표현이 될지 안될지가 처리 된다. -->
		<h4>조건문 결과</h4>
	</c:if>
	
	<%-- if(number1 > 50){} test 라는 속성에 조건이 들어감 --%>
	<c:if test="${number1 > 50}">
		<h4>number1이 50 보다 크다!</h4>
	</c:if>
	
	<%-- if(number2 == 200){} --%>
	<c:if test="${number2 eq 200}">
		<h4>number2는 200이다</h4>
	</c:if>
	
	<%-- if(number2 != 200){} --%>
	<c:if test="${number2 ne 200}">
		<h4>number2는 200이 아니다.</h4>
	</c:if>
	
	<%-- if(number3 == null){} --%>
	<%-- null, 없는 변수, 리스트가 비어 있다, 맵이 비어있다 --%>
	<c:if test="${empty number3}">
		<h4>number3 변수가 없다.</h4>
	</c:if>
	
	<c:if test="${not empty number2}">
		<h4>number2는 있는 변수 이다.</h4>
	</c:if>
	
</body>
</html>