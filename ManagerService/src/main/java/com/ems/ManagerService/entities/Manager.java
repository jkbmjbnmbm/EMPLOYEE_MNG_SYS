package com.ems.ManagerService.entities;

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
@Table(name = "Manager_records")
public class Manager {

	@Id
	@Column(name = "ManagerID")
	private String mgrId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Email", unique = true)
	private String email;
	
	@Column(name = "Password")
	private String pass;
	
	
	
}
