package com.jinju.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinju.spring.ex.mybatis.domain.Review;
import com.jinju.spring.ex.mybatis.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	// 전달된 id를 가진 리뷰정보를 json으로 response에 담는다.
	// 이 페이지를 요청하는 쪽에서 전달할 값으로 그에 해당하는 리뷰 정보를 response에 담는다.
	// 웹 페이지에서 전달하는 값은 뭘로 관리가 된다? request paramter ( 웹 페이지를 요청하는 과정에서 값을 전달한다는 의미는 request 파라미터를 통해 값을 전달 하는 거다. )
	// get 방식 => /mybatis/review?id=3
	@RequestMapping("/mybatis/review")
	@ResponseBody
	public Review review(@RequestParam("id") int id) { // String id = request.getParameter("id") 이 과정을 어노테이션을 통해 자바 파라미터 처럼 표현해주도록 만들어준 문법이다.
		
		Review review = reviewService.getReview(id);
		return review;
		
		// 메소드에 파라미터 처럼 기본 문법 만들어준다음에 id 이 변수에 파라미터 값이 저장되도록 할거다.
		// 그 때 id 여기에 저장 될 값이 어떤 파라미터 이름으로 매칭이 될건지를 @RequestParam("id") 어노테이션을 통해 
		// 파라미터 이름을 매칭시켜 주면 @RequestParam("id") 여기 안에 있는 이름으로 전달된 파라미터 값이 id에 저장됨
		// 단 @RequestParam("id") 정의된 파라미터가 전달되지 않으면 status 코드 400 에러가 남
	}
}
