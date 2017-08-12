package com.intech.telecom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String getAdminPage() {
		return "home";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String getPage(@RequestParam(value = "num") String number)  {
		switch (number) {
			case "1" : return "content";
			case "2" : return "account";
			case "3" : return "info";
			default: return "home";
		}
	}
}
