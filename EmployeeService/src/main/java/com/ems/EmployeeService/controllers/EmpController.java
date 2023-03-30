package com.ems.EmployeeService.controllers;

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

import com.ems.EmployeeService.entities.Employee;
import com.ems.EmployeeService.external.entities.Leaves;
import com.ems.EmployeeService.external.entities.Tasks;
import com.ems.EmployeeService.services.EmpService;

@RestController
@RequestMapping("/employees")
public class EmpController {

	@Autowired
	private EmpService eService;

	// READ all Employee handler
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> list1 = eService.getAllEmployees();
		if (list1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list1));
	}

	// READ specific employee handler
	@GetMapping("/{emp_ID}")
	public ResponseEntity<Employee> getEmployee_id(@PathVariable("emp_ID") String id) {
		Employee emp = eService.getEmployeeByid(id);
		if (emp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(emp));
	}

	// READ all employees assigned to a specific manager handler
	@GetMapping("/manager/{mgr_ID}")
	public ResponseEntity<List<Employee>> getEmployee_by_mgrid(@PathVariable("mgr_ID") String id) {
		List<Employee> list1 = eService.getEmployeeByMgrid(id);
		if (list1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list1));
	}

	// ADD new employee handler
	@PostMapping
	public ResponseEntity<Void> createEmployee(@RequestBody Employee e) {

		try {
			eService.saveEmployee(e);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// UPDATE specific employee handler
	@PutMapping("/{emp_ID}")
	public ResponseEntity<Employee> updateEmp_ID(@RequestBody Employee emp, @PathVariable("emp_ID") String id) {
		try {
			eService.updateEmployeebyID(emp, id);
			return ResponseEntity.ok().body(emp);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// READ specific task handler
	@GetMapping("/tasks/{tsk_ID}")
	public ResponseEntity<Tasks> getTasks_id(@PathVariable("tsk_ID") String id) {
		Tasks tsk = eService.getTaskbyTskID(id);
		if (tsk == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(tsk));
	}

	// READ tasks for specific employee handler
	@GetMapping("/{emp_ID}/tasks")
	public ResponseEntity<List<Tasks>> getTasks_empid(@PathVariable("emp_ID") String id) {
		List<Tasks> list1 = eService.getTasksByEmpid(id);
		if (list1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list1));
	}

	// UPDATE task progress handler
	@PutMapping("/task/{tsk_ID}")
	public ResponseEntity<Void> updateTask_ID(@RequestBody Tasks tsk, @PathVariable("tsk_ID") String id) {
		try {
			eService.updateTasksbyID(tsk, id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// ADD new leave handler
	@PostMapping("/{emp_ID}/leaves")
	public ResponseEntity<Void> createLeave(@RequestBody Leaves lv, @PathVariable String emp_ID) {

		try {
			eService.saveLeave(lv, emp_ID);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// READ leaves applied by specific employee handler
	@GetMapping("/{emp_ID}/leaves")
	public ResponseEntity<List<Leaves>> getLeave_empid(@PathVariable("emp_ID") String id) {
		List<Leaves> lisl1 = eService.getLeaveByEmpid(id);
		if (lisl1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(lisl1));
	}
}
