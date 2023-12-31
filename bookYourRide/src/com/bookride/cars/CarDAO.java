package com.bookride.cars;

import java.math.BigDecimal;

public class CarDAO {
    private static final Car[] CARS = {
            new Car("1234", new BigDecimal("1000"), Brand.TESLA, true),
            new Car("1235", new BigDecimal("900"), Brand.BMW, false),
            new Car("1236", new BigDecimal("800"), Brand.MERCEDES, false)
    };

    public Car[] getAllCars(){
        return CARS;
    }
}
