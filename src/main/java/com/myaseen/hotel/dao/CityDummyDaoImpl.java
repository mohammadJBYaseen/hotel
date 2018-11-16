package com.myaseen.hotel.dao;

import com.myaseen.hotel.exception.DataException;
import com.myaseen.hotel.exception.EntityNotFoundException;
import com.myaseen.hotel.model.City;
import com.myaseen.hotel.util.IDGenerator;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CityDummyDaoImpl extends AbstractDummyDaoImpl<City> implements CityDao{

    private Map<String,City> codeToCity = new HashMap<>();

    public CityDummyDaoImpl(IDGenerator idGenerator) {
        super(idGenerator);
    }

    @Override
    protected void saveExtra(City city) {
        codeToCity.put(city.getCode(), city);
    }

    @Override
    protected void deleteExtra(City city) {
        codeToCity.remove(city.getCode());
    }

    @Override
    public City findCityByCode(String cityCode) throws DataException {
        City city = codeToCity.getOrDefault(cityCode, null);
        if(city == null){
            throw new EntityNotFoundException("No City with code "+cityCode);
        }
        return city;
    }
}
