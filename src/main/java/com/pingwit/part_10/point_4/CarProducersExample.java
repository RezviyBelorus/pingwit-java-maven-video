package com.pingwit.part_10.point_4;

public class CarProducersExample {
    public static void main(String[] args) {
        System.out.println(CarProducers.MAZDA.sound());
        System.out.println(CarProducers.BMW.sound());

        CarProducers.MAZDA.sayHi();
        CarProducers.TESLA.sayHi();
    }
}
