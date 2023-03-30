package com.ems.EmployeeService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.EmployeeService.external.entities.Leaves;

@FeignClient(name = "LEAVE-SERVICE")
public interface LeaveService {

	@GetMapping("/leaves/employee/{emp_ID}")
	public List<Leaves> getLeave_empid(@PathVariable String emp_ID);
	
	@PostMapping("/leaves/{emp_ID}")
	public void createLeave(Leaves lv, @PathVariable String emp_ID);
}
