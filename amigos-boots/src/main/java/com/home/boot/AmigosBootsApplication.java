package com.home.boot;

import com.home.boot.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class AmigosBootsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmigosBootsApplication.class, args);
	}


}
