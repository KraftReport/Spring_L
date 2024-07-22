package com.jwt.demo.service;

import java.util.Optional;

import org.aspectj.weaver.patterns.IScope;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jwt.demo.model.User;


public class ApplicationAuditAware implements AuditorAware<Long> {

	@Override
	public Optional<Long> getCurrentAuditor() {
		 var auth = SecurityContextHolder.getContext().getAuthentication();
		 if(auth == null | !auth.isAuthenticated() || auth instanceof AnonymousAuthenticationToken) {
			 return Optional.empty();
		 }
		 var user =(User) auth.getPrincipal();
		return Optional.ofNullable(user.getId());
	}

}
