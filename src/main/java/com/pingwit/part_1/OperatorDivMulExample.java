package com.pingwit.part_1;

public class OperatorDivMulExample {
    public static void main(String[] args) {
        int num_1 = 5;
        int num_2 = 2;
        int result = num_1 / num_2;
        System.out.println(result);

        System.out.println(5 * 2);

//        System.out.println(5 / 0);
        System.out.println(5 * 0);

        System.out.println(2 % 6);

        System.out.println(5 / 0.0);
        System.out.println(-5 / 0.0);
        System.out.println(5 / 0.0 - 5 / 0.0);

        System.out.println(5 / 2.0);
        System.out.println(5 % 2.0);

        System.out.println(1.45 + 1.58); // BigDecimal
        System.out.println(1.5 + 1.58); // BigDecimal

        System.out.println(1.58 * 4.2);
    }

}
