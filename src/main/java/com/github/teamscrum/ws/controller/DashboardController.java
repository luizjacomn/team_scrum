package com.github.teamscrum.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@RequestMapping(value = "/dashboard")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/users/list")
	public String newUser() {
		return "users/list";
	}
	
}
