package com.example.demo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientTwoApplication.class, args);
	}

}
