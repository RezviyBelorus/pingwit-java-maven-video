package com.pingwit.part_33.reentrant_lock.producer_consumer_app;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Store {

    private int product = 0;
    private final AtomicInteger totalDelivered = new AtomicInteger();
    private final AtomicInteger totalSold = new AtomicInteger();

    private final ReentrantLock locker = new ReentrantLock();
    private final Condition condition = locker.newCondition();

    public void get() {
        try {
            locker.lock();

            while (product < 1) {
                condition.await();
            }

            product--;
            totalSold.incrementAndGet();

            System.out.println(String.format("[%s] Покупатель купил 1 товар", LocalTime.now().format(DateTimeFormatter.ISO_TIME)));
            System.out.println("(GET) Товаров на складе: " + product);

            condition.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            locker.unlock();
        }
    }

    public void put() {
        try {
            locker.lock();

            while (product > 5) {
                condition.await();
            }

            product++;
            totalDelivered.incrementAndGet();

            System.out.println(String.format("[%s] Производитель добавил 1 товар", LocalTime.now().format(DateTimeFormatter.ISO_TIME)));
            System.out.println("(PUT) Товаров на складе: " + product);

            condition.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            locker.unlock();
        }
    }

    public Integer getTotalDelivered() {
        return totalDelivered.get();
    }

    public Integer getTotalSold() {
        return totalSold.get();
    }
}
