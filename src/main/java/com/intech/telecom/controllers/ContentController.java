package com.intech.telecom.controllers;


import com.intech.telecom.models.content.Audio;
import com.intech.telecom.service.HitsAudioService;
import com.intech.telecom.service.NewestAudioService;
import com.intech.telecom.service.PopularAudioSerice;
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
	private PopularAudioSerice popularAudioSerice;

	@Autowired
	private UserService userService;

	@Autowired
	private NewestAudioService newestAudioService;

	@Autowired
	private HitsAudioService hitsAudioService;

	@RequestMapping
	public String getContentPage() {
		return "content";
	}

	@RequestMapping(value = "/popular")
	public ModelAndView getPopularAudio(@RequestParam(value = "pid", required = false) Long pid) {
		ModelAndView modelAndView = new ModelAndView("popular");
		if (pid == null) pid = 0L;
		long amount = popularAudioSerice.getPopularAudioAmount();
		if (pid >= amount) {
			pid = 0L;
		}
		modelAndView.addObject("audio", popularAudioSerice.getPopularAudioByPid(++pid));
		return modelAndView;
	}

	@RequestMapping(value = "/buypop", method = RequestMethod.POST)
	public ModelAndView buyPopularAudio(@RequestParam(value = "id") Long id,
										@RequestParam(value = "pid") Long pid) {
		ModelAndView modelAndView = new ModelAndView("popular");
		String msisdn = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Audio audio = userService.buyAudioById(msisdn, id);
		long amount = popularAudioSerice.getPopularAudioAmount();
		if (pid > amount) {
			pid = 0L;
		}
		if (audio == null) {
			modelAndView.addObject("err", "Эта композиция уже была куплена Вами ранее.");
		} else {
			modelAndView.addObject("msg", "Вы купили: " + audio);
		}
		modelAndView.addObject("audio", popularAudioSerice.getPopularAudioByPid(pid));

		return modelAndView;
	}

	@RequestMapping(value = "/newest")
	public ModelAndView getNewestAudio(@RequestParam(value = "pid", required = false) Long pid) {
		ModelAndView modelAndView = new ModelAndView("newest");
		if (pid == null) pid = 0L;
		long amount = newestAudioService.getNewestAudioAmount();
		if (pid >= amount) {
			pid = 0L;
		}
		modelAndView.addObject("audio", newestAudioService.getNewestAudioByPid(++pid));
		return modelAndView;
	}

	@RequestMapping(value = "/buynew", method = RequestMethod.POST)
	public ModelAndView buyNewestAudio(@RequestParam(value = "id") Long id,
									   @RequestParam(value = "pid") Long pid) {
		ModelAndView modelAndView = new ModelAndView("newest");
		String msisdn = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Audio audio = userService.buyAudioById(msisdn, id);
		long amount = newestAudioService.getNewestAudioAmount();
		if (pid > amount) {
			pid = 0L;
		}
		if (audio == null) {
			modelAndView.addObject("err", "Эта композиция уже была куплена Вами ранее.");
		} else {
			modelAndView.addObject("msg", "Вы купили: " + audio);
		}
		modelAndView.addObject("audio", newestAudioService.getNewestAudioByPid(pid));

		return modelAndView;
	}

	@RequestMapping(value = "/hits")
	public ModelAndView getHitsAudio(@RequestParam(value = "pid", required = false) Long pid) {
		ModelAndView modelAndView = new ModelAndView("hits");
		if (pid == null) pid = 0L;
		long amount = hitsAudioService.getHitsAudioAmount();
		if (pid >= amount) {
			pid = 0L;
		}
		modelAndView.addObject("audio", hitsAudioService.getHitsAudioByPid(++pid));
		return modelAndView;
	}

	@RequestMapping(value = "/buyhit", method = RequestMethod.POST)
	public ModelAndView buyHitsAudio(@RequestParam(value = "id") Long id,
									 @RequestParam(value = "pid") Long pid) {
		ModelAndView modelAndView = new ModelAndView("hits");
		String msisdn = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Audio audio = userService.buyAudioById(msisdn, id);
		long amount = hitsAudioService.getHitsAudioAmount();
		if (pid > amount) {
			pid = 0L;
		}
		if (audio == null) {
			modelAndView.addObject("err", "Эта композиция уже была куплена Вами ранее.");
		} else {
			modelAndView.addObject("msg", "Вы купили: " + audio);
		}
		modelAndView.addObject("audio", hitsAudioService.getHitsAudioByPid(pid));

		return modelAndView;
	}
}
