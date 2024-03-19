package com.pingwit.part_31.producer_consumer_app;

class Consumer implements Runnable {
    private final Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            store.get();
        }
    }
}
