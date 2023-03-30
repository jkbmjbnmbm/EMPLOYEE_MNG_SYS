package com.ems.AdminService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ems.AdminService.dao.UserRepository;
import com.ems.AdminService.entities.Users;
import com.ems.AdminService.external.entities.Employee;
import com.ems.AdminService.external.entities.Manager;
import com.ems.AdminService.external.services.EmployeeService;
import com.ems.AdminService.external.services.ManagerService;

@Service
public class AdminService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private EmployeeService eService;
	
	@Autowired
	private ManagerService mService;
	
	public List<Employee> getAllEmployees(){
		List<Employee> list1 = eService.getEmployees();
		return list1;
	}
	
	public List<Manager> getAllManagers(){
		List<Manager> list1 = mService.getManagers();
		return list1;
	}

	public void addUser(Users user) {
		String randomID = UUID.randomUUID().toString();
		user.setId(randomID);
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		String encodedPWD = bCrypt.encode(user.getPass());
		user.setPass(encodedPWD);
		if(user.getRole().getAction()=="Employee") {
			Employee e1 = new Employee();
			e1.setEmpId(randomID);
			e1.setBirthDate(user.getBirthDate());
			e1.setEmail(user.getEmail());
			e1.setGender(user.getGender());
			e1.setMaritalStatus(user.getMaritalStatus());
			e1.setMgrName(user.getMgrName());
			e1.setName(user.getName());
			e1.setPhone(user.getPhone());
			e1.setPass(encodedPWD);
			eService.addEmployee(e1);
		}
		else if(user.getRole().getAction()=="Manager") {
			Manager m1 = new Manager();
			m1.setEmail(user.getEmail());
			m1.setMgrId(randomID);
			m1.setName(user.getName());
			m1.setPass(encodedPWD);
			mService.addManager(m1);
		}
		repository.save(user);
	}

}
