package com.pingwit.part_32.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CallablePrinter callablePrinter = new CallablePrinter(10);
        FutureTask<Integer> futureTask = new FutureTask<>(callablePrinter);

        Thread thread = new Thread(futureTask);
        thread.start();

        Integer sum = futureTask.get();

        System.out.println("Result: " + sum);
    }
}

class CallablePrinter implements Callable<Integer> {
    private final Integer quantity;

    public CallablePrinter(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;

        for (int i = 0; i < quantity; i++) {
            System.out.println(i);
            sum += i;
            Thread.sleep(1000);
        }

        return sum;
    }
}