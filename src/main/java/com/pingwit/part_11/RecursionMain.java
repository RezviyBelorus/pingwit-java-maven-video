package com.pingwit.part_11;

public class RecursionMain {
    public static void main(String[] args) {
        show(0, 5);
    }

    private static void show(int from, int to) {
//        if (from > to) {
//            return;
//        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        show(++from, to);
        System.out.println(from);
    }

}
