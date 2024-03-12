package com.jinju.spring.ex.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinju.spring.ex.jsp.domain.User;
import com.jinju.spring.ex.jsp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public int addUser(String name, String birthday, String email) {
		int count = userRepository.insertUser(name, birthday, email);
		return count;
	}
	
	// user 객체를 만들어서 전달하기 위한 Service 메소드를 만들기
	public int addUserByObject(User user){
		int count = userRepository.insertUserByObject(user);
		return count;
	}
	
	// 가장 최근에 등록된 사용자 정보 얻기 기능
	public User getLastUser() {
		// 한 행만 조회한 거기 때문에 List 가 아니라 해당하는 객체 자체 리턴 
		User user = userRepository.selectLastUser();// 한 행의 정보를 Entity 클래스 객체로 만들어서 리턴해준다 
		return user;
	}
	
	public List<User> getUserList() {
		List<User> userList = userRepository.selectUserList();
		
		return userList;
	}
	
}
