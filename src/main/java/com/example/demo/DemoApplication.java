package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	User[] users = {
			new User("Иван", "Иванов"),
			new User("Петр", "Петров"),
			new User("Сидр", "Сидоров")
	};

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myname", defaultValue = "John") String name){
		return String.format("Привет, %s", name);
	}

	@GetMapping("/user")
	public User getUserById(
			@RequestParam(value = "id", defaultValue = "-1") Integer id
	){
		if (id != -1 && id < users.length)
			return users[id];
		else
//			return "user not found";
			return null;
	}
}
