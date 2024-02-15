package com.jinju.spring.ex.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinju.spring.ex.jsp.domain.User;
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
	
	@GetMapping("/info") // RequestMapping 말고 사용할 메소드에 맞춰서 어노테이션 선택한다
	public String userInfo(Model model) { // jsp 경로를 리턴하기 위해 String 으로 리턴 타입 잡아준다
		// 리턴하는 jsp 경로에서 채우고 싶은 데이터는 
		// 가장 최근에 추가된 사용자 정보 
		// 데이터 베이스 조회는 Controller가 Service를 통해서 얻어 와야 함
		// 데이터를 채우고 싶은 jsp를 리턴하는 이 메소드 안에서 일단 데이터 얻어오기
		// 가장 최근에 추가된 사용자 정보를 얻어오기 위해선 Service 에서 이 기능을 수행해 주는 메소드 호출해야 함
		
		
		// 메소드를 통해서 jsp 경로를 리턴해서 해당하는 url(/info)로 이 jsp(jsp/userInfo)를 response에 담기로 한건데 
		// 이 jsp 안에서 우리가 특정 데이터를 조회해서 쓰고 싶은거임 근데 MVC 패턴을 명확하게 구분해야 하기 때문에 
		// 해당하는 jsp 에서 데이터를 직접 조회할 순 없고 우리가 원래 하던 대로 MVC 패턴에 따라 Controller는 Service를 통해서 
		// 기존에 Service 객체를 멤버 변수 형태로 Autowired로 해놨기 때문에 필요한 곳에서 맘껏 사용하면 됨
		User user = userService.getLastUser();
		// 문제는 user 객체를 jsp/userInfo 여기로 바로 전달 할 방법은 없다.
		// 완전 서로 독립되어 있는 스타일 이기 때문에 이 둘을 직접적으로 연계해서 값을 쓰도록 할 수는 없는데
		// 중간 매개체가 하나 있음 바로 Model
		// Model 이란 것을 객체를 통해서 Controller가 값을 채울 수 있고 jsp에서는 해당 하는 Model의 값을 꺼내다가 쓸 수 있으니깐 Model애다가 값을 채울거임
		// 이 model 객체에다가 jsp 에서 사용됐으면 하는 데이터를 채워주면 된다.
		// 인자가 두개 들어가는 첫 번째는 key ( 해당 하는 객체를 어떤 이름으로 저장할지 ), 두 번째 인자로 이 key 로 저장할 실제 객체 값
		// response를 만드는 과정
		model.addAttribute("result", user);
		model.addAttribute("title", "사용자 정보");
		
		return "jsp/userInfo"; // 해당 jsp 경로를 찾아서 그 결과물 html을 response로 전달하도록 하는 페이지가 이 info 페이지가 된다.( responsbody는 있으면 안됨 )
		
		// 딱 이 메소드 안에서 리턴한 이 경로에 jsp에서만 이 메소드 안에서 채워넣은 이 model 객체를 사용할 수 있는 거다. 
	}
	
}
