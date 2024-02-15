package com.jinju.spring.ex.jsp.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinju.spring.ex.jsp.domain.User;

@Mapper
public interface UserRepository {

	public int insertUser(
			@Param("name") String name
			, @Param("birthday") String birthday
			, @Param("email") String email);
	
	// 가장 최근에 삽입된 행 조회
	// 리턴 타입은 가장 최근에 등록된 딱 한행이다 그럼 딱 한행 정보만 리턴되면 됨
	// Mybatis 활용해서 할거구 Mybatis를 통해서 조회된 결과는 Entity 클래스 기반으로 얻어오는게 좋을거 같음
	// 그래서 Entity 클래스 자체를 리턴 타입으로 잡아주면 됨
	// 한 행만 리턴할거니깐 List 가 아니라 User
	public User selectLastUser();
}
