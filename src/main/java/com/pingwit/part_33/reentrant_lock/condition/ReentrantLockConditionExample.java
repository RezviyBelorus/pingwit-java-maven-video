package com.pingwit.part_33.reentrant_lock.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockConditionExample {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        Condition condition = locker.newCondition();

        Waiter waiter = new Waiter(locker, condition);
        Signaller signaller = new Signaller(locker, condition);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(waiter);
        executorService.execute(signaller);

        executorService.shutdown();
    }
}
