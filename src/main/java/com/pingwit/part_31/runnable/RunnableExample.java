package com.pingwit.part_31.runnable;

import java.util.ArrayList;
import java.util.List;

public class RunnableExample {
    public static void main(String[] args) throws InterruptedException {
        /*
        Дано:
        - магазин с электроникой
        - работник, который заведует складом и разгрузкой товара
        - электроника, которая приехала в магазин

        Задача:
        - Разгрузить грузовик и сделать переучет товара
         */

        MediaMarket mediaMarket = new MediaMarket(new ArrayList<>());
        List<Agd> electronics = List.of(
                new Agd("Samsung K-1000", "Microwave", 500),
                new Agd("Oral-B IO9", "Toothbrush", 1000),
                new Agd("iPhone 15 PRO", "Phone", 800)
        );

        Storekeeper egorka = new Storekeeper(mediaMarket, electronics);
        Storekeeper evgeniy = new Storekeeper(mediaMarket, electronics);

        Thread threadEgorka = new Thread(egorka);
        Thread threadEvgeniy = new Thread(evgeniy);

        threadEgorka.start();
        threadEvgeniy.start();

        threadEgorka.join();
        threadEvgeniy.join();

        System.out.println("MediaMarket: " + mediaMarket.electronics().size());
    }
}
