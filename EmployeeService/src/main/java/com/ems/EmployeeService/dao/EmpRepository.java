package com.ems.EmployeeService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.EmployeeService.entities.Employee;

public interface EmpRepository extends JpaRepository<Employee, String> {
	
	public Employee findByEmpId(String id);
	public Employee findByEmail(String mail);
	public List<Employee> findByMgrId(String id);

}

