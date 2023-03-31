package com.ems.emsSecurity.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Auth_Users")
public class Users implements UserDetails {

	@Id
	@Column(name = "ID")
	private String Id;

	@Column(name = "Name")
	private String name;
	
	@Column(name = "Username")
	private String email;
	
	@Column(name = "Password")
	private String pass;
	
	@Enumerated(EnumType.STRING)
	private Roles role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List.of(new SimpleGrantedAuthority(role.name()));
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return pass;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}