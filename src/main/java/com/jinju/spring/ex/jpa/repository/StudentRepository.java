package com.jinju.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jinju.spring.ex.jpa.domain.Student;

// 어노테이션은 안붙여도 됨 필요한 어노테이션은 우리가 상속 받을 곳에 미리 부여 되어 있기 때문에 굳이 안해줘도 됨
public interface StudentRepository extends JpaRepository<Student, Integer>{ // 제너릭이 두 가지가 필요한데 첫 번째는 다룰 대상이 될 테이블에 Entity 클래스이다. 
	// 1행 삽입
	// 수정가능
	// 삭제 기능
	// 모든 행 조회 가능
	// primary key 기반 조회 가능
	
	// 그 메소드를 통해 어떤 조회를 하고 싶어 하는지를 정해진 규격에 따라서 만들어주면
	// 그걸 기반으로 JPA가 알아서 쿼리 수행 해줌
	
	// id 기준으로 내림차순으로 정렬한 모든 행 조회
	// ORDER BY `id` DESC
	public List<Student> findAllByOrderByIdDesc();
	
	// id를 기준으로 내림차순으로 정렬 후 하나만 조회
	// ORDER BY `id` DESC LIMIT 3
	public List<Student> findTop3ByOrderByIdDesc(); // 이거는 하나만 조회하는거라 객체로 리턴해주도록 해도 상관 없음.

	// 전달받은 값과 일치하는 name 컬럼을 가진 행 조회
	// WHERE `name` = #{name}
	public List<Student> findByName(String name); // 리턴 타입은 여러 행일수도 있어서 List 로 하기
	
	// 전달 받은 값들과 일치하는 name 컬럼을 가진 행 조회
	// WHERE `name` IN ('유재석', '조세호') // in 뒤에는 괄호 안에 name 컬럼에 들어갈 값들이 이렇게 나열이 되야 된다. 즉, name과 일치할 대상 문자열이 여러 개가 전달이 되어야 이게 나열이 될수 있겠다.
	public List<Student> findByNameIn(List<String> nameList); // 그래서 파라미터가 여러 값이 전달 될 수 있도록 List
	
	// 전달 받은 값이 포함된 email 컬럼을 가진 행 조회
	// WHERE `email` LIKE `%naver%` // LIKE 에 대한 조건은 Containing 라고 만들어 준다. 파라미터에 대한 부분은 `%naver%` 이 부분에 대한걸 전달 시켜 주면 된다.
	public List<Student> findByEmailContaining(String email);
	
	// id 컬럼의 값이 특정값 사이에 대응되는 데이터를 id 기준으로 내림차순으로 조회
	// WHERE `id` BETWEEN 1 AND 7 ORDER BY `id` DESC
	// 1 과 7 사이에 대응 되는 것만 조회가 되고 여기에 추가로 ORDER BY `id` DESC 까지 넣기
	public List<Student> findByIdBetweenOrderByIdDesc(int start, int end);
	
	// 쿼리를 활용한 조회
	// dreamJob 컬럼이 일치하는 데이터 조회
	// findByDreamJobQuery 이 메소드가 호출되었을 때 실행될 쿼리는 어떻게 매칭시키느냐??
	// 해당하는 메소드 위에다가 @Query() 라고 하는 어노테이션을 붙여서 괄호 안에 value 라는 속성에다가 query를 쭈욱 작성하면 된다. 
	@Query(value="SELECT * FROM `new_student` WHERE `dreamJob` = :dreamJob" , nativeQuery=true)
	// 해당 데이터 베이스 서버에 직접적으로 수행 할 쿼리 라고 해서 nativeQuery = true 라고 한다.
	public List<Student> findByDreamJobQuery(@Param("dreamJob")String dreamJob);

}
