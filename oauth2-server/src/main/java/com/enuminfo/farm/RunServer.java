/**
 * 
 */
package com.enuminfo.farm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author Kumar
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class RunServer {

	public static void main(String[] args) {
		SpringApplication.run(RunServer.class, args);
	}
}
