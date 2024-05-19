package com.pingwit.part_34.cyclic_barrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class FerryCyclicBarrierExample {
    public static void main(String[] args) {
        int numOfCars = 5;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(numOfCars, new Ferryboat());

        ExecutorService executorService = Executors.newFixedThreadPool(numOfCars);
        IntStream.range(0, 10)
                .forEach(carNumber -> {
                    try {
                        executorService.execute(new Car(cyclicBarrier, carNumber));
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

        executorService.shutdown();
    }
}

class Ferryboat implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("Паром переправил автомобили");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Car implements Runnable {
    private final CyclicBarrier cyclicBarrier;
    private final int carNumber;

    public Car(CyclicBarrier cyclicBarrier, int carNumber) {
        this.cyclicBarrier = cyclicBarrier;
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        try {
            System.out.printf("Автомобиль №%d подъехал к паромной переправе\n", carNumber);

            cyclicBarrier.await();

            System.out.printf("Автомобиль №%d продолжил движение\n", carNumber);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}