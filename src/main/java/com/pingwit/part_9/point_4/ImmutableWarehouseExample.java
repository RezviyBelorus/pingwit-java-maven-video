package com.pingwit.part_9.point_4;

public class ImmutableWarehouseExample {
    public static void main(String[] args) {
//        int[] numbers = {0, 1, 2, 3};
        Book harryPotter = new Book("Harry Potter");

        Warehouse neptun = new Warehouse(
                "Neptun",
                new int[]{0, 1, 2, 3},
                new Book[]{harryPotter, new Book("Home Alone")}
        );

        System.out.println(neptun);

        neptun.numbers()[0] = 777;
        neptun.books()[0].setName("Operacja Y");

        System.out.println(neptun);
        System.out.println(harryPotter == neptun.books()[0]);
    }
}
