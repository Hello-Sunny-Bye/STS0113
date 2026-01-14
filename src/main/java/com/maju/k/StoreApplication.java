package com.maju.k;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


// 컴포넌트 스캐너 비지니스 레이어 프레젠테이션 레이어 순으로 
//레이어를 연결해줌 


@ComponentScan(basePackages= {"com.korea","com.maju"})
@EntityScan(basePackages= {"com.korea","com.maju"})
@EnableJpaRepositories(basePackages = {"com.korea","com.maju"})



@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

}
