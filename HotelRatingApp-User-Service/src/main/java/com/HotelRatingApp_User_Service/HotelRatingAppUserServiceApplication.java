package com.HotelRatingApp_User_Service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class HotelRatingAppUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRatingAppUserServiceApplication.class, args);
	}

}


