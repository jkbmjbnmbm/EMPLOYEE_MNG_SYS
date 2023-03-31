package com.ems.emsSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.emsSecurity.entities.Users;

public interface UserRepository extends JpaRepository<Users, String> {

	public Users findByEmail(String email);
	
}
