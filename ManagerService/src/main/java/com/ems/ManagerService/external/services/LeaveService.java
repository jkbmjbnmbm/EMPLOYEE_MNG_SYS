package com.ems.ManagerService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.ems.ManagerService.external.entities.Leaves;

@FeignClient(name = "LEAVE-SERVICE")
public interface LeaveService {

	@GetMapping("/leaves/manager/{mgr_ID}")
	public List<Leaves> getLeave_mgrid(@PathVariable String mgr_ID);
	
	@GetMapping("/leaves/{lv_ID}")
	public Leaves getLeave_id(@PathVariable("lv_ID") String id);
	
	@PutMapping("/leaves/{lv_ID}")
	public void updateLeave_ID(Leaves lv, @PathVariable String lv_ID);
	
}
