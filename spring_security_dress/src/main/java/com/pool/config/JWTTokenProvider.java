package com.pool.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.security.constants.DressConstants;
import com.security.exception.JwtException;
import com.security.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JWTTokenProvider {

	//Geenerate 
	public String tokenGenerator(Authentication authentication) {
		User loginUser = (User) authentication.getPrincipal();
		Date sessionStartDate = new Date(System.currentTimeMillis());
		Date sessionEndDate = new Date(sessionStartDate.getTime() + DressConstants.EXPIRATION_DURIATION);
		String loginUserId = Long.toString(loginUser.getUserId());
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", (Long.toString(loginUser.getUserId())));
		claims.put("username", loginUser.getUsername());
		claims.put("firstName", loginUser.getFirstName());

		return Jwts.builder().
				setSubject(loginUserId)
				.setClaims(claims)
				.setIssuedAt(sessionStartDate)
				.setExpiration(sessionEndDate)
				.signWith(SignatureAlgorithm.HS256, DressConstants.SECRET_KEY)
				.compact();
	}
	
	//validate
	public boolean validateJwtToken(String jwtToken) {
		try {
			 Jwts.parser().setSigningKey(DressConstants.SECRET_KEY).parseClaimsJws(jwtToken);
			return true;
		/*} catch (SignatureException e) {
			//throw new JwtException("Signature Failed");
		}catch (MalformedJwtException e) {
			//throw new JwtException("Mal formed Jwt ");
		}catch (ExpiredJwtException e) {
			//throw new JwtException("Jwt Expired");
		}catch (UnsupportedJwtException e) {
			//throw new JwtException("Jwt Unsupported");
		}catch (IllegalArgumentException e) {
			//throw new JwtException("IllegalArgument");
		}*/
        }catch (SignatureException ex){
            System.out.println("Invalid JWT Signature");
        }catch (MalformedJwtException ex){
            System.out.println("Invalid JWT Token");
        }catch (ExpiredJwtException ex){
            System.out.println("Expired JWT token");
        }catch (UnsupportedJwtException ex){
            System.out.println("Unsupported JWT token");
        }catch (IllegalArgumentException ex){
            System.out.println("JWT claims string is empty");
        }
		return false;
	}
	////userd
	
	public Long extractUserid(String jwtToken) {
		Claims claims=Jwts.parser()
				.setSigningKey(DressConstants.SECRET_KEY)
				.parseClaimsJws(jwtToken).getBody();
		String signedUser=(String) claims.get("userId");
		System.out.println(signedUser);
		return Long.valueOf(signedUser);
	}
	
	
}
