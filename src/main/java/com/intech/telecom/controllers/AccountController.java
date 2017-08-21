package com.intech.telecom.controllers;

import com.intech.telecom.models.content.Audio;
import com.intech.telecom.service.AudioService;
import com.intech.telecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	private AudioService audioService;

	@Autowired
	private UserService userService;

	@RequestMapping
	public ModelAndView getAccountPage(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView modelAndView = new ModelAndView("account");
		if (id == null) id = 0L;
		String msisdn = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Audio audio = audioService.getNextAudioInAccount(msisdn, id);
		if (audio == null) {
			modelAndView.addObject("err", "У вас нет купленной музыки");
		}
		modelAndView.addObject("audio", audio);
		return modelAndView;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deleteAudioFromAccount(@RequestParam(value = "id") Long id,
									   HttpServletResponse response,
									   HttpServletRequest request) throws IOException {
		ModelAndView modelAndView = new ModelAndView("account");
		String msisdn = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Audio deleted = userService.deleteAudioFromAccount(msisdn, id);
		Audio current = audioService.getNextAudioInAccount(msisdn, id);
		modelAndView.addObject("msg", "Удалено: " + deleted);
		if (current == null) {
			modelAndView.addObject("err", "У вас нет купленной музыки");
		}
		modelAndView.addObject("audio", current);
		return modelAndView;
	}


}
