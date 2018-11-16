package com.myaseen.hotel.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class City implements Entity{
    private long id;
    private Long name;
    private String code;

    public City(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(@NotNull @NotEmpty String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof City)){
            return false;
        }
        return Objects.equals(code,((City) obj).getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "City{" +
                "name=" + name +
                ", code='" + code + '\'' +
                '}';
    }
}
