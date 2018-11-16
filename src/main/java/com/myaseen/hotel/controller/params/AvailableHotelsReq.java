package com.myaseen.hotel.controller.params;

import javax.validation.constraints.Min;

public class AvailableHotelsReq {
    String fromDate;
	String toDate;
	String city;
	Integer numberOfAdults;

    AvailableHotelsReq(){

    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(@Min(1) int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    @Override
    public String toString() {
        return "AvailableHotels{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", city='" + city + '\'' +
                ", numberOfAdults=" + numberOfAdults +
                '}';
    }
}
