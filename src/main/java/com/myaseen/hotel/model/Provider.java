package com.myaseen.hotel.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Provider implements Entity {

    private long id;
    private String code;
    private String name;

    private DateFormat dateFormat = DateFormat.ISO_INSTANT;

    public Provider() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@NotNull @NotEmpty String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(@NotNull @NotEmpty String code) {
        this.code = code;
    }


    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Provider)) {
            return false;
        }
        return Objects.equals(this.code, ((Provider) obj).getCode());
    }

    @Override
    public String toString() {
        return "Provider{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
