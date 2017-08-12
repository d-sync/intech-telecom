package com.intech.telecom.configs.initializer;



import com.intech.telecom.models.members.Role;
import com.intech.telecom.models.members.User;
import com.intech.telecom.service.RoleService;
import com.intech.telecom.service.UserService;
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

	private void init() {
		Role client = new Role("USER");

		roleService.addRole(client);

		Set<Role> roles = new HashSet<>();
		roles.add(client);
		User user = new User();
		user.setUsername("root");
		user.setPassword("root");
		user.setRoles(roles);

		userService.addUser(user);

	}
}
