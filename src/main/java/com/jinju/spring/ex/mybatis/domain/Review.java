package com.jinju.spring.ex.mybatis.domain;

import java.util.Date;

public class Review {
	
	// 멤버 변수 
	private int id;
	private int storeId;
	private String menu;
	private String userName;
	private double point;
	private String review;
	private Date createdAt;
	private Date updatedAt;
	
	// 이거 자체로는 mybatis에서 직접 생성해서 관리하도록 맡길 수가 없음 => 캡슐화 되어 있기 때문에 getter/setter 사용
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
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
