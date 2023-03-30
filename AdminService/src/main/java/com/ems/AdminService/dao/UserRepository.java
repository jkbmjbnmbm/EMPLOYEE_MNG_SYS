package com.ems.AdminService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.AdminService.entities.Users;

public interface UserRepository extends JpaRepository<Users, String> {

	public Users findByEmail(String mail);
}