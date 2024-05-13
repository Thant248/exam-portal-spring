package com.example.demo;

// import java.util.HashSet;
// import java.util.Set;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// import org.springframework.context.ApplicationContext;

// import com.example.demo.models.Role;
// import com.example.demo.models.User;
// import com.example.demo.service.UserService;


// import com.example.demo.models.UserRole;



@SpringBootApplication
public class DemoApplication {

	// @Autowired
	// private UserService service;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(ApplicationContext context){
	// 	return args -> {

	// 	User user = new User();
	// 	user.setFirstName("Thants");
	// 	user.setLastName("Sin");
	// 	user.setUsername("Thant Sin Phyoe");
	// 	user.setEmail("thantsinphyoe18920@gmail.com");
	// 	user.setPassword("thants");
	// 	user.setPhone("09773478424");
	// 	user.setProfile("default.png");

	// 	Role role = new Role();

	// 	role.setRoleId(44L);
	// 	role.setRoleName("ADMIN");

	// 	Set<UserRole> userRoles = new HashSet<>();
	// 	UserRole userRole = new UserRole();
	// 	userRole.setRole(role);
	// 	userRole.setUser(user);
	// 	userRoles.addAll(userRoles);
	
	// 	User user1 = service.createUser(user, userRoles);
	// 	System.out.println(user1.getLastName());

	// 	};
	// }


}
