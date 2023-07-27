package com.example.CamundaPrototype;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZeebeClient
@RestController
public class CamundaPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaPrototypeApplication.class, args);
	}

}
