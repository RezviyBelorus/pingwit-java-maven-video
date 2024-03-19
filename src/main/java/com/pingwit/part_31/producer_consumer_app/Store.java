package com.pingwit.part_31.producer_consumer_app;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Store {

    private int product = 0;

    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        product--;
        System.out.println(String.format("[%s] Покупатель купил 1 товар", LocalTime.now().format(DateTimeFormatter.ISO_TIME)));
        System.out.println("(GET) Товаров на складе: " + product);

        notify();
    }

    public synchronized void put() {
        while (product > 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        product++;
        System.out.println(String.format("[%s] Производитель добавил 1 товар", LocalTime.now().format(DateTimeFormatter.ISO_TIME)));
        System.out.println("(PUT) Товаров на складе: " + product);

        notify();
    }

}
