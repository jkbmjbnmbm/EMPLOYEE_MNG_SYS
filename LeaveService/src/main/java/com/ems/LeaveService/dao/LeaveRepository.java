package com.ems.LeaveService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.LeaveService.entities.Leave;

public interface LeaveRepository extends JpaRepository<Leave, String>{

	public Leave findByLeaveId(String leaveId);
	public List<Leave> findByEmpId(String empId);
	public List<Leave> findByMgrId(String mgrId);
	
}
