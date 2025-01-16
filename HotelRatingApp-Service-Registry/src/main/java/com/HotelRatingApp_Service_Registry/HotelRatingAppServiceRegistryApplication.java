package com.HotelRatingApp_Service_Registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HotelRatingAppServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRatingAppServiceRegistryApplication.class, args);
	}

}
