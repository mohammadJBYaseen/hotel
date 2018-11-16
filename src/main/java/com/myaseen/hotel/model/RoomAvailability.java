package com.myaseen.hotel.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.Objects;

public class RoomAvailability implements Entity{

    private long id;
    private Date fromDate;
    private Date toDate;
    private double fare;
    private int roomNumber;
    private int capacity;
    private Hotel hotel;


    public RoomAvailability(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(@Positive int capacity) {
        this.capacity = capacity;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(@Positive double fare) {
        this.fare = fare;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(@Positive int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setHotel(@NotNull Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof RoomAvailability)){
            return false;
        }
        return Objects.equals(this.roomNumber, ((RoomAvailability) obj).roomNumber) && Objects.equals(fromDate,
                ((RoomAvailability) obj).fromDate) && Objects.equals(toDate,((RoomAvailability) obj).toDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, fromDate, toDate,hotel);
    }

    @Override
    public String toString() {
        return "RoomAvailability{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", fare=" + fare +
                ", roomNumber=" + roomNumber +
                ", capacity=" + capacity +
                ", hotel=" + hotel +
                '}';
    }
}
