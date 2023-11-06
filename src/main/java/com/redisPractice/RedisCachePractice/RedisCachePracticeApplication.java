package com.redisPractice.RedisCachePractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisCachePracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCachePracticeApplication.class, args);
	}

}
