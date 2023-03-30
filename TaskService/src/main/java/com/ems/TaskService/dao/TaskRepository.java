package com.ems.TaskService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.TaskService.entities.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, String> {

	public Tasks findByTaskId(String taskId);
	public List<Tasks> findByEmpId(String empId);
	public List<Tasks> findByMgrId(String mgrId);
}
