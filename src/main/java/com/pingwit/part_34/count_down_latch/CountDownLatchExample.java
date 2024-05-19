package com.pingwit.part_34.count_down_latch;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        List<String> racers = List.of("Ejik", "Cherepaha", "Lisa", "Verblud");

        CountDownLatch countDownLatch = new CountDownLatch(racers.size() + 1);

        ExecutorService executorService = Executors.newFixedThreadPool(racers.size());
        racers.forEach(racer -> executorService.execute(new Racer(racer, countDownLatch)));

        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);

        System.out.println("Preparing for start...");

        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }

        System.out.println("Start!");
        countDownLatch.countDown();
        countDownLatch.countDown();
    }
}

class Racer implements Runnable {
    private final String name;
    private final CountDownLatch countDownLatch;

    public Racer(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.countDown();
            System.out.printf("%s is ready!\n", name);
            countDownLatch.await();

            System.out.printf("%s racer is finished!\n", name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}