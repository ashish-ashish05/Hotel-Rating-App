package com.HotelRatingApp_User_Service.repository;

import com.HotelRatingApp_User_Service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
