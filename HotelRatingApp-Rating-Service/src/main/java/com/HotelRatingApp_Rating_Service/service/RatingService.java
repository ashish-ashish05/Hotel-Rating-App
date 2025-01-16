package com.HotelRatingApp_Rating_Service.service;

import com.HotelRatingApp_Rating_Service.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating ratingDTO);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
