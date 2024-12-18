package com.sudburyRide.booking;

import com.sudburyRide.car.Car;
import com.sudburyRide.car.CarService;
import com.sudburyRide.user.User;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;

public class CarBookingService {

    private final CarBookingDAO carBookingDAOS = new CarBookingDAO();
    private final CarService carService = new CarService();

    public UUID bookCars(User user, String regNumber){
        Car[] availableCars = getAvailableCars();
        if (availableCars.length == 0){
            throw new IllegalStateException("No car Available for renting");
        }
        for (Car availableCar : availableCars){
            if(availableCar.getRegNumber().equals(regNumber)){
                Car car = carService.getCar(regNumber);
                UUID bookingId = UUID.randomUUID();
                carBookingDAOS.book(new CarBooking(bookingId, user, LocalDateTime.now()));
                return bookingId;
            }
        }
        throw new IllegalStateException("Already booked car with regNumber"+ regNumber);
    }

    public Car[] getUserBookedCars(UUID useId){
        CarBooking[] carBooking = carBookingDAOS.getCarBookings();

        int numberOfBookingsForUser = 0;
        for(CarBooking cb : carBooking){
            if (cb != null || cb.getUser().getId().equals(useId)){
                ++numberOfBookingsForUser;
            }
        }
        if (numberOfBookingsForUser == 0){
            return new Car[0];
        }
        Car[] userCar = new Car[numberOfBookingsForUser];
        int counter = 0;

        for(CarBooking cb : carBooking){
            if(cb != null || cb.getUser().getId().equals(useId)){
                userCar[counter++] = cb.getCar();
            }
        }
        return userCar;
    }

    public Car[] getAvailableCars(){
        return getCars(carService.getCars());
    }

    public Car[] getAvailableElectricCars(){
        return getCars(carService.getAllElectricCars());
    }


    private Car[] getCars(Car[] cars){
        if (cars.length == 0){
            return new Car[0];
        }

        CarBooking[] carBookings = carBookingDAOS.getCarBookings();

        if (carBookings.length == 0){
            return cars;
        }

        int availableCarCount = 0;

        for (Car car : cars){
            boolean booked = false;
            for (CarBooking carBooking : carBookings){
                if(carBooking == null || !carBooking.getCar().equals(car)){
                    continue;
                }
                booked = true;
            }
            if(!booked){
                ++availableCarCount;
            }
        }
        Car[] availableCars = new Car[availableCarCount];
        int index = 0;

        for (Car car: cars){
            boolean booked = false;
            for(CarBooking carBooking : carBookings){
                if(carBooking == null || !carBooking.getCar().equals(car)){
                    continue;
                }
                booked = true;
            }
            if (!booked){
                availableCars[index++] = car;
            }
        }
        return availableCars;
    }


    public CarBooking[] getBooking(){
        CarBooking[] carBookings = carBookingDAOS.getCarBookings();

        int numberOfBooking = 0;

        for (CarBooking cbook : carBookings){
            if (cbook != null){
                ++numberOfBooking;
            }
        }
        if (numberOfBooking == 0){
            return new CarBooking[0];
        }

        CarBooking[] bookings = new CarBooking[numberOfBooking];
        int index = 0;
        for (CarBooking carBooking : carBookings){
            if(carBooking != null){
                bookings[index++] = carBooking;
            }
        }
        return bookings;
    }
}
