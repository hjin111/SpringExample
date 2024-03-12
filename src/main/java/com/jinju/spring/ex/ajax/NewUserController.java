package com.jinju.spring.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/ajax/user")
public class NewUserController {
	
	@Autowired
	private UserService userService;
	
	// response가 html로 화면 구성을 위한 페이지
	// view 페이지
	@GetMapping("/list")
	public String userList(Model model) {
		
		List<User> userList = userService.getUserList();
		
		model.addAttribute("userList", userList);
		
		return "ajax/user/list";
	}
	
	// json 형태로 response가 담겨서 response에 데이터만 저장되있는 상태인 경우는 API라고 표현
	// response 가 json 데이터 형태인 페이지 
	// API 
	@GetMapping("/create")
	@ResponseBody
	public Map<String, String> createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email) {
		
		int count = userService.addUser(name, birthday, email);
		
		// 우리가 만든 이 페이지를 ajax에서 쓸려고 만드는 중이다.
		// ajax 에서 쓸려고 만드는 경우에는 response에 어떤 데이터를 채운다? 
		// 말 그대로 데이터를 채울거임 입력된 이후에 전달할 수 있는 데이터
		// 성공실패 여부 -> 이런것도 데이터 
		// 의도한 대로 저장이 잘 됐는지 안됐는지를 데이터로 만들어서 response에 채워넣으면 됨
		// 성공 : json 형식에서 {"result":"success"}
		// 실패 : json 형식에서 {"result":"fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) { // 성공
			resultMap.put("result", "success");
			
		}else { // 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	
	}
	
	@GetMapping("/input")
	public String inputUser() {
		
		return "ajax/user/input";
	}
	
}
