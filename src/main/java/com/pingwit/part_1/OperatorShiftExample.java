package com.pingwit.part_1;

public class OperatorShiftExample {
    public static void main(String[] args) {
        // <<, >>
        System.out.println(4);
        // 4, 2, 1 -> 0, 0, 1 -> 1,0,0
        System.out.println(0b100);
        // 1,0,0 << 2 -> 1,0,0,0,0
        // 1,0,0,0,0 -> (1 × 2⁴) + (0 × 2³) + (0 × 2²) + (0 × 2¹) + (0 × 2⁰) -> 16
        System.out.println(4 << 2); // -> 4 * 4 -> 16

        long num = 2;
        System.out.println(2L << 31);

        // 1,0,0 -> 4 >> 2 -> 0,0,1
        System.out.println(0b001);
        System.out.println(4 >> 2); // 4 / 4 -> 1
    }
}
