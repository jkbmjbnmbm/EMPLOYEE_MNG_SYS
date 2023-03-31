package com.ems.emsSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class emsSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	
		return http.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/auth/login", "/auth/validate").permitAll()
				.and()
				.build();
				
	}
}
