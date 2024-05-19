package com.pingwit.part_32;

import java.util.concurrent.*;

public class RunnableCallableLambdaExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        int quantity = 5;

        Callable<Integer> callable = () -> {
            int sum =  0;

            for (int i = 0; i < quantity; i++) {
                sum += i;
                System.out.println("Callable: " + i);

                Thread.sleep(1000);
            }
            return sum;
        };

        Runnable runnable = () -> {
            for (int i = 0; i < quantity; i++) {
                System.out.println("Runnable: " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Future<Integer> callableFuture = fixedThreadPool.submit(callable);
        Future<?> runnableFuture = fixedThreadPool.submit(runnable);

        Integer callableResult = callableFuture.get();
        Object nullObject = runnableFuture.get();
        System.out.println("Total sum: " + callableResult);

        fixedThreadPool.shutdown();

        System.out.println("Main thread finished");
    }
}
