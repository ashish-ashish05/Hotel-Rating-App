package com.HotelRatingApp_ConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class HotelRatingAppConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRatingAppConfigServerApplication.class, args);
	}

}
