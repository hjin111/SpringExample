package com.jinju.spring.ex.database.domain;

import java.util.Date;

// used_goods 라는 테이블의 한 행의 정보를 모두 저장하기 위한 클래스
// 테이블 이름과 일치하는 멤버변수 만들기
// Domain, Entity 클래스라고 부른다. ( 테이블에 있는 컬럼 이름이 정확히 일치하는 멤버변수를 가진 클래스를 도메인 클래스, Entity 클래스 라고 부른다 )
public class UsedGoods {

	private int id;
	private int sellerId;
	private String title;
	private int price;
	private String description;
	private String image;
	private Date createdAt;
	private Date updatedAt;
	
	// 이 클래스는 우리가 직접 객체를 만들어서 사용할 수도 있지만 이 놈은 여러 framework나 라이브러리가 직접 만들고 다루는게 훨씬 더 많다. 
	// 그때 가장 일반적으로 쓰이는 방법으로 해당 멤버 변수를 다루도록 동작한다.
	// 그럼 멤버 변수를 가장 일반적인 형식으로 다루는 방법은 private 으로 캡슐화 해 놓고 getter / setter를 통해서 사용할 수 있도록 해준다.
	
	public int getId() {
		return id;
	}	
	public void setId(int id) {
		this.id = id;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
