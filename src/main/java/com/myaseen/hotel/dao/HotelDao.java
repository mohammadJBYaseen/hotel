package com.myaseen.hotel.dao;

import com.myaseen.hotel.model.Hotel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;

public interface HotelDao extends Dao<Long, Hotel> {

    Optional<Hotel> findHotel(@NotNull String providerCode,@NotEmpty @NotNull String hotelName,
                              @NotEmpty @NotNull String cityCode);

    Set<Hotel> findHotelsInCity(@NotEmpty @NotNull String city);
}
