package com.myaseen.hotel.controller.response;

import java.util.Set;

public class AvailableHotel {
    private String provider;
    private String hotelName;
    private double fare;
    private Set<String> amenities;
    private double discount;

    public AvailableHotel(){

    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public Set<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(Set<String> amenities) {
        this.amenities = amenities;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "AvailableHotelsResponse{" +
                "provider='" + provider + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", fare=" + fare +
                ", amenities=" + amenities +
                ", discount=" + discount +
                '}';
    }
}
