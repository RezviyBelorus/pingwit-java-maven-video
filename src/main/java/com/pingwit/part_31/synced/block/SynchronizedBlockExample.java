package com.pingwit.part_31.synced.block;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedBlockExample {
    public static void main(String[] args) throws InterruptedException {
        RtvEuroAgd rtvEuroAgd = new RtvEuroAgd(new ArrayList<>());
        List<AgdRtvEuroAgd> electronics = List.of(
                new AgdRtvEuroAgd("Samsung K-1000", "Microwave", 500),
                new AgdRtvEuroAgd("Oral-B IO9", "Toothbrush", 1000),
                new AgdRtvEuroAgd("iPhone 15 PRO", "Phone", 800)
        );

        StorekeeperRtvEuroAgd yacek = new StorekeeperRtvEuroAgd(rtvEuroAgd, electronics);
        StorekeeperRtvEuroAgd yakub = new StorekeeperRtvEuroAgd(rtvEuroAgd, electronics);
        SuperFastStorekeeperRtvEuroAgd superFastSergiusz = new SuperFastStorekeeperRtvEuroAgd(rtvEuroAgd, electronics);

        Thread threadYacek = new Thread(yacek);
        Thread threadYakub = new Thread(yakub);
        Thread threadSuperFastSergiusz = new Thread(superFastSergiusz);

        threadYacek.start();
        threadYakub.start();
        threadSuperFastSergiusz.start();

        threadYacek.join();
        threadYakub.join();
        threadSuperFastSergiusz.join();

        System.out.println("RtvEuroAgd: " + rtvEuroAgd.electronics().size());
    }
}
