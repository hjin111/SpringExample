package com.jinju.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinju.spring.ex.mybatis.domain.Review;
import com.jinju.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository; // 멤버 변수에다가 객체를 생성해서 채우는 과정은 직접 하는게 아니라 Autowired 어노테이션을 통해서 딱 하나 이 멤버 변수만 관리함
											  // 하나씩 매칭이 되는 어노테이션이고 이 어노테이션을 통해서 이 변수의 값은, 객체 생성은 자동으로 주입하는 형태로 만들어준다
	
	// 전달된 id를 가진 리뷰 정보 돌려주는 기능
	public Review getReview(int id) {
		// repository에 있는 메소드를 통해서 id가 3인 행에 정보를 얻어와야 함
		Review review = reviewRepository.selectReview(id);
		return review;
	}
	
	// service 메소드에서 작성한 내용은 어떠한 사용법도 없는 순수한 자바 코드이다.
}
