package com.myaseen.hotel.dao;

import com.myaseen.hotel.model.RoomAvailability;
import com.myaseen.hotel.util.IDGenerator;
import org.springframework.stereotype.Repository;

@Repository
public class RoomAvailabilityDummyDaoImpl extends AbstractDummyDaoImpl<RoomAvailability> implements RoomAvailabilityDao {
    public RoomAvailabilityDummyDaoImpl(IDGenerator idGenerator) {
        super(idGenerator);
    }
}
