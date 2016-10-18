/**
 * 
 */
package com.enuminfo.farm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Kumar
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class RunInventoryService {

	public static void main(String[] args) {
		SpringApplication.run(RunInventoryService.class, args);
	}
	
	@Bean
	@LoadBalanced
    public RestTemplate loadRestTemplate() {
        return new RestTemplate();
    }
}
