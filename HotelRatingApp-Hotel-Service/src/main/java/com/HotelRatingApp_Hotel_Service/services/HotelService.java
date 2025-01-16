package com.HotelRatingApp_Hotel_Service.services;

import com.HotelRatingApp_Hotel_Service.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotelById(String id);
}
