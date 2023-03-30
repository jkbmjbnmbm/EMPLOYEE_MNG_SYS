package com.ems.EmployeeService.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ems.EmployeeService.external.entities.Manager;

@FeignClient(name = "MANAGER-SERVICE")
public interface ManagerService {

	@GetMapping("/managers/mname/{mgr_name}")
	public Manager getByname(@PathVariable String mgr_name);

}
