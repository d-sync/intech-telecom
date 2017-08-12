package com.intech.telecom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {


	@RequestMapping(value = "/info")
	public String getInfoPage() {
		return "info";
	}
}
