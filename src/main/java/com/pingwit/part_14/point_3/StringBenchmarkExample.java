package com.pingwit.part_14.point_3;

public class StringBenchmarkExample {
    public static void main(String[] args) {
        String symbol = "A";

        String string = "A";
        StringBuilder stringBuilder = new StringBuilder("A");
        StringBuffer stringBuffer = new StringBuffer("A");

        int quantity = 1000_000;

        long startString = System.currentTimeMillis();
        for (int i = 0; i < quantity; i++) {
            string = string + symbol;
        }
        long finishString = System.currentTimeMillis();
        System.out.println("String = " + (finishString - startString));

        long startStringBuilder = System.currentTimeMillis();
        for (int i = 0; i < quantity; i++) {
            stringBuilder.append(symbol);
        }
        long finishStringBuilder = System.currentTimeMillis();
        System.out.println("StringBuilder = " + (finishStringBuilder - startStringBuilder));

        long startStringBuffer = System.currentTimeMillis();
        for (int i = 0; i < quantity; i++) {
            stringBuffer.append(symbol);
        }
        long finishStringBuffer = System.currentTimeMillis();
        System.out.println("StringBuffer = " + (finishStringBuffer - startStringBuffer));
    }
}
