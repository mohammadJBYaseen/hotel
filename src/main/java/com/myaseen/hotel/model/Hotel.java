package com.myaseen.hotel.model;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Hotel implements Entity {
    private long id;
    private Provider provider;
    private String name;
    private Set<String> amenities = new HashSet<>();
    private City city;
    private int rank = 0;
    private float discount=0.0f;

    public Hotel() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(@NotNull Provider provider) {
        this.provider = provider;
    }

    public String getName() {
        return name;
    }

    public void setName(@NotNull @NotEmpty String name) {
        this.name = name;
    }

    public Set<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(@NotNull Set<String> amenities) {
        this.amenities = amenities;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(@NotNull City city) {
        this.city = city;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(@PositiveOrZero @Max(5) int rank) {
        this.rank = rank;
    }


    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Hotel)) {
            return false;
        }
        return Objects.equals(this.name, ((Hotel) obj).name) && Objects.equals(this.city, ((Hotel) obj).city);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "provider=" + provider +
                ", name='" + name + '\'' +
                ", amenities=" + amenities +
                ", city=" + city +
                ", rank=" + rank +
                '}';
    }
}
