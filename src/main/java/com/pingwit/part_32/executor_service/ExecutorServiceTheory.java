package com.pingwit.part_32.executor_service;

import java.util.concurrent.*;

public class ExecutorServiceTheory {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        Использование ExecutorService предоставляет ряд преимуществ по сравнению с явным созданием и запуском потоков:
        - Управление потоками: ExecutorService позволяет создавать пул потоков и переиспользовать их для выполнения задач.
        Это позволяет избежать накладных расходов на создание и уничтожение потоков для каждой задачи.

        - Управление ресурсами: Пулы потоков, создаваемые ExecutorService, позволяют контролировать количество
         одновременно работающих потоков, что позволяет эффективнее использовать ресурсы процессора и памяти.

        - Улучшенная масштабируемость: ExecutorService обеспечивает механизмы для легкого масштабирования приложения.
        Вы можете легко изменять размер пула потоков в зависимости от требований вашего приложения.

        - Управление завершением задач: ExecutorService предоставляет методы для управления завершением выполнения задач,
         такие как shutdown() и awaitTermination(), которые позволяют корректно завершить выполнение задач и остановить пул потоков.
         */

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);


        int quantity = 5;
        CallableSummaryPrinter callableSummaryPrinter = new CallableSummaryPrinter(quantity);
        RunnablePrinter runnablePrinter = new RunnablePrinter(quantity);

        Future<Integer> callableFuture = fixedThreadPool.submit(callableSummaryPrinter);
        Future<?> runnableFuture = fixedThreadPool.submit(runnablePrinter);

        Integer callableResult = callableFuture.get();
        Object nullObject = runnableFuture.get();
        System.out.println("Total sum: " + callableResult);

//        fixedThreadPool.awaitTermination(2, TimeUnit.SECONDS);
        fixedThreadPool.shutdown(); // НЕ останавливает приложение сразу же, а ждет окончание выполнения текущих задач и только потом завершает работу

//        fixedThreadPool.shutdownNow(); - останавливает приложение в момент выполнения

//        Future<Integer> causesExceptionDoNotUseItAfterShutdownMethod = fixedThreadPool.submit(callableSummaryPrinter);

        System.out.println("Main thread finished");
    }
}


class CallableSummaryPrinter implements Callable<Integer> {
    private final Integer quantity;

    public CallableSummaryPrinter(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public Integer call() throws Exception {
        int sum =  0;

        for (int i = 0; i < quantity; i++) {
            sum += i;
            System.out.println("Callable: " + i);

            Thread.sleep(1000);
        }
        return sum;
    }
}

class RunnablePrinter implements Runnable {
    private final Integer quantity;

    public RunnablePrinter(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantity; i++) {
            System.out.println("Runnable: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}