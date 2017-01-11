package com.sss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * Class with main method to run a Sprint Boot application
 * 
 * @author vaivorom
 *
 */

@SpringBootApplication
public class Application {
	/**
	 * Main method of Spring Boot application
	 * @param args not used
	 */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
