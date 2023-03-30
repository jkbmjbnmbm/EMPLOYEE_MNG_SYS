package com.ems.ManagerService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.ManagerService.entities.Manager;

public interface ManagerRepository extends JpaRepository<Manager, String>{

	public Manager findByMgrId(String id);

	public Manager findByName(String name);
}
