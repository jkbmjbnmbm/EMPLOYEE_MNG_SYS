package com.ems.emsSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmsSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsSecurityApplication.class, args);
	}

}
