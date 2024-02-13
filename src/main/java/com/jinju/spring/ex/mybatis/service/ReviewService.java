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
	
	// storeid, menu, username, point , riview 내용을 전달 받아서 그 정보로 리뷰 내용을 저장하는 기능 만들기
	public int addReview(int storeId, String menu, String userName, double point, String review){
		// 파라미터로 받아 온 정보들을 실제로 리뷰에 저장을 해야 함
		// 저장은 테이블에 insert를 하는 과정 이다.
		// 테이블을 기반으로 기능 수행이 필요함 => repository에 위에 파라미터 값들을 다 전달 받고 처리 하기 위한 메소드 만들기
		int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
		return count;
	}
	
	// 리뷰 객체를 전달 받고 그 안에 있는 정보를 통해 리뷰 정보를 저장시켜주는 기능
	public int addReviewByObject(Review review) {
		// 저장은 테이블의 한 행을 insert 하는 과정 => repository 메소드 호출
		int count = reviewRepository.insertReviewByObject(review);
		
		return count;
	}
}
