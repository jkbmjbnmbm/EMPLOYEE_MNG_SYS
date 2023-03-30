package com.ems.ManagerService.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.ManagerService.dao.ManagerRepository;
import com.ems.ManagerService.entities.Manager;
import com.ems.ManagerService.external.entities.Employee;
import com.ems.ManagerService.external.entities.Leaves;
import com.ems.ManagerService.external.entities.Tasks;
import com.ems.ManagerService.external.services.EmployeeService;
import com.ems.ManagerService.external.services.LeaveService;
import com.ems.ManagerService.external.services.TaskService;

@Service
public class MgrService{

	@Autowired
	private ManagerRepository repo;
	
	@Autowired
	private LeaveService lService;
	
	@Autowired
	private TaskService tService;
	
	@Autowired
	private EmployeeService eService;
	
	// get all managers
	public List<Manager> getAllManagers() {
		List<Manager> list1 = repo.findAll();
		return list1;
	}
	
	//get manager by id
	public Manager getManagerByid(String id) {
		Manager m1 = null;
		try {
			m1 = repo.findByMgrId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m1;
	}
	
	//get manager details by name
	public Manager getManagerByname(String name) {
		Manager m1 = null;
		try {
			m1 = repo.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m1;
	}
	
	
	//ADD a manager
	public Manager saveManager(Manager m1) {
		return repo.save(m1);
	}
	
	// update manager by id
	public void updateManagerbyID(Manager m2, String id) {		
		m2.setMgrId(id);  
		repo.save(m2);
	}

	public void saveTask(Tasks tsk, String emp_ID) {
		tService.createTasks(tsk, emp_ID);
		
	}

	public List<Tasks> getTasksByMgrid(String mgr_ID) {
		return tService.getTasks_mgrid(mgr_ID);
	}

	public List<Leaves> getLeaveByMgrid(String mgr_ID) {
		return lService.getLeave_mgrid(mgr_ID);
	}
	
	public Leaves getLeaveByid(String id) {
		return lService.getLeave_id(id);
	}

	public void updateLeavebyID(Leaves lv, String lv_ID) {
		lService.updateLeave_ID(lv, lv_ID);
	}

	public List<Employee> getEmployeeByMgrid(String id) {
		return eService.getEmployee_by_mgrid(id);
	}
	
	public Employee getEmployeeByid(String id) {
		return eService.getEmployee_id(id);
	}
	
}
