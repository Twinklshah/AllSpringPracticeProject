package com.example.demo.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;


public class AuditAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        
//        if (authentication == null ||
//                !authentication.isAuthenticated() ||
//                authentication instanceof AnonymousAuthenticationToken) {
//            return Optional.of("TestUser");
//        }
//
//       UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
//        return Optional.ofNullable(userPrincipal.getUsername());
		
		return Optional.of("Twinkle Shah");

	}
	

}
