package com.ems.EmployeeService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.EmployeeService.dao.EmpRepository;
import com.ems.EmployeeService.entities.Employee;
import com.ems.EmployeeService.external.entities.Leaves;
import com.ems.EmployeeService.external.entities.Manager;
import com.ems.EmployeeService.external.entities.Tasks;
import com.ems.EmployeeService.external.services.LeaveService;
import com.ems.EmployeeService.external.services.ManagerService;
import com.ems.EmployeeService.external.services.TaskService;

@Service
public class EmpService{

	@Autowired
	private EmpRepository repo;
	
	@Autowired
	private ManagerService mService;
	
	@Autowired
	private LeaveService lService;
	
	@Autowired
	private TaskService tService;

	// get all employees
	public List<Employee> getAllEmployees() {
		List<Employee> list1 = repo.findAll();
		return list1;
	}

	// get employee by id
	public Employee getEmployeeByid(String id) {
		Employee e1 = null;
		try {
			e1 = repo.findByEmpId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return e1;
	}

	// get employees by mgrid
	public List<Employee> getEmployeeByMgrid(String id) {
		List<Employee> l1 = null;
		try {
			l1 = repo.findByMgrId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l1;
	}

	// ADD an employee
	public Employee saveEmployee(Employee e1) {
		Manager m1 = mService.getByname(e1.getMgrName());
		e1.setMgrId(m1.getMgrId());
		return repo.save(e1);
	}

	// update employee by id
	public void updateEmployeebyID(Employee e2, String id) {
		Employee e1 = repo.findByEmpId(id);
		e1.setPhone(e2.getPhone());
		e1.setMaritalStatus(e2.getMaritalStatus());
		repo.save(e1);
	}

	public void updateTasksbyID(Tasks tsk, String tsk_ID) {
		tService.updateTask_ID(tsk, tsk_ID);
		
	}
	
	public Tasks getTaskbyTskID(String id) {
		return tService.getTasks_id(id);
	}

	public List<Tasks> getTasksByEmpid(String emp_ID) {
		return tService.getTasks_empid(emp_ID);
	}

	public List<Leaves> getLeaveByEmpid(String emp_ID) {
		return lService.getLeave_empid(emp_ID);
	}

	public void saveLeave(Leaves lv, String emp_ID) {
		lService.createLeave(lv, emp_ID);
	}

}
