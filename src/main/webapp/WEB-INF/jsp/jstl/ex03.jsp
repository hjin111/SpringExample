<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>format library</title>
</head>
<body>
	
	<h2>JSTL format library</h2>
	
	<h3>1.숫자 출력</h3>
	<c:set var="number" value="457312795" />
	<%-- 123,456 쉼표를 중간에 넣는 형태로 표현 하고 싶다 이럴 때 쓰는게 바로 format library 이다.--%>
	<%-- 자바에서 만들어진 데이터의 형태를 사용자가 보기 편하도록 만들어 주는 것 그걸 format library 를 통해 쉽게 만들어 낼 수 있다. --%>
	<%-- value 라는 속성에다가 값을 부여해주기 --%>
	<h4><fmt:formatNumber value="${number}" /></h4>
	
	<h3>2. 퍼센트</h3>
	<h4><fmt:formatNumber value="0.26" type="percent" /></h4>
	<h4><fmt:formatNumber value="${3/7}" type="percent" /></h4><%-- 비율 연산 결과를 퍼센트로 보여줬으면 좋겠다 이런 형태로 많이 사용한다. --%>
	
	<h3>3. 통화</h3>
	<h4><fmt:formatNumber value="${number}" type="currency" /></h4>
	<%-- type 에다가 통화를 의미하는 currency 라고 하는 값을 넣어주면 value의 값이 통화, 돈으로 판단해서 거기에 대응 되는 값으로 표현된다. --%>
	<%-- 원하는 통화 단위로 바꿀 수도 있다. 속성에 currencySymbol 속성에 세팅해주기 --%>
	<h4><fmt:formatNumber value="${number}" type="currency" currencySymbol="$"/></h4>
	
	<h3>4. 소수점 자리수 표현</h3>
	<c:set var="pi" value="3.141592" />
	
	<%-- 필요한 만큼의 소수점만 표현 할 수 있도록 하는 태그 
		 value 에다가 방금 만든 pi 라는 변수의 값을 세팅 해주고
		 내가 원하는 자릿수 만큼을 pattern 이라고 하는 속성에다가 
		 #으로 표현해주면 됨 --%>
	<h4><fmt:formatNumber value="${pi}" pattern="#.##"/></h4>
	<h4><fmt:formatNumber value="${pi}" pattern="#.########"/></h4><%--8자리로 표현하라고 시켰지만 있는 만큼만 표현이 됨 --%>
	<h4><fmt:formatNumber value="${pi}" pattern="0.00000000"/></h4><%--꼭 정해진 자릿수 만큼을 다 표현하고 채워지지 않는 부분을 0으로 채워라--%>
	
	<h3>5.변환 결과 변수 저장</h3>
	<fmt:formatNumber value="${pi}" pattern="#.##" var="pi2" />
	<%-- formatNumber를 통해서 변환된 결과가 바로 태그에 포함되는게 아니라 pi2 라는 변수 값이 만들어져서 pi2 이 변수에다가 저장이 된다. --%>
	<h4>${pi2 * 3}</h4>
	
	<h3>6. 날짜 포맷</h3>
	<%-- 날짜 포맷은 자바의 Date 객체에 있는 날짜, 시간 정보를 원하는 문자열 형태로 만들어주는 놈이다. ( simpleDateFormat 이잖아?? )
		그걸 jsp 에서 간단하게 쓸 수 있게 도와주는 것이다. --%>
	<%-- 여기서 사용 할 Date 객체는 이 jsp 경로를 리턴하는 메소드에서 만들어서 model에 세팅해주면 됨 --%>
	<h4>${now}</h4>
	<%-- Date 객체에 toString을 통해서 얻을 수 있는 문자열이다. 이걸 쓰기가 불편해서 SimpleDateFormat을 통해서 우리가 원하는 형태로 변환을 했었다. 그거랑 똑같은 기능이다.--%>
	<%-- fmt에 formatDate 라는 태그이다 변환할 date 객체를 value 속성에다가 넣어주면 되고 변환할 문자열의 형태를 simpleDateFormat에서 사용하던 그 형태 그대로 pattern 이라고 하는 속성에다가 넣어주면 된다.--%>
	<h4><fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" /></h4>
	
	<%-- 가끔 문자열 형태로 날짜, 시간 정보가 전달 될 수 있음 --%>
	<c:set var="dateTimeString" value="2024-02-15 20:57:12" />
	
	<%-- 문자열을 내가 원하는 다른 형태로 바꾸고 싶음 그럴려면 Date 객체가 필요함 --%>
	<%-- 문자열 형태로 만들어진 날짜 시간 정보를 Date 객체로 변환 할 수 있다. --%>
	<%-- String 날짜 시간 정보 -> Date 객체 --%>
	
	<%-- value 에다가 변환할 대상 변수를 넣어주면 됨 여기서 중요한건 이 문자열을 바로 내가 원하는 형태로 바꾸는게 아님
	     이 문자열을 Date 객체로 바꾸는거임 그리고 나서 그 Date 객체를 다시 사용하면 되는 거임 --%>
	<%-- 이 문자열을 Date 객체로 바꾸기 위해서는 이 문자열 안에 들어 있는 년,월,일,시,분,초의 형식을 알려줘야 됨 그래야 년,월,일,시,분,초를 쪼개서 Date 객체로 만들 수가 있다. 그거를 pattern 이라고 하는 속성에다가 넣어줄거임 --%>
	<%-- 문자열로 만들어진거를 Date 객체로 만들기 위한 거고 문자열 안에 들어 있는 년,월,일,시,분,초에 규격을 넣어줘야 그걸 뜯어내서 Date 객체로 만들어 줄 수 있다.
		 그래서 이거는 내가 바꾸고자하는 문자열이 아니라 지금 만들어져 있는 문자열에 년,월,일,시,분,초에 규격을 페턴에 넣어줘야 한다.2024-02-15 20:57:12 이 규격 넣어주면 됨 
		 변환한 결과를 변수에 저장할려면 var 속성에다가 변수 이름 지정해주면 된다.--%>
	<fmt:parseDate value="${dateTimeString}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
	
	<h4>${date}</h4>
</body>
</html>