package com.ems.ManagerService.external.entities;

import java.sql.Date;

import javax.json.bind.annotation.JsonbDateFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private String empId;
	private String name;
	private String gender;
	
	@JsonbDateFormat("dd/MM/yyyy")
	private Date birthDate;
	
	private long phone;
	private String maritalStatus;
	private String email;
	private String mgrName;
}