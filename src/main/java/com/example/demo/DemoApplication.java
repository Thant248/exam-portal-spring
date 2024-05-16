package com.example.demo;

// import java.util.HashSet;
// import java.util.Set;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;




@SpringBootApplication
@PropertySource(value = "classpath:/jwt-token.properties")
public class DemoApplication {

	// @Autowired
	// private UserService service;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	


}
