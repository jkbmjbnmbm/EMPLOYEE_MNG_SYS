package com.ems.AdminService.entities;

public enum Roles {
	
	EMPLOYEE("Employee"),
	ADMIN("Admin"),
	MANAGER("Manager");
	
	private String action;
	
	public String getAction() {
		return this.action;
	}


	private Roles(String action) {
		this.action = action;
	}


	
}
