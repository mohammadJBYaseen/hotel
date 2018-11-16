package com.myaseen.hotel.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DefaultDummyIDGenerator implements IDGenerator {
    private Random random = new Random();

    public DefaultDummyIDGenerator(){

    }

    @Override
    public long nextID() {
        return random.nextLong();
    }
}
