package com.sudburyRide.car;

public class CarService {
    private final CarDAO carDAO = new CarDAO();

    public Car[] getCars(){
        return carDAO.getAllCars();
    }

    public Car getCar(String regNumber){
        for (Car car : carDAO.getAllCars()) {
            if (regNumber.equals(car.getRegNumber())){
                return car;
            }
            }
        throw new IllegalArgumentException("regNumber can't be null");
        }

    public Car[] getAllElectricCars() {
        int countElectricCars = 0;
        Car[] cars = getCars();

        if (cars.length == 0) {
            return new Car[0];
        }

        for (Car car : cars) {
            if (car.isElectricCar()) {
                countElectricCars++;
            }
        }

        if (countElectricCars == 0) {
            return new Car[0];
        }

        int index = 0;

        Car[] allElectricCars = new Car[countElectricCars];

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].isElectricCar()) {
                allElectricCars[index++] = cars[i];
            }
        }
        return allElectricCars;
    }
}

