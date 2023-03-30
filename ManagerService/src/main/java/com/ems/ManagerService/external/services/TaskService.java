package com.ems.ManagerService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.ManagerService.external.entities.Tasks;

@FeignClient(name = "TASK-SERVICE")
public interface TaskService {

	@PostMapping("/tasks/{emp_ID}")
	public void createTasks(Tasks tsk, @PathVariable String emp_ID);
	
	@GetMapping("/tasks/manager/{mgr_ID}")
	public List<Tasks> getTasks_mgrid(@PathVariable String mgr_ID);
}
