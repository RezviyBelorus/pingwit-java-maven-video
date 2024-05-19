package com.pingwit.part_32.concurrent_collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class Airport {
    private List<Integer> arrivedAirplanes = new CopyOnWriteArrayList<>();
    private Map<String, Queue<String>> passengersByAirplane = new ConcurrentHashMap<>();

    public void arrive(Integer airplanes) {
        arrivedAirplanes.add(airplanes);
    }

    public void checkIn(String airplane, String passenger) {
        Queue<String> passengers = passengersByAirplane.get(airplane);

        if (passengers == null) {
            passengersByAirplane.put(airplane, new ConcurrentLinkedDeque<>(List.of(passenger)));
        } else {
            passengers.add(passenger);
        }
    }

    public Integer getArrivedAirplanes() {
        return arrivedAirplanes.size();
    }

    public void printDashboard() {
        System.out.println("Arrived airplanes: " + this.getArrivedAirplanes());

        System.out.println("Total airplanes: " + passengersByAirplane.size());
        System.out.println("Total passengers: " + passengersByAirplane.values().stream().mapToLong(Collection::size).sum());

        System.out.println("===Departure===");
        passengersByAirplane.forEach((airplane, passengers) -> {
            System.out.println(airplane);
            System.out.println(passengers);
        });
    }
}
