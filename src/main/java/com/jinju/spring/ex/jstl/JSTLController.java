package com.jinju.spring.ex.jstl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jstl")
public class JSTLController {

	@GetMapping("/ex01") // 파라미터가 있으면 고민할 거리가 있는데 파라미터가 없으면 그냥 GetMapping
	public String ex01() {
		return "jstl/ex01"; // jsp 있는 내용이 response 에 담기도록 경로를 문자열 형태로 리턴해준다.
	}
	
	// 해당 하는 jsp를 응답으로 전달 받을려면 controller 에서 url 매핑 해줘야 함
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		// 과일 이름 리스트
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("귤");
		fruitList.add("바나나");
		
		model.addAttribute("fruitList", fruitList);
		
		List<Map<String, Object>> userList = new ArrayList<>();
		
		// 똑같은 형태의 데이터이다. 
		// 값은 다른 부분이 있지만 규격은 둘 다 똑같다 그러면 이 두 개의 map을 list에 저장해서 다루어주면 좋을것같음
		Map<String, Object> userMap1 = new HashMap<>();
		userMap1.put("name", "김인규");
		userMap1.put("age", 29);
		userMap1.put("hobby", "독서");
		
		Map<String, Object> userMap2 = new HashMap<>();
		userMap2.put("name", "김바다");
		userMap2.put("age", 5);
		userMap2.put("hobby", "사냥하기");
		
		userList.add(userMap1);
		userList.add(userMap2);
		
		model.addAttribute("userList", userList);
	
		return "jstl/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		// 오늘 날짜 시간을 저장하는 Date 객체를 하나 만들어서 model에 세팅해보기
		Date now = new Date();
		
		model.addAttribute("now", now);
		return "jstl/ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04() {
		return "jstl/ex04";
	}
	
}
