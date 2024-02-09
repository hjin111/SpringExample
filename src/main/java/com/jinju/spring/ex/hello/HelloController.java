package com.jinju.spring.ex.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@ResponseBody // 메서드에서 return 된 내용이 responsebody에 담기도록 해주는 어노테이션
	@RequestMapping("/hello") // url 매핑을 위한 어노테이션
	public String hello() {
		return "Hello World";
	}
}
