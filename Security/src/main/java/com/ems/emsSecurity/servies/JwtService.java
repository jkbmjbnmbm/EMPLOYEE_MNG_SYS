package com.ems.emsSecurity.servies;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ems.emsSecurity.entities.Users;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	
	public static final String secret = "28482B4D6251655468576D5A7134743777217A24432646294A404E635266556A";
	
	public void validateToken(final String Token) {
		Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(Token);
	}
	
	public String generateToken(Users user) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, user);
	}

	private String createToken(Map<String, Object> claims, Users user) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(user.getUsername())
				.claim("userid", user.getId())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
				.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
	}

	private Key getSignKey() {
		byte[] keybytes = Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(keybytes);
	}
}
