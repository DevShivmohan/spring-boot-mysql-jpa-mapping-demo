package com.mapping.manytoone;

import com.mapping.manytoone.entity.Address;
import com.mapping.manytoone.entity.User;
import com.mapping.manytoone.repository.AddressRepository;
import com.mapping.manytoone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@AllArgsConstructor
public class ManyToOneMappingApplication {
	private final UserRepository userRepository;
	private final AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToOneMappingApplication.class, args);
	}

	/**
	 * Multiple users has belongs to single address in many to one relationship mapping
	 */
	@PostConstruct
	public void saveUser(){
		Address address=new Address();
		address.setDistrict("Sddn");
		address.setVillage("Chan");

		address = addressRepository.save(address);

		User user1=new User();
		user1.setName("A");
		user1.setEmail("a@gmail.com");
		user1.setAddress(address);


		User user2 =new User();
		user2.setName("B");
		user2.setEmail("b@gmail.com");
		user2.setAddress(address);

		var savedUser1 = userRepository.save(user1);
		System.out.println(savedUser1);

		var savedUser2 = userRepository.save(user2);
		System.out.println(savedUser2);
	}
}


