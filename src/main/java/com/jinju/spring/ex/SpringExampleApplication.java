package com.jinju.spring.ex;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
// 당장은 DB를 사용하지 않기 때문에 데이터베이스 설정을 잠시 잠그는 코드
// @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}

}
