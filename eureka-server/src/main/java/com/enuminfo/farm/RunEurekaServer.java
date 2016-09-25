/**
 * 
 */
package com.enuminfo.farm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Kumar
 */
@SpringBootApplication
@EnableEurekaServer
public class RunEurekaServer {

	public static void main(String[] args) {
		SpringApplication.run(RunEurekaServer.class, args);
	}
}
