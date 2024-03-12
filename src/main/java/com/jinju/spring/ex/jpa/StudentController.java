package com.jinju.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinju.spring.ex.jpa.domain.Student;
import com.jinju.spring.ex.jpa.repository.StudentRepository;

@Controller
@RequestMapping("/jpa/student")
public class StudentController {
	
	// Controller에서는 Repository 객체 사용 금지
	// 편의를 위해 잠시 사용
	@Autowired
	private StudentRepository studentRepository;
	
	// 한 학생의 정보를 저장하기 위한 페이지
//	@GetMapping("/jpa/student/create")
//	public createStudent(){
//		// 김인규, 010-1234-5678, lecture@hagulu.com, 개발자
//		// 이 4가지 정보를 전달 받고 저장해주는 기능 => controller가 할 일이 아님 service 한테 시키기
//		
//		
//	}
	
	
	@GetMapping("/select")
	@ResponseBody
	public List<Student> selectStudent() {
		
		// 파라미터 없이 모든 행 조회
		// 이 과정은 특별히 Service 없이 바로 Repository 접근 하기
		// Controller 에서 직접 repository 객체를 통해 메소드를 호출하는건 하면 안되는 경우인데 우리 지금 repository 쪽에 집중 하기 위해서 굳이 메소드 하나 만들어서 service 사용하는게 번거롭기 떄문에 service 빼고 진행할거임
		// 원래 이렇게 하면 안됨.
//		List<Student> studentList = studentRepository.findAll(); // 모든 행을 조회하는 거니깐 list 로 리턴을 해주는데 mybatis 랑 똑같다 한 행, 한 행 정보는 Entity 클래스, 그래서 제너릭을 Entity 클래스로 잡아준다.
		
//		List<Student> studentList = studentRepository.findAllByOrderByIdDesc();
		
//		List<Student> studentList = studentRepository.findTop3ByOrderByIdDesc(); // 딱 3 행만 조회
		
//		List<Student> studentList = studentRepository.findByName("유재석");
	
//		List<String> nameList = new ArrayList<>();
//		nameList.add("유재석");
//		nameList.add("조세호");
//		
//		List<Student> studentList = studentRepository.findByNameIn(nameList);
		
// 		List<Student> studentList = studentRepository.findByEmailContaining("naver");
//		List<Student> studentList = studentRepository.findByIdBetweenOrderByIdDesc(1, 7);
		
		List<Student> studentList = studentRepository.findByDreamJobQuery("모델");
		
		return studentList; // 모든 행을 조회한 결과를 list 로 얻어내고 그 list를 response body 기반으로 response body 에 담아서 응답으로 돌려준다. 해당 하는 list 객체는 JSON 문자열로 변환되서 response에 담길 거다.
	}
	
	

	@GetMapping("/jpa/lombok/test")
	@ResponseBody
	public Student lombokTest() {
		
		// Student student = new Student(5,"김인규", "010-1234-5678", "lecture@hagulu.com", "개발자", null, null);
//		student.setName("김인규");
//		student.setDreamJob("개발자");
//		student.setPhoneNumber("010-1234-5678");
//		student.setEmail("lecture@hagulu.com");
		
		// builder 패턴의 객체 생성 - 객체를 생성할 떄 생성자가 아니라 클래스 이름.builder 라고 붙여준 담에 저장할 멤버변수를 나열해주면 됨
		Student student = Student.builder()
								.name("김인규")
								.dreamJob("개발자")
								.phoneNumber("010-1234-5678")
								.email("lecture@hagulu.com")
								.build();
		
		return student;
		
	}
	
}
