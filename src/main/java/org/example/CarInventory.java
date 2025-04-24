package org.example; 
import java.util.*;

public class CarInventory {

    HashMap<String, Car> carInventory;

    public CarInventory() {
        carInventory = new HashMap<>();
    }

    public void addCar(Car car) {
        if (car == null) throw new IllegalArgumentException("Car parameter can not be null");
        if (carInventory.containsKey(car.getModel())) throw new IllegalArgumentException("Cars can not be the same model");
        carInventory.put(car.getModel(), car);
    }

    public Car getCar(String model) {
        return carInventory.get(model);
    }

    public Car sellCar(String model) {
        return carInventory.remove(model);
    }

    public void updateCarPrice(String model, double newPrice) {
        Car carToUpdate = this.getCar(model);
        if (carToUpdate != null) {
            carToUpdate.setPrice(newPrice);
        }
    }

    public List<Car> findCarsByMake(String make) {
        List<Car> carsWithSimilarMake = new ArrayList<>();
        for (String carModelKey : carInventory.keySet()) {
            Car currentCar = carInventory.get(carModelKey);
            String currentCarMake = carInventory.get(carModelKey).getMake();
            if (Objects.equals(currentCarMake, make)) {
               carsWithSimilarMake.add(currentCar);
            }
        }

        return carsWithSimilarMake;
    }

    public int getCarCount() {
       return carInventory.size();
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


    }
}