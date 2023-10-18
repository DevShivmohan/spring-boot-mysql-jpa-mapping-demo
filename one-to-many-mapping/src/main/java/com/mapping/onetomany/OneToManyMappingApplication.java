package com.mapping.onetomany;

import com.mapping.onetomany.entity.Address;
import com.mapping.onetomany.entity.User;
import com.mapping.onetomany.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class OneToManyMappingApplication {
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToManyMappingApplication.class, args);
	}

	/**
	 * Single user has multiple addresses in one to many relationship mapping
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

		List<Address> addresses=new ArrayList<>();
		addresses.add(address1);
		addresses.add(address2);

		user.setAddresses(addresses);

		var savedUser= userRepository.save(user);
		System.out.println(savedUser);
	}
}


