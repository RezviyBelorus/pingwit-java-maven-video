package com.pingwit.part_34.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        Hero hello = new Hero(exchanger, "Hello");
        Hero privet = new Hero(exchanger, "Privet");
        Hero ola = new Hero(exchanger, "Ola");
        Hero czesc = new Hero(exchanger, "Cześć");

        new Thread(hello).start();
        new Thread(privet).start();
        new Thread(ola).start();
        new Thread(czesc).start();
    }
}
