package com.tsi.pedro.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
public class MicroServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProjectApplication.class, args);
	}

}
