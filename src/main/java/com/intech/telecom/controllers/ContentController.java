package com.intech.telecom.controllers;


import com.intech.telecom.models.content.Audio;
import com.intech.telecom.service.AudioService;
import com.intech.telecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/content")
public class ContentController {

	@Autowired
	private UserService userService;

	@Autowired
	private AudioService audioService;

	@RequestMapping
	public String getContentPage() {
		return "content";
	}

	@RequestMapping(value = "/popular")
	public ModelAndView getPopularAudio(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView modelAndView = new ModelAndView("popular");
		if (id == null) id = 0L;
		modelAndView.addObject("audio", audioService.getNextPopularAudio(id));
		return modelAndView;
	}

	@RequestMapping(value = "/hits")
	public ModelAndView getHitsAudio(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView modelAndView = new ModelAndView("hits");
		if (id == null) id = 0L;
		modelAndView.addObject("audio", audioService.getNextHitsAudio(id));
		return modelAndView;
	}

	@RequestMapping(value = "/newest")
	public ModelAndView getNewestAudio(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView modelAndView = new ModelAndView("newest");
		if (id == null) id = 0L;
		modelAndView.addObject("audio", audioService.getNextNewestAudio(id));
		return modelAndView;
	}

	@RequestMapping(value = "/buypop", method = RequestMethod.POST)
	public ModelAndView buyPopular(@RequestParam(value = "id") Long id) {
		ModelAndView popular = new ModelAndView("popular");
		String msisdn = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Audio audio = userService.buyAudioById(msisdn, id);
		if (audio == null) {
			popular.addObject("err", "Эта композиция уже была куплена Вами ранее.");
		} else {
			popular.addObject("msg", "Вы купили: " + audio);
		}
		popular.addObject("audio", audioService.getNextPopularAudio(--id));
		return popular;
	}

	@RequestMapping(value = "/buynew", method = RequestMethod.POST)
	public ModelAndView buyNew(@RequestParam(value = "id") Long id) {
		ModelAndView newest = new ModelAndView("newest");
		String msisdn = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Audio audio = userService.buyAudioById(msisdn, id);
		if (audio == null) {
			newest.addObject("err", "Эта композиция уже была куплена Вами ранее.");
		} else {
			newest.addObject("msg", "Вы купили: " + audio);
		}
		newest.addObject("audio", audioService.getNextNewestAudio(--id));
		return newest;
	}

	@RequestMapping(value = "/buyhit", method = RequestMethod.POST)
	public ModelAndView buyHit(@RequestParam(value = "id") Long id) {
		ModelAndView hits = new ModelAndView("hits");
		String msisdn = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Audio audio = userService.buyAudioById(msisdn, id);
		if (audio == null) {
			hits.addObject("err", "Эта композиция уже была куплена Вами ранее.");
		} else {
			hits.addObject("msg", "Вы купили: " + audio);
		}
		hits.addObject("audio", audioService.getNextHitsAudio(--id));
		return hits;
	}
}
