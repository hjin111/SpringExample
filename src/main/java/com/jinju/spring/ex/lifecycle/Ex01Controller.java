package com.jinju.spring.ex.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex01Controller {
	
	@RequestMapping("/lifecycle/ex01/1") // 밑에 메서드의 결과물이 response에 담기도록 하는 urlMapping 해주기
	@ResponseBody
	public String stringResponse() {
		return "<h1>예제 1번 문자열 담기</h1>";
	}
	
	@RequestMapping("/lifecycle/ex01/2")
	@ResponseBody // 리턴된 객체가 그대로 response에 담기도록 해주는 어노테이션
	public Map<String, Integer> mapResponse() {
		
		// 과일이름 : 가격
		Map<String, Integer> fruitMap = new HashMap<>();
		
		fruitMap.put("apple", 1200);
		fruitMap.put("banana", 3000);
		fruitMap.put("orange", 1000);
		
		return fruitMap;
		
	}
}
