package com.mapping.onetoone;

import com.mapping.onetoone.entity.Address;
import com.mapping.onetoone.entity.User;
import com.mapping.onetoone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@AllArgsConstructor
public class OneToOneMappingApplication {
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneMappingApplication.class, args);
	}

	/**
	 * Single user has only single address in one to one mapping
	 */
	@PostConstruct
	public void saveUser(){
		User user=new User();
		user.setName("A");
		user.setEmail("a@gmail.com");

		Address address=new Address();
		address.setDistrict("Sddn");
		address.setVillage("Chan");

		user.setAddress(address);

		var savedUser= userRepository.save(user);
		System.out.println(savedUser);
	}
}


