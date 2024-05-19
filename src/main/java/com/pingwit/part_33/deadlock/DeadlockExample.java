package com.pingwit.part_33.deadlock;

public class DeadlockExample {
    /*
    Deadlock (взаимная блокировка) - это ситуация, когда два или более потока заблокированы, ожидая друг друга,
    чтобы освободить ресурсы, в которых они нуждаются для продолжения выполнения.
    Каждый из этих потоков удерживает какой-то ресурс, который нужен другому потоку,
    чтобы продолжить свое выполнение, но ни один из них не может освободить свой ресурс, потому что они заблокированы.

    Примером типичного deadlock-а может быть следующая ситуация:
    1. Поток A блокирует ресурс 1.
    2. Поток B блокирует ресурс 2.
    3. Поток A пытается получить доступ к ресурсу 2, но блокируется, поскольку он занят потоком B.
    4. Поток B пытается получить доступ к ресурсу 1, но блокируется, поскольку он занят потоком A.

    В результате ни один из потоков не может продолжить свое выполнение, и они остаются заблокированными, создавая deadlock.

    Deadlock является серьезной проблемой в многопоточных приложениях, поскольку может привести к замедлению или остановке работы приложения.
     */

    static Object LOCK_1 = new Object();
    static Object LOCK_2 = new Object();

    public static void main(String[] args) {
        new Thread_1().start();
        new Thread_2().start();
    }
}

class Thread_1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread_1 locks LOCK_1");

        synchronized (DeadlockExample.LOCK_1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("[Thread_1] Trying to lock LOCK_2");

            synchronized (DeadlockExample.LOCK_2) {
                System.out.println("[Thread_1] LOCK_2 locked");
            }
        }
    }
}

class Thread_2 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread_2 locks LOCK_2");

        synchronized (DeadlockExample.LOCK_2) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("[Thread_2] Trying to lock LOCK_1");

            synchronized (DeadlockExample.LOCK_1) {
                System.out.println("[Thread_2] LOCK_1 locked");
            }
        }
    }
}
