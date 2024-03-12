<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX 예제</title>
</head>
<body>

	<h2>AJAX 테스트</h2>
	
	<button type="button" id="requestBtn">요청</button>
	
	<h3 id="nameH"></h3>
	<h4 id="ageH"></h4>
	
	
	<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous"></script>
  	<script>
  		$(document).ready(function() {
  			
  			$("#requestBtn").on("click", function() {
  				
  				// /ajax/person
  				// 이벤트가 발생했을 때 /ajax/person 요청을 해볼거임
  				// javascript 문법 중 ajax를 통해 요청을 해볼거임
  				// 이 중괄호 사이에 요청과 응답에 필요한 설정 값들이 차곡차곡 들어가면 됨
  				$.ajax({
  					// 요청을 위한 정보들
  					type:"get"
  					, url:"/ajax/person"
  					// 요청에 같이 전달해야 될 파라미터
  					// data라는 옵션 값에다가 자바스크립트이기 때문에 key-value 형태를 표현 하는 방식 dictionary 형태로 값을 채워주면 됨
  					, data:{"name":"유재석", "birthday":"20050912"} // name 이라는 파라미터에 유재석이라는 값 birthday라는 파라미터에 29 라는 값이 전달 될거임
  					// success는 response를 처리하기 위한 곳이다. response는 머지?? 요청을 하고 나서 이 놈이 다 처리 해서 응답으로 돌려줄 떄 뭔가를 처리해야 되잖아 그 때 기능 수행이 들어감 즉, response가 전달이 되었을 때 요청에 대한 응답이 성공적으로 처리가 되었을 때 어떤 기능을 수행할지를 정의
  					// response body 에 들어가 있는 데이터가 전달이 되어야 한다. => 파라미터 data 추가
  					, success:function(data){
  						// {"name":"김인규", "age":25}
  						// jquery가 response를 전달된 json 문자열을 쓰기 편안하라고
  						// 자바스크립트 객체로 변환
  						console.log("나이 : " + data.age);
  						
  						$("#nameH").text(data.name);
  						$("#ageH").text(data.age);
  					}
  					, error:function() { // 에러가 발생됐을 떄 실행됨
  						alert("에러");
  					}
  				});
  				
  				
  			}); // 이벤트 등록할때는 on 메소드 사용 
  				// on 메소드는 두가지 인자가 들어간다. 첫 번째 인자는 이벤트 이름 들어감, 두 번째 인자는 해당하는 이벤트가 발생했을 때 수행될 코드  
  			
  		}); // 자바스크립트는 기본적으로 html 안에 있는 태그 구성을 DOM Tree라는 형태의 객체 구조로 만들어지고 그걸 기반으로 동작하기 때문에 태그가 다 완성이 되고 DOM Tree 형태로 구성된 이후에 작성될 코드를 여기다가 등록하는 형태로 사용한다.
  	
  	</script>
</body>
</html>