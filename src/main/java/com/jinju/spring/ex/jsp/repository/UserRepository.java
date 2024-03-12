package com.jinju.spring.ex.jsp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinju.spring.ex.jsp.domain.User;

@Mapper
public interface UserRepository {

	public int insertUser(
			@Param("name") String name
			, @Param("birthday") String birthday
			, @Param("email") String email);
	
	// 기존 insert 메소드와는 다른 형태 메소드
	// insert 하고 나서 그 insert 된 행의 id 컬럼, primary key 값을 얻어 오기 위해서는 값을 하나하나 전달 하는 형태가 아니라 객체 형태로 값을 전달하도록 파라미터가 구성이 되어야 한다. 
	public int insertUserByObject(User user);
	
	// 가장 최근에 삽입된 행 조회
	// 리턴 타입은 가장 최근에 등록된 딱 한행이다 그럼 딱 한행 정보만 리턴되면 됨
	// Mybatis 활용해서 할거구 Mybatis를 통해서 조회된 결과는 Entity 클래스 기반으로 얻어오는게 좋을거 같음
	// 그래서 Entity 클래스 자체를 리턴 타입으로 잡아주면 됨
	// 한 행만 리턴할거니깐 List 가 아니라 User
	public User selectLastUser();
	
	public List<User> selectUserList();
	
}
