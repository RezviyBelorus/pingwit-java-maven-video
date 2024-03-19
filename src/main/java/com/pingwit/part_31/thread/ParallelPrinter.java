package com.pingwit.part_31.thread;

public class ParallelPrinter extends Thread {

    public ParallelPrinter(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("Hello from %s: %d \n", super.getName(), i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
