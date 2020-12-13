package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.UsersService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	private Environment env;
	private UsersService usersService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public WebSecurity(Environment env,UsersService usersService,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.env = env ;
		this.usersService = usersService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
	//	http.authorizeRequests().antMatchers("/users/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/users").permitAll()
								.antMatchers(HttpMethod.POST,"/users/login").permitAll()
	.and()
		.addFilter(getAuthenticationFilter());
		http.headers().frameOptions().disable();

	}
	
	private AuthenticationFilter getAuthenticationFilter() throws Exception
	{
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(this.usersService,this.env,authenticationManager());
		authenticationFilter.setFilterProcessesUrl(this.env.getProperty("login.url.path"));
		
		return authenticationFilter;
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersService).passwordEncoder(bCryptPasswordEncoder);
    }

	
}
