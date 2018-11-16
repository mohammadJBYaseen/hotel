package com.myaseen.hotel.service;

import com.myaseen.hotel.dao.HotelDao;
import com.myaseen.hotel.dao.ProviderDao;
import com.myaseen.hotel.dao.RoomAvailabilityDao;
import com.myaseen.hotel.exception.DataException;
import com.myaseen.hotel.exception.EntityNotFoundException;
import com.myaseen.hotel.model.Hotel;
import com.myaseen.hotel.model.Provider;
import com.myaseen.hotel.model.RoomAvailability;
import com.myaseen.hotel.util.DateConverter;
import com.myaseen.hotel.util.DateConverterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private ProviderDao providerDao;

    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private RoomAvailabilityDao roomAvailabilityDao;

    @Autowired
    private DateConverterFactory factory;

    @Override
    public Provider addProvider(@NotNull Provider provider) throws DataException {
        return providerDao.save(provider);
    }

    @Override
    public Hotel addHotel(@NotNull @NotEmpty String providerCode,@NotNull @NotEmpty Hotel hotel) throws DataException {
        Provider byCode = providerDao.findByCode(providerCode);
        hotel.setProvider(byCode);
        hotelDao.save(hotel);
        return hotel;
    }

    @Override
    public void addRoom(String providerCode, String hotelName, String cityCode, RoomAvailability roomAvailability) throws DataException {
        Provider byCode = providerDao.findByCode(providerCode);
        Optional<Hotel> hotelObjWrapper = hotelDao.findHotel(byCode.getCode(),hotelName, cityCode);
        if(hotelObjWrapper.isPresent()){
            roomAvailability.setHotel(hotelObjWrapper.get());
            roomAvailabilityDao.save(roomAvailability);
        }else{
         throw new EntityNotFoundException("Cann't find hotel with name:"+hotelName+" in city with code "+cityCode);
        }
    }

    @Override
    public Set<Hotel> getAvailableHotels(String providerCode, String fromDate, String toDate, String city,
                                         Integer numberOfAdults) throws DataException {
        Provider byCode = null;
        DateConverter dateConverter = factory.getDateConverter(null);
        if(providerCode != null && providerCode.trim().length() >0){
           byCode = providerDao.findByCode(providerCode);
           dateConverter = factory.getDateConverter(byCode.getDateFormat());
        }

        Date fromDateObj = dateConverter.convertDate(fromDate);
        Date toDateObj = dateConverter.convertDate(toDate);


        return new HashSet<>();
    }
}
