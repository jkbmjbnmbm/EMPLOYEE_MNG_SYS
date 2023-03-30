package com.ems.LeaveService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ems.LeaveService.dao.LeaveRepository;
import com.ems.LeaveService.entities.Leave;
import com.ems.LeaveService.external.entities.Employee;
import com.ems.LeaveService.external.services.EmployeeService;

@Service
public class LeaveService {

	@Autowired
	private LeaveRepository repo;

	@Autowired
	private EmployeeService eService;

	// get all leaves
	public List<Leave> getAllLeaves() {
		List<Leave> lisl1 = repo.findAll();
		return lisl1;
	}

	// get all leaves
	public Leave getLeaveByid(String id) {
		Leave lv = repo.findByLeaveId(id);
		return lv;
	}

	// get leave by employee id
	public List<Leave> getLeaveByEmpid(String id) {
		List<Leave> l1 = null;
		try {
			l1 = repo.findByEmpId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l1;
	}

	// get leave by manager id
	public List<Leave> getLeaveByMgrid(String id) {
		List<Leave> l1 = null;
		try {
			l1 = repo.findByMgrId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l1;
	}

	// ADD a leave
	public Leave saveLeave(Leave lv, String id) {
		String randomID = UUID.randomUUID().toString();
		lv.setLeaveId(randomID);
		Employee e1 = eService.getEmployeeByid(id);
		lv.setEmpId(id);
		lv.setName(e1.getName());
		lv.setMgrId(e1.getMgrId());
		return repo.save(lv);
	}

	// update leave status
	public void updateLeavebyID(Leave l2, String id) {
		Leave l1 = repo.findByLeaveId(id);
		l1.setStatus(l2.getStatus());
		repo.save(l1);
	}

}
