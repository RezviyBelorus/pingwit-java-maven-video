package com.pingwit.part_34.exchanger;

import java.util.concurrent.Exchanger;

public class IvanushkaExchangerExample {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        Hero ivanushka = new Hero(exchanger, "Alenushkaaa...");
        Hero alenushka = new Hero(exchanger, "Ivanushkaaa...");

        new Thread(ivanushka).start();
        Thread.sleep(10_000);
        new Thread(alenushka).start();
    }
}
