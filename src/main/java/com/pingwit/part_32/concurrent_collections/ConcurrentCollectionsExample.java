package com.pingwit.part_32.concurrent_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentCollectionsExample {
    public static void main(String[] args) throws InterruptedException {
        /*
        Существует два типа потокобезопасных коллекций: Concurrent коллекции от Synchronized коллекции

        Основное отличие заключается в том, что Concurrent коллекции предоставляют более эффективные
        и безопасные механизмы для работы с коллекциями в многопоточных приложениях,
        в то время как Synchronized коллекции используют механизмы синхронизации на уровне методов для обеспечения потокобезопасности.
         */

        List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());

        Airport airport = new Airport();

        int quantity = 1000;
        Runnable operatorEgorka = () -> {
            for (int i = 0; i < quantity; i++) {
                airport.arrive(1);

                airport.checkIn("Aerobus", "John_" + i);
                airport.checkIn("Aerobus", "Nataly_" + i);
                airport.checkIn("Boening", "Christian_" + i);
                airport.checkIn("Boening", "Jakub_" + i);
                airport.checkIn("Boening", "Mike_" + i);
            }
        };

        Runnable operatorDonald = () -> {
            for (int i = 0; i < quantity; i++) {
                airport.arrive(1);

                airport.checkIn("Boening", "Sabrina_" + i);
                airport.checkIn("Boening", "Donatello_" + i);
                airport.checkIn("Aerobus", "Rafael_" + i);
                airport.checkIn("Aerobus", "Daniel_" + i);
                airport.checkIn("Boening", "Kasia_" + i);
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(operatorEgorka);
        executorService.execute(operatorDonald);

        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);

        airport.printDashboard();
    }
}
