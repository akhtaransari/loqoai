package com.loqoai.ProductFinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the ProductFinder Spring Boot application.

 * This class is annotated with {@link SpringBootApplication}, which is a convenience annotation that combines:
 * - {@link org.springframework.context.annotation.Configuration @Configuration}: Marks this class as a source of bean definitions.
 * - {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration @EnableAutoConfiguration}: Enables Spring Boot's auto-configuration mechanism.
 * - {@link org.springframework.context.annotation.ComponentScan @ComponentScan}: Enables component scanning for discovering beans.

 * The main method uses {@link SpringApplication#run(Class, String...)} to launch the application.

 * The application will start up the Spring context, perform classpath scanning, and configure the necessary beans.
 *
 * @see SpringApplication
 */
@SpringBootApplication
public class ProductFinderApplication {

	/**
	 * The main method that serves as the entry point for the Spring Boot application.

	 * It triggers the startup of the Spring application context and initializes the application.
	 *
	 * @param args Command-line arguments passed to the application. They can be used to configure application settings at runtime.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProductFinderApplication.class, args);
	}

}
