/**
 * 
 */
package com.enuminfo.farm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Kumar
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableOAuth2Sso
@EnableHystrix
public class RunServer extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(RunServer.class, args);
	}
	
	@Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.antMatcher("/**").authorizeRequests()
			.antMatchers("/index.html", "/login", "/", "/api/catalog/**", "/user", "/resources/**").permitAll()
			.anyRequest().authenticated().and().csrf().disable();
	}
}
