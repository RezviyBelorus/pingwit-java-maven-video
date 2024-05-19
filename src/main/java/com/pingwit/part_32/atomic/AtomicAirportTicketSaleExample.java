package com.pingwit.part_32.atomic;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AtomicAirportTicketSaleExample {
    public static void main(String[] args) throws InterruptedException {
        WizzAir wizzAir = new WizzAir();
        Lufthansa lufthansa = new Lufthansa();

        List<String> names = List.of("Egorka", "Olga", "Juk", "Hector", "Kuba", "Tomasz", "Milana");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        submitBots(wizzAir, executorService, names);
        submitBots(lufthansa, executorService, names);

        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.MINUTES);

        System.out.println("WizzAir sold tickets: " + wizzAir.getSoldTickets());
        System.out.println("Lufthansa sold tickets: " + lufthansa.getSoldTickets());
    }

    private static void submitBots(Airline airline, ExecutorService executorService, List<String> names) {
        Random random = new Random();

        Runnable bot = () -> {
            for (int i = 0; i < 10000; i++) {
                int randomNameIndex = random.nextInt(names.size());
                String name = names.get(randomNameIndex);
                airline.buyTicket(name);
            }
        };

        for (int i = 0; i < 10; i++) {
            executorService.execute(bot);
        }
    }
}
