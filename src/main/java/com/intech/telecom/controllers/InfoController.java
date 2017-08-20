package com.intech.telecom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/info")
public class InfoController {


	@RequestMapping()
	public String getInfoPage() {
		return "info";
	}

	@RequestMapping(value = "/opportunity")
	public String getOpportunity() {
		return "opportunity";
	}

	@RequestMapping(value = "/price")
	public String getPrice() {
		return "price";
	}
}
