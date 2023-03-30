package com.ems.AdminService.external.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Manager {

	private String mgrId;
	private String name;
	private String email;
	private String pass;
}
