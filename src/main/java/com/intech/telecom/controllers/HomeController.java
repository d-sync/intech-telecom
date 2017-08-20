package com.intech.telecom.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginForm(HttpServletRequest request,
									 HttpServletResponse response,
									 @RequestParam(value = "error", required = false) String error,
									 @RequestParam(value = "logout", required = false) String logout) throws Exception {

		ModelAndView model = new ModelAndView("login");
		if (error != null) {
			model.addObject("error", "Invalid msisdn and password!");
		}
		return model;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHello() {
		return "hello";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getAdminPage() {
		return "home";
	}



}
