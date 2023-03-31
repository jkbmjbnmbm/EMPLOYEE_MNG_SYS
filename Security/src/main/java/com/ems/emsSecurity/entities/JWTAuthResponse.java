package com.ems.emsSecurity.entities;

import lombok.Data;

@Data
public class JWTAuthResponse {

	private String token;
	private UserDto user;
	
	public JWTAuthResponse(String token) {
		super();
		this.token = token;
	}
	
}
