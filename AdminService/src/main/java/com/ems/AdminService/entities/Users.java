package com.ems.AdminService.entities;

import java.sql.Date;

import javax.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Auth_Users")
public class Users {

	@Id
	@Column(name = "ID")
	private String Id;

	@Column(name = "Name")
	private String name;
	
	@Transient
	@Column(name = "Gender")
	private String gender;
	
	@Transient
	@JsonbDateFormat("dd/MM/yyyy")
	@Column(name = "Birthday")
	private Date birthDate;
	
	@Transient
	@Column(name = "Contact")
	private long phone;
	
	@Transient
	@Column(name = "Marital Status")
	private String maritalStatus;
	
	@Column(name = "Username", unique = true)
	private String email;
	
	@Column(name = "Password")
	private String pass;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Role")
	private Roles role;
	
	public String getStrRole() {
		return role.getAction();
	}
	
	@Transient
	@Column(name = "ManagerID")
	private String mgrId;
	
	@Transient
	@Column(name = "ManagerName")
	private String mgrName;
}
