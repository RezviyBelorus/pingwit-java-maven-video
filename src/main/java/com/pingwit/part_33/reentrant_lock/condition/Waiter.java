package com.pingwit.part_33.reentrant_lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Waiter implements Runnable {

    private final ReentrantLock locker;
    private final Condition condition;

    public Waiter(ReentrantLock locker, Condition condition) {
        this.locker = locker;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            locker.lock();
            System.out.println("Waiter is waiting for the signal...");
            condition.await();
            System.out.println("Waiter received the signal, performing the operation...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            locker.unlock();
        }
    }
}
