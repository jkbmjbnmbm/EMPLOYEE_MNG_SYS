package com.ems.LeaveService.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ems.LeaveService.external.entities.Employee;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeService {

	@GetMapping("/employees/{emp_ID}")
	public Employee getEmployeeByid(@PathVariable String emp_ID);

}