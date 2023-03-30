package com.ems.LeaveService.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.LeaveService.services.LeaveService;
import com.ems.LeaveService.entities.Leave;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

	@Autowired
	private LeaveService lService;

	// READ all Leaves handler
	@GetMapping
	public ResponseEntity<List<Leave>> getLeaves() {
		List<Leave> lisl1 = lService.getAllLeaves();
		if (lisl1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(lisl1));
	}

	// READ leaves applied by id handler
	@GetMapping("/{lv_ID}")
	public ResponseEntity<Leave> getLeave_id(@PathVariable("lv_ID") String id) {
		Leave lv = lService.getLeaveByid(id);
		if (lv==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(lv));
	}

	// READ leaves applied by specific employee handler
	@GetMapping("/employee/{emp_ID}")
	public ResponseEntity<List<Leave>> getLeave_empid(@PathVariable("emp_ID") String id) {
		List<Leave> lisl1 = lService.getLeaveByEmpid(id);
		if (lisl1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(lisl1));
	}

	// READ leaves applied to specific manager handler
	@GetMapping("/manager/{mgr_ID}")
	public ResponseEntity<List<Leave>> getLeave_mgrid(@PathVariable("mgr_ID") String id) {
		List<Leave> lisl1 = lService.getLeaveByMgrid(id);
		if (lisl1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(lisl1));
	}

	// ADD new leave handler
	@PostMapping("/{emp_ID}")
	public ResponseEntity<Void> createLeave(@RequestBody Leave lv, @PathVariable String emp_ID) {

		try {
			lService.saveLeave(lv, emp_ID);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// UPDATE leave status handler
	@PutMapping("/{lv_ID}")
	public ResponseEntity<Leave> updateLeave_ID(@RequestBody Leave lv, @PathVariable("lv_ID") String id) {
		try {
			lService.updateLeavebyID(lv, id);
			return ResponseEntity.ok().body(lv);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
