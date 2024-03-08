package com.pingwit.part_14.point_1;

public class StringInternExample {
    public static void main(String[] args) {
        String name_1 = "Egorka";
        String name_2 = "Egorka";
        String name_3 = new String("Egorka");
        String name_4 = new String("Egorka");

        System.out.println(name_1.equals(name_2));
        System.out.println(name_1.equals(name_3));

        System.out.println("===");
        System.out.println(name_1 == name_2);
        System.out.println(name_1 == name_3);
        System.out.println(name_3 == name_4);

        name_3 = name_3.intern();
        System.out.println(name_1 == name_3);
    }
}
