package com.myaseen.hotel.controller.response;


import java.util.ArrayList;
import java.util.List;

public class AvailableHotelsResponse {

    private List<AvailableHotel> availableHotelList = new ArrayList<>();

    AvailableHotelsResponse(){

    }

    public List<AvailableHotel> getAvailableHotelList() {
        return availableHotelList;
    }

    public void setAvailableHotelList(List<AvailableHotel> availableHotelList) {
        this.availableHotelList = availableHotelList;
    }
}
