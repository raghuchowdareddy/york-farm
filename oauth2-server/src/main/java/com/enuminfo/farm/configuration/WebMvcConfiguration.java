/**
 * 
 */
package com.enuminfo.farm.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Kumar
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
		viewControllerRegistry.addViewController("/login").setViewName("login");
		viewControllerRegistry.addViewController("/oauth/confirm_access").setViewName("authorize");
	}
}
