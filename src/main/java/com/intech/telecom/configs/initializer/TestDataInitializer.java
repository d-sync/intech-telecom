package com.intech.telecom.configs.initializer;

import com.intech.telecom.models.content.Audio;
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
	AudioService audioService;


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

		Audio a1 = new Audio("Linkin Park", "With You", false, false, true);
		Audio a2 = new Audio("Avril Lavigne", "Losing Grip", false, false, true);
		Audio a3 = new Audio("New Artist", "New Song", true, false, false);
		Audio a4 = new Audio("New Artist", "New Song 2", true, false, false);
		Audio a5 = new Audio("Linkin Park", "In The End", false, true, true);
		Audio a6 = new Audio("New Cool Band", "New Hit Song", true, true, true);
		Audio a7 = new Audio("Test", "Test", false, false, false);

		audioService.add(a1);
		audioService.add(a2);
		audioService.add(a3);
		audioService.add(a4);
		audioService.add(a5);
		audioService.add(a6);
		audioService.add(a7);

	}
}
