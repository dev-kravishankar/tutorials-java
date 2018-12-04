/**
 * 
 */
package com.krs.tutorials.rest.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ravis
 *
 */
@SpringBootApplication(scanBasePackages = { "com.krs.tutorials.rest.springboot.jpa" })
public class RestSpringBootJPAApp {
	public static void main(String args[]) {
		SpringApplication.run(RestSpringBootJPAApp.class, args);
	}
}
