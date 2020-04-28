package com.clarivate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ContentHubPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentHubPublisherApplication.class, args);
	}

}
