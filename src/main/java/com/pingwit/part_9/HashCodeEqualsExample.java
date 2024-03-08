package com.pingwit.part_9;

public class HashCodeEqualsExample {
    public static void main(String[] args) {
        Cat murzik = new Cat("Siam", "black");
        Cat sharik = new Cat("Siam", "black");
        Cat white = new Cat("Pers", "white");

        Cat murzikClone = murzik;

        System.out.println(murzik == sharik);
        System.out.println("murzik.equals(sharik): " + murzik.equals(sharik));

        System.out.println(murzikClone.equals(murzik));

        /*
        hashCode равны -> equals МОГУТ быть равны
        equals равны -> hashCode обязаны равны
         */

        System.out.println("=== hashCode ===");
        System.out.println(murzik.hashCode());
        System.out.println(sharik.hashCode());
        System.out.println(white.hashCode());
    }
}
