package com.github.julioevencio.apiordermanagement.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.julioevencio.apiordermanagement.entities.User;
import com.github.julioevencio.apiordermanagement.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Fulano", "fulano@gmail.com", "999999", "123456");
		User user2 = new User(null, "Ciclano", "ciclano@gmail.com", "888888", "123456");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
	}
	
}