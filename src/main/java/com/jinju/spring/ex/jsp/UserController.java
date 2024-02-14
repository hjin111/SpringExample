package com.jinju.spring.ex.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinju.spring.ex.jsp.service.UserService;

@Controller
@RequestMapping("/jsp/user")
public class UserController {
	
	@Autowired
	private UserService userService; // 이 변수에 객체 생성은 spring한테 맡김. 그럼 해당 하는 변수를 사용할 때 알아서 객체를 주입시켜줌
	
	// 실제로 사용 될 수 있는 형태로 한 행을 insert 하는 기능을 만들거임
	// 요청에서부터 이름, 생년월일, 이메일을 전달 받고, 저장하는 페이지를 만들기
	// 기존에 insert는 mybatis에 집중 하기 위해서 저장 할 정보를 controller 직접 세팅을 했다.
	// 하지만 그렇게 만들면 안됨 요청하는 쪽에서 필요한 정보를 저장해야지 정해진 값만 저장하면 안됨
	// 이름, 생년월일, 이메일 이 3개의 정보를 모두 requestParameter로 전달 받을거임
	// 모든 파라미터 들은 다 requestParameter로 지정된 파라미터 이름으로 전달된 값을 변수에 파라미터로 저장해서 쓸것이다. 
	//@RequestMapping(path="/jsp/user/create", method=RequestMethod.GET) // requestMapping 안에 설정이 들어가 있는데 그걸 생략한 상태였던거임
																		// 어떻게 들어가있냐면 @RequestMapping(path="/jsp/user/create", method=RequestMethod.GET) 이게 생략되어져 있는 상태
	@GetMapping("/create")// Get 메소드를 통해서 페이지를 만들고 url 매핑하겠다
	@ResponseBody
	public String createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email){
		
		int count = userService.addUser(name, birthday, email);
		
		return "수행 결과 : " + count;
	}
	
	// 특정 위치에 있는 jsp 내용을 htmlresponse로 만들어서 전달할수있도록 해주는 메소드이다
	// jsp 경로를 리턴할거임
	@GetMapping("/input")
	public String inputUser() {
		// @ResponseBody 어노테이션 붙으면 경로로 인식 안하고 그냥 순수한 문자열로 인식해서 responsebody에 문자열로 담아버림 
		return "jsp/userInput";
	}
	
}
