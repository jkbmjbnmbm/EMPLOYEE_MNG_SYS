package com.ems.AdminService.external.entities;

import java.sql.Date;

import javax.json.bind.annotation.JsonbDateFormat;

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
public class Employee {

	private String empId;
	private String name;
	private String gender;
	
	@JsonbDateFormat("dd/MM/yyyy")
	private Date birthDate;
	
	private long phone;
	private String maritalStatus;
	private String email;
	private String pass;
	private String mgrName;
}
