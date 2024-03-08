package com.pingwit.part_14.point_2;

public class StringBuilderBufferExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Kukuha do swidania");

        sb.append(" vot tak");
        System.out.println(sb);

        String name = sb.toString();
        sb.reverse();
        System.out.println(sb);

        System.out.println(new StringBuilder("alucard").reverse());

        StringBuffer stringBuffer = new StringBuffer();
    }
}
