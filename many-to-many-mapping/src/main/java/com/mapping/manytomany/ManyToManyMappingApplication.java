package com.mapping.manytomany;

import com.mapping.manytomany.entity.Address;
import com.mapping.manytomany.entity.User;
import com.mapping.manytomany.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@AllArgsConstructor
public class ManyToManyMappingApplication {
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyMappingApplication.class, args);
	}

	/**
	 * Multiple users has belongs to multiple addresses in many-to-many relationship mapping
	 */
	@PostConstruct
	public void saveUser(){
		User user=new User();
		user.setName("A");
		user.setEmail("a@gmail.com");

		Address address1=new Address();
		address1.setDistrict("Sddn");
		address1.setVillage("Chan");

		Address address2=new Address();
		address2.setDistrict("Sddn2");
		address2.setVillage("Chan2");

		// A user belongs to different addresses
		user.getAddresses().add(address1);
		user.getAddresses().add(address2);

		// add users into addresses as a reference
		address1.getUsers().add(user);
		address2.getUsers().add(user);

		user= userRepository.save(user);
		System.out.println(user);
	}
}


