package com.ems.emsSecurity.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.emsSecurity.dao.UserRepository;
import com.ems.emsSecurity.entities.Users;
import com.ems.emsSecurity.entities.AuthRequest;
import com.ems.emsSecurity.entities.JWTAuthResponse;
import com.ems.emsSecurity.entities.UserDto;
import com.ems.emsSecurity.servies.JwtService;

@RestController
@RequestMapping("/auth")
public class LoginController {
	
	ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserRepository repo;
	
	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponse> authenticateAndGetToken(@RequestBody AuthRequest aRequest) throws UsernameNotFoundException {
		
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		Users u1 = repo.findByEmail(aRequest.getUserName());
		if(u1!=null) {
			if(bcrypt.matches(aRequest.getPassWord(), u1.getPassword())) {
				String token = jwtService.generateToken(u1);
				JWTAuthResponse response = new JWTAuthResponse(token);
				response.setUser(mapper.map(u1, UserDto.class));
				return new ResponseEntity<JWTAuthResponse>(response, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<JWTAuthResponse>(HttpStatus.UNAUTHORIZED);
			}
		}
		throw new UsernameNotFoundException("No user with this username is found !!");
	}
	
	
	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		jwtService.validateToken(token);
		return "Token is valid";
	}

}
