package com.pingwit.part_32.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Lufthansa implements Airline {
    private final AtomicInteger soldTickets = new AtomicInteger();

    @Override
    public void buyTicket(String name) {
        int ticketNumber = soldTickets.incrementAndGet();
        System.out.println("Lufthansa sold: " + soldTickets + " last passenger: " + name);
    }

    @Override
    public Integer getSoldTickets() {
        return soldTickets.get();
    }
}
