package com.intech.telecom.security.configs;

import com.intech.telecom.security.handlers.CustomAuthenticationSuccessHandler;
import com.intech.telecom.security.services.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;


@Configuration
@ComponentScan("com.intech.telecom")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		// отключена защита csrf на время тестов
		http.csrf().disable().addFilterBefore(filter, CsrfFilter.class);
		http.authorizeRequests()
				.antMatchers("/user/**").hasAnyAuthority("USER")
				.antMatchers("/audio/**").hasAnyAuthority("USER")
				.antMatchers("/home/**").hasAnyAuthority("USER")
				.antMatchers("/info/**").hasAnyAuthority("USER")
				.antMatchers("/content/**").hasAnyAuthority("USER")
				.and()
				.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error")
				.successHandler(customAuthenticationSuccessHandler)
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
				.logout().logoutSuccessUrl("/login?logout")
				.and()
				.anonymous()
				.disable()
		;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService);
	}
}
