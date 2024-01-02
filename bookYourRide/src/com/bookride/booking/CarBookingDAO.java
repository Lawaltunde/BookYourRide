package com.bookride.booking;

public class CarBookingDAO {
    private final static CarBooking[] carBookings;

    static {
        carBookings = new CarBooking[10];
    }
    public CarBooking[] getCarBookings(){
        return carBookings;
    }
    public void book(CarBooking carBooking){
        int nextFreeIndex = -1;

        for(int i = 0; i < carBookings.length; i++){
            if(carBookings[i] == null){
                nextFreeIndex = i;
            }
        }

        if(nextFreeIndex > -1){
            carBookings[nextFreeIndex] = carBooking;
            return;
        }

        // increasing the size of the array

        CarBooking[] largerCarbookings = new CarBooking[carBookings.length + 10];

        for(int i = 0; i < carBookings.length; i++){
            largerCarbookings[i] = carBookings[i];
        }
        largerCarbookings[carBookings.length] = carBooking;

    }

}
