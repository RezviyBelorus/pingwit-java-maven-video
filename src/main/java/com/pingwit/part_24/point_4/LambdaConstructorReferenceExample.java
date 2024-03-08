package com.pingwit.part_24.point_4;

class LambdaConstructorReferenceExample {
    public static void main(String[] args) {
        NetflixUserSupplier netflixUserSupplier = NetflixUser::new;

        NetflixUser egorka = netflixUserSupplier.supply("Egorka", 25);
        System.out.println(egorka);
    }
}

record NetflixUser(String name, Integer age) {
    NetflixUser() {
        this("AdminUser", 45);
        System.out.println("Hello from default constructor");
    }

    NetflixUser(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("Hello from all args constructor");
    }
}

interface NetflixUserSupplier {
    NetflixUser supply(String name, Integer age);
}