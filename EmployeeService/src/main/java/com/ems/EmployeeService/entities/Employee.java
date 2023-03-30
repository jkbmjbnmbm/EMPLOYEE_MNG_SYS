package com.ems.EmployeeService.entities;

import java.sql.Date;

import javax.json.bind.annotation.JsonbDateFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee_records")
public class Employee {
	
	@Id
	@Column(name = "EmpID")
	private String empId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Gender")
	private String gender;
	
	@JsonbDateFormat("dd/MM/yyyy")
	@Column(name = "Birthday")
	private Date birthDate;
	
	@Column(name = "Contact")
	private long phone;
	
	@Column(name = "Marital Status")
	private String maritalStatus;
	
	@Column(name = "Email", unique = true)
	private String email;
	
	@Column(name = "Password")
	private String pass;
	
	@Column(name = "ManagerID")
	private String mgrId;
	
	@Column(name = "ManagerName")
	private String mgrName;
	
}
