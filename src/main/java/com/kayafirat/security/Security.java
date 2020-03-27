package com.kayafirat.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService service;    
	
	@Autowired
	public Security(UserDetailsService service) {
		this.service = service;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/","/css/*","/js/*", "/home","/register","/confirm").permitAll()
				.antMatchers("/api/v1/**").permitAll()
				.antMatchers("/main").hasAnyRole(UserRole.ADMIN.name(),UserRole.USER.name())
				.antMatchers("/books","/users").hasAnyRole(UserRole.ADMIN.name())
				.anyRequest()
				.authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/main",true)
				.usernameParameter("username")							
				.passwordParameter("password")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout").permitAll()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))  
				.clearAuthentication(true) 										 
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/logout");
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
		
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(service);
		return provider;
	}
	
	
	@Autowired
    public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    };
    
    
    
    
    
    
    
}
