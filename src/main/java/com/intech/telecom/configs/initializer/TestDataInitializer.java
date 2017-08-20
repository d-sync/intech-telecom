package com.intech.telecom.configs.initializer;



import com.intech.telecom.models.content.Audio;
import com.intech.telecom.models.content.HitsAudio;
import com.intech.telecom.models.content.NewestAudio;
import com.intech.telecom.models.content.PopularAudio;
import com.intech.telecom.models.members.Role;
import com.intech.telecom.models.members.User;
import com.intech.telecom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class TestDataInitializer {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	PopularAudioSerice popularAudioSerice;

	@Autowired
	NewestAudioService newestAudioService;

	@Autowired
	HitsAudioService hitsAudioService;

	private void init() {
//		Role userRole = new Role("USER");
//
//		roleService.addRole(userRole);
//
//		Set<Role> roles = new HashSet<>();
//		roles.add(userRole);
//		User user = new User();
//		user.setUsername("root");
//		user.setPassword("root");
//		user.setRoles(roles);
//
//		userService.addUser(user);
//
//		NewestAudio nAudio = new NewestAudio("New Artist", "New Song");
//		NewestAudio nAudio2 = new NewestAudio("New Artist", "New Song 2");
//
//		newestAudioService.add(nAudio);
//		newestAudioService.add(nAudio2);
//
//		PopularAudio pAudio = new PopularAudio("Linkin Park", "With you");
//		PopularAudio pAudio2 = new PopularAudio("Avril Lavigne", "Losing grip");
//
//		popularAudioSerice.add(pAudio);
//		popularAudioSerice.add(pAudio2);
//
//		HitsAudio hAudio = new HitsAudio("Group", "Hit Song");
//		HitsAudio hAudio2 = new HitsAudio("Linkin Park", "Faint");
//
//		hitsAudioService.add(hAudio);
//		hitsAudioService.add(hAudio2);

	}
}
