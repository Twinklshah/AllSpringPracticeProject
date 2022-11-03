package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DtoprojectApplication { //implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DtoprojectApplication.class, args);
	}

//	@Autowired
//	CustomerRepository customerRepository;
//	
//	@Autowired
//	LocationRepository locationRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		
//		Location location=new Location();
//		location.setPlace("Navi Mumbai");
//		location.setDescription("it is in maharashtra");
//		location.setLatitude(20.7);
//		location.setLongitude(34.2);
//		customerRepository.save(location);
//		
//		
//	}

}
