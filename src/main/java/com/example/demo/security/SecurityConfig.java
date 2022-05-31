package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private AccountUserDetailService service;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
		web.ignoring().antMatchers("/public/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/","/login").permitAll()
			.antMatchers("/menu","/logout").authenticated()
			.antMatchers("/admin","/admin/**").hasRole("ADMIN")
			.antMatchers("/**").denyAll();

		http.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/auth")
			.usernameParameter("username")
			.passwordParameter("password")
			.defaultSuccessUrl("/menu",true)
			.failureUrl("/login")
			.permitAll();

		http.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.clearAuthentication(true)
			.permitAll();
	}
}
