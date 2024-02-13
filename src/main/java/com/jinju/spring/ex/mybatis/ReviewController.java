package com.jinju.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinju.spring.ex.mybatis.domain.Review;
import com.jinju.spring.ex.mybatis.service.ReviewService;

@Controller
@RequestMapping("/mybatis/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	// 전달된 id를 가진 리뷰정보를 json으로 response에 담는다.
	// 이 페이지를 요청하는 쪽에서 전달할 값으로 그에 해당하는 리뷰 정보를 response에 담는다.
	// 웹 페이지에서 전달하는 값은 뭘로 관리가 된다? request paramter ( 웹 페이지를 요청하는 과정에서 값을 전달한다는 의미는 request 파라미터를 통해 값을 전달 하는 거다. )
	// get 방식 => /mybatis/review?id=3
	@RequestMapping("/")
	@ResponseBody
	public Review review(@RequestParam("id") int id) { // String id = request.getParameter("id") 이 과정을 어노테이션을 통해 자바 파라미터 처럼 표현해주도록 만들어준 문법이다.
		
		Review review = reviewService.getReview(id);
		return review;
		
		// 메소드에 파라미터 처럼 기본 문법 만들어준다음에 id 이 변수에 파라미터 값이 저장되도록 할거다.
		// 그 때 id 여기에 저장 될 값이 어떤 파라미터 이름으로 매칭이 될건지를 @RequestParam("id") 어노테이션을 통해 
		// 파라미터 이름을 매칭시켜 주면 @RequestParam("id") 여기 안에 있는 이름으로 전달된 파라미터 값이 id에 저장됨
		// 단 @RequestParam("id") 정의된 파라미터가 전달되지 않으면 status 코드 400 에러가 남
	}
	
	// 리뷰에 한 행을 추가하는 기능
	@RequestMapping("/insert")
	@ResponseBody // 이걸 붙여야 return 된 문자열이 responsebody 에 그대로 담길거임
	public String createReview() {
		
		// 4, 치즈피자, 김인규, 4.5, 치즈피자 존맛! => 하나 하나 따로 나열
		// 위에 내용을 저장하고자 함 => 기능 수행은 service한테 시키기
		// int count = reviewService.addReview(4, "치즈피자", "김인규", 4.5, "치즈피자 존맛!");
		
		
		// 2, 뿌링클, 김인규, 4.0, 역시 뿌링클은 진리입니다. => 하나로 묶어서 다루어 보기
		Review review = new Review(); // 생성자 따로 안 만들어서 기본 생성자로 생성하기
		// setter 를 통해서 하나씩 값을 채워 넣기
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다.");
		// 이 객체 안에 들어 있는 정보를 기반으로 하나의 리뷰 정보를 저장해보려고 함
		// service 한테 이 객체 전달해서 여기 있는 정보 다 저장해줘 라는 기능을 수행 시키기
		
		int count = reviewService.addReviewByObject(review);
		
		return "수항결과 : " + count;
		
	}
}
