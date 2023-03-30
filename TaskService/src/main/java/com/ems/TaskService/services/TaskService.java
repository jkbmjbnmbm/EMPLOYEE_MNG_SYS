package com.ems.TaskService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.TaskService.external.entities.Employee;
import com.ems.TaskService.external.services.EmployeeService;
import com.ems.TaskService.dao.TaskRepository;
import com.ems.TaskService.entities.Tasks;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repo;
	
	@Autowired
	private EmployeeService eService;
	
	//get task by id
	public Tasks getTaskbyID(String id) {
		Tasks tsk = repo.findByTaskId(id);
		return tsk;
	}
	
	//get task by employee id
	public List<Tasks> getTasksByEmpid(String id) {
		List<Tasks> t1 = null;
		try {
			t1 = repo.findByEmpId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t1;
	}
	
	//get task by manager id
	public List<Tasks> getTasksByMgrid(String id) {
		List<Tasks> t1 = null;
		try {
			t1 = repo.findByMgrId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t1;
	}
	
	//ADD a task
	public Tasks saveTask(Tasks tsk, String id) {
		String randomID = UUID.randomUUID().toString();
		tsk.setTaskId(randomID);
		Employee e1 = eService.getEmployeeByid(id);
		tsk.setEmpId(id);
		tsk.setMgrId(e1.getMgrId());
		tsk.setName(e1.getName());
		return repo.save(tsk);
	}
	
	// update task progress
	public void updateTasksbyID(Tasks t2, String id) {		
		Tasks t1 = repo.findByTaskId(id);
		t1.setStatus(t2.getStatus());
		repo.save(t1);
	}
}
