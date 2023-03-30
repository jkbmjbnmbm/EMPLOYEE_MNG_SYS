package com.ems.ManagerService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ems.ManagerService.external.entities.Employee;

@FeignClient(name="EMPLOYEE-SERVICE")
public interface EmployeeService {

	@GetMapping("/employees/manager/{mgr_ID}")
	public List<Employee> getEmployee_by_mgrid(@PathVariable String mgr_ID);
	
	@GetMapping("/employees/{emp_ID}")
	public Employee getEmployee_id(@PathVariable("emp_ID") String id);
}
