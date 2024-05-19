package com.pingwit.part_34.semaphore;

import javax.swing.*;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(5);

        SwissBank santander = new SwissBank("Santander", semaphore, 1000_000);
        SwissBank pekao = new SwissBank("Pekao", semaphore, 100);
        SwissBank jpMorgan = new SwissBank("J.P.Morgan", semaphore, 1000);

        new Thread(santander).start();
        new Thread(pekao).start();
        new Thread(jpMorgan).start();

        System.out.println("semaphore.availablePermits(): " + semaphore.availablePermits());
        Thread.sleep(1000);
        System.out.println("[After sleep] semaphore.availablePermits(): " + semaphore.availablePermits());
    }
}

class SwissBank implements Runnable {
    private final String name;
    private final Semaphore semaphore;
    private final int transactionSum;

    public SwissBank(String name, Semaphore semaphore, int transactionSum) {
        this.name = name;
        this.semaphore = semaphore;
        this.transactionSum = transactionSum;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();

            System.out.printf("[%s] sum: %d\n", name, transactionSum);
            Thread.sleep(2000);

            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}