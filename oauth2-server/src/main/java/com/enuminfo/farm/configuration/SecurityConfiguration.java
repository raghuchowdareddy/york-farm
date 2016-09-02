/**
 * 
 */
package com.enuminfo.farm.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

/**
 * @author Kumar
 */
@Configuration
public class SecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Override
	public void init(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		
	}
}
