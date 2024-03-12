package com.jinju.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	// 이름과 생년월일 전달 받고, 이름과 나이를 json으로 response에 담는 기능
	@GetMapping("/ajax/person")
	@ResponseBody // 해당 하는 map을 리턴만 해주면 이 map 형태 그대로 json 문자열이 response에 담김
	public Map<String, Object> personInfo(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday) {
		
		int year = Integer.parseInt(birthday.substring(0, 4));
		
		int age = 2024 - year + 1;
		
		// {"name":"김인규", "age":25} => json은 이런 형식으로 만들면 됨
		Map<String, Object> personMap = new HashMap<>();
		personMap.put("name", name);
		personMap.put("age", age);
		
		return personMap;
		
	}
	
	@GetMapping("/ajax/ex01")
	public String ex01() {
		return "ajax/ex01";
	}
}
