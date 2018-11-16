package com.myaseen.hotel.dao;

import com.myaseen.hotel.exception.DataException;
import com.myaseen.hotel.model.Provider;

public interface ProviderDao extends Dao<Long, Provider> {

    Provider findByCode(String code) throws DataException;
}
