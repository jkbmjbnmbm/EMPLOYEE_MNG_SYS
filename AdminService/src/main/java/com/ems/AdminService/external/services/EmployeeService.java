package com.ems.AdminService.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.AdminService.external.entities.Employee;

import java.util.List;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeService {

	@PostMapping("/employees")
	public void addEmployee(Employee emp);
	
	@GetMapping("/employees")
	public List<Employee> getEmployees();
}
