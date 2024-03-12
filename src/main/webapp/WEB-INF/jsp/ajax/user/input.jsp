<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 추가</title>
</head>
<body>
	<h3>사용자 추가</h3>
	
	<label>이름 : </label><input type="text" id="nameInput"> <br>
	<label>생년월일 : </label><input type="text" id="birthdayInput"> <br>
	<label>이메일 : </label><input type="text" id="emailInput"> <br>
	<button type="button" id="addBtn">추가</button>
	
	<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous"></script>
  	<script>
  		$(document).ready(function(){
  			
  			// 추가 버튼을 클릭했을 때 입력된 내용을 얻어와서 ajax를 통해 api를 호출할거임
  			// 추가버튼이 클릭되면
  			$("#addBtn").on("click", function(){
  				
	  			// 입력 값을 얻어 와서
	  			let name = $("#nameInput").val(); // input 태그에서 사용자가 입력한 값은 자바스크립트에서 value 속성의 값을 얻어오면 됨	
	  			let birthday = $("#birthdayInput").val();
	  			let email = $("#emailInput").val();
	  			
	  			// create API 호출한다.
	  			$.ajax({
	  				type:"get"
	  				, url:"/ajax/user/create"
	  				, data:{"name":name, "birthday":birthday, "email":email} // 파라미터
	  				// 위에 3가지가 request를 위해 필요한 설정 항목들이다.
	  				// response에 대한 부분을 정리, response는 위에 3가지 옵션을 통해 실제 요청이 진행 되고 나서 기능 수행 이후에 만들어진 response의 내용을 어떻게 처리할건지를 함수로 등록해주는 과정이다.
	  				, success:function(data){ // 그리고 response 에는 항상 responsebody 데이터가 따라 다닌다 그 데이터를 저장 할 파라미터를 명시해주면 됨
	  					// 응답이 전달이 되었을 때 수행될 코드를 미리 작성하고 응답이 전달이 되면 그때 호출됨
	  					
	  					// data에 뭐가 들어 있다?
	  					// 성공 : json 형식에서 {"result":"success"}
						// 실패 : json 형식에서 {"result":"fail"}
	  					// 응답이 저장되는 data라는 변수에는 위에 둘 중에 하나의 데이터가 저장되어 있음
	  					if(data.result == "success"){
	  						// 성공
	  						// 리스트 페이지로 이동
	  						location.href = "/ajax/user/list"; // 자바스크립트에서 특정 페이지로 이동 하고 싶으면 location.href 라는 속성의 값을 원하는 주소값으로 바꿔주면 됨.
	  					}else {
	  						// 실패
	  						alert("추가실패!");
	  					}
	  				}
	  				, error:function(){
	  					alert("추가 에러!!");
	  				}
	  			});
  				
  			});
  		
  		});
  	</script>
</body>
</html>