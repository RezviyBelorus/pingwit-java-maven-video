package com.pingwit.part_31.producer_consumer_app;

public class ProducerConsumerApp {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        new Thread(producer, "Producer thread").start();
        new Thread(consumer, "Consumer thread").start();
    }
}
