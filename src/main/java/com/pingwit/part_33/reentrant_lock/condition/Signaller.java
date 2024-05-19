package com.pingwit.part_33.reentrant_lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Signaller implements Runnable{
    private final ReentrantLock locker;
    private final Condition condition;

    public Signaller(ReentrantLock locker, Condition condition) {
        this.locker = locker;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            locker.lock();
            System.out.println("Signaller is sending the signal...");
            condition.signal();
        } finally {
            locker.unlock();
        }
    }
}
