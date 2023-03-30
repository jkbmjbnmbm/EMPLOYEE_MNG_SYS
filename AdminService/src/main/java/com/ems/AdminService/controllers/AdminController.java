package com.ems.AdminService.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.AdminService.entities.Users;
import com.ems.AdminService.external.entities.Employee;
import com.ems.AdminService.external.entities.Manager;
import com.ems.AdminService.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService aService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> list1 = aService.getAllEmployees();
		if (list1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list1));
	}
	
	@GetMapping("/managers")
	public ResponseEntity<List<Manager>> getManagers() {
		List<Manager> list1 = aService.getAllManagers();
		if (list1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list1));
	}

	@PostMapping("/addUser")
	public ResponseEntity<Void> createUser(@RequestBody Users u1) {

		try {
			aService.addUser(u1);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
