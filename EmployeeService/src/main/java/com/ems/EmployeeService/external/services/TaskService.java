package com.ems.EmployeeService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.ems.EmployeeService.external.entities.Tasks;

@FeignClient(name = "TASK-SERVICE")
public interface TaskService {
	
	@GetMapping("/tasks/{tsk_ID}")
	public Tasks getTasks_id(@PathVariable String tsk_ID);

	@PutMapping("/tasks/{tsk_ID}")
	public void updateTask_ID(Tasks tsk, @PathVariable String tsk_ID);
	
	@GetMapping("/tasks/employee/{emp_ID}")
	public List<Tasks> getTasks_empid(@PathVariable String emp_ID);
}
