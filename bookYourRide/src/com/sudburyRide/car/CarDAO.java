package com.sudburyRide.car;

import java.math.BigDecimal;

public class CarDAO {

    public static final Car[] CARS = {
            new Car("1234", new BigDecimal("95.00"), Brand.TESLA, true),
            new Car("5678", new BigDecimal("76.5"), Brand.MERCEDES, false),
            new Car("9876", new BigDecimal("65.94"), Brand.AUDI, false)
    };


    public Car[] getAllCars(){
        return CARS;
    }
}
