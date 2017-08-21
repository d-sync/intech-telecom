package com.intech.telecom.configs.initializer;

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
		Role userRole = new Role("USER");
		Role userRole2 = new Role("USER");

		roleService.addRole(userRole);
		roleService.addRole(userRole2);

		Set<Role> roles = new HashSet<>();
		roles.add(userRole);
		User user = new User();
		user.setUsername("+79991394000");
		user.setPassword("root");
		user.setRoles(roles);

		Set<Role> roles2 = new HashSet<>();
		roles2.add(userRole2);
		User user2 = new User();
		user2.setUsername("+79101010001");
		user2.setPassword("root");
		user2.setRoles(roles2);

		userService.addUser(user);
		userService.addUser(user2);

		NewestAudio nAudio = new NewestAudio("New Artist", "New Song");
		NewestAudio nAudio2 = new NewestAudio("New Artist", "New Song 2");

		newestAudioService.add(nAudio);
		newestAudioService.add(nAudio2);

		PopularAudio pAudio = new PopularAudio("Linkin Park", "With you");
		PopularAudio pAudio2 = new PopularAudio("Avril Lavigne", "Losing grip");

		popularAudioSerice.add(pAudio);
		popularAudioSerice.add(pAudio2);

		HitsAudio hAudio = new HitsAudio("Group", "Hit Song");
		HitsAudio hAudio2 = new HitsAudio("Linkin Park", "Faint");

		hitsAudioService.add(hAudio);
		hitsAudioService.add(hAudio2);

	}
}
