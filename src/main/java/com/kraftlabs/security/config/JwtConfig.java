package com.kraftlabs.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

	@Autowired
	private JWTFilter jwtFilter;

	@Bean
	public FilterRegistrationBean<JWTFilter> filterRegistrationBean() {
		System.out.println("FilterRegistrationBean");
		FilterRegistrationBean<JWTFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(jwtFilter);
		filterRegistrationBean.addUrlPatterns("/user/*");
		return filterRegistrationBean;
	}

}
