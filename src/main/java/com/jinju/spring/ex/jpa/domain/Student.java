package com.jinju.spring.ex.jpa.domain;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@AllArgsConstructor // 모든 멤버 변수의 값을 채워주는 생성자
//@Setter
//@Getter
//@Builder // Builder 패턴 객체 생성을 굉장히 쉽게 할 수 있음 ( 롬복 없이도 동작하는 자바 문법인데 이걸 손쉽게 설정 할 수 있도록 해주는 어노테이션 ), 이걸 활용해서 builder 패턴이라고 하는 형식으로 객체를 생성할 수 있다.
@Builder
@NoArgsConstructor // 기본 생성자 ( 인자가 전달 되지 않는 생성자 )
@AllArgsConstructor
@Getter
@Table(name="new_student")
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	// 카멜 케이스로 정의된 컬럼은 정확한 컬럼이름 매칭
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	// 자동으로 현재시간이 저장될 컬럼
	@UpdateTimestamp 
	// 이렇게 설정 해놓으면 무조건 수정이 되어서 create, insert, update 될 때도 수정이 된다.
	// update 될때는 수정되지 않도록
	@Column(name="createdAt", updatable = false)
	private Date createdAt;
	
	// 이 컬럼은 업데이트 될 떄마다 수정되는게 맞음
	@UpdateTimestamp 
	@Column(name="updatedAt")
	private Date updatedAt;

}

// 이제 Entity 클래스 할 일이 되게 많다.
// 왜냐면 이 Entity 클래스를 기반으로 이 테이블을 분석해서 알아서 쿼리 수행을 해 주는 거기 때문에
// 이 Entity 클래스에 테이블에 매칭될 여러 속성들을 설정해줘야 함
// 먼저 첫 번째로는 이 클래스가 Entity 클래스 라는 걸 명확히 해주는 @Entity 라고 하는 어노테이션을 붙여 준다.
// 두번쨰로는 Table 이라는 어노테이션을 통해서 이 Entity 클래스가 정확하게 어떤 테이블과 매칭이 된건지를 name 이라는 속성을 통해 지정해준다. ( import 할 떄는 persistence 라는 키워드 붙어 있는 것들이 대부분이다. )
// 그 다음에는 Getter 와 Setter 가 필요합니다. 그리고 나서 생성자도 필요한데 지난 시간에 만들어 놨던 모든 멤버 변수를 전달 받고 멤버 변수를 채워주는 생성자 직접 만들 수 있지만 롬복을 통해서 @AllArgsConstructor 어노테이션 붙이기
// 그리고 기본 생성자도 필요하다. @NoArgsConstructor 어노테이션 붙이기
// 그리고 또 하나 이제 객체 생성, 이 Entity 클래스의 객체 생성은 Builder 패턴으로 만들어 갈거다 @Builder 어노테이션 붙이기
// 그리고 이제 컬럼에 대한 설명도 필요한 부분들은 추가해줘야 한다.
// 첫 번째 프라이머리 키에 대한 거를 설정해 줘야 한다. 그래서 primary key에 대한 멤버 변수 위에 이게 프라이머리 키다 라는걸 의미 하는 Id 라는 어노테이션을 추가해준다. ( 이것도 persistence 라는 키워드가 들어 있는 이 놈으로 import 해 주기 )
// 그리고 나서 이 멤버 변수에 또 하나 추가 한다. @GeneratedValue 옵션으로 @GeneratedValue(strategy=GenerationType.IDENTITY) 이것까지 설정하면 프라이머리 키에 대한 설정은 다 끝났다
// 멤버 변수가 카멜 케이스로 구성이 되어 있는 형태면 @Column(name="phoneNumber") 컬럼이라는 어노테이션을 통해서 name 이라는 속성으로 컬럼 이름을 매칭 시켜 준다.
// 또 하나 createdAt, updatedAt도 신경 써줘야 한다.
// 첫 번쨰 

