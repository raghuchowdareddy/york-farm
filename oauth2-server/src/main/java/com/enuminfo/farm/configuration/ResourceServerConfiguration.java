/**
 * 
 */
package com.enuminfo.farm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

/**
 * @author Kumar
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
			.antMatchers("/resources/**", "/login").permitAll()
			.anyRequest().authenticated();
	}
	
	@Bean
    HttpSessionSecurityContextRepository contextRepository() {
		return new HttpSessionSecurityContextRepository();
	}
}
