package com.jinju.spring.ex.jsp.domain;

import java.util.Date;

public class User {
	
	// 조회 메소드에서 리턴할 타입을 정의 하려고 만듬 
	
	// 멤버 변수
	private int id;
	private String name;
	private String yyyymmdd;
	private String email;
	private String introduce;
	private Date createdAt;
	private Date updatedAt;
	
	// 해당 Entity 클래스는 Mybatis에 의해서도 자동으로 객체 생성 되서 값이 세팅이 되고 
	// EL 태그를 통해서 자동으로 객체 안에 있는 멤버변수들을 막 끄집어내서 쓸거임
	// 멤버 변수다 보니 다 private 으로 접근 제어자가 처리가 되어 있음
	// 그럼 이 값들을 접근할 수 있는 방법을 만들어줘야 하는데 
	// 일반적으로 쓰여서 규격 까지 만들어져 있는 getter / setter 로 만들기
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYyyymmdd() {
		return yyyymmdd;
	}
	public void setYyyymmdd(String yyyymmdd) {
		this.yyyymmdd = yyyymmdd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
