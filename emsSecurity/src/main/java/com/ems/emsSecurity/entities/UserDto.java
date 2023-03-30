package com.ems.emsSecurity.entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@Id
	private String Id;
	private String name;
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Roles role;

}
