package com.myaseen.hotel.dao;

import com.myaseen.hotel.model.Hotel;
import com.myaseen.hotel.util.IDGenerator;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class HotelDummyDaoImpl extends AbstractDummyDaoImpl<Hotel> implements HotelDao {

    private Map<Triple<String,String, String>, Hotel> hotelMap = new HashMap<>();

    public HotelDummyDaoImpl(IDGenerator idGenerator) {
        super(idGenerator);
    }

    @Override
    protected void saveExtra(Hotel hotel) {
        hotelMap.put(Triple.of(hotel.getProvider().getCode(),hotel.getCity().getCode(), hotel.getName()), hotel);
    }


    @Override
    public Optional<Hotel> findHotel(@NotNull @NotEmpty String provider, @NotEmpty @NotNull String hotelName,
                                     @NotEmpty @NotNull String cityCode) {
        Triple<String,String, String> key = Triple.of(provider,cityCode, hotelName);
        Hotel hotel = hotelMap.getOrDefault(key, null);
        return Optional.of(hotel);
    }

    @Override
    public Set<Hotel> findHotelsInCity(@NotEmpty @NotNull String city) {
        if(hotelMap.isEmpty()){
            return Collections.EMPTY_SET;
        }
        return hotelMap.keySet().stream().filter(triple -> triple.getMiddle().equals(city)).map(hotelMap::get).collect(Collectors.toSet());
    }
}
