package com.myaseen.hotel.dao;

import com.myaseen.hotel.exception.DataException;
import com.myaseen.hotel.model.City;

public interface CityDao extends Dao<Long, City> {

    public City findCityByCode(String cityCode) throws DataException;

}
