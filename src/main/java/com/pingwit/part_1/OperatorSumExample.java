package com.pingwit.part_1;

public class OperatorSumExample {
    public static void main(String[] args) {
        byte num_1 = 100;
        byte num_2 = 100;

        byte sum = (byte) (num_1 + num_2);
        System.out.println(sum);

        short num_3 = 100;
        short num_4 = 100;

        int shortSum = num_3 + num_4;

        int num_5 = 200;
        int num_6 = 200;

        int intSum = num_5 + num_6;

        long longNum = 300;
        long longSum = intSum + longNum;

        double doubleNum = 100;
        double doubleSum = longSum + doubleNum;
        System.out.println(doubleSum);

        long result = num_5 - longNum;
    }
}
