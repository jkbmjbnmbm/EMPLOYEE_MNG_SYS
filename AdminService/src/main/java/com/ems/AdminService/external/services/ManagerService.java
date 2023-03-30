package com.ems.AdminService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.AdminService.external.entities.Manager;

@FeignClient(name = "MANAGER-SERVICE")
public interface ManagerService {

	@PostMapping("/managers")
	public void addManager(Manager mgr);
	
	@GetMapping("/managers")
	public List<Manager> getManagers();
}
