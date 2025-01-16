package com.HotelRatingApp_Rating_Service.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("user_ratings")
public class Rating {
    @Id
    private String ratingId;
    private String hotelId;
    private String userId;
    private int rating;
    private String feedback;

    public Rating() {
    }

    public Rating(String ratingId, String hotelId, String userId, int rating, String feedback) {
        this.ratingId = ratingId;
        this.hotelId = hotelId;
        this.userId = userId;
        this.rating = rating;
        this.feedback = feedback;
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}