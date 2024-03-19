package com.pingwit.part_31.synced;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedMethodExample {
    public static void main(String[] args) throws InterruptedException {
        MediaExpert mediaExpert = new MediaExpert(new ArrayList<>());
        List<AgdMediaExpert> electronics = List.of(
                new AgdMediaExpert("Samsung K-1000", "Microwave", 500),
                new AgdMediaExpert("Oral-B IO9", "Toothbrush", 1000),
                new AgdMediaExpert("iPhone 15 PRO", "Phone", 800)
        );

        StorekeeperMediaExpert ivan = new StorekeeperMediaExpert(mediaExpert, electronics);
        StorekeeperMediaExpert tomasz = new StorekeeperMediaExpert(mediaExpert, electronics);

        Thread threadIvan = new Thread(ivan);
        Thread threadTomasz = new Thread(tomasz);

        threadIvan.start();
        threadTomasz.start();

        threadIvan.join();
        threadTomasz.join();

        System.out.println("MediaExpert: " + mediaExpert.electronics().size());
    }
}
