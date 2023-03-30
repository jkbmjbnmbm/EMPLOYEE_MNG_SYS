package com.ems.TaskService.controllers;

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

import com.ems.TaskService.entities.Tasks;
import com.ems.TaskService.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskService tService;

	// READ task by task id handler
	@GetMapping("/{tsk_ID}")
	public Tasks getTasks_id(@PathVariable("tsk_ID") String id) {
		Tasks tsk = tService.getTaskbyID(id);
		return tsk;
	}

	// READ tasks for specific employee handler
	@GetMapping("/employee/{emp_ID}")
	public ResponseEntity<List<Tasks>> getTasks_empid(@PathVariable("emp_ID") String id) {
		List<Tasks> list1 = tService.getTasksByEmpid(id);
		if (list1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list1));
	}

	// READ tasks assigned by specific manager handler
	@GetMapping("/manager/{mgr_ID}")
	public ResponseEntity<List<Tasks>> getTasks_mgrid(@PathVariable("mgr_ID") String id) {
		List<Tasks> list1 = tService.getTasksByMgrid(id);
		if (list1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list1));
	}

	// ADD new task handler
	@PostMapping("/{emp_ID}")
	public ResponseEntity<Void> createTasks(@RequestBody Tasks tsk, @PathVariable String emp_ID) {

		try {
			tService.saveTask(tsk, emp_ID);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// UPDATE task progress handler
	@PutMapping("/{tsk_ID}")
	public ResponseEntity<Void> updateTask_ID(@RequestBody Tasks tsk, @PathVariable("tsk_ID") String id) {
		try {
			tService.updateTasksbyID(tsk, id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
