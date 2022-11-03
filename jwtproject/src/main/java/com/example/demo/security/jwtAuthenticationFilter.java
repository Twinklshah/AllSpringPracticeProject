package com.example.demo.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.service.ClientService;
import com.example.demo.service.impl.ClientServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class jwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	ClientService clientJwtService;
	
	@Autowired
	jwtTokenHelper jwTokenHelper; 

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//1. get token
		
	    final String requestToken=request.getHeader("Authorization");
		
		//Bearer 64257hjj
		
		String clientName=null;
		String token=null;
		
		if(requestToken !=null && requestToken.startsWith("Bearer")) {
			
			token=requestToken.substring(7);
			try {
				clientName=this.jwTokenHelper.getUsernameFromToken(token);
			}
			catch(IllegalArgumentException e){
				System.out.println("token was not valid");
			}
			catch(ExpiredJwtException e){
				System.out.println("token was expired");
			}
			
			catch(MalformedJwtException e){
				System.out.println("token was malformed");
			}
		}
		else {
			System.out.println("Token doesnot start with Bearer");
		}
		
		// Once we get Token now Validate
		
		if (clientName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.clientJwtService.loadUserByUsername(clientName);

			// if token is valid configure Spring Security to manually set authentication
			if (jwTokenHelper.validateToken(token, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
		
		
	}

}
