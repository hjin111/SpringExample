package com.jinju.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/lifecycle/ex01")
@RestController // @Controller + @ResponseBody
				// 이 클래스 안에 포함되어있는 모든 페이지들은, 모든 메서드는 ResponseBody 어노테이션이 자동으로 부여됩니다. 그래서 굳이 붙여줄 필요 없다
				// 그래서 Controller 웹 페이지를 위한 클래스라는 기본 설정에다가 ResponseBody 어노테이션의 기능 까지 부여됨
public class Ex01RestController {
	
	// 직접 만든 클래스 객체 리턴
	@RequestMapping("/3")
	public Person objectResponse() {
		Person me = new Person("이혜진", 25); // 객체 생성 하기 위해서는 생성자를 호출해야 하는데 기본 생성자는 없어졌다 왜? 우리가 직접 생성자를 만들었으니깐
		// 이름과 나이를 순서대로 전달을 하면 그 전달된 값이 멤버 변수로 저장된 객체가 생성이 된다
		
		return me;
	}
	
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse(){
		Person me = new Person("이혜진", 25);
		// HTTP Status Code
		// 요청에 대한 응답으로 이 요청에 문제가 있는지 아닌지를 코드로 알려주는 정보이다.
		// 200(일반적으로 정상적으로 처리된 응답) OK (200은 OK이라는 문자열로 표현이 된다)
		// 404(요청에 의한 에러와 관련된 코드) Not Fuound : 페이지가 없음 (주소 확인)
		// 405 Method Not Allow : 메소드가 일치 하지 않음 (Get, Post)
		// 400 Bad Request : 요청 잘못됨 (파라미터 일치 확인)
		// 500 Internal Server Error : 서버 에러 (클래스 자바 코드확인)
		
		ResponseEntity<Person> entity = new ResponseEntity(me, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}
