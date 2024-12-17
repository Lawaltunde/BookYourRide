package com.sudburyRide.car;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {
    private String regNumber;
    private BigDecimal rentalPricePerDay;
    private Brand brand;

    private boolean isElectricCar;

    public Car(String regNumber, BigDecimal rentalPricePerDay, Brand brand, boolean isElectricCar) {
        this.regNumber = regNumber;
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectricCar = isElectricCar;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public BigDecimal getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public Brand getBrand() {
        return brand;
    }

    public boolean isElectricCar() {
        return isElectricCar;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setRentalPricePerDay(BigDecimal rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setElectricCar(boolean electricCar) {
        isElectricCar = electricCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", brand=" + brand +
                ", isElectricCar=" + isElectricCar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return isElectricCar == car.isElectricCar && Objects.equals(regNumber, car.regNumber) && Objects.equals(rentalPricePerDay, car.rentalPricePerDay) && brand == car.brand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, rentalPricePerDay, brand, isElectricCar);
    }
}
