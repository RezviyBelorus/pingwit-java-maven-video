package com.pingwit.part_34.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class LoginSemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        int slots = 2100;

        ExecutorService executorService = Executors.newFixedThreadPool(slots);
        LoginSemaphore loginSemaphore = new LoginSemaphore(slots);

        System.out.println("loginSemaphore.availableSlots(): " + loginSemaphore.availableSlots());

        IntStream.range(0, slots)
                .forEach(browserTab -> executorService.submit(loginSemaphore::tryLogin));

        executorService.shutdown();
        System.out.println("loginSemaphore.availableSlots(): " + loginSemaphore.availableSlots());
        System.out.println("Try login result: " + loginSemaphore.tryLogin());
    }
}

class LoginSemaphore {
    private final Semaphore semaphore;

    public LoginSemaphore(int slots) {
        this.semaphore = new Semaphore(slots);
    }

    boolean tryLogin() throws InterruptedException {
        Thread.sleep(100);
        return semaphore.tryAcquire();
    }

    void logout() {
        semaphore.release();
    }

    int availableSlots() {
        return semaphore.availablePermits();
    }
}