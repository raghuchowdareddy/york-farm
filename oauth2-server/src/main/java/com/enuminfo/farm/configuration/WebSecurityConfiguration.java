/**
 * 
 */
package com.enuminfo.farm.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author Kumar
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.and().logout().permitAll()
			.and().csrf().disable();
	}
	
	@Configuration
    @EnableAuthorizationServer
    protected static class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {
		
		@Override
        public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {
			clientDetailsServiceConfigurer.inMemory()
				.withClient("acme").secret("acmesecret")
				.authorizedGrantTypes("authorization_code", "refresh_token", "password").scopes("openid");
		}
	}
}
