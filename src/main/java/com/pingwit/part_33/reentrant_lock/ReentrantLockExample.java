package com.pingwit.part_33.reentrant_lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) throws InterruptedException {
        Garage garage = new Garage();

        Runnable barrier = () -> {
            for (int i = 0; i < 200_000; i++) {
                garage.park(i);
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 2; i++) {
            executorService.execute(barrier);
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Cars parked: " + garage.getCars().size());
    }
}

class Garage {
    private final List<Integer> cars = new ArrayList<>();

    private final ReentrantLock locker = new ReentrantLock();

    public void park(int number) {
        try {
            if (locker.tryLock(5, TimeUnit.SECONDS)) {
                cars.add(number);
                System.out.println(number);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            locker.unlock();
        }
    }

    public List<Integer> getCars() {
        return cars;
    }
}