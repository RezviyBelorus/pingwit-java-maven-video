package com.pingwit.part_34.exchanger;

import java.util.concurrent.Exchanger;

public class Hero implements Runnable {

    private final Exchanger<String> exchanger;
    private final String name;

    public Hero(Exchanger<String> exchanger, String name) {
        this.exchanger = exchanger;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Exchanger '" + name + "' is waiting");
            Thread.sleep(2000);
            String exchange = exchanger.exchange(name);

            System.out.println("Sent: " + name + "; Exchanged: " + exchange);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
