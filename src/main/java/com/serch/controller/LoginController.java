package com.serch.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.serch.util.Views;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
	@GetMapping("/index")
	public String index(Authentication authentication) {
		System.out.println("LoginController index() -> username: "+authentication.getName());
		for(GrantedAuthority rol: authentication.getAuthorities()) {
			System.out.println("LoginController index() -> rol: "+rol.getAuthority());
		}
		return Views.ADMIN;
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Authentication authentication) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		System.out.println("LoginController logout() -> username: "+authentication.getName());
		for(GrantedAuthority rol: authentication.getAuthorities()) {
			System.out.println("LoginController index() -> rol: "+rol.getAuthority());
		}
		return "redirect:/"+Views.FORM_LOGIN;
	}
	
	
	
}
