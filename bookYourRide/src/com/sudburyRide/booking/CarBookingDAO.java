package com.sudburyRide.booking;

public class CarBookingDAO {

    private final static CarBooking[] carBookings;

    static {
        carBookings = new CarBooking[10];
    }

    public CarBooking[] getCarBookings(){
        return carBookings;
    }

    public void book(CarBooking carBooking){
        int nextSlot = -1;

        for (int i = 0; i < CarBookingDAO.carBookings.length; i++){
            if (CarBookingDAO.carBookings[i] == null){
                nextSlot = i;
            }
        }

        if(nextSlot > -1){
            carBookings[nextSlot] = carBooking;
            return;
        }

        CarBooking[] expandedCarBooking = new CarBooking[carBookings.length + 10];

        for (int i = 0; i < carBookings.length; i++) {
            expandedCarBooking[i] = carBookings[i];
           }

        expandedCarBooking[carBookings.length] = carBooking;
        }
        public void cancelCarBooking(){

        }
    }
