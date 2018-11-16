package com.myaseen.hotel.service;

import com.myaseen.hotel.exception.DataException;
import com.myaseen.hotel.model.Hotel;
import com.myaseen.hotel.model.Provider;;
import com.myaseen.hotel.model.RoomAvailability;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public interface HotelService {
    /**
     * <p>Add new <i>provider</i> to the system</p>
     * @param provider
     * @return
     * @throws DataException
     */
    Provider addProvider(@NotNull Provider provider) throws DataException;

    /**
     *  <p> Add hotel to specific providerCode, identifying provide by <i>providerCode</i> </p>
     * @param providerCode   provider code the hotel belong too.
     * @param hotel          hotel to be added to te system
     * @return               hotel object saved on the system.
     * @throws DataException exception will be thrown in case provider doesn't exit.
     */
    Hotel addHotel(@NotNull @NotEmpty String providerCode,@NotNull Hotel hotel) throws DataException;

    /**
     * <p>Add room details to the system within specific date time, for given hotel name, in specific city, for
     * given providerCode</p>
     * @param providerCode   providerCode code
     * @param hotelName  hotel name
     * @param cityCode   city name
     * @param roomAvailability  room details
     * @throws DataException
     */
    void addRoom(@NotNull @NotEmpty String providerCode,@NotNull @NotEmpty String hotelName,
                 @NotNull @NotEmpty String cityCode,
                 @NotNull RoomAvailability roomAvailability) throws DataException;

    /**
     *
     * @param providerCode
     * @param fromDate
     * @param toDate
     * @param city
     * @param numberOfAdults
     * @return
     */
    Set<Hotel> getAvailableHotels(String providerCode ,String fromDate,
            String toDate,
            String city,
            Integer numberOfAdults) throws DataException;

}
