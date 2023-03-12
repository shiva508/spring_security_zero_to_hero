package com.pool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StudentPoolDiscoveryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentPoolDiscoveryserviceApplication.class, args);
	}

}
