package com.jinju.spring.ex.lifecycle;

public class Person {
	
	// 멤버 변수 : 이름, 나이
	private String name;
	private int age;
	
	// 멤버 변수 어떻게 채울까 ? 
	// - 객체를 만들 때 이름과 나이가 생성과 동시에 채워지면 좋을것 같다고 판단
	// - 생성자를 통해서 채우자
	
	// 생성자는 클래스 이름과 동일한 이름을 가진 특수한 기능의 메서드이다
	public Person(String name, int age) {
		
		// 이 메서드를 통해서 위 멤버 변수의 값을 채울 것이다.
		// 파라미터로 멤버변수의 채울 값을 전달 받겠습니다
		// 멤버변수에 파라미터 값을 저장하는 과정에서 멤버 변수와 파라미터가 구분 되도록 하기 위해서
		// 멤버 변수 앞에는 this라는 키워드를 붙여서 해당하는 값을 저장시켜 준다.
		this.name = name;
		this.age = age;
	}

	// getter / setter 
	// public 이기 때문에 이 메서드들을 통해서 jackson 라이브러리가 여기 안에 있는 값을 끄집어내서 원하는 문자열을 만들 수 있다.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
