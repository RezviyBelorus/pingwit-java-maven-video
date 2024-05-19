package com.pingwit.part_32.atomic;

public class WizzAir implements Airline{

    private Integer soldTickets = 0;

    @Override
    public synchronized void buyTicket(String name) {
        soldTickets++;
        System.out.println("Wizzair sold: " + soldTickets + " last passenger: " + name);
    }

    @Override
    public Integer getSoldTickets() {
        return soldTickets;
    }
}
