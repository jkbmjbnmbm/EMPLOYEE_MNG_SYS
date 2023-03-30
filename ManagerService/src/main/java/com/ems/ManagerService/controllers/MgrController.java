package com.ems.ManagerService.controllers;

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

import com.ems.ManagerService.entities.Manager;
import com.ems.ManagerService.external.entities.Employee;
import com.ems.ManagerService.external.entities.Leaves;
import com.ems.ManagerService.external.entities.Tasks;
import com.ems.ManagerService.services.MgrService;

@RestController
@RequestMapping("/managers")
public class MgrController {

	@Autowired
	private MgrService mService;

	// READ all Managers handler
	@GetMapping
	public ResponseEntity<List<Manager>> getManagers() {
		List<Manager> list1 = mService.getAllManagers();
		if (list1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list1));
	}

	// READ specific employee handler by id
	@GetMapping("/employee/{emp_ID}")
	public ResponseEntity<Employee> getEmployee_id(@PathVariable("emp_ID") String id) {
		Employee emp = mService.getEmployeeByid(id);
		if (emp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(emp));
	}

	// READ specific manager handler by id
	@GetMapping("/mid/{mgr_ID}")
	public ResponseEntity<Manager> getManager_id(@PathVariable("mgr_ID") String id) {
		Manager mgr = mService.getManagerByid(id);
		if (mgr == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(mgr));
	}

	// READ specific manager handler by name
	@GetMapping("/mname/{mgr_name}")
	public ResponseEntity<Manager> getManager_name(@PathVariable("mgr_name") String name) {
		Manager mgr = mService.getManagerByname(name);
		if (mgr == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(mgr));
	}

	// ADD new manager handler
	@PostMapping
	public ResponseEntity<Void> createManager(@RequestBody Manager m) {

		try {
			mService.saveManager(m);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// UPDATE specific manager handler
//	@PutMapping("/{mgr_ID}")
//	public ResponseEntity<Manager> updateMgr_ID(@RequestBody Manager mgr, @PathVariable("mgr_ID") String id) {
//		try {
//			mService.updateManagerbyID(mgr, id);
//			return ResponseEntity.ok().body(mgr);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//	}

	// READ all employees assigned to a specific manager handler
	@GetMapping("/{mgr_ID}/employees")
	public ResponseEntity<List<Employee>> getEmployee_by_mgrid(@PathVariable("mgr_ID") String id) {
		List<Employee> list1 = mService.getEmployeeByMgrid(id);
		if (list1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list1));
	}

	// READ leaves applied to specific manager handler
	@GetMapping("/{mgr_ID}/leaves")
	public ResponseEntity<List<Leaves>> getLeave_mgrid(@PathVariable("mgr_ID") String id) {
		List<Leaves> lisl1 = mService.getLeaveByMgrid(id);
		if (lisl1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(lisl1));
	}

	// READ leaves applied by id handler
	@GetMapping("/leave/{lv_ID}")
	public ResponseEntity<Leaves> getLeave_id(@PathVariable("lv_ID") String id) {
		Leaves lv = mService.getLeaveByid(id);
		if (lv==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(lv));
	}

	// UPDATE leave status handler
	@PutMapping("/leaves/{lv_ID}")
	public ResponseEntity<Leaves> updateLeave_ID(@RequestBody Leaves lv, @PathVariable("lv_ID") String id) {
		try {
			mService.updateLeavebyID(lv, id);
			return ResponseEntity.ok().body(lv);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// READ tasks assigned by specific manager handler
	@GetMapping("/{mgr_ID}/tasks")
	public ResponseEntity<List<Tasks>> getTasks_mgrid(@PathVariable("mgr_ID") String id) {
		List<Tasks> list1 = mService.getTasksByMgrid(id);
		if (list1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list1));
	}

	// ADD new task handler
	@PostMapping("/employee/{emp_ID}/task")
	public ResponseEntity<Void> createTasks(@RequestBody Tasks tsk, @PathVariable String emp_ID) {

		try {
			mService.saveTask(tsk, emp_ID);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
