package com.jinju.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinju.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// id가 3인 행 조회 리턴 => 명확하게 한 행만 조회되는 형태의 쿼리 수행 메소드라면 entity 클래스로 타입 잡아주면 된다.
	public Review selectReview(@Param("id") int id);
	// 이제 해당하는 메소드가 호출 되었을 때 수행 될 쿼리를 매핑하러 이 repository와 연결된 xml로 간다.
	
	// 해당 하는 자바 변수가( int id ) 자바 변수 값이 xml 안에서 사용될 수 있도록 키워드를 하나 매칭 시켜 줄거다.
	// 해당하는 파라미터 앞에 @Param("id") 어노테이션을 추가함으로써 문자열 형태로 해당하는 파라미터 값을 xml에서 무슨 키워드로 사용할건지를 여기다가 매칭 시켜줌
	// 그리고 int id는 자바 문법이다 자바 문법으로써 파라미터를 하나 선언 해야 되고 그 파라미터 이름은 전달 될 값을 의미하는 키워드로 변수 이름을 지어진것뿐이다.
	// 이 변수 값이 사용되는 곳은 xml이고 xml에서 사용될 키워드는 @Param("id") 이 따옴표 안에 있는 값이다.
	
	
	// insert 한 이후 딱히 정보를 전달할게 없음 그래서 수행된 행의 개수가 정수로 return 됨
	public int insertReview(
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName")String userName
			, @Param("point")double point
			, @Param("review")String review); 
	
	public int insertReviewByObject(Review review);
	
	
}
